fun main() {
    print("Masukkan nilai angka yang ingin dikonversi : ")
    val suhu = readln().toDouble()
    var con: Boolean = true
    while (con == true) {
        println("===================")
        println("1. Celcius -> Fahrenheit")
        println("2. Fahrenheit -> Celcius")
        println("===================")
        print("Pilih pengonversian suhu yang ingin anda pilih (1 / 2): ")
        val choose = readln().toInt()

        if (choose == 1) {
            val result = celcius(suhu)
            print("Hasil konversi adalah = $result°F")
            con = false
        } else if (choose == 2){
            val result = fahrenheit(suhu)
            print("Hasil konversi adalah = $result°C")
            con = false
        } else {
            println("Tolong pilih kembali")
            con = true
        }
    }
}

fun celcius(suhu: Double): Double {
    return (9/5 * suhu) + 32
}

fun fahrenheit(suhu: Double): Double {
    return 5/9 * (suhu - 32)
}