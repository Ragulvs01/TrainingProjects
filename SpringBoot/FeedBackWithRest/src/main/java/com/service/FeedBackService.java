package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.FeedBack;
import com.dao.FeedBackDao;

@Service
public class FeedBackService {
@Autowired
FeedBackDao feedBackDao;
public List<FeedBack> getAllFeedBackDetails(){
	 return feedBackDao.getAllFeedBack();
}
public String storeFeedBack(FeedBack fb) {
	 if(feedBackDao.storeFeedBack(fb)>0) {
		 return" Feedback is stored in the database";
	 }else {
		 return"FeedBack Not Stored ";
	 }
}
}
