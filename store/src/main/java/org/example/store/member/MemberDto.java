package org.example.store.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    @JsonProperty("user_id")
    private Long id;
    private String userId;
    private String pw;
    private String name;
    private String email;
    private String contact;

    public Member convertToEntity() {
        return new Member(id, userId, pw, name, email, contact);
    }
}
