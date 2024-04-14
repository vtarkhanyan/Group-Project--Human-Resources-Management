import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Employee {
    private int employId;
    private String firstName;
    private String lastName;
    private Position position;

    private Contract contract;

    private Salary salary;
    private Department department;
    private Director director;


    private static final Scanner sc = new Scanner(System.in);
    private static ArrayList<Position> positions = new ArrayList<>();
public Employee(){}
    public Employee(int employId, String firstName, String lastName, Position position, Salary salary, Department department) {
    this.employId = employId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.position = position;
    this.salary = salary;
    this.department = department;

    }

    public ArrayList<Position> getPositions(){
        return positions;
    }

    public void setEmployId() {
        System.out.print("Enter Employee's ID ----------: ");
        this.employId = sc.nextInt();
    }

    public void setFirstName() {
        sc.nextLine();
        System.out.print("Enter Employee's First name ------: ");
        this.firstName = sc.nextLine();
    }

    public void setLastName() {
        System.out.print("Enter Employee's Last name ------: ");
        this.lastName = sc.nextLine();
    }

    public void setPosition(Position position) {

            this.position = position;
    }
    public Position getPosition(){
        return position;
    }
    public int getEmployId() {
        return employId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public void setContract() {
        if (this.contract == null) {
            this.contract = new Contract();
        }
        this.contract.addContract();
    }

    public Contract getContract() {
        return contract;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Director getDirector() {
        return director;
    }


    public void displayDetails() {
           if (director != null) {
            System.out.println("Director: " + director.getFirstName() + " " + director.getLastName());
        }
    }
    public void addEmployee() {


        setEmployId();
        setFirstName();
        setLastName();
        System.out.print("Enter Employee's Position ID ------: ");
        int posId = Integer.parseInt(sc.nextLine());
        Position pos = findPositionById(posId);
        setPosition(pos);
        if (pos != null) {

            System.out.println("Employee added with position: " + this.getPosition().getName());
        } else {
            System.out.println("Position ID not found.");
            System.out.println("You have first to add Employee position by pressing 3.");
            System.out.println("Press 3: To Add a Position");
            int three = sc.nextInt();
            if(three==3){
                position= Position.createPosition();
                this.getPositions().add(position);
            }else{
                System.out.println("rad exi");
            }

        }

        setContract();

        System.out.print("Enter Employee's Base Salary ------: ");
        double baseSalary = sc.nextDouble();
        System.out.print("Enter Employee's Base Salary ------: ");
        double bonus = sc.nextDouble();
        this.setSalary(new Salary(baseSalary,bonus));


        System.out.print("Enter department Id ------: ");
        int departmentId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter department Name ------: ");
        String departmentName = sc.nextLine();
        System.out.print("Enter department Location ------: ");
        String epartmentLocation = sc.nextLine();
        this.setDepartment(new Department(departmentId,departmentName,epartmentLocation));




        try {
            File file = new File("employee" + this.getEmployId() + ".txt");
            if (file.createNewFile()) {
                try (FileWriter myWriter = new FileWriter(file)) {
                    myWriter.write("Employee ID: " + this.getEmployId()+ "\nEmployee First Name: " + this.getFirstName() +
                            "\nEmployee Last Name: " + this.getLastName() + "\nEmployee Position: " + this.getPosition().getName() +
                            "\nEmployee contract ID: " + this.getContract().getContractId() +
                            "\nEmployee contract duration " + this.getContract().getDuration()+
                            "\nEmployee contract Term " + this.getContract().getTerms()+
                            "\nEmployee base Salary " + this.getSalary().getBaseSalary() +
                            "\nEmployee bonus " + this.getSalary().getBonus() +
                            "\nEmployee Total Salary " + this.getSalary().getTotalCompensation()+
                            "\nDepartment ID " + this.getDepartment().getDepartmentId() +
                            "\nDepartment Name " + this.getDepartment().getName() +
                            "\nEDepartment Location " + this.getDepartment().getLocation());
                               this.getSalary().displaySalaryDetails();
                               this.getDepartment().displayDepartmentDetails();

                    System.out.println("Employee has been Added :)");
                }
            } else {
                System.out.println("Employee already exists :(");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
    private static Position findPositionById(int id) {
        for (Position pos : positions) {
            if (pos.getId() == id) {
                return pos;
            }
        }
        return null;
    }
    public void viewEmployee(int employId) throws Exception {
        File file = new File("employee" + employId + ".txt");
        if (!file.exists()) {
            throw new Exception("Employee not found.");
        }
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        }
    }
    public void mainMenu() {
        System.out.println("\n\t\t\t        Management System");
        System.out.println("\t\t\t    --------------------");
        System.out.println("Press 1: To Add an Employee");
        System.out.println("Press 2: To View an Employee");
        System.out.println("Press 3: To Add a Position");
        System.out.println("Press 4: To Exit");
    }
}

