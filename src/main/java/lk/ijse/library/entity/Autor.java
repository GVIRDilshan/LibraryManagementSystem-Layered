package lk.ijse.library.entity;

public class Autor {
    private String AutorID;
    private String AutorName;
    private String BookName;
    private String BookID;

    public Autor(String autorName, String bookName, String bookID, String autorID) {
    }

    public Autor() {

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
    }
}
