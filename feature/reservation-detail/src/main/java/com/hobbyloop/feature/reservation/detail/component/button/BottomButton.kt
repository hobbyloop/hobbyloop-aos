package com.hobbyloop.feature.reservation.detail.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hobbyloop.feature.reservation.detail.Purple

@Composable
fun BottomButton(
    isSelected: Boolean,
    onClick: () -> Unit,
    text: String,
    selectedColor: Color,
    unselectedColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .border(
                width = 2.dp,
                color = if (isSelected) selectedColor else unselectedColor,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = if (isSelected) selectedColor else unselectedColor,
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            )
        ) {
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomButtonSelectedPreview() {
    var isSelected by remember { mutableStateOf(true) }

    BottomButton(
        isSelected = isSelected,
        onClick = { isSelected = !isSelected },
        text = "선택완료",
        selectedColor = Color.Gray,
        unselectedColor = Purple,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp)
            .offset(y = (-10).dp)
    )
}

@Preview(showBackground = true)
@Composable
fun BottomButtonNotSelectedPreview() {
    var isSelected by remember { mutableStateOf(false) }

    BottomButton(
        isSelected = isSelected,
        onClick = { isSelected = !isSelected },
        text = "선택완료",
        selectedColor = Color.Gray,
        unselectedColor = Purple,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp)
            .offset(y = (-10).dp)
    )
}
