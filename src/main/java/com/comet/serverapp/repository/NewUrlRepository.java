package com.comet.serverapp.repository;

import com.comet.serverapp.entity.NewUrl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public interface NewUrlRepository extends CrudRepository<NewUrl, UUID> {
    NewUrl findTopByCreationDate(Date creationDate);
}
