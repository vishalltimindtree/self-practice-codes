import java.util.*;

public class EmployeeManagement {
    private Map<Integer, Employee> employeeMap;

    public EmployeeManagement() {
        employeeMap = new HashMap<Integer, Employee>();
    }

    public void addEmployee(Employee employee) {
        employeeMap.put(employee.getEmployeeID(), employee);
    }
    
    public Employee getEmployee(int employeeID) {
        return employeeMap.get(employeeID);
    }

    public List<Employee> getAllEmployeesSortedByName() {
        List<Employee> empList = new ArrayList<Employee>(employeeMap.values());
        Collections.sort(empList);
        return empList;
    }

    public boolean removeEmployee(int employeeID) {
        return employeeMap.remove(employeeID) != null;
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(10743469, "Vishal", "four");
        Employee emp2 = new Employee(10743470, "Sunil", "five");
        EmployeeManagement e = new EmployeeManagement();
        e.addEmployee(emp1);
        e.addEmployee(emp2);
        e.getEmployee(emp1.getEmployeeID());
        List<Employee> empList = e.getAllEmployeesSortedByName();
        Iterator<Employee> itr = empList.iterator();
        while (itr.hasNext()) {
            Employee currEmp = itr.next();
            System.out.println("Employee ID: " + currEmp.getEmployeeID() + ", Employee Name: " + currEmp.getName() +
                                    ", Employee Grade: " + currEmp.getGrade());
        }
        if (e.removeEmployee(emp1.getEmployeeID())) {
            System.out.println("Employee removal success with ID: " + emp1.getEmployeeID());
        } else {
            System.out.println("Employee removal failed with ID: " + emp1.getEmployeeID());
        }
        
        System.out.println("\nList after removal:");
        empList = e.getAllEmployeesSortedByName();;
        itr = empList.iterator();
        while (itr.hasNext()) {
            Employee currEmp = itr.next();
            System.out.println("Employee ID: " + currEmp.getEmployeeID() + ", Employee Name: " + currEmp.getName() +
                                    ", Employee Grade: " + currEmp.getGrade());
        }
    }
}