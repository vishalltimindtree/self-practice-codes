//boolean,number,string,bigint,any,undefined,null;
//Explicit
var userNam: string = "Vinothkumar";
console.log(userNam);
//Implicit
let myName = "ashokkumar";

console.log(typeof myName);
//Any Datatype
let data: any = "modi";
console.log(data);
data = 34; // no error as it can be "any" type
console.log(data);

//Any Datatype
let data1: any[] = ["modi",34];
//data = 34; // no error as it can be "any" type
console.log(data1);

//******Array****/
const studentName: string[] = [];
studentName.push("Vinoth"); 
studentName.push("Ashok"); 
console.log(studentName);
//**Array Type 1 */
const studentName1: string[] = ["Vinoth","Ashok"];
console.log(studentName1[0]);
console.log(studentName1[1]);
console.log("Length "+studentName1.length);


/******* Read Only */
const names: readonly string[] = ["Vinothkumar","Ashokkumar"];
//names[3]="Selva";
console.log(names);
/**************  */


function add(a: number, b: number): number {
    return a + b;
}

console.log(add(20,66));
//Another Type 1

var add1Demo = (x: number, y: number): number => {
    return x + y;
};
console.log(add1Demo(66, 66));






//Another Type 2
let add2Demo: (a: number, b: number) => number =
    function (x: number, y: number) {
        return x + y;
    };
console.log(add2Demo(50,60));


// Function with default parameter
function greet(name: string, greeting: string = "Good Day") {
    console.log(`${greeting}, ${name}!`);
}

greet("Vinoth"); 
greet("vinoth", "Ashok");


function greet1(name: string, greeting?: string):void {
    if (greeting) {
        console.log(`${greeting}, ${name}!`);
    } else {
        console.log(`Good Day, ${name}!`);
    }
}

greet1("vino"); 
greet1("vino", "ashok"); 


/*A function has only one rest parameter.
The rest parameter appear last in the parameter list.
The type of the rest parameter is an array type.
*/
function combine(x:number,...args: any[]): any{
    let sum = 0;
    let strData = '';
    args.forEach((arg) => {
      if (typeof arg === 'number') {
        sum += arg;
      } else if (typeof arg === 'string') {
        strData += arg;
      }
    });
    console.log(x);
    return [sum, strData] ;
  }
  const [sum, strData]= combine(98,3, 'Good', 2, 1, ' Day');
  console.log({ sum });
  console.log({ strData });


  class Student {
    studentId: number;
    firstName: string;
    lastName: string;

    constructor(studentId: number, firstName: string, lastName: string) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    getFullName(): void {
        console.log(`Student Details:
            \nStudent ID: ${this.studentId}
            \nStudent Name: ${this.firstName}
            \nLast Name ${this.lastName}`);
    }
}

// Creating a new Student object
let student1 = new Student(1, "vinoth", "selvaarasan");

student1.getFullName();











  
