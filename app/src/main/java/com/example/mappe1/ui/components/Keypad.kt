package com.example.mappe1.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Keypad(
    onNumberClick: (String) -> Unit,
    onClear: () -> Unit,
    onSubmit: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        for (row in listOf(
            listOf("1", "2", "3"),
            listOf("4", "5", "6"),
            listOf("7", "8", "9"),
        )) {
            Row {
                for (num in row) {
                    CustomButton(onClick = { onNumberClick(num)}, modifier = Modifier.padding(4.dp)) {
                        Text(num)
                    }
                }
            }
        }
        Row {
            CustomButton(onClick = onClear, modifier = Modifier.padding(4.dp)) {
                Text("<--")
            }
            CustomButton(onClick = onClear, modifier = Modifier.padding(4.dp)) {
                Text("0")
            }
            CustomButton(onClick = onSubmit, modifier = Modifier.padding(4.dp)) {
                Text("Submit")
            }
        }
    }
}

@Preview(showBackground = true, name = "NumericKeypad Preview")
@Composable
fun NumericKeypadPreview() {
    Keypad(
        onNumberClick = {},
        onClear = {},
        onSubmit = {}
    )
}
