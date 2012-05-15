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
}
