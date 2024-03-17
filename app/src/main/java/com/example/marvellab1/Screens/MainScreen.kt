package com.example.marvellab1.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.marvellab1.Data.Hero
import com.example.marvellab1.Items.HeroRow
import com.example.marvellab1.R
import com.example.marvellab1.ui.theme.Padding

@Composable
fun MainScreen(navController: NavController, onClick: (Hero) -> Unit){
    val pad = Padding()
    Image(
        modifier = Modifier.fillMaxSize()
            .rotate(180f),
        alignment = Alignment.TopEnd,
        painter = painterResource(id = R.drawable.triangle),
        contentDescription = null)
    Column(modifier=Modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.mar),
            modifier = Modifier
                .padding(pad.big)
                .size(width = 160.dp, height = 45.dp),
            contentDescription = null)
        Text(
            text = "Choose your hero",
            fontSize = 36.sp,
            color = Color.White,
        )
        HeroRow(navController = navController ,onClick = onClick)
    }
}