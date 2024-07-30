// Define the Person interface
interface Person {
    id: number;
    name: string;
  }
  
  // Define the Staff class implementing Person
  export class Staff implements Person {
    id: number;
    name: string;
    role: string;
    department: string;
  
    constructor(id: number, name: string, role: string, department: string) {
      this.id = id;
      this.name = name;
      this.role = role;
      this.department = department;
    }
  
    showDetails(): void {
      console.log(`Staff Details: ID-${this.id}, Name-${this.name}, Role-${this.role}, Department-${this.department}`);
    }
  }
  
  // Define the Student class implementing Person
  export class Student implements Person {
    id: number;
    name: string;
    studentId: number;
    major: string;
  
    constructor(id: number, name: string, studentId: number, major: string) {
      this.id = id;
      this.name = name;
      this.studentId = studentId;
      this.major = major;
    }
  
    showDetails(): void {
      console.log(`Student Details: ID-${this.id}, Name-${this.name}, Student ID-${this.studentId}, Major-${this.major}`);
    }
  }
  
  // Create an object of the Staff class
  const staff = new Staff(1, 'John Doe', 'Teacher', 'Science');
  
  // Create an object of the Student class
  const student = new Student(2, 'Jane Doe', 12345, 'Computer Science');
  
  // Display details using showDetails method
  staff.showDetails();
  student.showDetails();
  






  