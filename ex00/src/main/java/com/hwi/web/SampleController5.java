package com.hwi.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwi.domain.ProductVO;

@Controller
public class SampleController5 {
	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {
		ProductVO vo = new ProductVO("Sample Product^_^", 3000);
		
		return vo;
	}
}
