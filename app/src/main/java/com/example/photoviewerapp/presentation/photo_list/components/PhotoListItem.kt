package com.example.photoviewerapp.presentation.photo_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.photoviewerapp.data.remote.dto.PhotoDto
import com.example.photoviewerapp.domain.model.Photo

@Composable
fun PhotoListItem(photo: Photo) {
    Card(modifier = Modifier.padding(10.dp), shape = RoundedCornerShape(10.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(photo.url),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Text(photo.title.replaceFirstChar { it.uppercase() }, textAlign = TextAlign.Center)
        }
    }

}