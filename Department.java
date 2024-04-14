import java.util.ArrayList;
public class Department {
    private int departmentId;
    private String name;
    private String location;
    private Director director;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Department(int departmentId, String name, String location) {
        this.departmentId = departmentId;
        this.name = name;
        this.location = location;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setDirector(Director director) {
        this.director = director;

        for (Employee emp : employees) {
            emp.setDirector(director);
        }
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
        emp.setDepartment(this);
        if (director != null) {
            emp.setDirector(director);
        }
    }

    public void displayDepartmentDetails() {
        System.out.println("Department ID: " + departmentId);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Director: " + (director != null ? director.getFirstName() + " " + director.getLastName() : "No director assigned"));
    }
}
