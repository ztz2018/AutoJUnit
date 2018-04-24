package file.analyser;

import static org.junit.Assert.*;

import org.junit.Test;

import file.analyser.JavaFileAnalyser;
import file.java.JavaClass;

public class JavaFileAnalyserTest
{
	@Test
	public void invalidFileTest() 
	{
		try
		{
			new JavaFileAnalyser("");
		}
		
		catch(JavaFileAnalyser.InvalidFileException ia)
		{
			assertTrue(true);
		}
	}
	
	@Test
	public void junitFileTest()
	{
		try
		{
			JavaFileAnalyser analyser = new JavaFileAnalyser("C:/Users/ezcofja/Desktop/Projects/AutoJUnit/AutoJUnit/test/file/analyser/JavaFileAnalyserTest.java");
			JavaClass jClass = analyser.getJavaClass();
			
			assertEquals("public", jClass.getAccessModifier());
			assertEquals("JavaFileAnalyserTest", jClass.getClassName());
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void accessModifiedClassTest()
	{
		try
		{
			String finalFilename 	= "C:/Users/ezcofja/Desktop/Projects/AutoJUnit/AutoJUnit/test/resources/analyser/finalClass.java";
			String abstractFilename	= "C:/Users/ezcofja/Desktop/Projects/AutoJUnit/AutoJUnit/test/resources/analyser/abstractClass.java";
			
			JavaClass finalClass 	= new JavaFileAnalyser(finalFilename).getJavaClass();
			JavaClass abstractClass = new JavaFileAnalyser(abstractFilename).getJavaClass();
			
			assertEquals("public final",finalClass.getAccessModifier());
			assertEquals("abstract", 	abstractClass.getAccessModifier());
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void classifyLineTest()
	{
		try
		{
			JavaFileAnalyser analyser = new JavaFileAnalyser("C:/Users/ezcofja/Desktop/Projects/AutoJUnit/AutoJUnit/test/file/analyser/JavaFileAnalyserTest.java");
			
			assertEquals("package declaration", analyser.classifyLine("package file.analyser;"));
			assertEquals("class declaration", 	analyser.classifyLine("public class JavaFileAnalyserTest"));
		}
		
		catch(Exception e)
		{
			fail();
		}
	}
}
