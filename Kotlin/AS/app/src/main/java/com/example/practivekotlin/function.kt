package com.example.practivekotlin

fun main() {
    val result = double(2)
    val lambda = { i: Int -> i + 3}
    println(lambda(9))
    println(double(2))
    println(triple(3))
    printHello(null)
    printHello("Hello")
    foo("a", "b", "c")
}

fun double(x: Int): Int {
    return 2 * x
}

fun triple(x: Int) = x * 3

fun printHello(name: String?): Unit { // ? bisa diisi null atau string
    if (name != null) {

    }
}

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an array
        result.add(t)
    return result
}

fun foo(vararg strings: String) {
    for (i in strings) {
        println(i)
    }
}