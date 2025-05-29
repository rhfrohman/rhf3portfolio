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

package com.example.rhf3portfolio.ui

import android.net.Uri
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import androidx.xr.compose.platform.LocalSpatialCapabilities
import androidx.xr.compose.spatial.Orbiter
import androidx.xr.compose.spatial.OrbiterEdge
import androidx.xr.compose.spatial.Subspace
import androidx.xr.compose.subspace.SpatialColumn
import androidx.xr.compose.subspace.SpatialPanel
import androidx.xr.compose.subspace.SpatialRow
import androidx.xr.compose.subspace.layout.SubspaceModifier
import androidx.xr.compose.subspace.layout.alpha
import androidx.xr.compose.subspace.layout.fillMaxSize
import androidx.xr.compose.subspace.layout.fillMaxWidth
import androidx.xr.compose.subspace.layout.height
import androidx.xr.compose.subspace.layout.movable
import androidx.xr.compose.subspace.layout.padding
import androidx.xr.compose.subspace.layout.resizable
import androidx.xr.compose.subspace.layout.size
import androidx.xr.compose.subspace.layout.width
import com.example.rhf3portfolio.R
import com.example.rhf3portfolio.ui.components.BugdroidModel
import com.example.rhf3portfolio.ui.components.EnvironmentControls
import com.example.rhf3portfolio.ui.components.SearchBar
import com.example.rhf3portfolio.ui.theme.Rhf3PortfolioTheme
import com.example.rhf3portfolio.CarouselItem
import com.example.rhf3portfolio.ui.components.ImageVideoCarousel
import kotlinx.coroutines.launch

@Composable
fun Rhf3PortfolioApp() {
    if (LocalSpatialCapabilities.current.isSpatialUiEnabled) {
        SpatialLayout(
            primaryContent = { PrimaryContent() },
            firstSupportingContent = { BlockOfContentOne() },
            secondSupportingContent = { BlockOfContentTwo() }
        )
    } else {
        NonSpatialTwoPaneLayout(
            secondaryPane = {
                BlockOfContentOne()
                BlockOfContentTwo()
            },
            primaryPane = { PrimaryContent() }
        )
    }
}

/**
 * Layout that displays content in [SpatialPanel]s, should be used when spatial UI is enabled.
 */
@Composable
private fun SpatialLayout(
    primaryContent: @Composable () -> Unit,
    firstSupportingContent: @Composable () -> Unit,
    secondSupportingContent: @Composable () -> Unit
) {
    val animatedAlpha = remember { Animatable(0.5f) }
    LaunchedEffect(Unit) {
        launch {
            animatedAlpha.animateTo(
                1.0f,
                animationSpec = tween(durationMillis = 400, easing = FastOutSlowInEasing)
            )
        }
    }
    Subspace {
        SpatialRow(modifier = SubspaceModifier.height(816.dp).fillMaxWidth()) {
            SpatialColumn(modifier = SubspaceModifier.width(400.dp)) {
                SpatialPanel(
                    SubspaceModifier
                        .alpha(animatedAlpha.value)
                        .size(400.dp)
                        .padding(bottom = 16.dp)
                        .movable()
                        .resizable()
                ) {
                    firstSupportingContent()
                }
                SpatialPanel(
                    SubspaceModifier
                        .alpha(animatedAlpha.value)
                        .weight(1f)
                        .movable()
                        .resizable()
                ) {
                    secondSupportingContent()
                }
            }
            SpatialPanel(
                modifier = SubspaceModifier
                    .alpha(animatedAlpha.value)
                    .fillMaxSize()
                    .padding(left = 16.dp)
                    .movable()
                    .resizable()
            ) {
                Column {
                    TopAppBar()
                    primaryContent()
                }
            }
        }
    }
}

/**
 * Layout that displays content in a 2-pane layout, should be used when spatial UI is not enabled.
 */
@Composable
private fun NonSpatialTwoPaneLayout(
    primaryPane: @Composable () -> Unit,
    secondaryPane: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
) {
    val animatedAlpha = remember { Animatable(0.5f) }
    LaunchedEffect(Unit) {
        launch {
            animatedAlpha.animateTo(
                1.0f,
                animationSpec = tween(durationMillis = 300, easing = FastOutSlowInEasing)
            )
        }
    }
    Column(
        modifier = modifier
            .alpha(animatedAlpha.value)
            .padding(16.dp)
            .systemBarsPadding()
    ) {
        TopAppBar()
        Spacer(Modifier.height(16.dp))
        if (windowSizeClass.windowWidthSizeClass == WindowWidthSizeClass.COMPACT) {
            TopAndBottomPaneLayout(primaryPane, secondaryPane)
        } else {
            SideBySidePaneLayout(primaryPane, secondaryPane)
        }
    }
}

/**
 * Positions the panes in a horizontal orientation
 */
@Composable
private fun SideBySidePaneLayout(
    primaryPane: @Composable () -> Unit,
    secondaryPane: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Surface(
            Modifier
                .width(400.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            Column {
                secondaryPane()
            }
        }
        Spacer(Modifier.width(16.dp))
        Surface(modifier.clip(RoundedCornerShape(16.dp))) {
            primaryPane()
        }
    }
}

/**
 * Positions the panes in a scrollable vertical orientation
 */
@Composable
private fun TopAndBottomPaneLayout(
    primaryPane: @Composable () -> Unit,
    secondaryPane: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Surface(Modifier.requiredHeight(500.dp)) {
            primaryPane()
        }
        Spacer(Modifier.height(16.dp))
        Surface(
            Modifier
                .requiredHeight(500.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
        ) {
            Column {
                secondaryPane()
            }
        }
    }
}

/**
 * Contains controls that decompose into Orbiters when spatial UI is enabled
 */
@Composable
private fun TopAppBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth()
    ) {
        Spacer(Modifier.weight(1f))
        Orbiter(
            position = OrbiterEdge.Top,
            offset = dimensionResource(R.dimen.top_ornament_padding),
            alignment = Alignment.Start
        ) {
            SearchBar()
        }
        Spacer(Modifier.weight(1f))
        Orbiter(
            position = OrbiterEdge.Top,
            offset = dimensionResource(R.dimen.top_ornament_padding),
            alignment = Alignment.End
        ) {
            EnvironmentControls()
        }
    }
}

@Composable
private fun PrimaryContent(modifier: Modifier = Modifier) {
    var showBugdroid by rememberSaveable { mutableStateOf(false) }

    if (LocalSpatialCapabilities.current.isSpatialUiEnabled) {
        Surface(modifier.fillMaxSize()) {
            Box(modifier.padding(48.dp), contentAlignment = Alignment.Center) {
                Button(
                    onClick = {
                        showBugdroid = true
                    },
                    modifier = modifier
                ) {
                    Text(
                        text = stringResource(id = R.string.show_bugdroid),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                BugdroidModel(showBugdroid = showBugdroid)
            }
        }
    } else {
        TextPane(
            text = stringResource(R.string.primary_content),
            modifier = modifier.clip(RoundedCornerShape(16.dp))
        )
    }
}

@Composable
private fun BlockOfContentOne(modifier: Modifier = Modifier) {
    TextPane(stringResource(R.string.block_of_content_1), modifier = modifier.height(240.dp))
}


// ... other imports
// Import com.example.helloandroidxr.ui.components.ImageVideoCarousel, com.example.helloandroidxr.CarouselItem, and your com.example.helloandroidxr.carouselItems list

@Composable
private fun BlockOfContentTwo(modifier: Modifier = Modifier) {
    // You can define com.example.helloandroidxr.carouselItems here or pass it from a ViewModel/higher composable
    val items = remember { // Remember the list to avoid recreation on recomposition
        listOf(
            CarouselItem.Image("https://picsum.photos/seed/page1/600/400"),
            // Make sure your package name is correct and the video file exists in res/raw
            CarouselItem.Video(Uri.parse("android.resource://com.example.rhf3portfolio/" + R.raw.herm)),
            CarouselItem.Image("https://picsum.photos/seed/page2/600/400"),
            CarouselItem.Image("https://picsum.photos/seed/page3/600/400")
        )
    }

    // Apply the original modifier if needed, or adjust as necessary for the carousel
    ImageVideoCarousel(
        items = items,
        modifier = modifier.fillMaxHeight() // Keep original constraint or adjust
    )
}

@Composable
@Preview(device = "spec:width=1920dp,height=1080dp,dpi=160")
@Preview(device = "spec:width=411dp,height=891dp")
fun AppLayoutPreview() {
    Rhf3PortfolioTheme {
        Rhf3PortfolioApp()
    }
}