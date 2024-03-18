
println("Hello World")
fun main(){
    println("Hello World")
}
main()

fun main2()  = 5
main2()
fun main3() : Int {
    return 5
}
main3()

fun main4(){
    var namn = "Sarhad"
    var String = "Hej, $namn"
    println(String)
}
main4()

//kort notation
fun area(x : Int, y : Int):Int{
    return x*y
}
fun omkrets(x:Int,y:Int):Int{
    return 2*(x+y)
}
//lång notation
fun area2(x : Int, y : Int): Int = x*y
fun omkrets2(x:Int,y:Int):Int =2*(x+y)
omkrets2(4,2)

//implicit typning
val x = 5
val y = 4
area(x,y)
//explicit typning
var x3 :Int = 5
var y3 :Int = 4
omkrets(x3,y3)
//Recursion
fun fact(n:Long):Long{
    if (n<=1) return 1
    return n * fact(n-1)
}
fact(3)

fun factAcc(n:Long):Long{
    fun factInneerAcc(acc:Long, n:Long):Long{
        if (n==1L) return acc
        else return factInneerAcc(n*acc,n-1)
    }
    return factInneerAcc(1,n)
}

val list = listOf('a','b','c','d')
val result = list.mapIndexed({ index: Int, n ->  "[$index = $n]" })
println(result)
println(list.joinToString(separator = "x", postfix = "end".toUpperCase(), transform = {" ${it.toUpperCase()} "}))

val isEven = {i : Int -> i % 2 == 0}
val listOfNumb = listOf(1,2,3,4,5)
println(listOfNumb.filter(isEven))
/*
val namn = readLine()
repeat(3){
    index -> println("Hello $index" + namn)
}
*/

fun rep2(times : Int, action: () -> Unit) {

    for (i in 0 until times) {
        action()
    }
}
rep2(5){ println("Hello")}

for (i in 1..5){
    println(i)
}
fun helloo(name: String){
    println("Hej $name")
}
helloo("Sarhad")