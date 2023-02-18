package com.wizardVadim.BookShopApp.data.repositories;

import com.wizardVadim.BookShopApp.data.struct.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("from Book WHERE author.id = ?1")
    List<Book> findByAuthorId(Integer id);
}
