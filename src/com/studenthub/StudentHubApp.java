package com.studenthub;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentHubApp {

    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        addSampleStudents();

        boolean running = true;

        while (running) {
            showMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    updateStudent();
                    break;
                case 5:
                    deleteStudent();
                    break;
                case 6:
                    showGradeSummary();
                    break;
                case 0:
                    running = false;
                    System.out.println("\nThank you for using StudentHub!");
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n=================================");
        System.out.println("          STUDENTHUB");
        System.out.println("=================================");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Grade Summary");
        System.out.println("0. Exit");
        System.out.println("=================================");
    }

    private static void addStudent() {
        System.out.println("\n--- Add Student ---");

        int id = readInt("Student ID: ");

        if (findStudentById(id) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }

        String name = readText("Name: ");
        String email = readText("Email: ");
        double grade = readGrade("Grade (0-100): ");

        students.add(new Student(id, name, email, grade));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        System.out.println("\n--- All Students ---");

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        System.out.println("\n--- Search Student ---");
        String keyword = readText("Enter student name: ").toLowerCase();

        boolean found = false;

        for (Student student : students) {
            if (student.getName().toLowerCase().contains(keyword)) {
                System.out.println(student);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching student found.");
        }
    }

    private static void updateStudent() {
        System.out.println("\n--- Update Student ---");
        int id = readInt("Enter student ID: ");

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String name = readText("New name: ");
        String email = readText("New email: ");
        double grade = readGrade("New grade (0-100): ");

        student.setName(name);
        student.setEmail(email);
        student.setGrade(grade);

        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        int id = readInt("Enter student ID: ");

        Student student = findStudentById(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        students.remove(student);
        System.out.println("Student deleted successfully.");
    }

    private static void showGradeSummary() {
        System.out.println("\n--- Grade Summary ---");

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        double total = 0;

        for (Student student : students) {
            total += student.getGrade();
        }

        double average = total / students.size();

        System.out.printf("Number of students: %d%n", students.size());
        System.out.printf("Average grade: %.2f%n", average);

        Student highest = students.get(0);
        Student lowest = students.get(0);

        for (Student student : students) {
            if (student.getGrade() > highest.getGrade()) {
                highest = student;
            }
            if (student.getGrade() < lowest.getGrade()) {
                lowest = student;
            }
        }

        System.out.println("Highest grade: " + highest.getName() +
                " (" + highest.getGrade() + ")");
        System.out.println("Lowest grade: " + lowest.getName() +
                " (" + lowest.getGrade() + ")");
    }

    private static Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    private static String readText(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static double readGrade(String message) {
        while (true) {
            try {
                System.out.print(message);
                double grade = Double.parseDouble(scanner.nextLine().trim());

                if (grade >= 0 && grade <= 100) {
                    return grade;
                }

                System.out.println("Grade must be between 0 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid grade.");
            }
        }
    }

    private static void addSampleStudents() {
        students.add(new Student(101, "John Smith", "john@example.com", 88));
        students.add(new Student(102, "Emma Wilson", "emma@example.com", 94));
        students.add(new Student(103, "Alex Brown", "alex@example.com", 76));
    }
}
