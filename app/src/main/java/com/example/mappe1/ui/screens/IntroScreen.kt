package com.example.mappe1.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import com.example.mappe1.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mappe1.ui.AppRoutes

@Composable
fun IntroScreen(
    onStartGameClick: () -> Unit,  // <-- PARAMETEREN DEFINERES HER
    onAboutGameClick: () -> Unit,
    onPreferencesClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.mappe1_logo),
            contentDescription = "App-logo",
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onStartGameClick) {
            Text(stringResource(id = R.string.start_game))
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = onAboutGameClick) {
            Text(stringResource(id = R.string.about_game))
        }
        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = onPreferencesClick) {
            Text(stringResource(id = R.string.preferances))
        }
    }
}



@Preview
@Composable
fun IntroScreenPreview() {
    IntroScreen(
        onStartGameClick = {},
        onAboutGameClick = {},
        onPreferencesClick = {}
    )
}