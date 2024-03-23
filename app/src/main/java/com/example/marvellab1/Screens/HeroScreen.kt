package com.example.marvellab1.Screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.marvellab1.Data.Hero
import com.example.marvellab1.R
import com.example.marvellab1.ui.theme.Padding

@Composable
fun HeroScreen(onClick: () -> Unit, hero: Hero) {
    val pad = Padding()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AsyncImage(
            model = hero.cardImageUrl,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.matchParentSize(),
        )
        Button(
            onClick = { onClick() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .align(Alignment.TopStart)
                .wrapContentSize()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = hero.cardText,
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.padding(pad.medium)
            )
            Text(
                text = hero.cardDesc,
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier.padding(pad.medium)
            )
        }
    }
}