# StudentHub

StudentHub is a simple Java console application for managing student information and grades.

## Features

- Add students
- View all students
- Search students by name
- Update student information
- Delete students
- Calculate average grade
- Show highest and lowest grades
- Automatically display letter grades
- Includes sample student data

## Java Concepts Used

This beginner-friendly project demonstrates:

- Classes and objects
- Constructors
- Encapsulation
- Getters and setters
- ArrayList
- Loops
- If/else conditions
- Switch statements
- Methods
- User input with Scanner
- Basic exception handling
- Searching and updating objects

## Project Structure

```text
StudentHub/
├── src/
│   └── com/
│       └── studenthub/
│           ├── Student.java
│           └── StudentHubApp.java
├── .gitignore
└── README.md
```

## How to Run

### IntelliJ IDEA / Eclipse

1. Open the `StudentHub` folder.
2. Mark `src` as the source folder if needed.
3. Open `StudentHubApp.java`.
4. Run the `main()` method.

### Terminal

From the `StudentHub` folder:

```bash
javac -d out src/com/studenthub/*.java
java -cp out com.studenthub.StudentHubApp
```

## Example

```text
=================================
          STUDENTHUB
=================================
1. Add Student
2. View All Students
3. Search Student
4. Update Student
5. Delete Student
6. Grade Summary
0. Exit
=================================
```

## Future Improvements

Possible future versions could add:

- File/database storage
- Login system
- Course management
- Multiple subjects and grades
- Java Swing or JavaFX interface
- Spring Boot REST API
- MySQL database

## Author

Kshama Thakur
