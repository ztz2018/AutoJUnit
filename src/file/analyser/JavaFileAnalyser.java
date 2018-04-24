package file.analyser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import file.java.JavaClass;

public class JavaFileAnalyser
{
	private File javaFile;
	
	public JavaFileAnalyser(String filename) throws InvalidFileException
	{
		if(!(filename.endsWith(".java")))
			throw new InvalidFileException();
		
		else
			this.javaFile = new File(filename);
	}
	
	public JavaClass getJavaClass() throws IOException
	{
		String classname = "";
		String accessModifier = "";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(javaFile)))
		{
			
		}
		
		return new JavaClass(classname, accessModifier);
	}
	
	public class InvalidFileException extends Exception{}
}
