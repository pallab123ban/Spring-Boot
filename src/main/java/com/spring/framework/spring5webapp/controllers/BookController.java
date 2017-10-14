package com.spring.framework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring.framework.spring5webapp.repositories.BookRepository;

/**
 * This is book controller class
 * 
 * @author Pallab Banerjee
 *
 */
@Controller
public class BookController {

  private BookRepository bookRepository;

  public BookController(BookRepository bookRepository) {
    super();
    this.bookRepository = bookRepository;
  }

  @RequestMapping("/books")
  public String getBooks(Model model) {
    model.addAttribute("books", bookRepository.findAll());
    return "books";
  }

}
