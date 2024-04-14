
import java.util.Scanner;
public class ManagementSystem {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.mainMenu();
        int choice = 0;

        while (choice != 4) {
            System.out.print("\nPlease Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    emp.addEmployee();

                    break;
                case 2:
                    System.out.print("\nPlease Enter Employee's ID: ");
                    int id = sc.nextInt();
                    try {
                        emp.viewEmployee(id);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    Position position = Position.createPosition();
                    emp.getPositions().add(position);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            emp.mainMenu();
        }
    }
}


