package com.codetech.task2.grademanager;


import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeBook gradeBook = new GradeBook();

        while (true) {
            System.out.println("\nGradeBook Menu");
            System.out.println("1. Add Grade");
            System.out.println("2. Calculate Average Grade");
            System.out.println("3. Display Grades");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    gradeBook.addGrade(scanner);
                    break;
                case 2:
                    gradeBook.calculateAverageGrade();
                    break;
                case 3:
                    gradeBook.displayGrades();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

class GradeBook {
    private ArrayList<Grade> grades;

    public GradeBook() {
        grades = new ArrayList<>();
    }

    public void addGrade(Scanner scanner) {
        System.out.print("Enter subject: ");
        String subject = scanner.nextLine();
        System.out.print("Enter grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        grades.add(new Grade(subject, grade));
        System.out.println("Grade added.");
    }

    public void calculateAverageGrade() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }

        double totalSum = 0;
        for (Grade grade : grades) {
            totalSum += grade.getGrade();
        }

        double average = totalSum / grades.size();
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Letter Grade: " + getLetterGrade(average));
        System.out.printf("GPA: %.2f\n", calculateGPA(average));
    }

    public void displayGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades available.");
            return;
        }

        System.out.println("\nGrades:");
        for (Grade grade : grades) {
            System.out.printf("Subject: %s, Grade: %.2f\n", grade.getSubject(), grade.getGrade());
        }
    }

    private String getLetterGrade(double average) {
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    private double calculateGPA(double average) {
        if (average >= 90) return 4.0;
        else if (average >= 80) return 3.0;
        else if (average >= 70) return 2.0;
        else if (average >= 60) return 1.0;
        else return 0.0;
    }
}

class Grade {
    private String subject;
    private double grade;

    public Grade(String subject, double grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public double getGrade() {
        return grade;
    }
}
