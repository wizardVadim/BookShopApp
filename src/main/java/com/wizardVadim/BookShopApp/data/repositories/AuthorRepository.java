package com.wizardVadim.BookShopApp.data.repositories;

import com.wizardVadim.BookShopApp.data.struct.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
