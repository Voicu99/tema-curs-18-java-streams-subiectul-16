import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ExpenseTracker tracker = new ExpenseTracker();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Edit Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. View Total Expenses");
            System.out.println("6. Export Expenses");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    tracker.viewExpenses();
                    break;
                case 3:
                    editExpense();
                    break;
                case 4:
                    deleteExpense();
                    break;
                case 5:
                    viewTotalExpenses();
                    break;
                case 6:
                    exportExpenses();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addExpense() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter date (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(scanner.next());
        tracker.addExpense(new Expense(category, amount, date));
    }

    private static void editExpense() {
        System.out.print("Enter index of expense to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        addExpense();
        tracker.editExpense(index, new Expense(scanner.nextLine(), scanner.nextDouble(), LocalDate.parse(scanner.next())));
    }

    private static void deleteExpense() {
        System.out.print("Enter index of expense to delete: ");
        int index = scanner.nextInt();
        tracker.deleteExpense(index);
    }

    private static void viewTotalExpenses() {
        System.out.print("Enter start date (yyyy-mm-dd): ");
        LocalDate startDate = LocalDate.parse(scanner.next());
        System.out.print("Enter end date (yyyy-mm-dd): ");
        LocalDate endDate = LocalDate.parse(scanner.next());
        double total = tracker.getTotalExpenses(startDate, endDate);
        System.out.println("Total Expenses: " + total);
    }

    private static void exportExpenses() {
        System.out.print("Enter filename to export expenses: ");
        String filename = scanner.nextLine();
        tracker.exportExpenses(filename);
        System.out.println("Expenses exported to " + filename);
    }
}
