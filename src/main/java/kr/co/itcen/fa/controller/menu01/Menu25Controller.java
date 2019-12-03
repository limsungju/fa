package kr.co.itcen.fa.controller.menu01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.itcen.fa.security.Auth;
import kr.co.itcen.fa.security.AuthUser;
import kr.co.itcen.fa.service.menu01.Menu25Service;
import kr.co.itcen.fa.vo.UserVo;
import kr.co.itcen.fa.vo.menu01.BankAccountVo;

/**
 * 
 * @author 황슬기
 * 계좌관리
 *
 */
@Auth
@Controller
@RequestMapping("/" + Menu25Controller.MAINMENU)
public class Menu25Controller {
	public static final String MAINMENU = "01";
	public static final String SUBMENU = "25";

	@Autowired
	private Menu25Service menu25Service;
	
	@RequestMapping({"/" + SUBMENU, "/" + SUBMENU + "/list" })
	public String test(Model model) {
		List<BankAccountVo> list = menu25Service.list();
		
		model.addAttribute("list", list);
		return MAINMENU + "/" + SUBMENU + "/list";
	}
	
	// Create
	@ResponseBody
	@RequestMapping("/" + SUBMENU + "/create")
	public Map<String, Object> create(@ModelAttribute BankAccountVo bavo,
			@AuthUser UserVo uvo) {
		System.out.println("create");
				
		// User 정보 넣기 -> getLastUpdate가 내가 원하는기능이면 다시 붙이면됨
		bavo.setInsertUserId(uvo.getName());
		
		Map<String, Object> result = menu25Service.create(bavo);
		result.put("success", true);
		
		return result;
	}
	
	// R
	@RequestMapping("/" + SUBMENU + "/read")
	public String read(@ModelAttribute BankAccountVo bavo	) {
		System.out.println("read");
		menu25Service.test();
		return "redirect:/"+ MAINMENU + "/" + SUBMENU + "/list";
	}
	
	// Update
	@RequestMapping("/" + SUBMENU + "/update")
	public String update(@ModelAttribute BankAccountVo bavo,
			@AuthUser UserVo uvo) {
		System.out.println("update");
		
		// User 정보 넣기 -> getLastUpdate가 내가 원하는기능이면 다시 붙이면됨
		bavo.setUpdateUserId(uvo.getName());
				
		menu25Service.update(bavo);
		return "redirect:/"+ MAINMENU + "/" + SUBMENU + "/list";
	}
	
	// Delete
	@RequestMapping("/" + SUBMENU + "/delete")
	public String delete(@ModelAttribute BankAccountVo bavo) {
		System.out.println("delete");
		
		menu25Service.delete(bavo);
		return "redirect:/"+ MAINMENU + "/" + SUBMENU + "/list";
	}
}