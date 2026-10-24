# Mobile Development Project

This project is an Android application developed in Java for a mobile development assignment. It is designed to manage student records using an SQLite database and provides basic CRUD (Create, Read, Update, Delete) functionality.

The app allows a user to register student details such as name, department, phone number, and identity number, then view, update, and delete the stored information.

## Features

- Add student records
- View all saved records
- Update existing student information
- Delete records by student ID
- Store data locally using SQLite
- Simple user interface built with Android XML layouts

## Technologies Used

- Java
- Android Studio
- SQLite Database
- Android XML layouts

## Project Structure

- `app/src/main/java/com/example/myapplication/` - Java source files for the application logic
  - `MainActivity.java` - Main registration screen and user actions
  - `RecordsActivity.java` - Displays all saved student records
  - `DbAdapter.java` - Handles database operations
  - `myDbHelper.java` - Creates and manages the SQLite database
- `app/src/main/res/` - Application resources such as layout files and strings
- `app/src/main/AndroidManifest.xml` - App configuration and activity declarations
- `app/build.gradle.kts` - Module-level Gradle configuration

## How It Works

The application uses a local SQLite database to persist student data. The main screen allows users to enter student information and save it. A separate screen displays all records stored in the database. The app also supports updating and deleting records based on the student ID.

## Getting Started

1. Clone this repository.
2. Open the project in Android Studio.
3. Let Gradle sync the project dependencies.
4. Run the app on an Android emulator or a connected Android device.

## Example Use Case

This project can be used as a small student management system for academic or learning purposes, demonstrating how Android apps interact with a local database.

## Notes

This repository is intended for educational and assignment purposes and demonstrates basic Android database integration with Java.
