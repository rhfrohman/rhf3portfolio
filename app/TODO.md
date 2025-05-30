# TODO - RHF3 XR Portfolio App

This document tracks the development progress, planned features, and ideas for the RHF3 Android XR Portfolio application.

## 🔑 Core Functionality & Current Tasks

### In Progress / To Do Next
-   [ ] **Portfolio Content - Key Skills:**
    -   [ ] Design and implement UI for displaying key skills (e.g., UX Design, UI Design, Prototyping, XR Design).
    -   [ ] Ensure it's readable and engaging in both 2D and XR spatial views.
-   [ ] **Portfolio Content - Project Carousel/Gallery:**
    -   [ ] Design interaction model for browsing projects (e.g., swipe, gaze, controller input).
    -   [ ] Implement dynamic loading of project thumbnails/titles.
    -   [ ] Develop the detailed project view (see "Detailed Project View" in New Features).
-   [ ] **Portfolio Content - Contact Integration:**
    -   [x] Implement Gmail button with `Intent.ACTION_SENDTO`.
    -   [x] Implement LinkedIn button with `Intent.ACTION_VIEW`.
    -   [ ] Style buttons to be more visually prominent and fit the theme.
-   [ ] **UI Refinements:**
    -   [x] Search bar background color updated to light gray.
    -   [ ] Review and refine typography across the app for XR readability.
    -   [ ] Ensure consistent spacing and alignment of UI elements.
-   [ ] **Animated 3D Models:**
    -   [x] Integrate `BugdroidModel` with animation.
    -   [x] Integrate `RHF3Model` (personal avatar/logo?) with animation.
    -   [ ] Consider interactive triggers for animations if appropriate.
-   [ ] **Documentation & Presentation:**
    -   [x] Update README.md with current features and video placeholder.
    -   [ ] Create and embed a video demonstration of the app.
    -   [ ] Add screenshots and GIFs to README.md.

### Completed
-   [x] Initial project setup based on "Hello Android XR" sample.
-   [x] Basic spatial panel layout.
-   [x] Orbiter functionality for search bar and environment controls.
-   [x] Custom Material 3 Theming (Blue-centric).
-   [x] Environment switching controls.
-   [x] Functional Search Bar component.

## ✨ New Feature Ideas for Designer Portfolio Showcase

This section brainstorms features to best leverage XR for showcasing design work, given access to GitHub prototypes, images, videos, case studies, Figma prototypes, and design library screenshots.

### 1. Interactive Project Deep Dive
-   [ ] **Concept:** Allow users to select a project and enter a more immersive "deep dive" space for it.
-   [ ] **Sub-Features:**
    -   [ ] **Spatial Case Study Viewer:**
        -   Display sections of a case study (Problem, Process, Solution, Outcome) on different spatial panels.
        -   Allow users to navigate between these panels.
    -   [ ] **Image & Video Gallery:**
        -   Showcase project images and videos on large spatial displays.
        -   Option for a "theater mode" for videos.
    -   [ ] **Interactive Prototype Viewer (Figma/GitHub):**
        -   **Option A (Web View):** Embed Figma prototypes (if viewable via public link) in a spatial WebView. *Requires careful consideration of performance and XR interaction with WebViews.*
        -   **Option B (Image/GIF Sequence):** For complex/private Figma prototypes or GitHub prototypes, showcase key screens/interactions as a sequence of images or GIFs on spatial panels.
        -   Could be triggered by looking at a "Prototype" panel.
    -   [ ] **3D Model Showcase (If applicable):** If any design projects involved 3D work, display the models spatially, perhaps with annotations.

### 2. Design Library Explorer
-   [ ] **Concept:** Create a dedicated section to showcase contributions to design libraries/systems.
-   [ ] **Sub-Features:**
    -   [ ] **Component Showcase:** Display screenshots or representations of UI components (buttons, cards, forms) on spatial panels.
    -   [ ] **Interactive Style Guide Snippets:** Show key aspects of a style guide (colors, typography, spacing) in a visually appealing spatial layout.
    -   [ ] **"Before & After" or "Contribution Highlight":** If possible, visually demonstrate specific contributions or improvements made to the design library.

### 3. "My Design Philosophy" Section
-   [ ] **Concept:** A more personal section where Roland can express his design philosophy or approach.
-   [ ] **Sub-Features:**
    -   [ ] **Spatial Text & Imagery:** Combine short text blurbs with impactful visuals on spatial panels.
    -   [ ] **Audio Narration (Optional):** Add short audio clips from Roland explaining his thoughts, triggered by looking at certain panels.

### 4. XR-Native Interactions for Portfolio Browsing
-   [ ] **Concept:** Make the act of browsing the portfolio itself a delightful XR experience.
-   [ ] **Sub-Features:**
    -   [ ] **Gaze-based Navigation/Selection:** For hands-free interaction.
    -   [ ] **Controller Support (If applicable for target XR platform):** Allow pointing and clicking with virtual controllers.
    -   [ ] **Spatial "Timeline" or "Map" of Projects:** Instead of a linear carousel, perhaps projects are laid out spatially, and the user can "walk" or "fly" to them. (More ambitious).

### 5. "Behind the Scenes" / Process Showcase
-   [ ] **Concept:** Offer glimpses into the design process.
-   [ ] **Sub-Features:**
    -   [ ] **Sketches & Wireframes Gallery:** Display early-stage design artifacts.
    -   [ ] **Short Video Clips of Process:** e.g., screen recordings of Figma work, user testing snippets.

### Technical Considerations for New Features
-   [ ] Evaluate performance implications of loading many high-resolution images/videos.
-   [ ] Investigate best practices for WebView interaction in Android XR if pursuing embedded Figma prototypes.
-   [ ] Design clear visual cues and affordances for interacting with spatial content.
-   [ ] Ensure all text is highly legible in an XR environment (contrast, font size, placement).
-   [ ] Consider different XR input modalities (gaze, controller, hand tracking if available).

## 🐛 Bugs & Issues
-   [ ] *(List any known bugs here)*

## 💡 Future Ideas / Wishlist
-   [ ] *(Less defined ideas or long-term goals)*
-   [ ] Addition of chatbot AI, the wizard Herm the 3rd
-   [ ] Integration with a live feed (e.g., Dribbble, Behance), text generation of headlines of topics I'm interested in - *Technically complex, consider carefully.*