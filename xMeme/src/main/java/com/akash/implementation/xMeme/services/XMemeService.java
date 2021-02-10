package com.akash.implementation.xMeme.services;

import com.akash.implementation.xMeme.beans.XMeme;
import com.akash.implementation.xMeme.repository.XmemeRepo;
import com.akash.implementation.xMeme.request.XMemeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("xMemeService")
public class XMemeService {

    @Autowired
    private XmemeRepo xmemeRepo;

    public String postMeme(XMemeData xMemeData){
        XMeme xMeme = new XMeme();
        xMeme.setName(xMemeData.getName());
        xMeme.setCaption(xMemeData.getCaption());
        xMeme.setUrl(xMemeData.getUrl());
        xmemeRepo.save(xMeme);
        return xMeme.getId().toString();
    }

    public List<XMeme> getLatest100Meme(){
        List<XMeme> xMemeList;
        xMemeList = xmemeRepo.findTop100ByOrderByTimestampDesc();
        if(xMemeList == null || xMemeList.isEmpty() ){
            xMemeList = new ArrayList<>();
        }
        return xMemeList;
    }

    public void updateMeme(XMemeData xMemeData){

    }
}
