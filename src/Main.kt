//class Person{
//    private var name: String = "Arpit"
//
//    fun getName(): String{
//        return name;
//    }
//    fun setName(name: String){
//        this.name= name;
//    }
//}

// class with parameters
class Person2(var name: String, var age:Int){
    fun canVote(): Boolean{
        return if (age>18) true else false;
    }

}

//Primary constructor and Initializer Blocks
class Person3(fName: String, personAge: Int){
    val firstName: String;
    var age: Int = 12;

    init{

        firstName = fName.capitalize()
        age = personAge
        println("First Name = $firstName")
        println("Age = $age")
    }

}

//secondary constructor
class Car{
    var name: String = "null";
    var age: Int = 0;

    constructor(){
        println("Create Car")
    }

    constructor(name: String){
        println("Constructor with single parameter")
        this.name= name;
    }

    constructor(name:String, age: Int){
        this.name = name;
        this.age = age;
        println("Constructor with two parameter");
    }

}

fun main(){
//    var person = Person()
//    person.setName("Ankit");
//    println(person.getName());
//
//    var person2 = Person2("Ankit", 18);
//    println(person2.canVote());

    var person3 = Person3("ankit", 21);

    var car = Car("Jaguar",200000)

    val f1= Footballer(21, "Ankit", "The DMJ Club");

}

class Profession{
    lateinit var name: String

    constructor(){
        name = "Software Engineer"
    }
}

//inheritance
open class Employee(name: String, dept: String){
    // codes
}

class Ankit( name: String, age: Int, dept: String): Employee(name, dept){
    init{
        println("Employee init")
        println("Employee name is $name and age is $age")
    }
    fun playFootball(){

    }
}



fun test(){
    println("Hello Test ")
}

open class Person(age: Int, name: String){

}
class Footballer (age: Int, name:String, club: String) : Person(age, name){
    init{
        println("Footballer player $name of age $age and plays for $club")
    }
    fun playFootball(){
        println("I am playing football")
    }
}

open class Log{
    var data: String = ""
    var numberOfData = 0
    constructor(_data: String){

    }
    constructor(_data: String, _numberOfData: Int){
        data = _data
        numberOfData = _numberOfData
        println("Data is $data")
    }
}

class AuthLog: Log{
    constructor(_data: String): this("From AuthLog -> + $_data", 10){

    }
    constructor(_data: String, _numberOfData: Int): super(_data, _numberOfData){

    }
}