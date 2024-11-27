package com.example.ninja.core.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.ninja.core.theme.BlackText

@Composable
fun SectionTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = TextStyle(fontSize = 22.sp, color = BlackText, fontWeight = FontWeight(900)),
        modifier = modifier
    )
}