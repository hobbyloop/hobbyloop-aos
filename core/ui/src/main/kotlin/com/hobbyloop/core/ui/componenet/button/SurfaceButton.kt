package com.hobbyloop.core.ui.componenet.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import theme.HobbyLoopColor
import theme.pretendard

@Composable
fun SurfaceButton(
    text: String,
    horizontalPadding: Dp,
    verticalPadding: Dp,
    selectable: Boolean = false,
    isSelected: Boolean = false,
    selectedTextColor: Color = Color.Black,
    unselectedTextColor: Color = Color.Gray,
    selectedBorderColor: Color = Color.Black,
    unselectedBorderColor: Color = HobbyLoopColor.Gray40,
    selectedFontWeight: FontWeight = FontWeight(700),
    unselectedFontWeight: FontWeight = FontWeight(500),
    fontSize: TextUnit = 14.sp,
    letterSpacing: TextUnit = -(0.02).em,
    shape: Shape = RoundedCornerShape(16.dp),
    borderWidth: Dp = 1.dp,
    onClick: () -> Unit = {}
) {
    val textColor = if (isSelected) selectedTextColor else unselectedTextColor
    val borderColor = if (isSelected) selectedBorderColor else unselectedBorderColor
    val fontWeight = if (isSelected) selectedFontWeight else unselectedFontWeight

    val interactionSource = remember { MutableInteractionSource() }

    Surface(
        shape = shape,
        border = BorderStroke(width = borderWidth, color = borderColor),
        color = Color.White,
        modifier = Modifier
            .then(
                if (selectable) {
                    Modifier
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = { onClick() }
                            )
                        }
                        .indication(
                            interactionSource = interactionSource,
                            indication = rememberRipple(bounded = true, color = Color.Unspecified)
                        )
                } else {
                    Modifier
                }
            ),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(horizontal = horizontalPadding)
                .padding(vertical = verticalPadding)
        ) {
            Text(
                text = text,
                style = TextStyle(
                    lineHeight = fontSize,
                    fontSize = fontSize,
                    color = textColor,
                    fontWeight = fontWeight,
                    letterSpacing = letterSpacing,
                    fontFamily = pretendard
                ),
            )
        }
    }
}

@Preview
@Composable
fun PreviewSurfaceButtonIsNotSelectable() {
    Surface {
        SurfaceButton(
            text = "Britta",
            horizontalPadding = 16.dp,
            verticalPadding = 8.dp,
            fontSize = 14.sp,
            selectable = false,
            selectedTextColor = HobbyLoopColor.Primary,
            unselectedTextColor = HobbyLoopColor.Gray80,
            selectedBorderColor = HobbyLoopColor.Primary,
            unselectedBorderColor = HobbyLoopColor.Gray20,
            shape = RoundedCornerShape(999.dp),
            borderWidth = 1.dp,
            isSelected = false,
            onClick = { }
        )
    }
}

@Preview
@Composable
fun PreviewSurfaceButtonIsSelectable() {
    var isSelectedState by remember {
        mutableStateOf(false)
    }

    Surface {
        SurfaceButton(
            text = "Britta",
            horizontalPadding = 16.dp,
            verticalPadding = 8.dp,
            fontSize = 14.sp,
            selectable = true,
            selectedTextColor = HobbyLoopColor.Primary,
            unselectedTextColor = HobbyLoopColor.Gray80,
            selectedBorderColor = HobbyLoopColor.Primary,
            unselectedBorderColor = HobbyLoopColor.Gray20,
            shape = RoundedCornerShape(999.dp),
            borderWidth = 1.dp,
            isSelected = isSelectedState,
            onClick = {
                isSelectedState = isSelectedState.not()
            }
        )
    }
}
