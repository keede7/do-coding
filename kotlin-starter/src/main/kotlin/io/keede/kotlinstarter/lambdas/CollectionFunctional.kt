package io.keede.kotlinstarter.lambdas


data class FruitEntity (
    val id: Long,
    val name: String,
    val factoryPrice: Long,
    val currentPrice: Long,
)

// 필터에 인덱스가 필요하다면 filterIndexed { idx, ~~~ }
val appleFilter = { fruit: FruitEntity -> fruit.name == "사과" }

// 맵에 인덱스가 필요하다면 mapIndexed { idx, ~~~ }
val applePriceFilter = { fruit: FruitEntity -> fruit.currentPrice }

fun main() {

    val fruits = mutableListOf<FruitEntity>(
        FruitEntity(1, "사과", 1000, 5000),
        FruitEntity(2, "배", 2000, 7000),
        FruitEntity(3, "사과", 10800, 9000),
    )

    val applePrices = fruits.filter(appleFilter)
        .map(applePriceFilter)

    val applePrices2 = fruits.filter(appleFilter)
        .mapIndexed { idx, fruit ->
            println(idx)
            fruit.currentPrice
        }

    val isAllApple = fruits.all(appleFilter)
    val isNoApple = fruits.none(appleFilter)
    val isAnyApple = fruits.any(appleFilter)
    val first = fruits.first()
    val firstOrNull = fruits.firstOrNull()
    val last = fruits.last()
    val lastOrNull = fruits.lastOrNull()

    val groupBy: Map<String, List<FruitEntity>> = fruits.groupBy { fruit -> fruit.name }
    val groupBy2: Map<String, List<Long>> = fruits.groupBy ({ fruit -> fruit.name }, {fruit -> fruit.factoryPrice } )
    val map: Map<Long, FruitEntity> = fruits.associateBy { fruit -> fruit.id }
    val map2: Map<Long, Long> = fruits.associateBy ({ fruit -> fruit.id }, {fruit -> fruit.factoryPrice } )

    // 중첩된 컬렉션 처리

}
