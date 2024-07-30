class Employee {
    private String empEmail;
    private String empName;
    private String empDept;
    private double empSalary;
    private long empPhoneNo;

    public Employee(
        String empEmail,
        String empName, 
        String empDept,
        double empSalary, 
        long empPhoneNo
    ) {
        this.empEmail = empEmail;
        this.empName = empName;
        this.empDept = empDept;
        this.empSalary = empSalary;
        this.empPhoneNo = empPhoneNo;
    }

    public String getEmpEmail() {
        return empEmail;
    }
    
    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public long getEmpPhoneNo() {
        return empPhoneNo;
    }

    public void setEmpPhoneNo(long empPhoneNo) {
        this.empPhoneNo = empPhoneNo;
    }
}