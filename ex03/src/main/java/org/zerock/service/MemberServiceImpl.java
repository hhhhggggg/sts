package org.zerock.service;

import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper mapper;

	@Override
	public void register(MemberVO mem) {
		log.info(mem);
		mapper.insert(mem);
	}

	@Override
	public String login(String id) {
		
		return mapper.selectLogin(id);
	}

	@Override
	public boolean registerIdCheck(String id) {
		boolean result = false;
		
		if(mapper.selectIdCheck(id)==0) result = true;
		
		return false;
	}
	
	
	
}
