package tech.bestwebshop.api.userclient;

import lombok.Data;
import lombok.NonNull;

@Data
public class Role {

    private int id;
    private String typ;
    private int level;
}
