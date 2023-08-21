package org.zerock.service;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.annotations.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTest {
	@Autowired
	private BoardService service;
	
	@Test
	public void testExist() {
		log.info(service);
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새작글");
		board.setContent("새작네");
		board.setWriter("newbie");
		
		service.register(board);
		
		log.info("생성된 게시물의 번호 : " + board.getBno());
	}
	

	@Test
	public void testGet() {
		log.info(service.get(41L));
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = service.get(41L);
		if(board==null) {
			return;
		}
		else {
			board.setTitle("제목수정할거임.");
			log.info("Modify res : "+service.modify(board));
		}
	}
	
	@Test
	public void testDelete() {
		log.info("Remove res : " + service.remove(41L));
	}
}
