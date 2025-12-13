class Person{
    private var name: String = "Arpit"

    fun getName(): String{
        return name;
    }
    fun setName(name: String){
        this.name= name;
    }
}

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
    var person = Person()
//    person.setName("Ankit");
//    println(person.getName());
//
//    var person2 = Person2("Ankit", 18);
//    println(person2.canVote());

    var person3 = Person3("ankit", 21);

    var car = Car("Jaguar",200000)



}
fun test(){
    println("Hello Test ")
}