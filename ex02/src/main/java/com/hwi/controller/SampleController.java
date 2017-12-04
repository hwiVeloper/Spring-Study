package com.hwi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwi.domain.SampleVO;

@RestController
@RequestMapping("/sample")
public class SampleController {
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}
	
	/* JSON으로 객체를 반환 */
	@RequestMapping("/sendVO")
	public SampleVO sendVO() {
		SampleVO vo = new SampleVO();
		vo.setFirstName("종휘");
		vo.setLastName("이");
		vo.setMno(1220);
		
		return vo;
	}
	
	/* 컬렉션 타입의 객체를 반환하는 경우 */
	@RequestMapping("/sendList")
	public List<SampleVO> sendList() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("종휘");
			vo.setLastName("이");
			vo.setMno(i);
			list.add(vo);
		}
		
		return list;
	}
	
	@RequestMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap() {
		Map<Integer, SampleVO> map = new HashMap<Integer, SampleVO>();
		
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("종휘");
			vo.setLastName("이");
			vo.setMno(i);
			map.put(i, vo);
		}
		
		return map;
	}
	
	/* 400 */
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth() {
		return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
	}
	
	/* 404 */
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot() {
		List<SampleVO> list = new ArrayList<SampleVO>();
		
		for(int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("종휘");
			vo.setLastName("이");
			vo.setMno(i);
			list.add(vo);
		}
		
		return new ResponseEntity<List<SampleVO>>(list, HttpStatus.NOT_FOUND); 
	}
}
