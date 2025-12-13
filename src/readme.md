# Types of Constructors
- Primary Constructor : concise way to initialize a class
- Secondary constructor : allows you to put additional initialization logic

## Primary Constructor
```java
class Person2(var name: String, var age:Int){
    fun canVote(): Boolean{
        return if (age>18) true else false;
    }

}
```
The primary constructor is part of the class header.
To put the initialization code , initializer vkicj us s=used to prefixed with init keyword . Let;s modufy the above example with initializer block.

```java
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
```

## Secondary Constructor
```java
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
```

# lateinit in Kotlin
we must have noticed that when we write
```java
var name: String;   //this will throw an error 

```
this throws an error which says to initilize a value. But if we want to keep it null and may initilize late rin the code
we use the "lateinit" keyword which allow us to initialize the value later in the code.


