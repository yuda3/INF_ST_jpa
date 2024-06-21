package com.group.jpa.repository;

import com.group.jpa.eneity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
