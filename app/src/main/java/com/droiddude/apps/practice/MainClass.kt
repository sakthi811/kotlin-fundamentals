
fun reverse(n : Int) : Int {
    var reverse = 0
    var temp = n
    while(temp>0) {
        reverse = reverse * 10 + temp % 10
        temp /= 10
    }
    return reverse
}

fun reverse(n : Long) : Long {
    var reverse = 0L
    var temp = n
    while(temp>0) {
        reverse = reverse * 10 + temp % 10
        temp /= 10
    }
    return reverse
}

val reverse : (String) -> String = { it.reversed() }

fun main() {
    var longNum = 123452392098098923L
    println("Reverse of Long Number is ${reverse(longNum)}")
    var intNum = 12345
    println("Reverse of Long Number is ${reverse(intNum)}")
    var name = "SAKTHIVEL"
    println("Reverse of String is ${reverse(name)}")
}