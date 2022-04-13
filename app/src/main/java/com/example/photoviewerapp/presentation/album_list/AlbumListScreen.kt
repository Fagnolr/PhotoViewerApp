package com.example.photoviewerapp.presentation.album_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.photoviewerapp.presentation.Screen
import com.example.photoviewerapp.presentation.album_list.components.AlbumListItem
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun AlbumListScreen(
    navController: NavController,
    viewModel: AlbumListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = viewModel.state.value.isRefreshing),
        onRefresh = { viewModel.getAlbums(isRefreshing = true) }) {
        Box(modifier = Modifier.fillMaxSize()) {
            state.albums?.let { album ->
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    items(album) { album ->
                        AlbumListItem(
                            album = album,
                            onItemClick = {
                                navController.navigate(Screen.PhotoListScreen.route + "/${album.id}")
                            }
                        )
                    }
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}