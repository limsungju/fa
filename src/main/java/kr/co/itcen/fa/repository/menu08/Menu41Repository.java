package kr.co.itcen.fa.repository.menu08;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.fa.vo.menu08.TestVo;


/**
 * 
 *  @author 권영미
 *  차량관리
 */
@Repository
public class Menu41Repository {

	@Autowired
	private SqlSession sqlSession;

	public void test() {
		TestVo testVo = new TestVo();
		testVo.setName("권영미관리");
		sqlSession.insert("menu41.save", testVo);
	}
}
