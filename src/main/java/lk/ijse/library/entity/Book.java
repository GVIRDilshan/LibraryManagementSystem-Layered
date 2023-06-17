package lk.ijse.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String id;
    private String name;
    private String author;
    private String publisher;
    private String supplier;
    private int qty;


}
