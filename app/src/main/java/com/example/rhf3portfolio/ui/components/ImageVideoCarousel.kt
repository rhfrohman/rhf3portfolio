/*
 * Copyright 2024 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.rhf3portfolio.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import android.widget.VideoView
import coil.compose.AsyncImage
import com.example.rhf3portfolio.CarouselItem
import kotlinx.coroutines.launch

// (com.example.helloandroidxr.CarouselItem sealed class and example data from above)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageVideoCarousel(
    items: List<CarouselItem>,
    modifier: Modifier = Modifier
) {
    if (items.isEmpty()) {
        Text("No items to display in carousel.")
        return
    }

    val pagerState = rememberPagerState { items.size }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Box(modifier = modifier.fillMaxSize()) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { pageIndex ->
            val item = items[pageIndex]
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp) // Padding for each item
                    .background(MaterialTheme.colorScheme.surfaceVariant), // Background for item area
                contentAlignment = Alignment.Center
            ) {
                when (item) {
                    is CarouselItem.Image -> {
                        AsyncImage(
                            model = item.url,
                            contentDescription = "Carousel Image ${pageIndex + 1}",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Fit
                        )
                    }

                    is CarouselItem.Video -> {
                        // For video, we use AndroidView to embed the VideoView
                        // This is a simple implementation. For more control (play/pause, etc.),
                        // you'd need to manage the VideoView instance more actively.
                        AndroidView(
                            factory = {
                                VideoView(context).apply {
                                    setVideoURI(item.uri)
                                    // You might want to add media controller or auto-start
                                    // setMediaController(android.widget.MediaController(context))
                                    setOnPreparedListener { mp ->
                                        mp.isLooping = true // Optional: loop the video
                                        start() // Optional: auto-start
                                    }
                                }
                            },
                            modifier = Modifier.fillMaxSize(),
                            update = { videoView ->
                                // Called when the composable recomposes.
                                // You can update VideoView properties here if needed based on state.
                                videoView.setVideoURI(item.uri) // Re-set URI if it changes
                                videoView.start()
                            }
                        )
                    }
                }
            }
        }

        // Left Chevron Arrow
        IconButton(
            onClick = {
                scope.launch {
                    val prevPage = (pagerState.currentPage - 1).coerceAtLeast(0)
                    pagerState.animateScrollToPage(prevPage)
                }
            },
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(8.dp)
                .background(Color.Black.copy(alpha = 0.3f), CircleShape)
                .clip(CircleShape),
            enabled = pagerState.currentPage > 0
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "Previous",
                tint = Color.White
            )
        }

        // Right Chevron Arrow
        IconButton(
            onClick = {
                scope.launch {
                    val nextPage = (pagerState.currentPage + 1).coerceAtMost(items.size - 1)
                    pagerState.animateScrollToPage(nextPage)
                }
            },
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(8.dp)
                .background(Color.Black.copy(alpha = 0.3f), CircleShape)
                .clip(CircleShape),
            enabled = pagerState.currentPage < items.size - 1
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Next",
                tint = Color.White
            )
        }

        // Optional: Page Indicators (Dots)
        Row(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            items.indices.forEach { index ->
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary else Color.LightGray)
                        .clickable { scope.launch { pagerState.animateScrollToPage(index) } }
                )
            }
        }
    }
}