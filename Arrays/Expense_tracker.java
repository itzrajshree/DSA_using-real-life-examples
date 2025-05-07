
/*📆 2. Expense Manager
Problem Statement:
Create a program to record daily expenses for a month and provide a report including total, average, and maximum expense days.
Constraints:
Accept only positive numbers as expenses.
Allow user to edit/update a specific day’s expense.
Display: Total expenses, Average daily expense, The day with highest expense*/
import java.util.*;

public class Expense_tracker {
    static Scanner sc = new Scanner(System.in);
    private int days;
    private int[] expenses;

    Expense_tracker(int days) {
        this.days = days;
        this.expenses = new int[days];
    }

    void input_expenses() {
        for (int i = 0; i < days; i++) {
            System.out.print("Enter expense for day" + (i + 1) + ": ");
            int expense = sc.nextInt();
            sc.nextLine();
            if (expense >= 0) {
                expenses[i] = expense;
            } else {
                System.out.println("Negative expenses not allowed.");
            }
        }
        for (int i = 0; i < days; i++) {
            System.out.println("Expenses for day-" + (i + 1) + ": " + expenses[i]);

        }
    }

    void update_expense(int day) {
        if (day < 1 || day > days) {
            System.out.println("Days not in the range of data");
            return;
        }
        System.out.println("Current expense for the given day: " + expenses[day - 1]);
        System.out.print("Updated Expense: ");
        int new_expense = sc.nextInt();
        sc.nextLine();
        if (new_expense >= 0) {
            expenses[day - 1] = new_expense;
        } else {
            System.out.println("Negative expenses not allowed");
        }
        System.out.println("Expense updated successfully");
        for (int i = 0; i < days; i++) {
            System.out.println("Expenses for day-" + i + ": " + expenses[i]);
        }
    }

    int display_total() {
        int total = 0;
        for (int i : expenses) {
            total += i;
        }
        return total;
    }

    void avg_daily_expense() {
        int total = display_total();
        System.out.println("Average daily expense: " + (total / days));
    }

    void day_with_highestexpense() {
        int max = Integer.MIN_VALUE;
        int day = 0;
        for (int i = 0; i < days; i++) {
            if (expenses[i] > max) {
                max = expenses[i];
                day = i + 1;
            }
        }
        System.out.println("Highest Expense: " + max + " on the day: " + day);
    }

    public static void main(String[] args) {
        System.out.print("Enter number of days to log expense for: ");
        int days = sc.nextInt();
        Expense_tracker et = new Expense_tracker(days);
        while (true) {
            System.out.println("Menu");
            System.out.println("1: Insert Expenses for particular day");
            System.out.println("2: Update Expenses for a particular day");
            System.out.println("3: Display Total Expenditure");
            System.out.println("4: Display Average Expenditure");
            System.out.println("5: Display Day with Highest Expense");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 0 and 6.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    et.input_expenses();
                    break;
                case 2:
                    System.out.println("Enter day to be changed: ");
                    int day = sc.nextInt();
                    sc.nextLine();
                    et.update_expense(day);
                    break;
                case 3:
                    int t = et.display_total();
                    System.out.println("Total: " + t);
                    break;
                case 4:
                    et.avg_daily_expense();
                    break;
                case 5:
                    et.day_with_highestexpense();
                    break;
                case 6:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
