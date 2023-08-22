package org.zerock.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/join/*")
@AllArgsConstructor
public class MemberController {
	
	private MemberService service;
	
	@GetMapping("/login")
	public void login() {
		
		log.info("로그인 요청 받음");
		
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest request, RedirectAttributes rttr)
	{
		log.info("로그인. 입력한 비밀번호는 -> " + request.getParameter("pw"));
		
		log.info("DB에 있는 비밀번호 -> " + service.login(request.getParameter("id")));
		
		//아이디로 비밀번호를 꺼내서 입력한 비밀번호와 같은지 비교할거야
		
		if( !(service.login(request.getParameter("id")).equals(request.getParameter("pw"))) ) {
			log.info("비밀번호 틀렸어");
			
			rttr.addFlashAttribute("msg", "비밀번호 틀림");
			
			return "redirect:/join/login";
		}
		
		rttr.addFlashAttribute("id", request.getParameter("id"));
		
		//service.register(member);
	
		return "redirect:/join/index";
	}
	
	@GetMapping("/index")
	public void index() {
		
	}
	
	@GetMapping("/register")
	public void register() {
		
		log.info("회원가입 페이지 요청 받음");
		
	}
	
	@PostMapping("/register")
	public String register(MemberVO member, RedirectAttributes rttr)
	{
		log.info("가입할사람 -> " + member);
		
		log.info(member.getPw());
		
		/*
		 * if (!(service.registerIdCheck(member.getId()))) { log.info("아이디 중복");
		 * 
		 * rttr.addFlashAttribute("msg", "아이디 중복");
		 * 
		 * return "redirect:/join/register"; }
		 */
		
		service.register(member);
		
		return "redirect:/join/login";
	}
	
	
	
}
