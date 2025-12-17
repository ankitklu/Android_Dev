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

//    Child.log("Ankit")
//    Child.log("AKM")
//
//
//    Loading.log("Ankit Kumar Mishra")
//    println(Loading.log("2200032823"))
//    println(Loading.log("21"))

    val res = HttpStatus.BAD_REQUEST;
    println(res)
    println(res.responseLog())

    HttpStatus.entries.forEach {
        println(it.name)
    }

    val states: List<Result> = listOf(
        Result.success,
        Result.Failure(404,"Error in storing user data"),
        Result.Error("Network error")
    )

    for (state in states) {
        println(state)
    }


    // lambda functions
    val add = { a: Int, b: Int -> a + b }
    println(add(1,2))


    //higher order functions
    val sum = calculate(10, 5) { x, y -> x + y }
    val diff = calculate(10, 5) { x, y -> x - y }
    val product = calculate(10, 5) { x, y -> x * y }

    println(sum)
    println(diff)
    println(product);

    // filter
    val arr = arrayOf(1,2,20,3,3,4)
    val newArr = arr.filter { it % 2 == 0 }
    println(newArr)

    val list = listOf<Int>(1,2,23)
    val newList = list.filter{ it%3==0}
    println(newList)

    arr.forEach{println(it)}

}

fun calculate(
    a: Int,
    b: Int,
    operation: (Int, Int) -> Int
): Int {
    return operation(a, b)
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

data object Child{
    fun log(name: String){
        println("LOG: $name");
    }
}

data object Loading{
    fun log(name: String){
        println("LOADING: $name");
    }
    fun age(age: Int){
        println("AGE: $age");
    }
}

enum class HttpStatus(val code: Int, val msg:String){
    ERROR(404, "Server error"),
    OK(200,"OK"),
    BAD_REQUEST(400, "Bad request"),
    InternalServerError(500, "Internal server error");

    fun responseLog() : String{
        return "$code: $msg"
    }
}

// sealed classes
sealed class Result{
    data object success : Result()
    data class Failure(val code: Int, val msg: String) : Result()
    data class Error(val message: String) : Result()

}

fun render(state: Result) {
    when (state) {
        Result.success -> println("UI: Loading...")
        is Result.Failure -> println("UI: Success -> ${state.code}")
        is Result.Error -> println("UI: Error -> ${state.message}")
    }
}