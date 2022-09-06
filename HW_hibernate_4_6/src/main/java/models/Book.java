package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private long author_id;

    public Book() {
    }

    public Book(long id, String name, long author_id) {
        this.id = id;
        this.name = name;
        this.author_id = author_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author_id=" + author_id +
                '}';
    }
}
