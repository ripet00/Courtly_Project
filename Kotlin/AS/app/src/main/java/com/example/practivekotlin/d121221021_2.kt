package com.example.practivekotlin

fun main() {
    repeat(4) {
        println("================")
        println("Penghitungan Tahun Kabisat")
        print("Masukkan tahun : ")
        val year = readln().toInt()

        if ((year % 4 ==0 && year % 100 !=0) || year % 400 ==0) {
            println("Tahun $year merupakan tahun kabisat")
        } else {
            println("$year bukan merupakan tahun kabisat")
        }
    }

}