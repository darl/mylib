package ru.darlz.mylib.shared.model;

import javax.persistence.*;

/**
 * User: Vladislav Dolbilov (darl@yandex-team.ru)
 * Date: 14.05.12 23:03
 */
@Entity
@Table
public class Author {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "born_year")
    private int bornYear;

    public Author(String fullName, int bornYear) {
        this.fullName = fullName;
        this.bornYear = bornYear;
    }

    public long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getBornYear() {
        return bornYear;
    }
}
