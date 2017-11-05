package com.hwi.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hwi.domain.BoardVO;
import com.hwi.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
		logger.info("register get.................");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registPOST(BoardVO board, Model model) throws Exception {
		logger.info("regist post..................");
		logger.info(board.toString());
		
		service.regist(board);;
		
		model.addAttribute("result", "success");
		
//		rttr.addFlashAttribute("msg", "SUCCESS");

//		return "/board/success";
		return "redirect:/board/listAll"; // success 이후 redirect
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		logger.info("show all list.......................");
		
		// BoardService와의 연결 작업
		model.addAttribute("list", service.listAll()); // model을 이용하여 jsp로 전달
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) throws Exception{
		// @RequestParam은 문자열, 숫자, 날짜 등 형 변환이 가능하다.
		model.addAttribute(service.read(bno));
	}
}
