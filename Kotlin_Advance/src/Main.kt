fun main(){
    val person1 = Person(32823, "Ankit",21)
    val person2 = person1.copy(name = "ankit")
    println(person2.name)
//    println(person2) // this prints Person@63961c42 if toString() method is present in the data class.

    // to get rid of this Person + memory thing we need to remove the override toString function

    println(person2)

    val person3 = person1.copy(
        name= "AKM",
        id=22000

    )
    println(person2==person1)

    println(person3);

}

data class Person(val id: Int, val name: String, val age: Int){
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

//    override fun toString(): String {
//        return super.toString()
//    }
}