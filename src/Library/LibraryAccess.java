package Library;

import java.util.List;

public interface LibraryAccess {
    public List<Book> ListBook();

    public boolean verifikasiID(Book book);
}
