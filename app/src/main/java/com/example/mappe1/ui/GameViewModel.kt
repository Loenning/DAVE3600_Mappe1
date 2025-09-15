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
import android.util.Log
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.lang.System.console

class GameViewModel : ViewModel() {

    /* ------------------ VARIABLER ------------------ */

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    private var allMathProblems: List<String> = emptyList()
    private var allMathAnswers: List<String> = emptyList()
    private var currentIndex = 0

    private val _currentMathProblem = MutableLiveData<String>()
    val currentMathProblem: LiveData<String> = _currentMathProblem

    private var usedProblems: MutableSet<String> = mutableSetOf()

    var userAnswer by mutableStateOf("")
     private set

    init {
        resetGame()
    }



    /* ------------------ FUNKSJONER ------------------ */


    fun loadAllMathProblems(problemSet: List<String>, answerSet: List<String>) {
        // ----> HER ER LØSNINGEN <----
        // Bare last inn og stokk spørsmålene HVIS listen er tom.
        // ViewModel-objektet overlever rotasjon, så denne listen vil kun
        // være tom den aller første gangen funksjonen kalles.
        if (allMathProblems.isNotEmpty()) {
            return // Ikke gjør noe hvis spørsmålene allerede er lastet inn
        }

        val problemsAndAnswers = problemSet.zip(answerSet).shuffled()

        allMathProblems = problemsAndAnswers.map { it.first }
        allMathAnswers = problemsAndAnswers.map { it.second }
        currentIndex = 0

        _uiState.value = GameUiState(
            currentMathProblem = allMathProblems[currentIndex],
            currentProblemCount = currentIndex + 1
        )
    }


    fun pickRandomMathProblem(): String {
        var newQuestion: String
        if (usedProblems.size == allMathProblems.size) {
            usedProblems.clear()
        }
        do {
            newQuestion = allMathProblems.random()
        } while (usedProblems.contains(newQuestion))
        usedProblems.add(newQuestion)
        return newQuestion
    }


    fun updateUserAnswer(answer: String) {
        _uiState.update { it.copy(userAnswer = answer, isAnswerWrong = false) }
    }

    fun checkUserAnswer() {
        // --- CHANGE 3: Convert both user answer and correct answer to Int for comparison ---
        val userAnswerInt = uiState.value.userAnswer.toIntOrNull()
        val correctAnswerInt = allMathAnswers[currentIndex].toIntOrNull()

        if (userAnswerInt != null && userAnswerInt == correctAnswerInt) {
            // Correct Answer
            val updatedScore = _uiState.value.score + 10
            _uiState.update { it.copy(score = updatedScore) }
            goToNextProblem()
        } else {
            // Wrong Answer
            _uiState.update { it.copy(isAnswerWrong = true) }
        }
    }

    private fun goToNextProblem() {
        currentIndex++
        if (currentIndex < allMathProblems.size) {
            // There are more problems
            _uiState.update { currentState ->
                currentState.copy(
                    currentMathProblem = allMathProblems[currentIndex],
                    currentProblemCount = currentState.currentProblemCount + 1,
                    userAnswer = "", // Clear input field for next problem
                    isAnswerWrong = false
                )
            }
        } else {
            // The game is over
            _uiState.update { currentState ->
                currentState.copy(
                    isGameOver = true,
                    currentMathProblem = "You finished them all!",
                )
            }
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


    fun resetGame() {
        // Only proceed if problems have actually been loaded
        if (allMathProblems.isNotEmpty()) {
            currentIndex = 0
            _uiState.value = GameUiState(currentMathProblem = allMathProblems[0])
        }
    }
}
