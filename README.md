# 🎬 AI Movie Recommender Android Application

## 📌 Project Overview
The **AI Movie Recommender** is a native Android application designed to provide movie recommendations based on content similarity and genre matching. Developed using **Java** and **XML** in **Android Studio**, the app utilizes an on-device content-based filtering logic to analyze target movie features and deliver relevant suggestions through a modern, card-based user interface.

---

## 👤 Student Identification
* **Student Name:** Alina Zia
* **Roll Number:** 242201087
* **Program:** Bachelor of Science in Computer Science (BSCS)
* **Semester / Section:** 5th Semester, Section B

---

## ⚙️ Core Architecture & Working Logic

### 1. Content-Based Recommendation Algorithm
The application employs a tag/genre matching engine to evaluate similarity scores between movies:
* **Dataset Initialization:** The system maintains a mapped dataset containing movie titles associated with specific feature vectors (e.g., `Sci-Fi`, `Action`, `AI`, `Space`).
* **Feature Comparison:** When a user inputs a target movie title, the engine extracts its key feature tags and compares them against all other entries in the dataset.
* **Similarity Scoring:** Scores are calculated based on the count of matching feature tags. Movies with positive match scores are formatted and ranked into a dynamic list.

### 2. User Interface & Experience (UI/UX)
* **CardView & Dark Theme:** Styled with a clean, dark-mode dashboard interface using rounded `CardView` elements for input and output display.
* **Dynamic Listing (RecyclerView):** Recommended results are passed to a `RecyclerView` managed by a custom `MovieAdapter`, ensuring smooth scrolling and structured card rendering for each movie item.
* **Validation & Toast Alerts:** Built-in error handling manages empty search queries or unlisted titles with user-friendly Toast notifications.

---

## 📁 Repository Directory & File Descriptions

* **`.idea/`**: Internal workspace configurations and IDE settings managed by Android Studio[cite: 2, 3].
* **`app/`**: Primary module containing all application source code[cite: 2, 3]:
  * `MainActivity.java`: Contains core activity lifecycle logic, similarity engine, and RecyclerView adapter implementation.
  * `activity_main.xml`: Defines the layout structure, input fields, cards, and list container.
  * `item_movie.xml`: XML layout template for individual recommendation cards.
  * `AndroidManifest.xml`: System-level declaration file for activity registers and application configurations.
* **`gradle/`**: Holds the Gradle Wrapper files required to execute builds without external installation[cite: 2, 3].
* **`build.gradle`**: Project-level dependency configuration and Android SDK settings[cite: 2, 3].
* **`gradle.properties`**: Global build properties and JVM parameter allocations[cite: 2, 3].
* **`settings.gradle`**: Defines overall project name and includes app modules[cite: 2, 3].
* **`README.md`**: Official documentation file detailing project features, technical architecture, and author details.

---

## 🛠️ Tech Stack & Prerequisites
* **Language:** Java[cite: 2, 3]
* **UI Layout:** XML
* **IDE:** Android Studio[cite: 2, 3]
* **Target Environment:** Android (Tested on Android physical devices)
