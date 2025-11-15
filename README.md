# Quotes App

A clean and modern Android application built using **Jetpack Compose**.  
The app displays inspirational quotes across multiple categories, allows users to save favorites, and provides a simple, smooth navigation experience.

This project is built as a learning exercise to explore modern Android development practices.

---

## Screenshots

| Home | Explore | Saved |
|:----:|:-------:|:-----:|
| <img src="screenshots/home_screen.png" width="250"/> | <img src="screenshots/explore_screen.png" width="250"/> | <img src="screenshots/saved_screen.png" width="250"/> |

---

## Features

- Browse latest and trending quotes
- Explore quotes by category
- Save favorite quotes
- Clean and modern Material 3 UI
- Gradient card designs and smooth animations
- Bottom navigation for seamless screen switching
- Compose-first architecture

---

## Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Material Design 3**
- **Navigation Compose**
- **MVVM-ready presentation structure**
- **Min SDK:** 24
- **Target / Compile SDK:** 36

---

## Dependencies

- Jetpack Compose BOM (2024.09.00)
- Material 3
- Navigation Compose (2.9.6)
- Lifecycle Runtime KTX
- Activity Compose

---

## Project Structure

```
app/src/main/java/com/example/quotes/
├── domain/
│   └── model/
│       ├── Category.kt          # Category data models and enums
│       └── Quote.kt             # Quote data model and sample data
├── navigation/
│   ├── BottomNavigationBar.kt   # Bottom navigation bar component
│   ├── NavigationItem.kt         # Navigation items configuration
│   └── QuotesScreenRoute.kt     # Navigation routes
├── presentation/
│   ├── SavedQuotesState.kt       # State management for saved quotes
│   ├── QuotesAppNavGraph.kt     # Navigation graph setup
│   ├── components/
│   │   ├── CategoryCard.kt       # Category card component
│   │   ├── ExploreQuoteCard.kt   # Quote card for explore screen
│   │   └── QuoteCard.kt          # Quote card component with favorite
│   └── screens/
│       ├── HomeScreen.kt         # Home screen with latest/trending quotes
│       ├── ExploreScreen.kt      # Explore screen with category filtering
│       └── SavedScreen.kt        # Saved quotes screen
├── ui/
│   └── theme/
│       ├── Color.kt              # Color definitions
│       ├── Theme.kt              # App theme configuration
│       └── Type.kt               # Typography definitions
└── MainActivity.kt               # Main activity entry point
```


---

## Getting Started

### Clone the repository
```bash
git clone https://github.com/Kunal-Jain21/QuotesApp.git
cd QuotesApp
```

### Open in Android Studio
- Open **Android Studio**
- Select **Open Existing Project**
- Wait for Gradle sync to complete

### Run the app
- Connect a device or launch an emulator
- Press **Run** or `Shift + F10`

---

## Learning Objectives

This project was created to strengthen skills in:

- Building UIs with **Jetpack Compose**
- Navigation with **Navigation Compose**
- State management in Compose
- Material 3 theming & UI structure
- Reusable component design
- Lazy lists (LazyColumn / LazyRow)
- Clean and modular file structure

---

## License
This is a learning project and can be freely used or modified.
