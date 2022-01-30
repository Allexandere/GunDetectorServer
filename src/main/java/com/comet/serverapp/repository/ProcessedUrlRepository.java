package com.comet.serverapp.repository;

import com.comet.serverapp.entity.ProcessedUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProcessedUrlRepository extends JpaRepository<ProcessedUrl, UUID> {
}
