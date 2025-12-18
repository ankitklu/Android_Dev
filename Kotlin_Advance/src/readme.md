# What is a Coroutine?
A coroutine is a task that can pause, wait, and continue later without blocking everything else.
```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {
        println("Coroutine: Start")
        delay(2000)
        println("Coroutine: End")
    }

    println("Main: I am NOT blocked")
}

```

# What is Suspend Coroutine?
“If the phone rings, pause homework, answer phone, then continue.”

When a suspend function pauses:
- Kotlin saves its state
- Frees the thread
- Later restores state
- Continues from where it stopped

Like a YouTube video pause/play

```kotlin
fun main(){
    println("Start")
    fetchData()
    println("End")
}
suspend fun fetchData() {
    println("Fetching data...")
    delay(2000)
    println("Data fetched")
}
```

it's like i am doing my homework,
mummy says "stop your homework, wash the dishes and then come back."
