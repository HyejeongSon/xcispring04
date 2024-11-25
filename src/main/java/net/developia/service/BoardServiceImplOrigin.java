package net.developia.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.developia.domain.BoardVO;
import net.developia.mapper.BoardMapper;

@Log4j
//@Service
//@AllArgsConstructor
public class BoardServiceImplOrigin{
	
	private BoardMapper mapper;

	public void register(BoardVO board) throws Exception {
		try {
			log.info("register......." + board);
			mapper.insertSelectKey(board);
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
		
	}

	public BoardVO get(Long bno) throws Exception {
		try {
			log.info("get....." + bno);
			BoardVO board = mapper.read(bno);
			if (board == null) throw new RuntimeException(bno + "게시물이 없음");
			return board;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	public boolean modify(BoardVO board) throws Exception {
		try {
			log.info("modify......" + board);
			
			if (mapper.update(board) == 0) 
				throw new RuntimeException(board.getBno() + "번 게시물이 수정되지 않음");
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	public boolean remove(Long bno) throws Exception {
		try {
			log.info("remove......" + bno);
			
			if (mapper.delete(bno) == 0) 
				throw new RuntimeException(bno + "번 게시물이 삭제되지 않음");
			return true;
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

	public List<BoardVO> getList() throws Exception {
		try {
			return mapper.getList();
		} catch (Exception e) {
			log.error(e.getMessage());
			throw e;
		}
	}

}
