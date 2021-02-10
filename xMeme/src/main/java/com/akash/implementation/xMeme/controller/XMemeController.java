package com.akash.implementation.xMeme.controller;

import com.akash.implementation.xMeme.beans.XMeme;
import com.akash.implementation.xMeme.repository.XmemeRepo;
import com.akash.implementation.xMeme.request.XMemeData;
import com.akash.implementation.xMeme.response.ErrorMessage;
import com.akash.implementation.xMeme.response.Response;
import com.akash.implementation.xMeme.services.XMemeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
public class XMemeController {

    @Autowired
    private XMemeService xMemeService;
    @Autowired
    private XmemeRepo xmemeRepo;

    Logger logger = LogManager.getLogger(this.getClass());

    @PostMapping("/memes")
    public ResponseEntity<Object> postMeme(@RequestBody XMemeData xMemeData, HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException {
        if(xMemeData.getName() == null || xMemeData.getName().isEmpty()){
            ErrorMessage message = new ErrorMessage();
            message.setMessage("Name of Meme Maker is Required");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        if(xMemeData.getCaption() == null || xMemeData.getCaption().isEmpty()){
            ErrorMessage message = new ErrorMessage();
            message.setMessage("Meme Caption is Required");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        if(xMemeData.getUrl() == null || xMemeData.getUrl().isEmpty()){
            ErrorMessage message = new ErrorMessage();
            message.setMessage("Meme URL is Required");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
        Response response = new Response();
        response.setId(xMemeService.postMeme(xMemeData));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/memes")
    public ResponseEntity<Object> getMemeList() throws JsonProcessingException {
        List<XMeme> xMemeList = xmemeRepo.findTop100ByOrderByTimestampDesc();
        return new ResponseEntity<>(xMemeList,HttpStatus.OK);
    }

    @GetMapping("memes/{id}")
    public ResponseEntity<Object> getMemeById(@PathVariable(name = "id", required = false) Long memeId) {
        Optional<XMeme> xMeme = xmemeRepo.findById(memeId);
        if(xMeme.isPresent()){
            return new ResponseEntity<>(xMeme.get(), HttpStatus.OK);
        }
        else{
            ErrorMessage message = new ErrorMessage();
            message.setMessage("Meme Id is not valid");
            return new ResponseEntity<>(message,HttpStatus.NOT_FOUND);
        }
    }
}
