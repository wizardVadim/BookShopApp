package com.wizardVadim.BookShopApp.data.struct.book.file;

import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@Table(name = "book_file")
public class BookFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String hash;

    @Column(name = "type_id", columnDefinition = "INT NOT NULL")
    private int typeId;

    @Column(columnDefinition = "VARCHAR(255) NOT NULL")
    private String path;
}
