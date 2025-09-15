package com.example.mappe1.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp


@Composable
fun NumberButton(
    text: String,
    onClick: () -> Unit, // En funksjon for hva som skjer ved klikk
    modifier: Modifier = Modifier // En standard modifier for ekstra fleksibilitet
) {
    Button(
        onClick = onClick, // Bruk funksjonen som sendes inn
        modifier = modifier
            .size(64.dp) // All stil er samlet her
            .padding(3.dp) // Padding er også her nå
            .background(colorScheme.surfaceTint),
        shape = RectangleShape, // Her definerer vi formen
        colors = ButtonDefaults.buttonColors( // Og her definerer vi fargene
            containerColor = Color.DarkGray,
            contentColor = Color.White
        )
    ) {
        Text(text = text)
    }
}



@Composable
fun ButtonRowTop(modifier: Modifier = Modifier){
    Row {
        NumberButton(onClick = { /*TODO*/ }, text = "0", modifier = modifier)
        NumberButton(onClick = { /*TODO*/ }, text = "1", modifier = modifier)
        NumberButton(onClick = { /*TODO*/ }, text = "2", modifier = modifier)
        NumberButton(onClick = { /*TODO*/ }, text = "3", modifier = modifier)
        NumberButton(onClick = { /*TODO*/ }, text = "4", modifier = modifier)
    }
}

@Composable
fun ButtonRowBottom(modifier: Modifier = Modifier){
    Row {
        NumberButton(onClick = { /*TODO*/ }, text = "5", modifier = modifier)
        NumberButton(onClick = { /*TODO*/ }, text = "6", modifier = modifier)
        NumberButton(onClick = { /*TODO*/ }, text = "7", modifier = modifier)
        NumberButton(onClick = { /*TODO*/ }, text = "8", modifier = modifier)
        NumberButton(onClick = { /*TODO*/ }, text = "9", modifier = modifier)
    }
}



@Composable
fun MenuButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .size(128.dp)
            .padding(3.dp),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Yellow,
            contentColor = Color.Green
        )
    ) {
        Text(text = text)
    }
}