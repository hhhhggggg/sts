package org.zerock.service;

import org.zerock.domain.MemberVO;

public interface MemberService {
	
	public void register(MemberVO mem);
	
	public String login(String id);
	
	public boolean registerIdCheck(String id);
	
	
}
