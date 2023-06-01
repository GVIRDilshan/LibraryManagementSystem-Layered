package lk.ijse.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String userName;
    private String password;

    public User() {

    }
}
