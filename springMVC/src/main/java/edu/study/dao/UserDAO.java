package edu.study.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.study.vo.UserVO;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public UserVO login(UserVO vo) {
		return sqlSession.selectOne("edu.study.mapper.userMapper.login", vo);
	}
}
