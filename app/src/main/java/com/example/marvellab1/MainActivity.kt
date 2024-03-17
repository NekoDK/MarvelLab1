package com.example.marvellab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.marvellab1.Data.HeroViewModel
import com.example.marvellab1.Screens.HeroScreen
import com.example.marvellab1.Screens.MainScreen
import com.example.marvellab1.ui.theme.MarvelLab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel: HeroViewModel by viewModels()
            MarvelLab1Theme {
                Surface(modifier = Modifier.fillMaxSize(), color = Color.DarkGray) {
                }

                NavHost(navController = navController, startDestination = "scr1") {
                    composable("scr1") {
                        MainScreen(navController = navController, onClick = { hero ->
                            navController.navigate("scr2/${hero.IdHero}")
                        })
                    }
                    composable(
                        "scr2/{heroId}",
                        arguments = listOf(navArgument("heroId") { type = NavType.IntType })
                    ) { backStackEntry ->
                        val heroId = backStackEntry.arguments?.getInt("heroId") ?: -1
                        val hero = viewModel.getHeroById(heroId)
                        if (hero != null) {
                            HeroScreen(
                                onClick = { navController.navigate("scr1") },
                                hero = hero
                            )
                        } else {
                            // Jopa
                        }
                    }

                }
            }
        }
    }
}



