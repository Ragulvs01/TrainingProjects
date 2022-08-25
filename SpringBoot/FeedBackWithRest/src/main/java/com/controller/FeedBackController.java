package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.FeedBack;
import com.service.FeedBackService;

@RestController
public class FeedBackController {
@Autowired
FeedBackService feedBackService;
@RequestMapping(value="FeedBackDb",method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
public List<FeedBack> FeedBackDb(){
	return feedBackService.getAllFeedBackDetails();
}
@RequestMapping(value="storeFeedBack",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
public String storeFeedBack(@RequestBody FeedBack fb) {
	return feedBackService.storeFeedBack(fb);
}
}
