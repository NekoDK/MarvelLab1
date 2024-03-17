package com.example.marvellab1.Items


import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.marvellab1.Data.Hero
import com.example.marvellab1.ui.theme.Padding
import kotlin.math.abs

@Composable
fun CardItem(
    navController: NavController,
    onClick: (Hero) -> Unit,
    hero: Hero,
    state: LazyListState
) {
    val pad = Padding()

    val index = hero.IdHero
    val scale by remember {
        derivedStateOf {
            val currentItem = state.layoutInfo.visibleItemsInfo.firstOrNull { it.index == index }
                ?: return@derivedStateOf 1.0f
            val halfRowWidth = state.layoutInfo.viewportSize.width / 2
            (
                    1f - minOf(
                        1f,
                        abs(currentItem.offset + (currentItem.size / 2) - halfRowWidth).toFloat() / halfRowWidth
                    ) * 0.20f
                    )
        }
    }

    Card(
        modifier = Modifier
            .size(width = 300.dp, height = 550.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .scale(scale)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true),
            ) {
                onClick(hero)
                navController.navigate("scr2/${hero.IdHero}")
            },
    ) {
        Box {
            AsyncImage(
                model = hero.cardImageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = "Card image",
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomStart),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = stringResource(id = hero.cardText),
                    color = Color.White,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(pad.medium)
                )
            }
        }
    }
}
