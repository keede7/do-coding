package io.keede.kotlinstarter.collections



fun main() {

    val list = listOf(100, 200)

    val aa: List<Int> = emptyList()

    println(list[0])

    for (number in list) {
        println("${number}")
    }

    for ( (idx, value) in list.withIndex() ) {
        println("${idx} ${value}")
    }

    val mutable = mutableListOf(100, 200)

    mutable.add(300)

    println()

    // 가변 컬렉션
    for ( (idx, value) in mutable.withIndex() ) {
        println("${idx} ${value}")
    }

    // Map
    val map = mutableMapOf<Int, String>()
    map[1] = "MONDAY";
    map[2] = "TUESDAY"

    println(map)

    // 가변
    val map2 = mutableMapOf<String, String>()
    map2["a"] = "MONDAY";
    map2["b"] = "TUESDAY"
    map2["c"] = "WEN"

    println("map2 = ${map2}")

    // 불변
    val map3 = mapOf(1 to "M", 2 to "B")
    println("map3 = ${map3}")

    for (key in map.keys) {
        println("key = ${key}")
        println("map[key] = ${map[key]}")
    }

    for (value in map.values) {
        println("value = ${value}")
    }

    println()

    for ( (key, value) in map.entries) {
        println("key = ${key}")
        println("value = ${value}")
    }

    // 리스트만 null일 수 있다.
    val list1: List<Int>?
    // 내부 인덱스 값이 null일 수 있다.
    val list2: List<Int?>
    // 내부 값이 null이 들어 갈 수 있고, 리스트가 null일 수 있다.
    val list3: List<Int?>?

}
