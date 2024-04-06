package com.test.wiproassignment.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.test.wiproassignment.R
import com.test.wiproassignment.domain.entities.CatImage
import com.test.wiproassignment.presentation.viewmodels.CatViewModel

@Composable
fun MainScreen(viewModel: CatViewModel = hiltViewModel()) {
    val images by viewModel.imageState.collectAsState()

    // Example: Two columns staggered grid
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(images.size) { index ->
            ImageItem(image = images[index])
        }
    }
}

@Composable
fun ImageItem(image: CatImage) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Image(
            painter = rememberImagePainter(
                data = image.url,
                builder = {
                    crossfade(true)
                    placeholder(R.drawable.ic_launcher_foreground) // Define a placeholder in your drawable resources if needed
                }
            ),
            contentDescription = "Cat Image",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth // Adjust the scaling to fit the width of the card
        )
    }
}