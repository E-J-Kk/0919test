package edu.study.service;

import java.util.List;

import edu.study.vo.BoardVO;

public interface BoardService {

	List<BoardVO> list();
	BoardVO selectByBidx(int bidx);
	int updateByBidx(BoardVO vo);
	int deleteByBidx(int bidx);
}
