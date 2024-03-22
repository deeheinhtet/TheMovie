package com.dee.home.presentation

data class ToggleSelectionModel(
    val title: String,
    var isSelected: Boolean = false,
    val id: String,
)