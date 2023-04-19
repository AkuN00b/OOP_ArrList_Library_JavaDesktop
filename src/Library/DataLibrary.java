package Library;

import java.util.*;

public class DataLibrary implements LibraryAccess {
    // private instance variables
    ArrayList<Book> listbook = new ArrayList<Book>();

    // return the listbook value
    public List getAll() {
        return listbook;
    }

    // method for add the book into the list
    public void insertBook(String id, String title, String author, int qty) {
        Book book = new Book(id, title, author, qty);
        listbook.add(book);
    }

    @Override
    public List<Book> ListBook() {
        if(listbook.size() == 0) {
            System.out.println("Book is Empty");
        }

        return listbook;
    }

    public boolean verifikasiID(Book book) {
        for (Book book1 : listbook) {
            if (book1.getId().equals(book.getId())) {
                return true;
            }
            if (!book1.getId().equals(book.getId())) {
                return false;
            }
            if (listbook.isEmpty()) {
                System.out.println("Book is Empty");
            }
        }

        return false;
    }

    public boolean delete (String id) {
        for (Book book : listbook) {
            if (book.getId().equals(id)) {
                listbook.remove(book);
                return true;
            }
        }

        return false;
    }

    public boolean borrow (String id, int qty) {
        for (Book book : listbook) {
            if (book.getId().equals(id)) {
                book.qtyBorrow(qty);
                return true;
            }
        }

        return false;
    }

    public boolean returnBook (String id, int qty) {
        for (Book book : listbook) {
            if (book.getId().equals(id)) {
                book.qtyReturn(qty);
                return true;
            }
        }

        return false;
    }
}
