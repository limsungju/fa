package kr.co.itcen.fa.repository.menu01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.fa.util.PaginationUtil;
import kr.co.itcen.fa.vo.menu01.PreviousVo;
import kr.co.itcen.fa.vo.menu01.ReceiptVo;
import kr.co.itcen.fa.vo.menu17.ClosingDateVo;

/**
 * 
 * @author 김승곤 황슬기
 * 계정거래처명세서조회
 *
 */

@Repository
public class Menu29Repository {
	@Autowired
	private SqlSession sqlSession;
	
	public int listCount(ReceiptVo revo) {
		
		return sqlSession.selectOne("menu29.listCount",revo);
	}
	
	public List<ReceiptVo> list(PaginationUtil pagination, ReceiptVo revo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pagination", pagination);
		map.put("vo", revo);
		List<ReceiptVo> list= sqlSession.selectList("menu29.list",map);
		return list;
	}

	public List<Long> selectVoucherNo(ClosingDateVo cVo) {
		Calendar cal = Calendar.getInstance();				//전월이월
        cal.setTime(cVo.getStartDate());
        cal.add(Calendar.MONTH, 1);

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String End = transFormat.format(cVo.getEndDate());								//차월이월 date
		String Start = transFormat.format(cal.getTime());								//전월이월 date
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("End",End);
		map.put("Start", Start);
		System.out.println(End+":"+ Start);
		System.out.println(sqlSession.selectList("menu29.select",map));
		return sqlSession.selectList("menu29.select",map);
	}

	public List<PreviousVo> previous(ReceiptVo revo) {
		return sqlSession.selectList("menu29.previous", revo);
	}

	public boolean previousexist(ReceiptVo revo) {
		int a=sqlSession.selectOne("menu29.previousexist", revo);
		return a==0;
	}

	public ReceiptVo dsum(ReceiptVo revo) {
		return sqlSession.selectOne("menu29.dsum", revo);
	}
	
	public ReceiptVo csum(ReceiptVo revo) {
		return sqlSession.selectOne("menu29.csum", revo);
	}
}
