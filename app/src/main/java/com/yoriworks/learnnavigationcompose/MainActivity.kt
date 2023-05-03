package com.yoriworks.learnnavigationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yoriworks.learnnavigationcompose.screen.DetailScreen
import com.yoriworks.learnnavigationcompose.screen.HomeScreen
import com.yoriworks.learnnavigationcompose.ui.theme.LearnNavigationComposeTheme

class MainActivity : ComponentActivity() {
    
    sealed class NavDrawerItem(var route: String, var icon: Int, var title: String) {
        object Home : NavDrawerItem("home", R.drawable.ic_menu_home, "Home")
        object Detail : NavDrawerItem("detail", android.R.drawable.ic_menu_info_details, "Detail")
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnNavigationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MyAppNavHost(navController = navController)
                }
            }
        }
    }
    
}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = startDestination
    ) {
        composable("home") { HomeScreen(navController) }
        composable("detail") { DetailScreen(navController) }
    }
}





