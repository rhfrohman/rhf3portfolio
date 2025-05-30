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

package com.example.rhf3portfolio.ui.theme

import androidx.compose.ui.graphics.Color

// Your existing colors (keep these)
val PaneBackground = Color(0xFFF5E8C8)
val AppContainerBackground = Color(0xFFF3D1A0)

// --- Define your new Blue colors based on your logo ---
// Replace these HEX codes with the actual colors from your logo

// For Light Theme (typically more saturated/brighter primary)
val PrimaryBlue = Color(0xFF0066CC)       // Replace with your main logo blue
val OnPrimaryBlue = Color(0xFFFFFFFF)     // Text/icons on PrimaryBlue (often White)
val PrimaryContainerBlue = Color(0xFFB3D9FF) // A lighter shade for containers
val OnPrimaryContainerBlue = Color(0xFF001E33) // Text/icons on PrimaryContainerBlue

// For Dark Theme (primary can be a bit desaturated/lighter than light theme's primary)
val DarkPrimaryBlue = Color(0xFF80BFFF)   // A lighter/softer blue for dark theme
val OnDarkPrimaryBlue = Color(0xFF24405E) // Text/icons on DarkPrimaryBlue
val DarkPrimaryContainerBlue = Color(0xFF004C99) // A darker container shade for dark theme
val OnDarkPrimaryContainerBlue = Color(0xFFB3D9FF) // Text/icons on DarkPrimaryContainerBlue

// You might want a Secondary Blue as well, or you can use neutrals/grays
// For simplicity, I'll focus on replacing primary.
// If you had PurpleGrey80 and PurpleGrey40 for secondary, decide if you want a blue-grey
// or a contrasting neutral.
val SecondaryBlue = Color(0xFF507FA8) // Example secondary blue
val OnSecondaryBlue = Color(0xFFFFFFFF)
val SecondaryContainerBlue = Color(0xFFD3E5F5)
val OnSecondaryContainerBlue = Color(0xFF0A1823)

val DarkSecondaryBlue = Color(0xFFADCBEF)
val OnDarkSecondaryBlue = Color(0xFF22303C)
val DarkSecondaryContainerBlue = Color(0xFF394653)
val OnDarkSecondaryContainerBlue = Color(0xFFD3E5F5)


// Keep Pink if it's your accent/tertiary, or choose a new one.
val Pink80 = Color(0xFFEFB8C8) // This was your old tertiary
val Pink40 = Color(0xFF7D5260) // This was your old tertiary

// Consider a new Tertiary color if Pink doesn't fit with Blue
val TertiaryYellow = Color(0xFFFFD700) // Example: A gold/yellow to complement blue
val OnTertiaryYellow = Color(0xFF3B2D00)
val TertiaryContainerYellow = Color(0xFFFFF0B3)
val OnTertiaryContainerYellow = Color(0xFF241A00)

val DarkTertiaryYellow = Color(0xFFE6C100)
val OnDarkTertiaryYellow = Color(0xFF302400)
val DarkTertiaryContainerYellow = Color(0xFF5C4900)
val OnDarkTertiaryContainerYellow = Color(0xFFFFF0B3)


// REMOVE OLD PURPLE DEFINITIONS:
// val Purple80 = Color(0xFFD0BCFF)
// val PurpleGrey80 = Color(0xFFCCC2DC)
// val Purple40 = Color(0xFF6650a4)
// val PurpleGrey40 = Color(0xFF625b71)