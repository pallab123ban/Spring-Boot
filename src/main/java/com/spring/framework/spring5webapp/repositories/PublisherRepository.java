package com.spring.framework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.spring.framework.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
