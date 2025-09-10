package com.example.mappe1.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mappe1.R


@Composable
fun GameLayout(
    userAnswer: String,
    isAnswerWrong: Boolean,
    onUserAnswerChanged: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    currentMathProblem: String,
    problemCount: Int,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .clip(shapes.medium)
                    .background(colorScheme.surfaceTint)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
                    .align(alignment = Alignment.End),
                text = stringResource(R.string.problem_count, problemCount),
                style = typography.titleMedium,
                color = colorScheme.onPrimary
            )
            Text(
                text = currentMathProblem,
                style = typography.displayMedium
            )
        }
    }
}

@Preview
@Composable
fun GameLayoutPreview() {
    GameLayout(
        userAnswer = "",
        isAnswerWrong = false,
        onUserAnswerChanged = {},
        onKeyboardDone = {},
        currentMathProblem = "Math Problem",
        problemCount = 1,
        modifier = Modifier
    )
}