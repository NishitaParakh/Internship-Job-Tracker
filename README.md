# Internship & Job Application Tracker

## 1. Overview

The Internship & Job Application Tracker is a command-line based Java application designed to help students manage their internship and job applications in one place.

The system allows users to store application details, track application status and priority, manage interview information, view application statistics, and save or load data using text files.

The project provides a simple and organized way for students to keep track of their internship and job application progress.

---

## 2. Features

### Application Management

- Add a new job or internship application
- View all applications
- Search for an application
- Update application status
- Delete an application
- Set application priority

### Interview Management

- Add interview details
- View interviews
- Search for an interview
- Update interview status
- Add interview notes

### Dashboard and Statistics

- View total number of applications
- View applications by status
- View selected and rejected applications
- Calculate selection rate
- Calculate interview rate

### Data Management

- Save application data to a file
- Save interview data to a file
- Load previously saved data
- Handle invalid input

---

## 3. Technologies and Tools Used

- **Programming Language:** Java
- **Interface:** Command Line Interface (CLI)
- **Data Structure:** ArrayList
- **File Handling:** Java I/O
- **Development Environment:** Visual Studio Code
- **Version Control:** Git and GitHub

---

## 4. Project Structure

InternshipJobTracker/
|
├── src/

│   └── tracker/

│       ├── ApplicationManager.java

│       ├── ApplicationStatus.java

│       ├── FileManager.java

│       ├── InputValidator.java

│       ├── Interview.java

│       ├── InterviewManager.java

│       ├── JobApplication.java

│       ├── Main.java

│       └── Statistics.java
|
├── data/

│   ├── applications.txt

│   └── interviews.txt
|
├── .gitignore

├── README.md

└── statement.md

---

## 5. Installation and Running

### Prerequisites

Make sure Java is installed on your system.

Check the Java version using:

java -version

Check the Java compiler using:

javac -version

### Compile the Project

Open the terminal in the main InternshipJobTracker folder and run:

javac -d out src\tracker\*.java

### Run the Project

After successful compilation, run:

java -cp out tracker.Main

The application will display a command-line menu from which the user can select different operations.

---

## 6. Testing Instructions

### Application Testing

1. Add a new application.
2. View all applications.
3. Search for an existing application.
4. Update its status.
5. Delete an application.
6. Test different priority values.

### Interview Testing

1. Add an interview for an application.
2. View interviews.
3. Search for an interview.
4. Update the interview status.
5. Add interview notes.

### Statistics Testing

1. Add applications with different statuses.
2. Open the Statistics/Dashboard option.
3. Check the total application count.
4. Check status-wise application counts.
5. Check the interview rate and selection rate.

### File Handling Testing

1. Add application and interview data.
2. Select the Save option.
3. Exit the program.
4. Start the program again.
5. Select the Load option.
6. View the applications and interviews.
7. Verify that the previously saved data is displayed.

---

## 7. Data Storage

The project uses text files for storing application and interview data.

### Application Data

Application data is stored in:

data/applications.txt

The application file stores:

- Application ID
- Company name
- Job role
- Application date
- Application status
- Priority

### Interview Data

Interview data is stored in:

data/interviews.txt

The interview file stores:

- Application ID
- Interview date
- Interview time
- Interview type
- Interview status
- Interview notes

The FileManager class is responsible for saving and loading this information.

---

## 8. Command Line Execution

The project is completely executable through the command line and does not require a graphical user interface.

### Compilation

javac -d out src\tracker\*.java

### Execution

java -cp out tracker.Main

### Main Menu

The application provides the following options:

1. Add Application
2. View Applications
3. Search Application
4. Update Application Status
5. Delete Application
6. Add Interview
7. My Interviews
8. Update Interview Status
9. Add Interview Notes
10. View Statistics
11. Save
12. Load
13. Exit

---

## 9. Screenshots
1. Main Menu:
   
   <img width="490" height="383" alt="image" src="https://github.com/user-attachments/assets/f197bde5-bd51-41c3-9210-9f4705fd6fab" />

2. View Applications:

   <img width="452" height="428" alt="image" src="https://github.com/user-attachments/assets/c8e53454-e65d-41fe-82ac-74ea4fe7a728" />

3. View Interviews:

   <img width="343" height="332" alt="image" src="https://github.com/user-attachments/assets/4cb7dc6d-24ae-4d5c-a008-2f10a2042aa2" />

4. View Statistics:

   <img width="332" height="216" alt="image" src="https://github.com/user-attachments/assets/6892f7f9-a523-4d73-a74b-6b5a41ef5307" />

5. Exit:

   <img width="333" height="113" alt="image" src="https://github.com/user-attachments/assets/b9bfc9a2-e69e-4e17-8ceb-1dbbda02f93a" />







