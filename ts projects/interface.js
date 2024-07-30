"use strict";
exports.__esModule = true;
// Define the Staff class implementing Person
var Staff = /** @class */ (function () {
    function Staff(id, name, role, department) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.department = department;
    }
    Staff.prototype.showDetails = function () {
        console.log("Staff Details: ID-" + this.id + ", Name-" + this.name + ", Role-" + this.role + ", Department-" + this.department);
    };
    return Staff;
}());
exports.Staff = Staff;
// Define the Student class implementing Person
var Student = /** @class */ (function () {
    function Student(id, name, studentId, major) {
        this.id = id;
        this.name = name;
        this.studentId = studentId;
        this.major = major;
    }
    Student.prototype.showDetails = function () {
        console.log("Student Details: ID-" + this.id + ", Name-" + this.name + ", Student ID-" + this.studentId + ", Major-" + this.major);
    };
    return Student;
}());
exports.Student = Student;
// Create an object of the Staff class
var staff = new Staff(1, 'John Doe', 'Teacher', 'Science');
// Create an object of the Student class
var student = new Student(2, 'Jane Doe', 12345, 'Computer Science');
// Display details using showDetails method
staff.showDetails();
student.showDetails();
