package com.example.mappe1.ui

data class GameUiState(
    val currentMathProblem: String = "",
    val currentProblemCount: Int = 1,
    val score: Int = 0,
    val userAnswer: String = "",
    val isAnswerWrong: Boolean = false,
    val isGameOver: Boolean = false
)
