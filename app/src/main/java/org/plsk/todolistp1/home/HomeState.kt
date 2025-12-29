package org.plsk.todolistp1.home

data class HomeState(
    var isLoading: Boolean = false,
    var isError: Boolean = false,
    val homeUiData: HomeUIData
)