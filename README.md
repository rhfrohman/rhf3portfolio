# RHF3 Portfolio - An Android XR Showcase

Welcome to the RHF3 Portfolio app! This Android Studio project is a dynamic and immersive portfolio application for **Roland Frohman III**, showcasing his skills and projects using Android XR technology. The app demonstrates modern Android development practices, Jetpack Compose, and the exciting capabilities of spatial UI.

This application is built upon the foundational "Hello Android XR" sample, extending it to create a personalized portfolio experience.

You can learn more about my work at: [rhfrohman3.com](https://rhfrohman3.com)

## 🎥 Video Demonstration

[RHF3 Portfolio XR View](docs/screenshots/demo.gif)

**Example:**
<!-- [Watch the RHF3 Portfolio App in Action!](https://www.youtube.com/watch?v=your_video_id) -->

## ✨ Core Features & Demonstrations

This portfolio application showcases:

-   **Android XR Integration:**
    -   **Orbiters:** Components like the search bar and environment controls gracefully detach and orbit in the spatial view.
    -   **Dynamic Layouts:** The app intelligently switches between a traditional 2D layout (for standard Android devices or when XR is not enabled) and a fully spatial layout in XR environments.
    -   **Animated 3D Models:** Explores the integration and animation of 3D models (glTF) within the spatial environment, adding depth and interactivity (as seen with the `BugdroidModel` and `RHF3Model` components).
-   **Modern Android UI with Jetpack Compose:**
    -   **Custom Theming:** A distinct blue-centric Material 3 theme, inspired by Roland's branding, is implemented for both light and dark modes (see `Theme.kt` and `Color.kt`).
    -   **Adaptive UI:** The layout adapts to different screen sizes and orientations, providing a good experience on phones, tablets, and within the XR space.
    -   **Interactive Components:** Includes custom components like a functional `SearchBar` and will feature other interactive elements.
-   **Portfolio Content Presentation:**
    -   *(Placeholder: Detail how specific portfolio pieces like "Key Skills," "Project Carousel," or "Contact Information" are displayed. For example: "Interactive display of Roland's key skills using Material Design components.")*
    -   *(Placeholder: "Image and video carousel for showcasing visual projects.")*
    -   *(Placeholder: "Easy access to contact Roland via integrated Gmail and LinkedIn buttons.")*
-   **Environment Controls:** Allows users to switch between different virtual environments when in XR mode.

## 🚀 Getting Started

### Prerequisites

-   **Android Studio:** The latest Canary version is highly recommended for the best Android XR development experience. Download it from the [Android Studio Preview page](https://developer.android.com/studio/preview).
-   **Android XR Emulator Image:** Ensure you have the latest XR emulator image installed via Android Studio's SDK Manager. Look for system images with "XR" support.
-   *(Optional: A physical Android XR compatible device.)*

### Building and Running the RHF3 Portfolio App

1.  **Clone the repository:**
2. **Open in Android Studio:**
    *   Launch Android Studio.
    *   Select "Open" or "Import Project".
    *   Navigate to the cloned `rhf3-portfolio-xr` directory and select it.
3.  **Sync Gradle:**
    *   Allow Android Studio to sync the Gradle files and download any necessary dependencies.
4.  **Set up an Android XR Emulator (or Device):**
    *   **Emulator:** In Android Studio, go to `Tools > Device Manager`. Create a new Virtual Device. Select a device definition that supports XR and download the corresponding system image.
    *   **Physical Device:** If using a compatible physical device, enable Developer Options and USB Debugging, then connect it.
5.  **Run the App:**
    *   Select the configured XR emulator or connected physical device.
    *   Click the "Run" button (▶️) or use `Shift + F10`.

## 🎨 Theming & UI Design

The RHF3 Portfolio app features a custom Material 3 theme defined in `app/src/main/java/com/example/rhf3portfolio/ui/theme/`.

-   **Color Palette:** Primarily uses shades of blue for `primary`, `secondary`, and related "on" colors, with yellow as an accent for `tertiary` colors. This is defined in `Color.kt`.
-   **Typography:** Custom typography settings can be found in `Type.kt`.
-   **Component Styling:** Specific components like the `SearchBar` (`SearchBar.kt`) have their styles customized (e.g., container colors, shape) to fit the overall design.

## 📸 Screenshots / GIFs

[RHF3 Portfolio XR View](docs/screenshots/demo.gif)

**Example:**
<!-- ![RHF3 Portfolio XR View](docs/screenshots/demo.gif) -->
<!-- *Roland Frohman III's portfolio viewed in an Android XR environment.* -->

## 📚 Additional Android XR Resources

For more information on developing for Android XR:

-   [Android XR Official Documentation](https://developer.android.com/develop/xr)
-   [Android XR Codelabs & Samples](https://developer.android.com/develop/xr#bootcamp)
-   [Designing for XR on Android](https://developer.android.com/design/ui/xr)

## 🤝 Contributing

While this is a personal portfolio project, feedback and suggestions are welcome. Please open an issue if you encounter any problems or have ideas for improvement.

## 📄 License

The RHF3 Portfolio app is based on code that is distributed under the terms of the Apache License (Version 2.0). See the `LICENSE` file for more information.
