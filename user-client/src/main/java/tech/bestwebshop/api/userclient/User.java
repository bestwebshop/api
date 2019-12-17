package tech.bestwebshop.api.userclient;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
public class User {

    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private Role role;
}

