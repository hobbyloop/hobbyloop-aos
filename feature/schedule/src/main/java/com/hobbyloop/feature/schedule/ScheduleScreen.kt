package com.hobbyloop.feature.schedule

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
internal fun ScheduleScreen(
    backgroundColor: Color,
    onContentColor: (color: Color) -> Unit,
) {
    onContentColor(backgroundColor)

    Scaffold { padding ->
        Column(
            modifier =
                Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(backgroundColor),
        ) {
            Text(
                text = "스케줄",
            )
        }
    }
}