package it.tostao.sswa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Index {

    private static final Logger LOG = LoggerFactory.getLogger(Index.class);

	public Index() {

    }
    
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public ModelAndView get(){
		LOG.info("Index#get() called");
		ModelAndView mav = new ModelAndView("index");
		Long l = Long.valueOf("1");
		if( null == l){
			LOG.error("We have a big problem!");
		}
		return mav;
	}
}
