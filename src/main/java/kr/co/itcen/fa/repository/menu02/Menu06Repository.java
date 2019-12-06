package kr.co.itcen.fa.repository.menu02;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.fa.vo.menu02.CustomerVo;
import kr.co.itcen.fa.vo.menu02.PurchaseitemVo;
import kr.co.itcen.fa.vo.menu02.PurchasemanagementVo;
import kr.co.itcen.fa.vo.menu02.TestVo;

/**
 * 
 * @author 윤종진
 * 매입관리
 *
 */

@Repository
public class Menu06Repository {
	@Autowired
	private SqlSession sqlSession;
	
	public void test() {
		TestVo testVo = new TestVo();
		testVo.setName("zxcvb123"); // 이름
		
		sqlSession.insert("menu06.save", testVo);
	}

	public Boolean insert(PurchasemanagementVo vo) {
		int count = sqlSession.insert("menu06.insert", vo);
		return count == 1;
		
	}

	public List<PurchaseitemVo> getItemList() {
		List<PurchaseitemVo> result = sqlSession.selectList("menu06.getItemList");
		return result;
	}

	public List<CustomerVo> getCustomerList() {
		List<CustomerVo> result = sqlSession.selectList("menu06.getCustomerList");
		return result;
	}

	public PurchasemanagementVo getList(PurchasemanagementVo vo) {
		PurchasemanagementVo result = sqlSession.selectOne("menu06.getList",vo);
		return result;
	}

	public Boolean update(PurchasemanagementVo vo) {
		int count = sqlSession.insert("menu06.update", vo);
		return count == 1;
	}

	public Boolean delete(PurchasemanagementVo vo) {
		int count = sqlSession.insert("menu06.delete", vo);
		return count == 1;
	}
}
