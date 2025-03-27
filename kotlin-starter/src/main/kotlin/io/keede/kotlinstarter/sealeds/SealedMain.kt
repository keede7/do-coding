package io.keede.kotlinstarter.sealeds

fun main() {
     test(Avante())
}

private fun test(car: HyundaiCar) {
    when(car) {
        is Avante -> println("av")
        is Grandeur -> println("ge")
        is Sonata -> println("so")
    }

}

