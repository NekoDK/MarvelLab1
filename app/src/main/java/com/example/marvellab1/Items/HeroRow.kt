package com.example.marvellab1.Items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.marvellab1.Data.Hero
import com.example.marvellab1.Data.HeroData
import com.example.marvellab1.ui.theme.Padding


@OptIn(ExperimentalFoundationApi::class)
@Composable

fun HeroRow(navController: NavController, onClick: (Hero) -> Unit) {
    val pad = Padding()
    val heroList = HeroData.getHero()
    val state = rememberLazyListState()

    val snappingLayout = remember(state) { SnapLayoutInfoProvider(state) }
    Spacer(modifier = Modifier.padding(top = pad.big))
    LazyRow(
        modifier = Modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(space = pad.small),
        contentPadding = PaddingValues(horizontal = pad.big),
        state = state,
        flingBehavior = rememberSnapFlingBehavior(snappingLayout),

        )
    {
        items(heroList) { hero ->
            CardItem(navController = navController, onClick = onClick, hero = hero, state = state)
        }
    }
}