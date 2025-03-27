package io.keede.kotlinstarter.sealeds

// 상속이 가능하도록 추상 클래스를 만든다.
// 대신 외부에서는 이 클래스를 상속 불가능하게. => 하위 클래스들을 봉인하자.
// 즉 런타임때 하위 클래스 추가가 불가능. => 같은 패키지에 있어야 한다.
sealed class HyundaiCar(
    val name: String,
    val price: Long
)
// 컴파일에 하위 클래스를 기억하기 떄문에, 아래의 클래스만 허용된다.
class Avante: HyundaiCar("아반떼", 1_000L)
class Sonata: HyundaiCar("소나타", 1_000L)
class Grandeur: HyundaiCar("그렌저", 1_000L)