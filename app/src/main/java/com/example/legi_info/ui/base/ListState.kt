package com.example.legi_info.ui.base

sealed class ListState<out T> {
    data class Success<T>(val data: List<T>): ListState<T>()
    data class Error(val error: String? = null): ListState<Nothing>()
    object Loading: ListState<Nothing>()
}