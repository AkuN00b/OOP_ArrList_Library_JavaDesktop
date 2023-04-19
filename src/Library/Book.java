package Library;

public class Book {
    // private instance variables
    private String id;
    private String title;
    private String author;
    private int qty;

    // constructor for the class
    public Book(String id, String title, String author, int qty) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.qty = qty;
    }

    public Book(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    // a public method to retrieve title
    public String getTitle() {
        return title;
    }

    // a public method to retrieve author
    public String getAuthor() {
        return author;
    }

    // a public method to retrieve quantity
    public int getQty() {
        return qty;
    }

    public void qtyBorrow(int qty) {
        this.qty -= qty;
    }

    public void qtyReturn(int qty) {
        this.qty += qty;
    }
}
