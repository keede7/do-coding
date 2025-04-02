package io.keede.kotlinstarter.functions

// 확장함수
/*
    1. 원본 클래스의 private, protected 멤버 접근 불가능
    2. 멤버함수, 확장함수 중 멤버함수에 우선권이 있다.
    3. 확장함수는 현재 타입을 기준으로 호출된다.
    4. Java의 static을 쓰는 것처럼 사용이 가능하다.
 */
// custom getter에도 사용이 가능하다. get() = ...
fun String.lastChar(): Char {
    return this[this.length - 1]
}

// 만약 멤버함수와 확장함수의 시그니처가 같으면 멤버함수가 먼저 호출된다.
fun main() {
    val s: String = "asdf"

    println(s.lastChar())

    println()
    // infix 함수
    val value: Int = 3;
    value add2 4
}

// infix 함수 = 중위함수, 새로운 함수를 호출하는 방법.
// 예를들어 downTo, step이 있었다. '변수.함수이름(arg)' 대신 '변수 함수이름 arg'
fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}

/*
    지역함수
    함수 내에 함수를 정의한다. 하지만 depth가 깊어지므로 코드가 좋아보이진 않는다.
 */