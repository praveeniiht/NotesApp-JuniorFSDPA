package com.iiht.yaksha.juniorfsd.juniorfsd.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static com.iiht.yaksha.juniorfsd.juniorfsd.test.utils.TestUtils.*;
import com.iiht.yaksha.juniorfsd.juniorfsd.controller.HomeController;
import com.iiht.yaksha.juniorfsd.juniorfsd.service.NotesService;

public class NotesControllerTest {
	
	@Mock
	private NotesServiceImpl notesService;
	
	@InjectMocks
	private HomeController homeController;
	
	private MockMvc mockmvc;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockmvc = MockMvcBuilders.standaloneSetup(homeController).build();
	}

	@Test
	public void test1() throws Exception {
		MvcResult result = this.mockmvc.perform(get("/")).andExpect(view().name("index")).andReturn();
	//	File file = new File("output_functional_revised.txt"); 
	//	FileUtils.write(file, "\n testShowHomePage ="+(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false), true);
	yakshaAssert(currentTest(),(result.getResponse().getStatus() == HttpStatus.OK.value() ? true : false),businessTestFile);
	}
	@Test
	public void testStatusPage() throws Exception {
		MvcResult result = this.mockmvc.perform(get("/statusManager")).andExpect(view().name("statusmanager")).andReturn();
	//	File file = new File("output_functional_revised.txt"); 
	//	FileUtils.write(file, "\n testStatusPage ="+(result!=null ? true : false), true);
		yakshaAssert(currentTest(),(result!=null ? true : false),businessTestFile);
	}
	/*
	 * testViewAllPage method is used to test whether redirecting to 
	 * viewAll page, expected 
	 */
	@Test
	public void testViewAllPage() throws Exception {
		MvcResult result = this.mockmvc.perform(get("/viewlAll")).andExpect(view().name("viewall")).andReturn();
	//	File file = new File("output_functional_revised.txt"); 
	//	FileUtils.write(file, "\n testViewAllPage ="+(result!=null ? true : false), true);
		yakshaAssert(currentTest(),(result!=null ? true : false),businessTestFile);
	}
	@Test
	public void testUpdatePage() throws Exception {
		MvcResult result = this.mockmvc.perform(get("/updateNote")).andExpect(view().name("index")).andReturn();
		//File file = new File("output_functional_revised.txt"); 
	//	FileUtils.write(file, "\n testUpdatePage ="+(result!=null ? true : false), true);
		yakshaAssert(currentTest(),(result!=null ? true : false),businessTestFile);
	}
	

}
