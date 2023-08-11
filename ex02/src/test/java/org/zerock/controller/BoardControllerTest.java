package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTest {
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); 
	}
	
	@Test
	public void testList(){
		try {
			log.info(
					mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
					.andReturn()
					.getModelAndView()
					.getModelMap()
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRegister() {
		String resultPage;
		try {
			resultPage = mockMvc
					.perform(MockMvcRequestBuilders.post("/board/register")
							.param("title","테새제")
							.param("content", "테새내")
							.param("writer", "user00"))
					.andReturn().getModelAndView().getViewName();
			log.info(resultPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet() {
		try {
			log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
					.param("bno", "2"))
					.andReturn()
					.getModelAndView().getModelMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testmodify() throws Exception{
		String resultPage = mockMvc
				.perform(MockMvcRequestBuilders.post("/board/modify")
						.param("bno","1")
						.param("title","수테새제")
						.param("content", "수테새내")
						.param("writer","user00"))
				.andReturn().getModelAndView().getViewName();
		log.info(resultPage);
	}
	
	@Test
	public void testRemove() {
		String resultPage;
		try {
			resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
					.param("bno","25"))
					.andReturn().getModelAndView().getViewName();
			log.info(resultPage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
