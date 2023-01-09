package edu.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.study.service.BoardService;
import edu.study.vo.BoardVO;

@RequestMapping(value="/ajax")
@Controller
public class AjaxController {
	
	@Autowired
	private BoardService boardService;

	
	@RequestMapping(value= "/main.do", method=RequestMethod.GET)
	public String main() {
		return "ajax/main";
	}
	@ResponseBody //화면에다 뿌리는 어노테이션
	@RequestMapping(value="/callString.do", method=RequestMethod.GET)
	public String callStr() {
		return "ajax test data!!";
	}

	@ResponseBody
	@RequestMapping(value="findBidx.do", method=RequestMethod.GET)
	public BoardVO findBidx(int bidx) {
		BoardVO vo = boardService.selectByBidx(bidx);
		return vo;
	}
}
