package com.project.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "id", updatable = false)
    private int id;

    @Column(name = "name")
    @NotBlank(message="სახელის ველი უნდა იყოს შევსებული")
    @NotNull(message = "სახელის ველი უნდა იყოს შევსებული")
    private String name;

    @Column(name = "author")
    @NotBlank(message="ავტორის ველი უნდა იყოს შევსებული")
    @NotNull(message = "ავტორის ველი უნდა იყოს შევსებული")
    private String author;

    @Column(name = "cover_url")
    private String coverUrl;

    @Column(name = "language")
    private String language;

    @Column(name = "genre")
    private String genre;

    @Column(name = "date")
    private String date;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "quantity")
    private int quantity;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                ", date='" + date + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
