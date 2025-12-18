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

    // let keyword
    /*
    If the declaring value is null then the let block won't execute
    -> We use let when we deal with null possibilities
    ->
     */

//    val name: String? = null
    val name: String? = "Ankit"
    var entered: Boolean = false;
    name?.let{
        println(it.uppercase())
        entered= true;
    }
    println(entered)

    //when we want to retrun something from the let scope.
    val length = name?.let{
        it.length
    }
    println(length)


    // run keyword
    /*
    when we don't need the object afterward and we need to calculate something, we use run keyword.
    It's like do some work and give me the result
     */
    var ar = arrayOf(1,2,20,3,3,4)

    var len = ar?.run{
        ar.set(0,999)
        size
    }
    ar.forEach { print("$it, ") }
    println()
    println(len)

    val numbers = intArrayOf(1, 2, 3, 4, 5)

    val result = numbers.run {
        println("Size = $size")
        sum()
    }

    val sumofmaxmin = numbers.run{
        val max = maxOrNull()?: 0;
        val min = minOrNull()?: 0;
        max+min
    }
    println(sumofmaxmin)
    println(result) // 15

    /*
        Avoid repeating numbers, keeps the logic grouped and returns a value
        -> we can also have a null check before implementing the run scope
     */
    val num: IntArray? = intArrayOf(10, 20, 30)

    val average = num?.run {
        sum().toDouble()/size
    }

    println(average)

    // we can also use run for validation logic

    val numArr = intArrayOf(10, 20, 31)
    val allEven = numArr?.run{
         all {it % 2 == 0}
    }
    println(allEven)


    // can use multiple trasnforms and then applyu run keyword as well
    val newArray = numbers.filter{it>2}.toIntArray().run{
        sum()*size
    }
    println(newArray)

    // apply keyword
    val num2 = IntArray(5).apply {
        for (i in indices) {
            this[i] = i * 2
        }
    }

    println(numbers.joinToString())

    val numberArray = arrayOf(5, 2, 4, 3, 1)
    val newArray2 = numberArray?.apply{
        sort()
    }
    println(newArray2?.joinToString())


    //apply keyword
    println("-----------APPLY------------")
    val newNumArray = arrayOf(1,2,3,4,5)
    newNumArray.also{println("before sorting, the array was ${newNumArray.joinToString()}")}
        .apply { sortDescending() }
        .also{ println("after sorting the array ${newNumArray.joinToString()}") }

    // map function in kotlin
    var list2 = listOf(1,2,3,4,5)
    var newList2 = list2.map{it*it}
    println(newList2)

    list2 = list2.map{it*2}
    println(list2)


    var list3 = listOf("ankit","om","akm","coder")
    var l = list3.map{it.length}
    println(l.joinToString())

    val ageMap = mapOf("Ankit" to 22, "Ravi" to 16)

    val newAgeMap = ageMap.map{
        (name, age)-> "$name to ${2*age}"
    }
    println(newAgeMap)

    val adults = ageMap.filter { (name, age) ->
        age >= 18 && name.length ==5
    }
    println(adults)

    //associateBy keyword
    /*
    -> It creates a map from a list by choosing a key or a value from the list
    ->
     */

    data class User(val name: String, val age : Int)
    val users = listOf(
        User("Ankit",21),
        User("Arpit",22)
    )

    val userMap = users.associateBy { it.name }
    println(userMap)

    val users2 = listOf(
        User("Ankit", 22),
        User("Ravi", 17),
        User("Raj", 25)
    )

    val adultUserNamesById =
        users2
            .filter { it.age >= 18 }
            .map { it.name }

    val adultMap = users2
        .filter{it.age >=18}
        .associateBy { "${it.name} to ${it.age}" }

    println(adultMap)

    println(adultUserNamesById)

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