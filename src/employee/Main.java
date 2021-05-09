package employee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) throws java.lang.Exception {
        String prompt = """
                Employee REGISTRATION SYSTEM
                1. ADD Employee (type 'ADD')
                2. UPDATE Employee (type 'UPDATE')
                3. DELETE Employee (type 'DELETE')
                4. GET Employee (type 'GET' or 'GET <ID/INDEX>')
                Enter You Response:\040""";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println(prompt);
            String response = br.readLine().trim().toUpperCase();

            if (response.contains("GET")) {
//            String[] responses = response.split(" ");
                try {
                    long id = Long.parseLong(response.split(" ")[1]);
                    EmployeeDao.getEmployeeDetails(employees, id);
                } catch (ArrayIndexOutOfBoundsException e) {
                    EmployeeDao.getEmployeeDetails(employees);
                }
            } else {
                boolean methodResponse;
                switch (response) {
                    case "ADD" -> {
                        int size = employees.size();
                        methodResponse = EmployeeDao.addEmployee(employees);
                        int newSize = employees.size();
                        if (methodResponse) {
                            System.out.println((newSize - size) + " EMPLOYEES ADDED SUCCESSFULLY!!");
                        } else {
                            System.out.println("EMPLOYEE NOT ADDED!!");
                        }
                    }
                    case "UPDATE" -> {
                        methodResponse = EmployeeDao.updateEmployee(employees);
                        if (methodResponse) {
                            System.out.println("EMPLOYEE UPDATED SUCCESSFULLY!!");
                        } else {
                            System.out.println("EMPLOYEE NOT UPDATED!!");
                        }
                    }

                    case "DELETE" -> {
                        methodResponse = EmployeeDao.deleteEmployee(employees);
                        if (methodResponse) {
                            System.out.println("EMPLOYEE DELETED SUCCESSFULLY!!");
                        } else {
                            System.out.println("EMPLOYEE NOT DELETED!!");
                        }
                    }

                    default -> System.out.println("INVALID INPUT");
                }
            }
            System.out.print("Press 'H' for Home Screen or Press 'E' to EXIT and Press ENTER: " );
        } while (br.readLine().trim().equalsIgnoreCase("H"));

    }
}
