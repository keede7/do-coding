package io.keede.kotlinstarter.enums;

/**
 * <pre>
 * 패키지명: io.keede.kotlinstarter.enums
 * 상세설명:
 * </pre>
 *
 * @date: 2025-03-27
 * @author: P0005337 김윤환
 */
public enum JavaCountry {

    KOREA("KO"),
    AMERICA("US")
    ;

    private final String code;

    JavaCountry(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    // 코드가 많아지면 조건문 처리가 애매해진다
    private static final void handleCountry(JavaCountry javaCountry) {
        if(javaCountry == JavaCountry.KOREA) {

        }

        if (javaCountry == JavaCountry.AMERICA) {

        }
    }
}
