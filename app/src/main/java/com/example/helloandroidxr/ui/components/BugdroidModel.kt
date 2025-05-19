/*
 * Copyright 2025 The Android Open Source Project
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

package com.example.helloandroidxr.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.xr.compose.platform.LocalSession
import androidx.xr.compose.spatial.Subspace
import androidx.xr.compose.subspace.Volume
import androidx.xr.compose.subspace.layout.SubspaceModifier
import androidx.xr.compose.subspace.layout.offset
import androidx.xr.scenecore.GltfModel
import androidx.xr.scenecore.GltfModelEntity
import com.example.helloandroidxr.R
import kotlinx.coroutines.guava.await
import kotlinx.coroutines.launch
import java.io.InputStream

@Composable
fun BugdroidModel(showBugdroid: Boolean) {
    if (showBugdroid) {
        val xrSession = checkNotNull(LocalSession.current)
        val scope = rememberCoroutineScope()
        val context = LocalContext.current

        Subspace {
            val inputStream: InputStream =
                context.resources.openRawResource(R.raw.bugdroid_animated_wave)
            Volume(
                SubspaceModifier.offset(z = 400.dp) // Relative position
            ) { parent ->
                scope.launch {
                    val gltfModel = GltfModel.create(
                        session = xrSession,
                        assetData = inputStream.readBytes(),
                        assetKey = "BUGDROID"
                    ).await()
                    val gltfEntity = GltfModelEntity.create(xrSession, gltfModel)
                    // Make this glTF a child of the Volume
                    gltfEntity.setParent(parent)
                    // Change the size of the large glTF to 10%
                    gltfEntity.setScale(0.1f)
                    gltfEntity.startAnimation(
                        loop = true,
                        animationName = "Armature|Take 001|BaseLayer"
                    )
                }
            }
        }
    }
}