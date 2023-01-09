package edu.study.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.study.service.BoardService;
import edu.study.vo.BoardVO;
import edu.study.vo.UserVO;

@RequestMapping(value="/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@RequestMapping(value="/list.do")
	public String list(Model model) {
		//DB list ��ȸ
		
		List<BoardVO> list = boardService.list();
		
		model.addAttribute("datalist",list);
		
		
		
		
		
		
		
		
		
		
		/*
		 * List<BoardVO> list = new ArrayList<BoardVO>();
		 * 
		 * BoardVO vo1 = new BoardVO(); vo1.setTitle("ù��° �Խñ�"); vo1.setWriter("�ۼ���1");
		 * vo1.setContent("ù��° ����");
		 * 
		 * list.add(vo1);
		 * 
		 * BoardVO vo2 = new BoardVO(); vo2.setTitle("�ι�° �Խñ�"); vo2.setWriter("�ۼ���2");
		 * vo2.setContent("�ι�° ����");
		 * 
		 * list.add(vo2);
		 * 
		 * BoardVO vo3 = new BoardVO(); vo3.setTitle("����° �Խñ�"); vo3.setWriter("�ۼ���3");
		 * vo3.setContent("����° ����");
		 * 
		 * list.add(vo3);
		 * 
		 * model.addAttribute("datalist",list);
		 */
		
		
		
		
		return "board/l";
	}
	
	@RequestMapping(value="/view.do",method=RequestMethod.GET)
	public String view(int bidx, Model model) {
		//DB �󼼵����� ��ȸ
		BoardVO vo = boardService.selectByBidx(bidx);
		
		model.addAttribute("vo",vo);
		
		return "board/v";
	}
	
	@RequestMapping(value="/write.do",method=RequestMethod.GET)
	public String write() {
		
		return "board/w";
	}
	
	
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String write(BoardVO vo,@RequestParam("etc") String temp) {
		//�ش� �޼ҵ带 ȣ���ϴ� ������ -> projectpath/board/write.do
		System.out.println(vo.toString());
		System.out.println("temp::"+temp);
		//System.out.println("etc::"+etc);
		/*
		 * System.out.println("param title ::"+title);
		 * System.out.println("param writer ::"+writer);
		 * System.out.println("param content ::"+content);
		 */
		
		//db�۾� (insert)
		return "redirect:list.do?param=testdata"; //redirect�Ǵ� ������ -> projectpath/board/list.do
		//return "redirect:/user/list.do"; //redirect�Ǵ� ������ -> projectpath/user/list.do
	}
	
	@RequestMapping(value="/modify.do", method=RequestMethod.GET)
	public String modify(int bidx,Model model) {
		
		BoardVO vo = boardService.selectByBidx(bidx);
		
		model.addAttribute("vo", vo);
		
		return "board/m";
	}
	
	@RequestMapping(value="/modify.do", method=RequestMethod.POST)
	public String modify(BoardVO vo) {
		
		int result = boardService.updateByBidx(vo);
		
		if(result>0) {
			return "redirect:view.do?bidx="+vo.getBidx();
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String delete(int bidx, HttpSession session) {
		
		UserVO login = (UserVO)session.getAttribute("login");
		
		int uidx = login.getUidx();
		
		boardService.deleteByBidx(bidx);
		
		return "redirect:list.do";
	}
} 













