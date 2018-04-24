package file.java;

public class JavaClass 
{
	private String classname;
	private String accessModifier;
	
	public JavaClass(String classname, String accessModifier)
	{
		this.classname = classname;
		this.accessModifier = accessModifier;
	}
	
	public String getClassName()
	{
		return classname;
	}
	
	public String getAccessModifier()
	{
		return accessModifier;
	}
}
