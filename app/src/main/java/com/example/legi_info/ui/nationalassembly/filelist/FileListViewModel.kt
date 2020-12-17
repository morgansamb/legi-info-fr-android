package com.example.legi_info.ui.nationalassembly.filelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.local.FileEntity
import com.example.domain.result.Result
import com.example.domain.usecase.file.GetMostRecentFileUseCase
import com.example.legi_info.ui.base.ListState
import com.orhanobut.logger.Logger
import kotlinx.coroutines.launch
import java.lang.IllegalStateException

class FileListViewModel(
    private val getMostRecentFileUseCase: GetMostRecentFileUseCase
): ViewModel() {

    private val _state = MutableLiveData<ListState<FileEntity>>()
    val state: LiveData<ListState<FileEntity>>
        get() = _state

    init {
        getMostRecentFiles()
    }

    private fun getMostRecentFiles() = viewModelScope.launch {
        _state.value = ListState.Loading
        val result = getMostRecentFileUseCase()
        _state.value = when(result) {
            is Result.Success -> ListState.Success(result.data)
            is Result.Error -> {
                Logger.e(result.exception.stackTraceToString())
                ListState.Error()
            }
            Result.Loading -> throw IllegalStateException()
        }
    }
}
