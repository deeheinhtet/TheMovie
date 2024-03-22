//package com.dee.brewstar.component
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.wrapContentHeight
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Star
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import coil.compose.AsyncImage
//
///**
// * Created by Hein Htet
// */
//
//@Composable
//fun BeerItem(modifier: Modifier, item: BeerResponse) {
//
//    val isFavorite = remember { mutableStateOf(false) }
//
//    Card(
//        modifier
//            .fillMaxWidth().wrapContentHeight()
//            .clickable {  },
//        colors = CardDefaults.cardColors(
//            containerColor = MaterialTheme.colorScheme.surfaceVariant,
//        ),
//    ) {
//        Box(modifier = Modifier.fillMaxWidth()) {
//            Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
//                AsyncImage(
//                    model = item.imageUrl.orEmpty(),
//                    contentDescription = item.name,
//                    modifier = Modifier
//                )
//                Spacer(Modifier.padding(top = 8.dp))
//                Text(
//                    item.name,
//                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold)
//                )
//                item.tagline?.let {
//                    Text(
//                        item.tagline.orEmpty(),
//                        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal)
//                    )
//                }
//            }
//            FavoriteToggle(
//                modifier = Modifier
//                    .align(Alignment.TopEnd),
//                checked = isFavorite.value,
//                onCheckedChange = {
//                    isFavorite.value = it
//                }
//            )
//        }
//    }
//}