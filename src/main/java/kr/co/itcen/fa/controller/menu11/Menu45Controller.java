package kr.co.itcen.fa.controller.menu11;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.itcen.fa.dto.DataResult;
import kr.co.itcen.fa.security.Auth;
import kr.co.itcen.fa.service.menu11.Menu45Service;
import kr.co.itcen.fa.vo.menu11.BankVo;

/**
 * 
 * @author 이지수
 * 은행코드현황조회
 *
 */
@Auth
@Controller
@RequestMapping("/" + Menu45Controller.MAINMENU)
public class Menu45Controller {
	public static final String MAINMENU = "11";
	public static final String SUBMENU = "45";
	
	@Autowired
	private Menu45Service menu45Service;
	
	@RequestMapping(value = {"/" + SUBMENU, "/" + SUBMENU + "/list" }, method=RequestMethod.GET)
	public String list(
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "code", required = false, defaultValue = "") String code, Model model) {
		System.out.println(code);
		DataResult<BankVo> dataResult = menu45Service.list(code, page);
		model.addAttribute("dataResult", dataResult);
		return MAINMENU + "/" + SUBMENU + "/list";
	}
}
