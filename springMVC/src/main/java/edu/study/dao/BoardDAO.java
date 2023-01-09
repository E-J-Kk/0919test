package edu.study.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.study.vo.BoardVO;


@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public List<BoardVO> list(){
		
		return sqlSession.selectList("edu.study.mapper.boardMapper.list");
	}
	
	public BoardVO selectByBidx(int bidx) {
		return sqlSession.selectOne("edu.study.mapper.boardMapper.selectByBidx", bidx);
	}
	
	public int updateByBidx(BoardVO vo) {
		return sqlSession.update("edu.study.mapper.boardMapper.updateByBidx", vo);
	}
	
	public int deleteByBidx(int bidx) {
		return sqlSession.delete("edu.study.mapper.boardMapper.deleteByBidx", bidx);
	}
	
	public int deleteFromReply(int bidx) {
		return sqlSession.delete("edu.study.mapper.boardMapper.deleteFromReply", bidx);
	}
}













