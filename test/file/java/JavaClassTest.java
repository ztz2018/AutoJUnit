package file.java;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import file.analyser.JavaFileAnalyser;
import file.analyser.JavaFileAnalyser.InvalidFileException;

public class JavaClassTest 
{
	@Test
	public void junitClassTest() 
	{
		String junitFile = "C:/Users/ezcofja/Desktop/Projects/AutoJUnit/AutoJUnit/test/file/analyser/JavaFileAnalyserTest.java";
		
		try 
		{
			JavaClass junitClass = new JavaFileAnalyser(junitFile).getJavaClass();
			
			assertEquals("public", junitClass.getAccessModifier());
			assertEquals("JavaFileAnalyserTest", junitClass.getClassName());
		} 
		
		catch (InvalidFileException | IOException e) 
		{
			fail();
		}
		
		
	}

}
