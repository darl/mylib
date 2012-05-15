package ru.darlz.mylib.server;

import org.hibernate.criterion.Restrictions;
import ru.darlz.mylib.client.LibraryService;
import ru.darlz.mylib.shared.model.Author;
import ru.darlz.mylib.shared.model.Book;
import ru.darlz.mylib.util.Hu;

import java.util.Collections;
import java.util.List;

/**
 * User: Vladislav Dolbilov (darl@yandex-team.ru)
 * Date: 15.05.12 10:08
 */
public class LibraryServiceImpl implements LibraryService {


    @Override
    public void addAuthor(Author author) {
        Hu.addObject(author);
    }

    @Override
    public void addBook(Book book) {
        Hu.addObject(book);
    }

    @Override
    public void updateAuthor(Author author) {
        Hu.updateObject(author);
    }

    @Override
    public void updateBook(Book book) {
        Hu.updateObject(book);
    }

    @Override
    public Author getAuthor(long id) {
        return Hu.loadById(Author.class, id);
    }

    @Override
    public Book getBook(long id) {
        return Hu.loadById(Book.class, id);
    }

    @Override
    public List<Author> getAuthors() {
        return Hu.loadByCriteria(Author.class);
    }

    @Override
    public List<Book> getBooks() {
        return Hu.loadByCriteria(Book.class);
    }

    @Override
    public List<Book> getBooks(Book.OrderField orderField) {
        return Hu.loadByCriteria(Book.class, orderField.getOrder());
    }

    @Override
    public List<Book> getBooksForAuthor(Author author) {
        return Hu.loadByCriteria(Book.class, null, Restrictions.in("author", Collections.singletonList(author)));
    }

    @Override
    public List<Book> getBooksForAuthor(Author author, Book.OrderField orderField) {
        return Hu.loadByCriteria(Book.class, orderField.getOrder(), Restrictions.in("author", Collections.singletonList(author)));
    }
}
