package com.dee.themovie.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dee.themovie.R
import com.dee.themovie.theme.Text16Bold
import com.dee.home.presentation.ToggleSelectionModel
import com.dee.home.common.MovieItemDisplay

/**
 * Created by Hein Htet
 */

@Composable
fun HorizontalListMoviesView(
    modifier: Modifier = Modifier,
    headerTitle: String? = null,
    toggleSelections: List<ToggleSelectionModel> = emptyList(),
    movies: List<MovieItemDisplay> = emptyList(),
    onItemClick: (item: MovieItemDisplay) -> Unit = {},
    onToggleItemClick: (item: ToggleSelectionModel) -> Unit = { },
) {
    Column(modifier) {
        if (headerTitle != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text16Bold(
                    headerTitle,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                    ),
                    textStyle = MaterialTheme.typography.titleLarge.copy(fontSize = 18.sp)
                )
                if (toggleSelections.isNotEmpty()) {
                    ToggleSelectionView(
                        modifier = Modifier.padding(start = 8.dp),
                        selections = toggleSelections,
                        onItemClick = onToggleItemClick
                    )
                } else {
                    Box(modifier = Modifier.weight(1f)) {}
                    Box(
                        modifier = Modifier.padding(horizontal = 8.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .clickable { }

                    ) {
                        Text16Bold(
                            modifier = Modifier.padding(horizontal = 8.dp),
                            text = stringResource(R.string.LABEL_SEE_MORE),
                            textStyle = TextStyle(
                                color = MaterialTheme.colorScheme.primary
                            ),
                        )
                    }
                }
            }
        }
        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            modifier = Modifier.height(380.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(movies, key = { it.id }) {
                MovieItemView(item = it, onItemClick = { onItemClick.invoke(it) })
            }
        }
    }
}