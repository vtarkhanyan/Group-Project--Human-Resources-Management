import java.util.Scanner;
public class Position {
    private static int id;
    private static String name;
    private static final Scanner sc = new Scanner(System.in);
    public Position(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public static Position createPosition() {
        System.out.print("Enter Position ID: ");
        id = Integer.parseInt(sc.nextLine());
        System.out.print("Enter Position Name: ");
        name = sc.nextLine();
        return new Position(id, name);
    }
}

