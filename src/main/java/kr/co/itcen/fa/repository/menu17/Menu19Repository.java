package kr.co.itcen.fa.repository.menu17;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.fa.vo.menu17.ClosingDateVo;
import kr.co.itcen.fa.vo.menu17.Menu17SearchForm;
import kr.co.itcen.fa.vo.menu17.TestVo;

/**
 * 
 * @author 김재원
 * 마감일자관리
 */

@Repository
public class Menu19Repository {
	
	@Autowired
	private SqlSession sqlSession;

	public void test() {
		TestVo testVo = new TestVo();
		testVo.setName("김재원");
		sqlSession.insert("menu19.save",testVo);
	}

	
	/**
	 * 
	 * 마감일 등록
	 */
	public int insertClosingDate(ClosingDateVo closingDate) {
		return sqlSession.insert("menu19.insertClosingDate", closingDate);
	}
	
	
	/**
	 * 
	 * 마감일 단일 조회 
	 */
	public ClosingDateVo selectClosingDateByNo(Menu17SearchForm menu17SearchForm) {
		return sqlSession.selectOne("menu19.selectClosingDateByNo", menu17SearchForm);
	}
	
	/**
	 * 
	 * 마감년월을 이용한 마감일 단일 조회 
	 */
	public ClosingDateVo selectClosingDateByYearMonth(Date businessDate) {
		return sqlSession.selectOne("menu19.selectClosingDateByYearMonth", businessDate);
	}
	
	/**
	 * 
	 * 마감일 전체 갯수 조회
	 */
	public int selectAllClosingDateCount() {
		return sqlSession.selectOne("menu19.selectAllClosingDateCount");
	}
	
	
	/**
	 * 
	 * 마감일 중복검사 (1이상 == 중복됨) 
	 */
	public int selectCountByYearMonth(ClosingDateVo closingDateVo) {
		return sqlSession.selectOne("menu19.selectCountByYearMonth", closingDateVo);
	}
	
	/**
	 * 
	 * 마감일 전체 조회(마감일 순 내림차순)
	 */
	public List<ClosingDateVo> selectAllClosingDate(Menu17SearchForm menu17SearchForm) {
		return sqlSession.selectList("menu19.selectAllClosingDate", menu17SearchForm);
	}
	
	
	/**
	 * 
	 * 최신 결산완료 마감일 조회 - 결산된 마감일의 수정, 삭제시 유효성검사 
	 */
	public ClosingDateVo selectLastestClosedDateByClosingDateNoPerYear(ClosingDateVo closingDateVo) {
		return sqlSession.selectOne("menu19.selectLastestClosedDateByClosingDateNoPerYear", closingDateVo);
	}
	
	/**
	 * 
	 * 마감일 수정(미결산 마감일만 수정 가능)
	 */
	public int updateClosingDate(ClosingDateVo closingDate) {
		return sqlSession.update("menu19.updateClosingDate", closingDate);
	}
	
	
	/**
	 * 
	 * 마감일 삭제(미결산 마감일만 삭제 가능)
	 */
	public int deleteClosingDate(ClosingDateVo closingDate) {
		return sqlSession.delete("menu19.deleteClosingDate", closingDate);
	}
	
	
	/**
	 * 
	 * 결산완료된 마감일자 미결산처리 
	 */
	public int updateClosingYnToFalse(ClosingDateVo closingDateVo) {
		return sqlSession.update("menu19.updateClosingYnToFalse", closingDateVo);
	}
	
}
