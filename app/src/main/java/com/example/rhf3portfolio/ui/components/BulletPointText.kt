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

// In ui/components/BulletPointComposables.kt

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun BulletPointText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    color: Color = LocalContentColor.current,
    bulletChar: String = "•" // You can customize the bullet character
) {
    Row(
        modifier = modifier.padding(vertical = 4.dp), // Add some vertical spacing between bullet points
        verticalAlignment = Alignment.Top // Align bullet with the top of the text
    ) {
        Text(
            text = bulletChar,
            style = style.copy(color = color),
            modifier = Modifier.padding(end = 8.dp) // Space between bullet and text
        )
        Text(
            text = text,
            style = style.copy(color = color)
        )
    }
}

// Optional: A composable for a list of bullet points
@Composable
fun BulletList(
    items: List<String>,
    modifier: Modifier = Modifier,
    itemStyle: TextStyle = LocalTextStyle.current,
    itemColor: Color = LocalContentColor.current
) {
    // Column will handle the vertical arrangement.
    // If you need scrolling for many bullet points within a fixed height,
    // you might use LazyColumn here instead and pass the items directly to its items block.
    // For now, assuming Column is sufficient for the text pane.
    // See [1] for more details on LazyColumn if needed.
    // The parent composable (TextPane or BlockOfContentOne) should handle overall scrolling if necessary.
    Column(modifier = modifier) {
        items.forEach { itemText ->
            BulletPointText(
                text = itemText,
                style = itemStyle,
                color = itemColor
            )
        }
    }
}