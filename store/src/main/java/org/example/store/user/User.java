package org.example.store.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private int id;

    private String username;

    private String password;

    private String email;

    private String phone;

    }
}
