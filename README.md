# Cloud Notes App – Assignment 4

## Project Overview
Cloud Notes is an Android application developed using **Java** in **Android Studio**. The application provides a login interface and a simple cloud notes system where users can enter, save, and view notes through a user-friendly interface.

The project demonstrates Android application development concepts along with integration and configuration of AWS services such as **Amazon Cognito** and **Amazon DynamoDB**.

---

## Features Implemented

✅ User Login Screen  
✅ Email and Password Input Fields  
✅ Notes Screen Interface  
✅ Save Notes Functionality  
✅ Display Saved Notes  
✅ Logout Functionality  
✅ AWS Cognito Configuration  
✅ Amazon DynamoDB Table Creation  
✅ Simple and User-Friendly UI  

---

## Technologies Used

### Frontend
- Java
- Android Studio
- XML Layout Design

### Backend / Cloud Services
- AWS Cognito
- Amazon DynamoDB
- AWS Amplify

### Libraries Used
- AndroidX AppCompat
- Material Design Components
- Constraint Layout
- Amplify Framework

---

## Project Structure

```text
Assignment4
│
├── app
│   ├── manifests
│   │      └── AndroidManifest.xml
│   │
│   ├── java
│   │      └── com.example.assignment4
│   │              ├── LoginActivity.java
│   │              └── MainActivity.java
│   │
│   └── res
│          ├── layout
│          │      ├── activity_login.xml
│          │      └── activity_main.xml
│          │
│          └── values
│                 ├── colors.xml
│                 ├── strings.xml
│                 └── themes.xml
│
└── Gradle Files
```

---

## Application Workflow

### Step 1: Login Screen
- User enters email
- User enters password
- User clicks Login

### Step 2: Cloud Notes Screen
- User enters a note
- User clicks Save Note
- Saved note is displayed on the screen

### Step 3: Logout
- User clicks Logout button
- Application returns to login page

---

## AWS Services Configured

### Amazon Cognito
Used for:

- User authentication
- User management
- Secure login configuration

### Amazon DynamoDB

Created Table:

```text
CloudNotes
```

Partition Key:

```text
noteId
```

Purpose:

- Store note information in cloud database

---

## Screenshots

### Login Screen


### Cloud Notes Screen


### AWS Cognito Setup


### DynamoDB Table Creation


---

## Future Improvements

- Real-time cloud note synchronization
- User registration functionality
- Edit and delete notes
- Multiple note support
- Enhanced UI design
- Persistent cloud database storage

---

## Conclusion

Cloud Notes demonstrates the implementation of Android application development using Java and cloud technologies. The application successfully integrates login functionality and note management features while exploring AWS cloud service configurations. The project provides practical experience in Android UI development, cloud configuration, and application workflow design.

---

## Author

Praveena Somu
