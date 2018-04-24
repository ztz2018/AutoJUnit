package file.analyser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import file.java.JavaClass;

public class JavaFileAnalyser
{
	private static String PACKAGE_PATTERN = "package [a-zA-Z0-9.]+;";
	private static String CLASS_PATTERN = "(private |public |abstract |final |static )*class [a-zA-Z0-9]+( extends [a-zA-Z0-9]+| implements [a-zA-Z0-9]+)*";
	
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
			String line;
			while((line = reader.readLine()) != null && classname.equals(""))
			{
				String classification = classifyLine(line);
				
				switch(classification)
				{
					case "package declaration": 	break;
					case "class declaration": 	String [] details = extractDetails(classification, line); classname = details[1]; accessModifier = details[0];	break;
				}
			}
		}
		
		return new JavaClass(classname, accessModifier);
	}
	
	public String classifyLine(String line)
	{
		String result = "";
		
		if(line.trim().matches(PACKAGE_PATTERN))
			result = "package declaration";
		
		else if(line.trim().matches(CLASS_PATTERN))
			result = "class declaration";
		
		return result;
	}
	
	private String[] extractDetails(String classification, String line)
	{
		String [] details = null;
		switch(classification)
		{
			case "class declaration":	String [] data = line.split(" ");
										details = new String[2];
										details[0] = line.replace(data[data.length - 1], "").replace(data[data.length - 2], "").trim();
										details[1] = data[data.length - 1];
										break;
		}
		
		return details;
	}
	
	public class InvalidFileException extends Exception{}
}


