package com.akash.implementation.xMeme.repository;

import com.akash.implementation.xMeme.beans.XMeme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface XmemeRepo extends JpaRepository<XMeme, Long> {

    List<XMeme> findByNameAndCaptionAndUrl(String name, String caption, String url);

    List<XMeme> findTop100ByOrderByTimestampDesc();
}
