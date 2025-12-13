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

fun main(){
    var person = Person()
    person.setName("Ankit");
    println(person.getName());

    var person2 = Person2("Ankit", 18);
    println(person2.canVote());
}
fun test(){
    println("Hello Test ")
}