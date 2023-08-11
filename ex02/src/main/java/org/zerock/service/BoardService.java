package org.zerock.service;

import org.zerock.domain.BoardVO;
import java.util.*;
public interface BoardService {
	public void register(BoardVO board);
	public BoardVO get(Long bno);
	public boolean modify(BoardVO board);
	public boolean remove(Long bno);
	public List<BoardVO> getList();
}
