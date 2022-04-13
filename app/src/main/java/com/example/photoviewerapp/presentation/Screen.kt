package com.example.photoviewerapp.presentation

sealed class Screen(val route: String) {
    object AlbumListScreen: Screen("album_list_screen")
    object PhotoListScreen: Screen("photo_list_screen")
}