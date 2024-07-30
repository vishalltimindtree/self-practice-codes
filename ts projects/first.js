//boolean,number,string,bigint,any,undefined,null;
//Explicit
var userNam = "Vinothkumar";
console.log(userNam);
//Implicit
var myName = "ashokkumar";
console.log(typeof myName);
//Any Datatype
var data = "modi";
console.log(data);
data = 34; // no error as it can be "any" type
console.log(data);
//Any Datatype
var data1 = ["modi", 34];
//data = 34; // no error as it can be "any" type
console.log(data1);
//******Array****/
var studentName = [];
studentName.push("Vinoth");
studentName.push("Ashok");
console.log(studentName);
//**Array Type 1 */
var studentName1 = ["Vinoth", "Ashok"];
console.log(studentName1[0]);
console.log(studentName1[1]);
console.log("Length " + studentName1.length);
/******* Read Only */
var names = ["Vinothkumar", "Ashokkumar"];
//names[3]="Selva";
console.log(names);
/**************  */
function add(a, b) {
    return a + b;
}
console.log(add(20, 66));
//Another Type 1
var add1Demo = function (x, y) {
    return x + y;
};
console.log(add1Demo(66, 66));
//Another Type 2
var add2Demo = function (x, y) {
    return x + y;
};
console.log(add2Demo(50, 60));
// Function with default parameter
function greet(name, greeting) {
    if (greeting === void 0) { greeting = "Good Day"; }
    console.log(greeting + ", " + name + "!");
}
greet("Vinoth");
greet("vinoth", "Ashok");
function greet1(name, greeting) {
    if (greeting) {
        console.log(greeting + ", " + name + "!");
    }
    else {
        console.log("Good Day, " + name + "!");
    }
}
greet1("vino");
greet1("vino", "ashok");
/*A function has only one rest parameter.
The rest parameter appear last in the parameter list.
The type of the rest parameter is an array type.
*/
function combine(x) {
    var args = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        args[_i - 1] = arguments[_i];
    }
    var sum = 0;
    var strData = '';
    args.forEach(function (arg) {
        if (typeof arg === 'number') {
            sum += arg;
        }
        else if (typeof arg === 'string') {
            strData += arg;
        }
    });
    console.log(x);
    return [sum, strData];
}
var _a = combine(98, 3, 'Good', 2, 1, ' Day'), sum = _a[0], strData = _a[1];
console.log({ sum: sum });
console.log({ strData: strData });
var Student = /** @class */ (function () {
    function Student(studentId, firstName, lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    Student.prototype.getFullName = function () {
        console.log("Student Details:\n            \nStudent ID: " + this.studentId + "\n            \nStudent Name: " + this.firstName + "\n            \nLast Name " + this.lastName);
    };
    return Student;
}());
// Creating a new Student object
var student1 = new Student(1, "vinoth", "selvaarasan");
student1.getFullName();
