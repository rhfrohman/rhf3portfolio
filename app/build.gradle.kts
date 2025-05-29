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

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.screenshot)
}

android {
    namespace = "com.example.rhf3portfolio"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.rhf3portfolio"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.4"
    }
    experimentalProperties["android.experimental.enableScreenshotTest"] = true
}

dependencies {
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    implementation(libs.androidx.arcore)
    implementation(libs.androidx.scenecore)
    implementation(libs.androidx.compose)
    implementation(libs.kotlinx.coroutines.guava)
    implementation(libs.androidx.scenecore)
    implementation(libs.material)

    implementation("io.coil-kt:coil-compose:2.6.0") // Or the latest version of Coil
    implementation(libs.androidx.compose.material3) // You already have this
    implementation(libs.androidx.compose.foundation) // Ensure you have foundation if not through BOM
    implementation("androidx.compose.ui:ui-text-google-fonts:1.8.1") // Use the latest stable version

    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.adaptive.android)
    implementation(libs.androidx.concurrent.futures)
    implementation(libs.androidx.compose.runtime)
    implementation(libs.androidx.activity.compose)

    implementation(libs.androidx.compose.ui.tooling)

    screenshotTestImplementation(libs.androidx.compose.ui.tooling)
}