# HexSoftwares QuizApp

![Java](https://img.shields.io/badge/Java-Android-orange)
![XML](https://img.shields.io/badge/XML-UI%20Design-blue)
![Android Studio](https://img.shields.io/badge/Android%20Studio-Project-green)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

## 📌 Project Overview

**HexSoftwares QuizApp** is a simple and interactive Android quiz application developed as part of the **HexSoftwares Internship Program**.

The app allows users to test their knowledge by selecting different quiz categories and answering multiple-choice questions. It validates answers, tracks scores, and stores top scores in a local leaderboard.

This project is developed using **Java** and **XML** in **Android Studio**.

---

## 🚀 Project Name

**Quiz Android App**

## 📂 Repository Name

```text
HexSoftwares_QuizApp
```

---

## ✨ Features

* User can enter their name before starting the quiz.
* User can select quiz categories.
* Multiple-choice questions are displayed.
* Instant correct/wrong answer feedback.
* Score is calculated during the quiz.
* Final result is shown after quiz completion.
* Leaderboard displays top scores.
* Scores are stored locally using SharedPreferences.
* Simple, clean, and beginner-friendly UI.

---

## 🧠 Quiz Categories

The app includes the following categories:

* History
* Science
* Sports
* Music

---

## 🛠️ Technologies Used

* Java
* XML
* Android Studio
* RecyclerView
* SharedPreferences
* Android SDK

---

## 📱 App Screens

The app contains the following screens:

### 1. Start Screen

User enters their name and starts the quiz.

### 2. Category Screen

User selects a quiz category.

### 3. Quiz Screen

Questions and multiple-choice options are displayed.

### 4. Result Screen

Final score is displayed after quiz completion.

### 5. Leaderboard Screen

Top scores are displayed using locally saved data.

---

## 📁 Project Structure

```text
HexSoftwares_QuizApp/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/quizapp/
│   │   │   │   ├── activities/
│   │   │   │   │   ├── MainActivity.java
│   │   │   │   │   ├── CategoryActivity.java
│   │   │   │   │   ├── QuizActivity.java
│   │   │   │   │   ├── ResultActivity.java
│   │   │   │   │   └── LeaderboardActivity.java
│   │   │   │   │
│   │   │   │   ├── adapters/
│   │   │   │   │   ├── CategoryAdapter.java
│   │   │   │   │   └── LeaderboardAdapter.java
│   │   │   │   │
│   │   │   │   ├── models/
│   │   │   │   │   ├── Category.java
│   │   │   │   │   ├── Question.java
│   │   │   │   │   └── UserScore.java
│   │   │   │   │
│   │   │   │   ├── data/
│   │   │   │   │   ├── QuizData.java
│   │   │   │   │   └── LeaderboardStorage.java
│   │   │   │   │
│   │   │   │   └── utils/
│   │   │   │       └── Constants.java
│   │   │   │
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   ├── drawable/
│   │   │   │   └── values/
│   │   │   │
│   │   │   └── AndroidManifest.xml
│   │
│   ├── build.gradle
│
├── build.gradle
├── settings.gradle
└── README.md
```

---

## ⚙️ How to Run This Project

Follow these steps to run the project:

1. Clone this repository:

```bash
git clone https://github.com/ibrahim-codes1/HexSoftwares_QuizApp.git
```

2. Open the project in **Android Studio**.

3. Wait for Gradle sync to complete.

4. Connect an Android device or start an emulator.

5. Click on the **Run** button.

---

## 📦 Required Dependencies

Make sure these dependencies are added in `app/build.gradle`:

```gradle
implementation 'androidx.appcompat:appcompat:1.7.0'
implementation 'androidx.recyclerview:recyclerview:1.3.2'
```

---

## 🧩 How the App Works

1. The user opens the app.
2. The user enters their name.
3. The user selects a quiz category.
4. The app displays questions one by one.
5. The user selects an answer.
6. The app checks whether the answer is correct or wrong.
7. The score is updated.
8. At the end, the result screen shows the final score.
9. The score is saved in the leaderboard.

---

## 🏆 Leaderboard

The leaderboard is implemented using **SharedPreferences**.

It stores user scores locally on the device and displays the top scores in descending order.

---

## 🎯 Learning Outcomes

Through this project, I learned:

* How to build Android apps using Java.
* How to design layouts using XML.
* How to use multiple activities.
* How to pass data between activities using Intent.
* How to use RecyclerView.
* How to store data locally using SharedPreferences.
* How to implement basic quiz logic and score tracking.

---

## 🔮 Future Improvements

* Add more quiz categories.
* Add more questions.
* Add timer-based quizzes.
* Add difficulty levels.
* Add Firebase database for online leaderboard.
* Add animations and improved UI design.
* Add dark mode support.

---

## 📌 Internship Task

This project was completed as part of the **Android Development Internship Task** assigned by **HexSoftwares**.

---

## 👨‍💻 Author

**Ibrahim**

GitHub: [ibrahim-codes1](https://github.com/ibrahim-codes1)

---

## 📄 License

This project is created for learning and internship submission purposes.

---

## 🔖 Tags

`Android` `Java` `XML` `Quiz App` `Android Studio` `RecyclerView` `SharedPreferences` `HexSoftwares` `Internship Project`

---

## 📢 Hashtags

#AndroidDevelopment #Java #XML #AndroidStudio #QuizApp #MobileAppDevelopment #InternshipProject #HexSoftwares #GitHub #Programming
