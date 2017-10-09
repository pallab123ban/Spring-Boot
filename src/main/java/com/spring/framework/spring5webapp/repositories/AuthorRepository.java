package com.spring.framework.spring5webapp.repositories;

/**
 * @author Pallab Banerjee
 */
import com.spring.framework.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
