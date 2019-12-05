package kr.co.itcen.fa.controller.menu11;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.itcen.fa.dto.JSONResult;
import kr.co.itcen.fa.security.Auth;
import kr.co.itcen.fa.service.menu11.Menu47Service;
import kr.co.itcen.fa.vo.menu11.STermDebtVo;

@Auth
@Controller
@RequestMapping("/api/" + Menu47Controller.MAINMENU)
public class Menu47ApiController {
	
	@Autowired
	public Menu47Service menu47Service;
	
	@ResponseBody
	@RequestMapping("/" + Menu47Controller.SUBMENU + "/search")
	public JSONResult search(STermDebtVo sTermDebtVo) {
		List<STermDebtVo> list = menu47Service.search(sTermDebtVo);
		System.out.println("ajax 탔다 ");
		return JSONResult.success(list);
	}
	
	@ResponseBody
	@RequestMapping("/" + Menu47Controller.SUBMENU + "/order")
	public JSONResult order(STermDebtVo sTermDebtVo, @RequestParam(value="orderColumn", required=true) String orderColumn) {
		System.out.println("orderColumn : " + orderColumn);
		List<STermDebtVo> list = menu47Service.order(sTermDebtVo, orderColumn);
		System.out.println("list1 : " + list.get(0).getDebtDate());
		return JSONResult.success(list);
	}
	
}