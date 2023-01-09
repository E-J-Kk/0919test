package edu.study.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.study.service.UserService;
import edu.study.vo.UserVO;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	public String login() {
		
		
		return "user/login";
	}
	/*
	  �α��ι�ư Ŭ�� �� ����ڰ� �Է��� ���̵� �н����� ������ ��ġ�ϴ� usertb ������ controller���� ��ȸ�� ���� 
	  
	 */

	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	public String login(UserVO vo, HttpSession session) {
		
		//����� ������ ��ȸ�ؿ�����
		UserVO loginVO = userService.login(vo);
		
		if(loginVO != null) {
			session.setAttribute("login", loginVO);

			System.out.println(loginVO.toString());
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
