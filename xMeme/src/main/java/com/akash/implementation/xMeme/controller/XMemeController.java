package com.akash.implementation.xMeme.controller;

import com.akash.implementation.xMeme.beans.XMeme;
import com.akash.implementation.xMeme.repository.XmemeRepos;
import com.akash.implementation.xMeme.services.XMemeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class XMemeController {

    @Autowired
    private XMemeService xMemeService;
    @Autowired
    private XmemeRepos xmemeRepos;

    Logger logger = LogManager.getLogger(this.getClass());

    @PostMapping("/memes")
    public ResponseEntity<Object> postMeme(@RequestBody XMeme xMeme, HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException {
        logger.trace("Get KhataBook List controller called");
        xmemeRepos.save(xMeme);
        return new ResponseEntity<>("1", HttpStatus.OK);
    }

    @GetMapping("/memes")
    public ResponseEntity<Object> getMemeList() throws JsonProcessingException {
        List<XMeme> xMemeList = xmemeRepos.findAll();
        return new ResponseEntity<>(xMemeList,HttpStatus.OK);
    }
}
