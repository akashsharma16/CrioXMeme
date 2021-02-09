package com.akash.implementation.xMeme.repository;

import com.akash.implementation.xMeme.beans.XMeme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XmemeRepos extends JpaRepository<XMeme, Long> {

}
