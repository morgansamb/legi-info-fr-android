package com.example.legi_info.ui.nationalassembly.deputy.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Deputy
import com.example.domain.result.Result
import com.example.domain.usecase.deputy.GetDeputyUseCase
import com.orhanobut.logger.Logger
import kotlinx.coroutines.launch

class DeputyDetailViewModel(
    private val getDeputyUseCase: GetDeputyUseCase
): ViewModel() {

    private val _state = MutableLiveData<DeputyDetailState>()
    val state: LiveData<DeputyDetailState> = _state

    fun loadInformation(slug: String) = viewModelScope.launch {
        _state.value = DeputyDetailState.Loading
        val result = getDeputyUseCase(slug)
        _state.value = when(result) {
            is Result.Success -> DeputyDetailState.Success(result.data)
            is Result.Error -> {
                Logger.e(result.exception.stackTraceToString())
                DeputyDetailState.Error()
            }
            Result.Loading -> throw IllegalStateException()
        }
    }
}

sealed class DeputyDetailState {
    data class Success(val deputy: Deputy): DeputyDetailState()
    data class Error(val error: String? = null): DeputyDetailState()
    object Loading: DeputyDetailState()
}
