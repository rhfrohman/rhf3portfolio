package com.example.rhf3portfolio.ui.theme // Adjust to your package name

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font // Important import for downloadable fonts
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.rhf3portfolio.R // Adjust to your R class import

// Provider for Google Fonts
val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs // Reference the array from Step 1
)

// Define the Merriweather font
val merriweatherFontName = GoogleFont("Merriweather")

val merriweatherFontFamily = FontFamily(
    Font(googleFont = merriweatherFontName, fontProvider = provider), // Regular
    Font(googleFont = merriweatherFontName, fontProvider = provider, weight = FontWeight.Bold), // Bold example
    Font(googleFont = merriweatherFontName, fontProvider = provider, weight = FontWeight.ExtraBold), // Weight 300

    // Add other weights and styles (italic) as needed by creating more Font() entries
    // e.g., Font(googleFont = GoogleFont("Merriweather Italic"), fontProvider = provider, style = FontStyle.Italic)
    // or for specific weights:
    // Font(googleFont = GoogleFont("Merriweather"), fontProvider = provider, weight = FontWeight.Light), // Weight 300
    // Font(googleFont = GoogleFont("Merriweather"), fontProvider = provider, weight = FontWeight.Medium), // Weight 500
)

// Replace your existing Typography
val Typography1 = Typography(
    displayLarge = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Black,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = (-2).sp
    ),
    headlineLarge = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Normal, // Or FontWeight.Bold if you want headlines bold
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.ExtraBold, // Titles are often bold
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.15.sp
    ),
    titleSmall = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.4.sp
    ),
    labelLarge = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = merriweatherFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

