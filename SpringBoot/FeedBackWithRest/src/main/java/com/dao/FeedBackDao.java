package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.FeedBack;


@Repository
public class FeedBackDao {
 @Autowired
 EntityManagerFactory emf;
 public List<FeedBack> getAllFeedBack(){
	   EntityManager manager=emf.createEntityManager();
	   Query qry= manager.createQuery("select p from feedback p");
	   List<FeedBack> listOfFeedBack= qry.getResultList();
	   return listOfFeedBack;
 }
 public int storeFeedBack(FeedBack fb) {
	   try {
		   EntityManager manager= emf.createEntityManager();
		   EntityTransaction tran= manager.getTransaction();
		   tran.begin();
		   manager.persist(fb);
		   tran.commit();
		   return 1;
	   }catch(Exception e) {
		   System.out.println(e);
		   return 0;
	   }
 }
 
}
