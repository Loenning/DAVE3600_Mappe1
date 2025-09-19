package com.example.mappe1.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.mappe1.ui.GameViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mappe1.ui.components.GameLayout
import com.example.mappe1.R
import com.example.mappe1.ui.components.Keypad
import com.example.mappe1.ui.theme.Mappe1Theme

@Composable
fun GameScreen(
    gameViewModel: GameViewModel = viewModel(),
    onClickCancelGame: () -> Unit
) {
    val gameUiState by gameViewModel.uiState.collectAsState()
    val context = LocalContext.current

    // This LaunchedEffect will run once when GameScreen enters the composition.
    // It's the perfect place to do one-time setup tasks.
    LaunchedEffect(Unit) {
        // 1. The Composable uses its context to get the arrays from XML.
        val problems = context.resources.getStringArray(R.array.math_questions).toList()
        val answers = context.resources.getStringArray(R.array.math_answers).toList()

        // 2. The Composable passes this data to the ViewModel.
        gameViewModel.loadAllMathProblems(problems, answers)
    }
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.mappe1_logo),
                contentDescription = "App-logo",
                modifier = Modifier.size(80.dp)
            )

            Button(
                modifier = Modifier
                    .clip(shapes.medium)
                    .background(colorScheme.surfaceTint)
                    .height(60.dp)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .align(Alignment.CenterEnd),
                onClick = {/*TODO*/}
            ) {
                Text(
                    text = stringResource(R.string.stop_game),
                    style = typography.titleMedium,
                    color = colorScheme.onPrimary
                )
            }
        }


        GameLayout(
            userAnswer = gameUiState.userAnswer,
            isAnswerWrong = gameUiState.isAnswerWrong,
            onUserAnswerChanged = { gameViewModel.updateUserAnswer(it) },
            onKeyboardDone = { gameViewModel.checkUserAnswer() }, // **FIX:** No parameter needed
            currentMathProblem = gameUiState.currentMathProblem,
            problemCount = gameUiState.currentProblemCount,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Keypad()
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { gameViewModel.checkUserAnswer() }
            ) {
                Text(
                    text = stringResource(R.string.submit),
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    Mappe1Theme {
        GameScreen(
            onClickCancelGame = {}
        )
    }
}