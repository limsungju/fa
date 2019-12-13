package kr.co.itcen.fa.repository.menu01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.itcen.fa.util.PaginationUtil;
import kr.co.itcen.fa.vo.menu01.AccountCustomerLedgerVo;
import kr.co.itcen.fa.vo.menu01.CustomerVo;
import kr.co.itcen.fa.vo.menu11.TestVo;

/**
 * 
 * @author 이종윤
 * 계정거래처원장조회
 *
 */

@Repository
public class Menu32Repository {
	@Autowired
	private SqlSession sqlSession;

	public void test() {
		TestVo testVo = new TestVo();
		testVo.setName("계정거래처원장조회");
		sqlSession.insert("menu32.save", testVo);
	}

	public List<CustomerVo> getCustomerNoInfo(String customerNo) {
		return sqlSession.selectList("menu32.getCustomerNoInfo", customerNo);
	}

	public List<CustomerVo> getCustomerNameInfo(String customerName) {
		String name = "%"+ customerName +"%";
		List<CustomerVo> result = sqlSession.selectList("menu32.getCustomerNameInfo", name);
		
		return result;
	}

	/*public int listCount(AccountCustomerLedgerVo aclVo) {
		int i = sqlSession.selectOne("menu32.searchCount",aclVo);
		
		return sqlSession.selectOne("menu28.searchCount",aclVo);
	}*/

	public List<AccountCustomerLedgerVo> list(/*PaginationUtil pagination,*/ AccountCustomerLedgerVo aclVo,
			Long accountCode, String datepicker1, String datepicker2, String customerNo) {
		Map<String,Object> map = new HashMap<String, Object>();
		//map.put("pagination",pagination);
		map.put("vo", aclVo);
		map.put("accountCode", accountCode);
		map.put("datepicker1", datepicker1);
		map.put("datepicker2", datepicker2);
		map.put("customerNo", customerNo);
		List<AccountCustomerLedgerVo> list = sqlSession.selectList("menu32.optionSearch",map);
		return list;
	}



}
