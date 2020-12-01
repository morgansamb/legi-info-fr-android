package com.example.legi_info.ui.nationalassembly.deputy.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.local.DeputyEntity
import com.example.domain.result.Result
import com.example.domain.usecase.deputy.GetDeputiesUseCase
import com.example.legi_info.ui.base.ListState
import com.orhanobut.logger.Logger
import kotlinx.coroutines.launch
import java.lang.IllegalStateException

class DeputyListViewModel(
    private val getDeputiesUseCase: GetDeputiesUseCase
): ViewModel() {

    private val _state = MutableLiveData<ListState<DeputyEntity>>()
    val state: LiveData<ListState<DeputyEntity>> = _state

    init {
        getCurrentDeputies()
    }

    private fun getCurrentDeputies() = viewModelScope.launch {
        _state.value = ListState.Loading
        val result = getDeputiesUseCase()
        _state.value = when (result) {
            is Result.Success -> ListState.Success(result.data)
            is Result.Error -> {
                Logger.e(result.exception.message.orEmpty())
                ListState.Error(result.exception.message)
            }
            Result.Loading -> throw IllegalStateException()
        }
    }
}
