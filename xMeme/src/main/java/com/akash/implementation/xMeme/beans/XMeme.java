package com.akash.implementation.xMeme.beans;

import javax.persistence.*;

@Entity
@Table(name = "xmeme")
public class XMeme {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "caption")
    String caption;

    @Column(name = "memeUrl")
    String memeUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getMemeUrl() {
        return memeUrl;
    }

    public void setMemeUrl(String memeUrl) {
        this.memeUrl = memeUrl;
    }
}
