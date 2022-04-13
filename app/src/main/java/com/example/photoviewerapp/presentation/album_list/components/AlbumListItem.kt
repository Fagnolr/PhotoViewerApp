package com.example.photoviewerapp.presentation.album_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.photoviewerapp.data.remote.dto.AlbumDto
import com.example.photoviewerapp.domain.model.Album

@Composable
fun AlbumListItem(
    album: Album,
    onItemClick: (Album) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(album) }
            .padding(10.dp),
    ) {
        Text(
            text = album.title.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Created by : ${album.userId.toString()}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
    }
}