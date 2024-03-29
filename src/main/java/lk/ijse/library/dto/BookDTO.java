package lk.ijse.library.dto;

public class BookDTO {

    private String id;
    private String name;
    private String author;
    private int qty;
    private String publisher;
    private String supplier;

    public BookDTO(String id, String name, String author, String publisher, String supplier, int qty) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.supplier = supplier;
        this.qty = qty;
    }

    public BookDTO() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
