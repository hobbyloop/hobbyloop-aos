package com.hobbyloop.core.ui.componenet.box

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun GradientBox(
    modifier: Modifier,
    borderWidth: Dp,
    gradientColors: List<Color>,
    borderShape: Shape,
    onClick: () -> Unit = {},
    content:  @Composable BoxScope.() -> Unit = { },
) {
    val gradientBrush = Brush.linearGradient(colors = gradientColors)

    Box(
        modifier = Modifier
            .then(modifier)
            .border(
                width = borderWidth,
                brush = Brush.linearGradient(colors = listOf(Color.Transparent, Color.Transparent)),
                shape = borderShape
            )
            .background(
                brush = gradientBrush,
                shape = borderShape
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
    ) {
        content()
    }
}

@Preview
@Composable
fun PreviewGradientBox() {
    Surface {
        GradientBox(
            modifier = Modifier
                .fillMaxWidth()
                .height(193.dp)
                .padding(horizontal = 16.dp),
            borderWidth = 2.dp,
            gradientColors = listOf(
                Color(0xFF88B967),
                Color(0xFFC2DA76),
                Color(0xFFEEDFCC)
            ),
            borderShape = RoundedCornerShape(
                topStart = 12.dp,
                topEnd = 2.dp,
                bottomEnd = 2.dp,
                bottomStart = 12.dp
            ),
            onClick = { }
        ) {
        }
    }
}
