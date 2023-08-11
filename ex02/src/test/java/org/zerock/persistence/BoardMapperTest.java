package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Test
	public void testGetList() {
		mapper.getList();
	}
	
	@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		
		board.setTitle("새작글");
		board.setContent("새작내");
		board.setWriter("newbie");
		mapper.insert(board);
		log.info(board);
	}
	
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		
		board.setTitle("새작글 selectKey");
		board.setContent("새작내 selectKey");
		board.setWriter("newbie2");
		mapper.insertSelectKey(board);
		log.info(board);
	}
	
	@Test
	public void testRead() {
		BoardVO board = mapper.read(21L);
		log.info(board);
	}	
	
	@Test
	public void testDelete() {
		int res = mapper.delete(21L);
		if(res==0) {
			log.info("Delete cnt : " + res);
		}
		else {
			log.info(res+"개 삭제됨");
		}
	}
	
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		//������ �����Ѵ� ��ȣ���� Ȯ��
		board.setBno(45L);
		board.setTitle("수제");
		board.setContent("수내");
		board.setWriter("user00");
		
		int cnt = mapper.update(board);
		log.info("Update Count : " + cnt);
	}

}
