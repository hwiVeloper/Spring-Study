package com.hwi.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hwi.domain.BoardVO;
import com.hwi.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOTest {
	@Inject
	private BoardDAO dao;
	
//	private Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void testRead() throws Exception {
		dao.read(1);
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO board = new BoardVO();
		board.setBno(1);
		board.setTitle("updated title");
		board.setContent("updated content");
		dao.update(board);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(1);
	}
}
