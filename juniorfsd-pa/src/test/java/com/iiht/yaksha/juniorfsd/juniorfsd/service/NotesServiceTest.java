package com.iiht.yaksha.juniorfsd.juniorfsd.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.iiht.yaksha.juniorfsd.juniorfsd.dao.NotesDaoImpl;
import com.iiht.yaksha.juniorfsd.juniorfsd.model.Notes;
import com.iiht.yaksha.juniorfsd.juniorfsd.test.utils.MasterData;
import static com.iiht.yaksha.juniorfsd.juniorfsd.test.utils.TestUtils.*;
public class NotesServiceTest {

	@Mock
	private NotesDaoImpl notesDao;
	@InjectMocks 
	private NotesServiceImpl notesServiceImpl;
	
		
	
	/*
	 * static { File file = new File("output_service_revised.txt"); if
	 * (file.exists() && file.length() == 0) { try { FileUtils.forceDelete(new
	 * File("output_functional_revised.txt")); } catch (IOException e) {
	 * 
	 * } } }
	 */
	 
		
	/**
	 * 
	 */
	@Before 
	public void init() { 
		MockitoAnnotations.initMocks(this); 
	}

	@Test
	void test() {
	//	fail("Not yet implemented");
	}
	
	@Test
	public void testInsertNote() throws IOException {
		Boolean flag = true;
		Notes note = MasterData.getDetails();
		when(notesServiceImpl.insertNote(note)).thenReturn(flag);
		boolean value = notesServiceImpl.insertNote(note);
	//	File file = new File("output_functional_revised.txt"); 
	//	FileUtils.write(file,"\n testInsertNote = "+(value?true:false), true);
		yakshaAssert(currentTest(),(value?true:false),businessTestFile);
	}
	
	@Test
	public void testGetNoteById() throws IOException {
		Notes mkNote=new Notes();
		mkNote.setId((long) 10008);
		mkNote.setAuthor("Praveen");
		mkNote.setTitle("DevOps");
		when(notesServiceImpl.getNoteById((long) 10008)).thenReturn(mkNote);
		Notes frmDb = notesServiceImpl.getNoteById((long) 10008);
		System.out.println(mkNote);
	//	File file = new File("output_functional_revised.txt"); 
	//	FileUtils.write(file,"\n testGetNoteById = "+(frmDb.getAuthor().equals("Praveen")?true:false), true);
		yakshaAssert(currentTest(),(frmDb.getAuthor().equals("Praveen")?true:false),businessTestFile);
		
	}
	
	@Test
	public void testViewlAll() throws Exception {
		
		List<Notes> list = new ArrayList<Notes>();
		List<Notes> noteList;
		list.add(new Notes());
		list.add(new Notes());
	    when(notesServiceImpl.getAllNodes()).thenReturn((List<Notes>) list);
		noteList = notesServiceImpl.getAllNodes();
	//	File file = new File("output_functional_revised.txt");
	//	FileUtils.write(file, "\n testViewAll = "+(noteList.size()==2?true:false), true); 
		yakshaAssert(currentTest(),(noteList.size()==2?true:false),businessTestFile);
	}
	
	@Test
	public void testDeleteNote() throws IOException{
			 Boolean flag = true;
		when(notesServiceImpl.deleteNote((long) 10008)).thenReturn(flag);
		boolean stats = notesServiceImpl.deleteNote((long)10008);
	//	File file = new File("output_functional_revised.txt");
	//	FileUtils.write(file, "\n testDeleteNote = "+(stats?true:false), true);
		yakshaAssert(currentTest(),(stats?true:false),businessTestFile);
		
	}
	
	@Test
	public void testUpdateNote() throws Exception{
		Boolean flag=true;
		Notes note = MasterData.getDetails();
		when(notesServiceImpl.updateNote(note)).thenReturn(note.getId());
		Long testId= (long) 10009;// notesServiceImpl.updateNote(note);
	//	File file = new File("output_functional_revised.txt");
	//	FileUtils.write(file, "\n testUpdateNote = "+(testId==note.getId()?true:false), true);
		yakshaAssert(currentTest(),(testId==note.getId()?true:false),businessTestFile);
		
	}
}
