package kr.co.itcen.fa.controller.menu02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.itcen.fa.security.Auth;
import kr.co.itcen.fa.service.menu02.Menu07Service;
import kr.co.itcen.fa.vo.menu02.PurchaseitemVo;
import kr.co.itcen.fa.vo.menu02.PurchasemanagementVo;

/**
 * 
 * @author 윤종진
 * 매입현황조회
 *
 */

@Auth
@Controller
@RequestMapping("/" + Menu07Controller.MAINMENU)
public class Menu07Controller {
	public static final String MAINMENU = "02";
	public static final String SUBMENU = "07";
	
	@Autowired
	private Menu07Service menu07Service;
	

	@RequestMapping(value = {"/" + SUBMENU}, method = RequestMethod.GET)
	public String index(Model model, @RequestParam(defaultValue = "1") String page) {
		
		int countPage = 5;
		int curPage;
		int lastPage;

		if ("".equals(page)) {
			curPage = 1;
		} else {
			curPage = Integer.parseInt(page);
		}

		int startPage = ((curPage - 1) / countPage) * countPage + 1;
		int endPage = startPage + countPage - 1;

		int blockNum = 0;

		blockNum = (int) Math.floor((curPage - 1) / countPage);
		int blockStartNum = (countPage * blockNum) + 1;
		int blockLastNum = blockStartNum + (countPage - 1);

		int total = menu07Service.getCount();

		if (total % countPage == 0) {
			lastPage = (int) Math.floor(total / countPage);
		} else {
			lastPage = (int) Math.floor(total / countPage) + 1;
		}

		
		List<PurchasemanagementVo> result = menu07Service.getList((curPage - 1) * 11);
		model.addAttribute("result", result);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("blockStartNum", blockStartNum);
		model.addAttribute("blockLastNum", blockLastNum);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("curPage", curPage);
		
		return MAINMENU + "/" + SUBMENU + "/list";
	}

	@ResponseBody
	@RequestMapping(value = {"/" + SUBMENU + "/search" }, method = RequestMethod.POST)
	public List<PurchasemanagementVo> search(Model model, @RequestBody PurchasemanagementVo vo,
			String[] purchaseDate, @RequestParam(defaultValue = "1") String page) {
		int countPage = 5;
		int curPage;
		int lastPage;

		if ("".equals(page)) {
			curPage = 1;
		} else {
			curPage = Integer.parseInt(page);
		}

		int startPage = ((curPage - 1) / countPage) * countPage + 1;
		int endPage = startPage + countPage - 1;

		int blockNum = 0;

		blockNum = (int) Math.floor((curPage - 1) / countPage);
		int blockStartNum = (countPage * blockNum) + 1;
		int blockLastNum = blockStartNum + (countPage - 1);

		int total = menu07Service.getCount();

		if (total % countPage == 0) {
			lastPage = (int) Math.floor(total / countPage);
		} else {
			lastPage = (int) Math.floor(total / countPage) + 1;
		}

//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("page",(curPage - 1) * 11);
//		map.put("vo",vo);
		//List<PurchasemanagementVo> result = menu07Service.getList(map);
		vo.setPage(curPage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("blockStartNum", blockStartNum);
		model.addAttribute("blockLastNum", blockLastNum);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("curPage", curPage);
		List<PurchasemanagementVo> result = menu07Service.getList(vo);
		System.out.println("vo : " + vo);
		System.out.println("result : " + result);
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/" + SUBMENU + "/paging")
	public List<PurchasemanagementVo> paging(Model model, @RequestParam(value="page", required=false, defaultValue="1") int page) {
		int countPage = 5;
		int curPage = page;
		int lastPage;

		
		int startPage = ((curPage - 1) / countPage) * countPage + 1;
		int endPage = startPage + countPage - 1;

		int blockNum = 0;

		blockNum = (int) Math.floor((curPage - 1) / countPage);
		int blockStartNum = (countPage * blockNum) + 1;
		int blockLastNum = blockStartNum + (countPage - 1);

		int total = menu07Service.getCount();

		if (total % countPage == 0) {
			lastPage = (int) Math.floor(total / countPage);
		} else {
			lastPage = (int) Math.floor(total / countPage) + 1;
		}

		
		List<PurchasemanagementVo> result = menu07Service.getList((curPage - 1) * 11);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("blockStartNum", blockStartNum);
		model.addAttribute("blockLastNum", blockLastNum);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("curPage", curPage);
		return result;
	}
}
