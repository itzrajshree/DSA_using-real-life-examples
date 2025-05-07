import java.util.*;

public class StudentGradeTracker {
    private int num;
    private String[] name;
    private int[] grade;

    StudentGradeTracker(int num) {
        this.num = num;
        this.name = new String[num];
        this.grade = new int[num];
    }

    static Scanner sc = new Scanner(System.in);

    void input_name_grades() {
        for (int i = 0; i < num; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            name[i] = sc.nextLine();

            int grades;
            while (true) {
                System.out.print("Enter grade for " + name[i] + " (0-100): ");
                if (sc.hasNextInt()) {
                    grades = sc.nextInt();
                    sc.nextLine(); // clear newline
                    if (grades >= 0 && grades <= 100) {
                        break;
                    } else {
                        System.out.println("Grade must be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.nextLine(); // clear invalid input
                }
            }
            grade[i] = grades;
        }
    }

    void display() {
        System.out.println("\n--- Student Grades ---");
        for (int i = 0; i < num; i++) {
            System.out.println("Name: " + name[i] + "\tGrade: " + grade[i]);
        }
    }

    void retrieve_grade(String s_name) {
        boolean found = false;
        for (int i = 0; i < name.length; i++) {
            if (name[i].equalsIgnoreCase(s_name)) {
                System.out.println("Grade of " + name[i] + ": " + grade[i]);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }

    void average_grade() {
        int total_sum = 0;
        for (int i : grade) {
            total_sum += i;
        }
        double average = (double) total_sum / num;
        System.out.printf("Average grade: %.2f%n", average);
    }

    void min_grade() {
        int min = grade[0];
        String min_name = name[0];
        for (int i = 1; i < num; i++) {
            if (grade[i] < min) {
                min = grade[i];
                min_name = name[i];
            }
        }
        System.out.println("Minimum grade: " + min + " by " + min_name);
    }

    void max_grade() {
        int max = grade[0];
        String max_name = name[0];
        for (int i = 1; i < num; i++) {
            if (grade[i] > max) {
                max = grade[i];
                max_name = name[i];
            }
        }
        System.out.println("Maximum grade: " + max + " by " + max_name);
    }

    public static void main(String[] args) {
        System.out.print("Enter number of students (1-50): ");
        int num_stu = sc.nextInt();
        sc.nextLine(); // clear buffer

        if (num_stu <= 0 || num_stu > 50) {
            System.out.println("Invalid number of students. Exiting...");
            return;
        }

        StudentGradeTracker st = new StudentGradeTracker(num_stu);

        while (true) {
            System.out.println("\nMenu");
            System.out.println("0: Insert Student name and grade");
            System.out.println("1: Display entered details");
            System.out.println("2: Retrieve grade by name");
            System.out.println("3: Find Average grade");
            System.out.println("4: Find lowest grade");
            System.out.println("5: Find highest grade");
            System.out.println("6: Exit");
            System.out.print("Enter choice (0-6): ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 6.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 0:
                    st.input_name_grades();
                    break;
                case 1:
                    st.display();
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    st.retrieve_grade(name);
                    break;
                case 3:
                    st.average_grade();
                    break;
                case 4:
                    st.min_grade();
                    break;
                case 5:
                    st.max_grade();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
