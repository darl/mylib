package ru.darlz.mylib.shared.model;


import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.Date;

/**
 * User: Vladislav Dolbilov (darl@yandex-team.ru)
 * Date: 14.05.12 23:02
 */
@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author")
    private Author author;

    @Column(name = "name")
    private String name;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "publish_year")
    private int publishYear;

    @Column(name = "price")
    private long price;

    @Column(name = "amount")
    private long amount;

    @Column(name = "arrival_time")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date arrivalTime;

    @Column(name = "keywords")
    private String keywords;

    public Book(Author author, String publisher, int publishYear, long price, long amount, Date arrivalTime, String keywords) {
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.price = price;
        this.amount = amount;
        this.arrivalTime = arrivalTime;
        this.keywords = keywords;
    }

    public long getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public long getPrice() {
        return price;
    }

    public long getAmount() {
        return amount;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public String getKeywords() {
        return keywords;
    }

    public enum OrderField {
        NAME(Order.asc("name")),
        AUTHOR(Order.asc("author")),
        ;

        private final Order order;

        private OrderField(Order order) {
            this.order = order;
        }

        public Order getOrder() {
            return order;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (amount != book.amount) return false;
        if (id != book.id) return false;
        if (price != book.price) return false;
        if (publishYear != book.publishYear) return false;
        if (arrivalTime != null ? !arrivalTime.equals(book.arrivalTime) : book.arrivalTime != null) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (keywords != null ? !keywords.equals(book.keywords) : book.keywords != null) return false;
        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        if (publisher != null ? !publisher.equals(book.publisher) : book.publisher != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + publishYear;
        result = 31 * result + (int) (price ^ (price >>> 32));
        result = 31 * result + (int) (amount ^ (amount >>> 32));
        result = 31 * result + (arrivalTime != null ? arrivalTime.hashCode() : 0);
        result = 31 * result + (keywords != null ? keywords.hashCode() : 0);
        return result;
    }
}
