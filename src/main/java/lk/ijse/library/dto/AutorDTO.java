package lk.ijse.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AutorDTO {

    private String AutorID;
    private String AutorName;
    private String BookName;
    private String BookID;

    /*public AutorDTO(String autorID, String autorName, String bookName, String bookID) {
        AutorID = autorID;
        AutorName = autorName;
        BookName = bookName;
        BookID = bookID;
    }

    public AutorDTO() {

    }

    public AutorDTO(String s, String name, String address) {
    }

    public String getAutorID() {
        return AutorID;
    }

    public void setAutorID(String autorID) {
        AutorID = autorID;
    }

    public String getAutorName() {
        return AutorName;
    }

    public void setAutorName(String autorName) {
        AutorName = autorName;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(String bookID) {
        BookID = bookID;
    }*/
}
