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
}
