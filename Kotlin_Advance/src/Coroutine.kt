import kotlinx.coroutines.*

fun main() = runBlocking {  //blocks the main thread until all coroutines are blocked
//    launch {
//        println("Coroutine: Start")
//        delay(2000)
//        println("Coroutine: End")
//    }
//
//    println("Main: I am NOT blocked")
//
//    val job = launch {
//        delay(5000)
//        println("Finished")
//    }
//
//    delay(2000)
//    job.cancel()
//    println("Cancelled")

    println("Start")
    fetchData()
    println("End")


}
suspend fun fetchData() {
    println("Fetching data...")
    delay(2000)
    println("Data fetched")
}
