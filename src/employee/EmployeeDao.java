package employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EmployeeDao {
    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

    public static boolean addEmployee(ArrayList<Employee> employees) {
        try {
            do {
                System.out.print("Enter Employee Name: ");
                String name = br.readLine().trim();
                System.out.print("Enter Employee Age: ");
                int age = Integer.parseInt(br.readLine().trim());
                System.out.print("Enter Employee Address: ");
                String address = br.readLine().trim();
                long id = 10125 + employees.size();
                Employee e = new Employee(id, name, age, address);
                employees.add(e);
                System.out.print("""
                        EMPLOYEE ADDED SUCCESSFULLY!!!
                        DO YOU WANT TO CONTINUE? (Y/N):\040""");
            } while (br.readLine().trim().equalsIgnoreCase("Y"));
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean updateEmployee(ArrayList<Employee> employees) {
        try {
            System.out.println("Enter Employee ID/INDEX: ");
            long id = Long.parseLong(br.readLine().trim());
            for (Employee e: employees) {
                if (e.getEmpId() == id || e.getEmpId() == 10125 + id) {
                    System.out.print("Enter Field to be Updated (NAME/AGE/ADDRESS): ");
                    String field = br.readLine().trim();
                    if (field.equalsIgnoreCase("NAME")) {
                        System.out.print("Enter new Name: ");
                        String name = br.readLine();
                        e.setEmpName(name);
                        return true;
                    } else if (field.equalsIgnoreCase("AGE")) {
                        System.out.print("Enter new Age: ");
                        int age = Integer.parseInt(br.readLine().trim());
                        e.setEmpAge(age);
                        return true;
                    } else if (field.equalsIgnoreCase("ADDRESS")) {
                        System.out.print("Enter new Address: ");
                        String address = br.readLine();
                        e.setEmpAddress(address);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteEmployee(ArrayList<Employee> employees) {
        try {
            System.out.print("Enter Employee ID/INDEX: ");
            long id = Long.parseLong(br.readLine().trim());
            boolean deleted = false;
            for (Employee e: employees) {
                if ((e.getEmpId() == id || e.getEmpId() == 10125 + id) && !deleted) {
                    employees.remove(e);
                    deleted = true;
//                    return true;
                }
            }
            // if last employee is deleted update indexes and id
            if (deleted) {
                for (int i = 0; i < employees.size(); i++) {
                    employees.get(i).setEmpId(10125 + i);
                }
            }
            return deleted;
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void getEmployeeDetails(ArrayList<Employee> employees,long id) {
        for (Employee e: employees) {
            if (e.getEmpId() == id || e.getEmpId() == 10125 + id) {
                System.out.println("empId\t\tempName\t\tempAge\t\tempAddress");
                System.out.println(e.getEmpId() + "\t\t" + e.getEmpName() + "\t\t" + e.getEmpAge() + "\t\t" + e.getEmpAddress());
                return;
            }
        }
        System.out.println("INVALID EMPLOYEE ID");
    }

    public static void getEmployeeDetails(ArrayList<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("NO EMPLOYEE RECORD FOUND");
            return;
        }
        employees.forEach(e -> System.out.println(e.getEmpId() + "\t\t" + e.getEmpName() + "\t\t" + e.getEmpAge() + "\t\t" + e.getEmpAddress()));
    }

}
