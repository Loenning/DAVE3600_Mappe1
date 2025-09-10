package com.example.mappe1.ui

data class GameUiState(
    val currentMathQuestion: String = "",
    val isAnswerWrong: Boolean = false,
    val currentProblemCount: Int = 1
)
