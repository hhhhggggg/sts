package org.zerock.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private Long memno;
	private String id;
	private String pw;
	private String name;
	private String email;

	
}
