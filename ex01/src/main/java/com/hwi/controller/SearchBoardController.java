package com.hwi.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hwi.domain.PageMaker;
import com.hwi.domain.SearchCriteria;
import com.hwi.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception {
		logger.info(cri.toString()); // input된 parameter를 String으로 표현
		
		model.addAttribute("list", service.listCriteria(cri));
		
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		
		pm.setTotalCount(service.listCountCriteria(cri));
		
		model.addAttribute("pm", pm);
	}
}
