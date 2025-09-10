package com.example.mappe1.ui
import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.mappe1.R
import android.content.Context
import androidx.compose.ui.res.stringResource

class GameViewModel : ViewModel() {

    /* ------------------ VARIABLER ------------------ */

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private lateinit var currentMathProblem: String

    private var usedProblems: MutableSet<String> = mutableSetOf()



    var userAnswer by mutableStateOf("")
     private set

    init {
        resetGame()
    }



    /* ------------------ FUNKSJONER ------------------ */



    /*fun pickRandomMathQuestion(): String {
        var newQuestion: String
        if (usedProblems.size == allMathProblems.size) {
            usedProblems.clear()
        }
        do {
            newQuestion = allMathProblems.random()
        } while (usedProblems.contains(newQuestion))
        usedProblems.add(newQuestion)
        return newQuestion
    }*/


    fun updateUserAnswer(answer: String) {
        userAnswer = answer
    }

    fun checkUserAnswer() {
        if (userAnswer.equals(currentMathProblem, ignoreCase = true)) {
            val updatedProblemCount = _uiState.value.currentProblemCount + 1
        }
    }




    private fun updateGameState() {/*
        _uiState.update { currentState ->
            currentState.copy(
                isGuessedAnswerWrong = false,
                currentMathQuestion = pickRandomMathQuestion(),
                currentProblemCount = currentState.currentProblemCount.inc(),
            )
        }
    */}


    fun resetGame() { /*
        userAnswer.clear()
        _uiState.value = GameUiState(currentMathQuestion = pickRandomMathQuestion())
    */}
}
