package com.spring.framework.spring5webapp.bootstarp;

import com.spring.framework.spring5webapp.model.Author;
import com.spring.framework.spring5webapp.model.Book;
import com.spring.framework.spring5webapp.repositories.AuthorRepository;
import com.spring.framework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Book book1 = new Book("Advanced Java","1234","O'Reilley");
        book1.getAuthors().add(eric);
        eric.getBooks().add(book1);

        authorRepository.save(eric);
        bookRepository.save(book1);

        //Reid
        Author reid = new Author("Reid", "Thomas");
        Book book2 = new Book("PL-SQL Concepts","6787","Macgrath");
        book2.getAuthors().add(reid);
        reid.getBooks().add(book2);

        authorRepository.save(reid);
        bookRepository.save(book2);
    }
}
