package ru.darlz.mylib.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import ru.darlz.mylib.shared.model.Author;
import ru.darlz.mylib.shared.model.Book;

import java.util.List;

/**
 * User: Vladislav Dolbilov (darl@yandex-team.ru)
 * Date: 15.05.12 10:09
 */
@RemoteServiceRelativePath("library")
public interface LibraryService extends RemoteService {

    void addAuthor(Author author);

    void addBook(Book book);

    void updateAuthor(Author author);

    void updateBook(Book book);

    Author getAuthor(long id);

    Book getBook(long id);

    List<Author> getAuthors();

    List<Book> getBooks();

    List<Book> getBooks(Book.OrderField orderField);

    List<Book> getBooksForAuthor(Author author);

    List<Book> getBooksForAuthor(Author author, Book.OrderField orderField);

}
