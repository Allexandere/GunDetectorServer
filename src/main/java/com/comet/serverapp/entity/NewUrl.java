package com.comet.serverapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "new_urls")
@Data
public class NewUrl {
    @Id
    @GeneratedValue
    private UUID id;
    @Column
    private String url;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creationDate;
    @Column
    private String key;

    public NewUrl(String url, String key) {
        this.url = url;
        this.key = key;
        this.creationDate = new Date();
    }

    public NewUrl() {
    }
}
