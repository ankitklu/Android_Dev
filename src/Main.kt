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

fun main(){
    var person = Person()
//    person.setName("Ankit");
//    println(person.getName());
//
//    var person2 = Person2("Ankit", 18);
//    println(person2.canVote());

    var person3 = Person3("ankit", 21);


}
fun test(){
    println("Hello Test ")
}