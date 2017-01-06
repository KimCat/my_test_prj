package kr.co.test.controller;

import java.util.List;
import java.util.Map;

import kr.co.test.common.CommonUtil;
import kr.co.test.service.MainService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	private Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private MainService mainService;
	
	@RequestMapping(value="/")
	public String test() throws Exception{
		
		try {
			
			List<Map<String, Object>> userList = CommonUtil.renameKey(mainService.getUsers());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "home";
	}
}
