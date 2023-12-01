package day1

import java.io.File
import java.io.InputStream

fun read(): List<String> {
    val inputStream: InputStream = File("cp/src/day1/input.txt").inputStream()
    return inputStream.bufferedReader().use { it.readText() }.split("\n")
}



fun countProblem1(s : String) : Int{
    var first = 0
    var last = 0
    for(ch in s) {
        if (ch.isDigit() ) {
            if(first == 0){
                first = ch.digitToInt()
            }
            last = ch.digitToInt()
        }
    }
    return first * 10 + last
}
fun countProblem2(s : String) : Int{
    var first = 0
    var last = 0
    var ss = s
    val numberslist = arrayListOf<String>("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" )

    numberslist.forEachIndexed{ i,n ->
        if(i > 0){
            ss = ss.replace(n , "$n$i$n")
        }
    }
    return countProblem1(ss)
}




fun solve1(listData : List<String>) : Int{
    var sum = 0
    listData.forEach{
        sum += countProblem1(it)
    }
    return sum
}
fun solve2(listData : List<String>) : Int{
    var sum = 0
    listData.forEach{
        sum += countProblem2(it)
    }
    return sum
}
fun main(){
    val data = read()
    val result1 = solve2(data)
    println(result1)

}
