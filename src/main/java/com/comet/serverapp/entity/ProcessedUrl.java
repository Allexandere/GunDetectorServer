package com.comet.serverapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "processed_urls")
@Data
public class ProcessedUrl {
    @Id
    private UUID key;
    @Column(name = "json_result", length = 1048576)
    private String jsonResult;

    public ProcessedUrl(UUID key, String jsonResult) {
        this.key = key;
        this.jsonResult = jsonResult;
    }

    public ProcessedUrl() {
    }
}
