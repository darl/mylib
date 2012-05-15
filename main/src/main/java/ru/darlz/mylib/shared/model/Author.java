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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (bornYear != author.bornYear) return false;
        if (id != author.id) return false;
        if (fullName != null ? !fullName.equals(author.fullName) : author.fullName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + bornYear;
        return result;
    }
}
