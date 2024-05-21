package org.example.store.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    @JsonProperty("user_id")
    private String userId;

    private String pw;

    private String name;

    @Email
    private String email;

    private String contact;

    Member(String userId, String pw, String name, String email, String contact) {
        this.userId = userId;
        this.pw = pw;
        this.name = name;
        this.email = email;
        this.contact = contact;
    }
    public static Member fromDtoToEntity(MemberDto memberDto) {
        return new Member(
            memberDto.getUserId(),
            memberDto.getPw(),
            memberDto.getName(),
            memberDto.getEmail(),
            memberDto.getContact()
        );
    }
}

