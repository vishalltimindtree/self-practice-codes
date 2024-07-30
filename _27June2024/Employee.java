public class Employee implements Comparable<Employee> {
    private int employeeID;
    private String name;
    private String grade;

    public Employee() {}

    public Employee(int employeeID, String name, String grade) {
        this.employeeID = employeeID;
        this.name = name;
        this.grade = grade;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }
}