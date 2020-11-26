package com.example.legi_info.ui.nationalassembly.organizationlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.local.OrganizationEntity
import com.example.domain.result.Result
import com.example.domain.usecase.organization.GetOrganizationsUseCase
import com.example.legi_info.ui.base.ListState
import com.orhanobut.logger.Logger
import kotlinx.coroutines.launch
import java.lang.IllegalStateException

class OrganizationListViewModel(
    private val getOrganizationsUseCase: GetOrganizationsUseCase
): ViewModel() {

    private val _state = MutableLiveData<ListState<OrganizationEntity>>()
    val state: LiveData<ListState<OrganizationEntity>>
        get() = _state

    init {
        getOrganizations()
    }

    private fun getOrganizations() = viewModelScope.launch {
        _state.value = ListState.Loading
        val result = getOrganizationsUseCase()
        _state.value = when(result) {
            is Result.Success -> ListState.Success(result.data)
            is Result.Error -> {
                Logger.e(result.exception.message.orEmpty())
                ListState.Error(result.exception.message)
            }
            Result.Loading -> throw IllegalStateException()
        }
    }
}
