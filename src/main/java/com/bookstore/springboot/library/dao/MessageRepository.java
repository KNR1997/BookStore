package com.bookstore.springboot.library.dao;

import com.bookstore.springboot.library.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}
