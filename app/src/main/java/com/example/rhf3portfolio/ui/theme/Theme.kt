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

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// Assuming your text colors are defined here or directly in the scheme
val MyLightOnSurfaceColor = Color(0xFF333333)
val MyLightOnBackgroundColor = Color(0xFF222222)
val MyDarkOnSurfaceColor = Color(0xFFE0E0E0)
val MyDarkOnBackgroundColor = Color(0xFFF5F5F5)


private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimaryBlue,
    onPrimary = OnDarkPrimaryBlue,
    primaryContainer = DarkPrimaryContainerBlue,
    onPrimaryContainer = OnDarkPrimaryContainerBlue,

    secondary = DarkSecondaryBlue, // Or your chosen secondary
    onSecondary = OnDarkSecondaryBlue,
    secondaryContainer = DarkSecondaryContainerBlue,
    onSecondaryContainer = OnDarkSecondaryContainerBlue,

    tertiary = DarkTertiaryYellow, // Or your chosen tertiary (was Pink80)
    onTertiary = OnDarkTertiaryYellow,
    tertiaryContainer = DarkTertiaryContainerYellow,
    onTertiaryContainer = OnDarkTertiaryContainerYellow,

    background = Color(0xFF1C1B1F), // Example dark background
    onBackground = MyDarkOnBackgroundColor,
    surface = Color(0xFF2C2B2F), // Example dark surface
    onSurface = MyDarkOnSurfaceColor,
    surfaceVariant = Color(0xFF49454F), // Darker variant
    onSurfaceVariant = Color(0xFFCAC4D0) // Text on surfaceVariant
    // ... other colors like error, onError, etc.
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    onPrimary = OnPrimaryBlue,
    primaryContainer = PrimaryContainerBlue,
    onPrimaryContainer = OnPrimaryContainerBlue,

    secondary = SecondaryBlue, // Or your chosen secondary (was PurpleGrey40)
    onSecondary = OnSecondaryBlue,
    secondaryContainer = SecondaryContainerBlue,
    onSecondaryContainer = OnSecondaryContainerBlue,

    tertiary = TertiaryYellow, // Or your chosen tertiary (was Pink40)
    onTertiary = OnTertiaryYellow,
    tertiaryContainer = TertiaryContainerYellow,
    onTertiaryContainer = OnTertiaryContainerYellow,

    // Your existing background/surface setup
    background = AppContainerBackground, // Or another light background color
    onBackground = OnDarkPrimaryBlue,
    surface = Color(0xFFF8F0E3), // Or Color(0xFFF8F0E3) if that was your intended surface
    onSurface = OnDarkPrimaryBlue,
    surfaceVariant = Color(0xFFF1F1F1), // Lighter variant
    onSurfaceVariant = Color(0xFF494544) // Text on surfaceVariant
    // ... other colors like error, onError, etc.

    /* Other default colors to override if needed:
    error = Color(0xFFB00020),
    onError = Color.White,
    outline = Color(0xFF79747E)
    */
)

@Composable
fun Rhf3PortfolioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Set to false to ensure your blue theme is used
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography1, // Make sure Typography1 is correctly defined
        content = content
    )
}