package com.hwi.persistence;

import java.util.List;

import com.hwi.domain.BoardVO;

public interface BoardDAO {
	public List<BoardVO> listAll() throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void create(BoardVO vo) throws Exception;
		
	public void update(BoardVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
}
