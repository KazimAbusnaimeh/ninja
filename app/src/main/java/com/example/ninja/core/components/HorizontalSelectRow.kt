package com.example.ninja.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ninja.core.theme.GrayEdge
import com.example.ninja.core.theme.GrayText
import com.example.ninja.core.theme.MainColor
import com.example.ninja.domain.models.Tag


@Composable
fun HorizontalSelectRow(
    selectedCategoryId: Int,
    restaurantCategories: List<Tag>,
    onCategoryChanged: (Int) -> Unit
) {
    LazyRow(
        Modifier.padding(0.dp, 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(restaurantCategories) { category ->
            TagItem(
                title = category.text,
                selected = selectedCategoryId == category.id,
                onClick = {
                    if (category.id != selectedCategoryId) {
                        onCategoryChanged(category.id)
                    }
                }
            )
        }
    }
}

@Composable
private fun TagItem(
    title: String,
    selected: Boolean,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .border(1.dp, GrayEdge, RoundedCornerShape(100.dp))
            .clip(RoundedCornerShape(100.dp))
            .background(color = if (selected) MainColor else Color.Transparent)
            .clickable { onClick() }
            .padding(10.dp, 12.dp)
    ) {
        Text(
            title,
            style = TextStyle(color = if (selected) Color.White else GrayText, fontSize = 14.sp)
        )
    }
}