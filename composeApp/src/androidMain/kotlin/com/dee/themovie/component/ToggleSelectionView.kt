package com.dee.themovie.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.dee.themovie.theme.Text12
import com.dee.home.presentation.ToggleSelectionModel

/**
 * Created by Hein Htet
 */

@Composable
fun ToggleSelectionView(
    modifier: Modifier = Modifier,
    selections: List<ToggleSelectionModel>,
    onItemClick: (item: ToggleSelectionModel) -> Unit = { },
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(30.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)),
        colors = CardDefaults.cardColors().copy(containerColor = Color.Transparent)
    ) {
        LazyRow {
            items(selections, key = { it.isSelected }) {
                ToggleSectionItem(it, onItemClick)
            }
        }
    }
}

@Composable
fun ToggleSectionItem(
    item: ToggleSelectionModel,
    onItemClick: (item: ToggleSelectionModel) -> Unit = { },
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(if (item.isSelected) 30.dp else 0.dp))
            .background(if (item.isSelected) MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp) else Color.Transparent)
            .clickable { onItemClick.invoke(item) }
            .padding(horizontal = 16.dp, vertical = 4.dp)
    ) {
        Text12(
            item.title,
            textStyle = TextStyle(color = if (item.isSelected) MaterialTheme.colorScheme.primary else Color.Gray)
        )
    }
}