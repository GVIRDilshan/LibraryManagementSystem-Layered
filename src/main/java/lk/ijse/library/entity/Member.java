package lk.ijse.library.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Member {
    private String id;
    private String name;
    private String address;
    private String Contact;
    private int age;
    private String Email;
    private String Gender;

    public Member(String id, String name, String address, int age, String contact, String email, String gender) {
    }
}
