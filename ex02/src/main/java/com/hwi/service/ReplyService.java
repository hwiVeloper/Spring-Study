package com.hwi.service;

import java.util.List;

import com.hwi.domain.ReplyVO;

public interface ReplyService {
	public void addReply(ReplyVO vo) throws Exception;
	
	public List<ReplyVO> listReply(Integer bno) throws Exception;
	
	public void modifyReply(ReplyVO vo) throws Exception;
	
	public void removeReply(Integer rno) throws Exception;
}
