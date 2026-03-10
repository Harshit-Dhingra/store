package com.bookStore08.bookStore08.Repository;

import com.bookStore08.bookStore08.Entity.MyBookList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList, Integer> {
}
