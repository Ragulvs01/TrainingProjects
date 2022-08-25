package com.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    
	@RequestMapping(value="say",method=RequestMethod.GET)
	public String sayHello() {
		return"Welcome to rest";
	}
	@RequestMapping(value="html",method=RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String sayHTML() {
		return"<h2>Welcome to rest<h2>";
	}
	@RequestMapping(value="plain",method=RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String sayPlainText() {
		return"<h2>Welcome to rest<h2>";
	}
	@RequestMapping(value="xml",method=RequestMethod.GET, produces = MediaType.TEXT_XML_VALUE)
	public String sayXml() {
		return"<h2>Welcome to rest</h2>";
	}
}
