package kr.co.itcen.fa.service.menu08;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.itcen.fa.dto.DataResult;
import kr.co.itcen.fa.repository.menu08.Menu10Repository;
import kr.co.itcen.fa.util.PaginationUtil;
import kr.co.itcen.fa.vo.menu08.LandVo;


/**
 * 
 *  @author 정의돈
 *  토지현황조회
 */

@Service
public class Menu10Service {
	
	@Autowired
	private Menu10Repository menu10Repository;
	
	public void test() {
		menu10Repository.test();
	}

	public Map<String, Object> getList(LandVo landVo, String startDate, String endDate) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchList", menu10Repository.getList(landVo, startDate, endDate));
		
		
		return map;
	}

	public Map<String, Object> selectList() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("selectList", menu10Repository.selectList());
		
		return map;
	}
	
	public DataResult<LandVo> list(String id, int page) {
		DataResult<LandVo> dataResult = new DataResult<LandVo>();
		
		int totalCount = menu10Repository.listCount(id);
		
		//pagination
		PaginationUtil pagination = new PaginationUtil(page, totalCount, 11, 5);
		dataResult.setPagination(pagination);
		List<LandVo> list = menu10Repository.list(id, pagination);
		dataResult.setDatas(list);
		
		return dataResult;
	}
}
