//package com.dee.brewstar.component
//
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.PaddingValues
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.lazy.grid.GridCells
//import androidx.compose.foundation.lazy.grid.GridItemSpan
//import androidx.compose.foundation.lazy.grid.LazyGridScope
//import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
//import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
//import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
//import androidx.compose.foundation.lazy.staggeredgrid.items
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import beercommon.BeerResponse
//
///**
// * Created by Hein Htet
// */
//
//@Composable
//fun BeerListView(beers: List<BeerResponse>, onFooterView: @Composable () -> Unit = {}) {
//    LazyVerticalStaggeredGrid(
//        columns = StaggeredGridCells.Fixed(2),
//        contentPadding = PaddingValues(16.dp),
//        verticalItemSpacing = 16.dp,
//        horizontalArrangement = Arrangement.spacedBy(16.dp),
//    ) {
//        items(beers, key = { it.id }) {
//            BeerItem(Modifier, it)
//
//        }
//        if(beers.isNotEmpty()){
//            item (span = StaggeredGridItemSpan.FullLine){
//                onFooterView()
//            }
//        }
//    }
//}
