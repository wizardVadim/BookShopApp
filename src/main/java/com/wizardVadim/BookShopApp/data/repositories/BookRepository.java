package com.wizardVadim.BookShopApp.data.repositories;

import com.wizardVadim.BookShopApp.data.struct.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "SELECT * FROM books JOIN book2author ON books.id = book2author.book_id JOIN authors ON book2author.author_id = authors.id WHERE authors.id = ?1", nativeQuery = true)
    List<Book> findBooksByAuthorId(Integer id);
}
