package org.example.store.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String UserId;
    private String name;
    private String password;
    private String phone;
    private String email;
}
