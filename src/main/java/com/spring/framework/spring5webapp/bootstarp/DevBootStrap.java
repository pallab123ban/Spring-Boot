package com.spring.framework.spring5webapp.bootstarp;

/**
 * @author Pallab Banerjee
 */
import com.spring.framework.spring5webapp.model.Author;
import com.spring.framework.spring5webapp.model.Book;
import com.spring.framework.spring5webapp.model.Publisher;
import com.spring.framework.spring5webapp.repositories.AuthorRepository;
import com.spring.framework.spring5webapp.repositories.BookRepository;
import com.spring.framework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

  private AuthorRepository authorRepository;
  private BookRepository bookRepository;
  private PublisherRepository publisherRepository;



  public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository,
      PublisherRepository publisherRepository) {
    super();
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }

  private void initData() {
    // Eric
    Publisher publisher1 = new Publisher();
    publisher1.setName("O'Reilley");
    publisher1.setAddress("Austin");
    publisherRepository.save(publisher1);

    Author eric = new Author("Eric", "Evans");
    Book book1 = new Book("Advanced Java", "1234", publisher1);
    book1.getAuthors().add(eric);
    eric.getBooks().add(book1);

    authorRepository.save(eric);
    bookRepository.save(book1);


    // Reid
    Publisher publisher2 = new Publisher();
    publisher2.setName("Macgrath");
    publisher2.setAddress("Dallas");
    publisherRepository.save(publisher2);
    Author reid = new Author("Reid", "Thomas");
    Book book2 = new Book("PL-SQL Concepts", "6787", publisher2);
    book2.getAuthors().add(reid);
    reid.getBooks().add(book2);

    authorRepository.save(reid);
    bookRepository.save(book2);
  }
}
