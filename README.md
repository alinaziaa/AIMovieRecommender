🎬 1. Project Overview & Introduction
Project Name: AI Movie Recommender (Android Application)

Description: A smart, content-based movie recommendation Android application developed in Java using Android Studio. The application is designed to help users discover similar movies based on genre and tag-matching algorithms, complete with user authentication and dynamic dataset management.

👩‍🎓 2. Student Information (For Submission)
Student Name: Alina Zia

Roll Number: 242201087

Semester & Section: 5th Semester, Section B

Institution: Dr. A. Q. Khan Institute of Computer Sciences & Information Technology (KICSIT)

⚙️ 3. Core Features Implemented
User Authentication & Session Management (LoginActivity):

Features a secure login screen requiring email and password input.

Validates inputs to ensure fields are not empty and the email format is correct before granting access.

Content-Based Recommendation Algorithm (MainActivity):

Utilizes a built-in dataset structure (HashMap) containing movies and their respective tags/genres (e.g., Sci-Fi, Action, Thriller).

Calculates a tag-matching score when a user searches for a movie and displays relevant recommendations dynamically using a RecyclerView.

Dynamic Add Movie / Task Feature:

Allows users to input new movie titles and custom tags/genres directly at runtime, expanding the active dataset instantly.

Logout Functionality:

Includes a secure logout option on the dashboard that terminates the current session and safely redirects the user back to the login screen.

Modern User Interface (UI):

Styled with a sleek dark theme, utilizing CardViews, RecyclerViews, and structured linear layouts for a responsive experience.

📁 4. Project File Structure & Architecture
AndroidManifest.xml: Configures application components and sets LoginActivity as the primary launcher activity (MAIN and LAUNCHER intent filters).

activity_login.xml & LoginActivity.java: Defines the login user interface layout and handles authentication validation logic.

activity_main.xml & MainActivity.java: Houses the main dashboard layout, search bar, add movie form, logout handler, and recommendation engine logic.

item_movie.xml & MovieAdapter: Manages individual movie card designs and binds dataset items efficiently to the RecyclerView.

🔗 5. GitHub Repository Link
Repository URL: [https://github.com/alinaziaa/AIMovieRecommender]
