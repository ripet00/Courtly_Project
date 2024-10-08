package com.example.practivekotlin

fun main() {
    var num = 5
    var age = 15

    // C1
    if (num > 7) {
        print("Selamat Siang")
    } else {
        print("Selamat Sore")
    }

    // C2
    if (num < 10) {
        num += 10
    }

    // C3
    if (num > 14 && age < 10) {
        print("Selamat Malam")
    }
}
// C1 num = 5 sehingga false dan ngeprint selamat sore
// C2 num = 5 true, dan num berubah menjadi 15 setelah itu false
// C3 false sehingga tidak mengeprint