import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CustomException extends Exception {

    private static final long seriaVersionUID = 1L;

    public CustomException(String str) {
        super();
        System.out.println(str);
        EmployeeSystem.operations();
    }
}

public class EmployeeSystem {

    public static Map<Integer, Employee> Map = new HashMap<>();

    public static void addEmployee(String name, int age, int id) {
        Employee emp = new Employee(name, age, id);
        Map.put(id, emp);

        operations();
        ;
    }

    public static void deleteEmployeee(int EmpId) throws CustomException {
        if (Map.containsKey(EmpId)) {
            Map.remove(EmpId);
            System.out.println("Successfully Deleted !");
        } else {
            throw new CustomException("Not Found Exception");
        }

        operations();
    }

    public static void searchEmployee(int EmpId) throws CustomException {
        if (Map.containsKey(EmpId)) {
            System.out.println("Employee Details: -" + Map.get(EmpId));
        } else {
            throw new CustomException("Not Found Exception");
        }

        operations();
    }

    public static void employeeeList() {
        System.out.println(Map.toString());
    }

    public static void operations() {
        System.out.println("\n****** Employee management system ******");
        System.out.println("1. Add employee");
        System.out.println("2. Delete employee");
        System.out.println("3. Search employee");
        System.out.println("4. Employee List");

        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();

        if (userInput == 1) {
            System.out.println("enter Employee Details(Name, age, id");
            Scanner sc1 = new Scanner(System.in);

            String name = sc1.next();
            int age = sc1.nextInt();
            int id = sc1.nextInt();

            if (!name.equals("") && age != 0 && id != 0) {
                addEmployee(name, age, id);
            }
        } else if (userInput == 2) {
            System.out.println("Enter Employee Id");
            Scanner sc2 = new Scanner(System.in);

            int EmpId = sc2.nextInt();

            try {
                deleteEmployeee(EmpId);
            } catch (CustomException e) {
                // e.printStackTrace();
            }

            operations();

            try {
                searchEmployee(EmpId);
            } catch (CustomException e) {
                // e.printStackTrace();
            }

            operations();
        } else if (userInput == 4) {
            employeeeList();

            operations();
        }
    }

    public static void main(String[] args) {
        operations();
    }
}
