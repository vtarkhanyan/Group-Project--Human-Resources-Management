import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
    public class Contract {
        private int contractId;
        private String duration;
        private String terms;
        private static final Scanner sc = new Scanner(System.in);

        public void setContractId() {
            System.out.print("Enter Contract ID ----------: ");
            this.contractId = Integer.parseInt(sc.nextLine());
        }

        public void setDuration() {
            System.out.print("Enter Contract Duration (e.g., 12 months) ------: ");
            this.duration = sc.nextLine();
        }

        public void setTerms() {
            System.out.print("Enter Contract Terms ------: ");
            this.terms = sc.nextLine();
        }

        public int getContractId() {
            return contractId;
        }

        public String getDuration() {
            return duration;
        }

        public String getTerms() {
            return terms;
        }

        public void addContract() {
            setContractId();
            setDuration();
            setTerms();

            try {
                File file = new File("contract" + this.getContractId() + ".txt");
                if (file.createNewFile()) {
                    try (FileWriter myWriter = new FileWriter(file)) {
                        myWriter.write("Contract ID: " + this.contractId + "\nContract Duration: " + this.duration +
                                "\nContract Terms: " + this.terms);
                        System.out.println("Contract has been added :)");
                    }
                } else {
                    System.out.println("Contract already exists :(");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

