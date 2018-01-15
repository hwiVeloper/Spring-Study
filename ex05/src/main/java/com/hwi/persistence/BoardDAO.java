package com.hwi.persistence;

import java.util.List;

import com.hwi.domain.BoardVO;
import com.hwi.domain.Criteria;
import com.hwi.domain.SearchCriteria;

public interface BoardDAO {
	public List<BoardVO> listAll() throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public void create(BoardVO vo) throws Exception;
		
	public void update(BoardVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<BoardVO> listPage(int page) throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;
	
	/* 검색 추가 */
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	
	public int listSearchCount(SearchCriteria cri) throws Exception;
	
	/* 파일 업로드 */
	public void addAttach(String fullName) throws Exception;
}
