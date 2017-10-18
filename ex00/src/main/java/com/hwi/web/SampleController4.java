package com.hwi.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController4 {
	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr) {
		logger.info("doE called but redirect to /doF..............");
		
		rttr.addFlashAttribute("msg", "This is the Message!! with redirected");
		
		return "redirect:/doF";
		// return "forward:/doF";
	}
	
	@RequestMapping("/doF")
	public String doF(@ModelAttribute("msg") String msg) {
		logger.info("doF called............." + msg);
		
		// 추가 - view로 넘기는 경우.
		return "result"; // 이전에 만들었던 result.jsp의 ${msg}로 전송
	}
}
