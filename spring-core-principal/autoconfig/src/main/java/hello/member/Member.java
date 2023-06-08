package hello.member;


import lombok.Data;

/**
 * @author keede
 * Created on 2023-06-09
 */
@Data
public class Member {
    private String memberId;
    private String name;

    public Member() {
    }

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}
