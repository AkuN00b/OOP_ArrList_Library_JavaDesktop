package Library;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MyLibraryApp {
    private int choice;
    Scanner scan = new Scanner(System.in);
    Scanner anw = new Scanner(System.in);
    DataLibrary data = new DataLibrary();

    // method to show menu
    public int getMenus() {
        System.out.println("\n=========================");
        System.out.println("== LIBRARY APPLICATION ==");
        System.out.println("=========================");
        System.out.println("1. Menambahkan buku");
        System.out.println("2. Menampilkan buku");
        System.out.println("3. Meminjam buku");
        System.out.println("4. Mengembalikan buku");
        System.out.println("5. Menghapus buku");
        System.out.println("6. Keluar");
        System.out.print("\nPilihan: ");

        this.choice = scan.nextInt();
        return this.choice;
    }

    // method to get the choice menu
    public int getChoice(int choice) {
        switch (choice) {
            case 1: firstMenu(); break;
            case 2: secondMenu(); break;
            case 3: thirdMenu(); break;
            case 4: fourthMenu(); break;
            case 5: fifthMenu(); break;
            case 6: sixthMenu(); break;
            default: System.out.println("Pilihan Anda Salah!\t:"); break;
        }
        return choice;
    }

    // method to add a new book
    private void firstMenu() {
        System.out.print("\nBook ID: ");
        String id = anw.next();
        anw.nextLine();

        Book book = new Book(id);
        book.setId(id);

        System.out.print("Title: ");
        String title = anw.nextLine();

        System.out.print("Author: ");
        String author = anw.next();
        anw.nextLine();

        System.out.print("Quantity: ");
        int qty = anw.nextInt();

        data.insertBook(id, title, author, qty);
        System.out.println("\nMenambahkan Buku Berhasil");
        System.out.println("");

        getChoice(getMenus());
    }

    // method to show list book
    private void secondMenu() {
        List listBook = new ArrayList();
        listBook = data.getAll();

        if (listBook.size() == 0) {
            System.out.println("\nBook is Empty");
            getChoice(getMenus());
        } else {
            System.out.println("\nNo\t\tID Book\t\tTitle\t\t\t\t\t\tAuthor\t\tQty");
            System.out.println("======================================================" +
                    "======================");

            for (int i = 0; i < listBook.size(); i++) {
                Book a = (Book) listBook.get(i);
                System.out.println(i+1+"\t\t"+a.getId()+"\t\t"+a.getTitle()+"\t\t\t"+a.getAuthor()+"\t\t"+a.getQty());
            }

            System.out.println("======================================================" +
                    "======================");

            getChoice(getMenus());
        }
    }

    private void thirdMenu() {
        List listBook = new ArrayList();
        listBook = data.getAll();

        System.out.println("\nNo\t\tID Book\t\tTitle\t\t\t\t\t\tAuthor\t\tQty");
        System.out.println("======================================================" +
                "======================");

        for (int i = 0; i < listBook.size(); i++) {
            Book a = (Book) listBook.get(i);
            System.out.println(i+1+"\t\t"+a.getId()+"\t\t"+a.getTitle()+"\t\t\t"+a.getAuthor()+"\t\t"+a.getQty());
        }

        System.out.println("======================================================" +
                "======================");

        System.out.print("\nBook ID want to borrow: ");
        String id = anw.next();
        anw.nextLine();

        Book book = new Book(id);
        book.setId(id);

        System.out.print("Qty: ");
        int qty = anw.nextInt();

        boolean borrow;
        borrow = data.borrow(book.getId(), qty);

        if (borrow) {
            System.out.println("\nPeminjaman Buku dengan ID " + id + " Berhasil");

            // get tanggal hari ini
            LocalDate dateLocal = LocalDate.now();
            // mengatur format tanggal
            DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            // menyimpan tanggal hari ini dengan format tanggal yang sudah ada ke var
            String formattedDate = dateLocal.format(formatDate);

            LocalDate shipDurate = LocalDate.now().plusDays(5);
            String formattedShipDate = shipDurate.format(formatDate);

            System.out.println("Tanggal Peminjaman Buku " + formattedDate);
            System.out.println("Tanggal Pengembalian Buku " + formattedShipDate);

            System.out.println("\nNo\t\tID Book\t\tTitle\t\t\t\t\t\tAuthor\t\tQty");
            System.out.println("======================================================" +
                    "======================");

            for (int i = 0; i < listBook.size(); i++) {
                Book a = (Book) listBook.get(i);
                System.out.println(i+1+"\t\t"+a.getId()+"\t\t"+a.getTitle()+"\t\t\t"+a.getAuthor()+"\t\t"+a.getQty());
            }

            System.out.println("======================================================" +
                    "======================");

            System.out.println("\nBook successfully borrowed");
            getChoice(getMenus());
        } else {
            System.out.println("\nBook unsuccessfully borrowed");
            getChoice(getMenus());
        }
    }

    private void fourthMenu() {
        List listBook = new ArrayList();
        listBook = data.getAll();

        System.out.println("\nNo\t\tID Book\t\tTitle\t\t\t\t\t\tAuthor\t\tQty");
        System.out.println("======================================================" +
                "======================");

        for (int i = 0; i < listBook.size(); i++) {
            Book a = (Book) listBook.get(i);
            System.out.println(i+1+"\t\t"+a.getId()+"\t\t"+a.getTitle()+"\t\t\t"+a.getAuthor()+"\t\t"+a.getQty());
        }

        System.out.println("======================================================" +
                "======================");

        System.out.print("\nBook ID want to return: ");
        String id = anw.next();
        anw.nextLine();

        Book book = new Book(id);
        book.setId(id);

        System.out.print("Qty: ");
        int qty = anw.nextInt();

        // get tanggal hari ini
        LocalDate dateLocal = LocalDate.now();
        // mengatur format tanggal
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // menyimpan tanggal hari ini dengan format tanggal yang sudah ada ke var
        String formattedDate = dateLocal.format(formatDate);

        System.out.println("\nTanggal Pengembalian Buku " + formattedDate);

        boolean qtyReturn;
        qtyReturn = data.returnBook(id, qty);

        if (qtyReturn) {
            System.out.println("\nNo\t\tID Book\t\tTitle\t\t\t\t\t\tAuthor\t\tQty");
            System.out.println("======================================================" +
                    "======================");

            for (int i = 0; i < listBook.size(); i++) {
                Book a = (Book) listBook.get(i);
                System.out.println(i+1+"\t\t"+a.getId()+"\t\t"+a.getTitle()+"\t\t\t"+a.getAuthor()+"\t\t"+a.getQty());
            }

            System.out.println("======================================================" +
                    "======================");

            System.out.println("\nBook successfully returned");
            getChoice(getMenus());
        } else {
            getChoice(getMenus());
        }
    }

    private void fifthMenu() {
        System.out.print("\nBook ID want to delete: ");
        String id = anw.next();
        anw.nextLine();

        Book book = new Book(id);
        book.setId(id);

        boolean delete;
        delete = data.delete(book.getId());
        if (delete) {
            System.out.println("\nBook successfully delete");
            getChoice(getMenus());
        } else {
            System.out.println("\nBook unsuccessfully delete");
            getChoice(getMenus());
        }
    }

    private void sixthMenu() {
        System.out.println("\nThanks for using Library Application!");
    }

    public static void main(String[] args) {
        MyLibraryApp app = new MyLibraryApp();
        app.getChoice(app.getMenus());
    }
}
