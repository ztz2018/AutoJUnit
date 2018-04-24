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
			JavaFileAnalyser analyser = new JavaFileAnalyser("");
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
			fail();
		}
	}
}
