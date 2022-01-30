package com.comet.serverapp.dto;

public class PhotoUrlDto {
    private String photoLink;

    public PhotoUrlDto(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }
}
