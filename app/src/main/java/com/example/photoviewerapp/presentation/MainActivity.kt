package com.example.photoviewerapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.photoviewerapp.R
import com.example.photoviewerapp.presentation.album_list.AlbumListScreen
import com.example.photoviewerapp.presentation.photo_list.PhotoListScreen
import com.example.photoviewerapp.presentation.ui.theme.PhotoViewerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoViewerTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.AlbumListScreen.route
                    ) {
                        composable(
                            route = Screen.AlbumListScreen.route
                        ) {
                            AlbumListScreen(navController)
                        }
                        composable(
                            route = Screen.PhotoListScreen.route + "/{albumId}"
                        ) {
                            PhotoListScreen()
                        }
                    }
                }
            }
        }
    }
}