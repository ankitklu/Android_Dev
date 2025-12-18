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

# Inheritance
If the class has a primary constructor , the base must be initialized using the paramaeters of the primary constructor. in the above program , both derived classes gave two parameters age and naem, and both these parameters are initialized in primary constructor in the base clasee.

```java

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
```

# Visibility Modifiers inside classes and interfaces

- public => visible to any client who can see the declaring class
- private => vosoble inside the class only
- protected => visible inside the class and its subclasses
- internal => visible to any client inside the module that can see the declaring class

Note: If you override a protected member in the derived class without specifying its visibility , its visibility will also be protected.


# Conditional Statements

```java
// if else ladder
if(){}
else{}

//else if ladder
if(){}
else if(){}
else{}

//switch conditional
when(number){
    case1 -> println()
    case
}
```

# Loops
```java
while(condition){
    //do something and upate
}

for(i in 1..5){
    
}
//back looping
        for (i in 10 downTo 1) {
            println(i)
        }

            for(i in 10 downTo 1 step 1){
                print("$i ");
            }

//for each
var text = "Ankit"
for(letter in text){
    
}

```

# Function
```java
fun name(par1: Int, par2:Int): Int{
    
}
```

# Arrays

```java
var arr = arrayOf("One","Two","Three")
```


