package com.comet.serverapp.repository;

import com.comet.serverapp.entity.NewUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NewUrlRepository extends JpaRepository<NewUrl, UUID> {
    NewUrl findFirstByOrderByCreationDate();
}
