class Person{
    private var name: String = "Arpit"

    fun getName(): String{
        return name;
    }
    fun setName(name: String){
        this.name= name;
    }
}

fun main(){
    var person = Person()
    person.setName("Ankit");
    println(person.getName());
}
fun test(){
    println("Hello Test ")
}