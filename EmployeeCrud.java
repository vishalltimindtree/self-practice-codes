import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmployeeCrud {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee emp;
        ArrayList<Employee> arrList = new ArrayList<Employee>();
        for (int i = 0; i < 2; i++) {
            System.out.print("Enter email of employee " + (i + 1) + ": ");
            String empEmail = sc.next();
            System.out.print("Enter name of employee " + (i + 1) + ": ");
            String empName = sc.next();
            System.out.print("Enter department of employee " + (i + 1) + ": ");
            String empDept = sc.next();
            System.out.print("Enter salary of employee " + (i + 1) + ": ");
            double empSalary = sc.nextDouble();
            System.out.print("Enter phone number of employee " + (i + 1) + ": ");
            long empPhoneNo = sc.nextLong();
    
            emp = new Employee(empEmail, empName, empDept, empSalary, empPhoneNo);
            arrList.add(emp);
            System.out.println();
        }
        
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpDb", "root", "root");
            String insertQuery = "INSERT INTO Employee (Email, Name, Department, Salary, PhoneNo ) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);

            int res = 0;
            Iterator<Employee> it = arrList.iterator();
            while (it.hasNext()) {
                Employee currEmp = it.next();
                ps.setString(1, currEmp.getEmpEmail());
                ps.setString(2, currEmp.getEmpName());
                ps.setString(3, currEmp.getEmpDept());
                ps.setDouble(4, currEmp.getEmpSalary());
                ps.setLong(5, currEmp.getEmpPhoneNo());
                
                res = ps.executeUpdate();
            }
            
            if (res > 0) {
                System.out.println("Insert successfully");
            } else {
                System.out.println("Insert failed");
            }

            String retrieveQuery = "SELECT * FROM Employee";
            ps = con.prepareStatement(retrieveQuery);
            ResultSet rSet = ps.executeQuery();
            while (rSet.next()) {
                int empId = rSet.getInt("Id");
                String empEmail = rSet.getString("Email");
                String empName = rSet.getString("Name");
                String empDept = rSet.getString("Department");
                double empSalary = rSet.getDouble("Salary");
                long empPhoneNo = rSet.getLong("PhoneNo");
                
                System.out.print(empId + "\t" + empEmail + "\t" + empName + "\t" + empDept + "\t" + empSalary + "\t" + empPhoneNo);
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e);
                }
            }
            sc.close();
        }    
    }
}
