package io.keede.kotlinstarter.lambdas

data class Fruit(
    val name: String
)

fun main() {
    val fruit: Fruit = Fruit("@")

    println(isApple(fruit))
    println(isApple2(fruit))

    // 마지막 파라미터가 함수일 경우 아래와 같이 람다를 사용할 수 있다.
    filterFruit(mutableListOf(fruit)) { it.name == "tkrhk" }
    // 람다를 여러줄 작성 가능하며, 마지막 줄의 결과가 반환값
    filterFruit(mutableListOf(fruit)) { fruit ->
        println("사과만 받기")
        fruit.name.contains("@") // 적용되지 않음.
        fruit.name.contains("1")
    }.forEach { println(it) }
}

// 람다 만드는 방법 1
val isApple = fun(fruit: Fruit): Boolean {
    // 코틀린은 ==가 equals와 같다.(동등성)
    // === (동일성) java의 ==
    return fruit.name == "사과"
}

// 람다 만드는 방법 2
val isApple2 = { fruit: Fruit -> fruit.name == "사과"}

val isApple3: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
    // 코틀린은 ==가 equals와 같다.(동등성)
    // === (동일성) java의 ==
    return fruit.name == "사과"
}

val isApple4: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과"}

fun filterFruit(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    val result = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if(filter.invoke(fruit)) {
            result.add(fruit)
        }
    }

    println("result : ${result}")
    return result
}