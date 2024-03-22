package com.dee.themovie.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by Hein Htet
 */

@Composable
fun LoadMoreButton(onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(modifier = Modifier, onClick = {
            onClick.invoke()
        }) {
            Text("Load More")
        }
    }
}