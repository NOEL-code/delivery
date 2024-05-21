package org.example.store.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {
    @Id
    private Long id;
    private String userId;
    private String pw;
    private String name;
    private String email;
    private String contact;


    public static Member fromDtoToEntity(MemberDto memberDto) {
        return new Member(
            memberDto.getId(),
            memberDto.getUserId(),
            memberDto.getPw(),
            memberDto.getName(),
            memberDto.getEmail(),
            memberDto.getContact()
        );
    }
}

