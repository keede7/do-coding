package io.keede.kotlinstarter.arrays


fun main() {

    val array = arrayOf(100, 200)

    // indices => 0 부터 마지막 index까지 범위
    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    println()

    array.plus(300) // 값을 넣을 수 있다.

    // withIndeX() => 인덱스와 값을 한번에 가져올 수 있다.
    for ( (idx, value) in array.withIndex() ) {
        println("${idx} ${value}")
    }

}