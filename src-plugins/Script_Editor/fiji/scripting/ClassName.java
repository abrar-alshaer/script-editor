package fiji.scripting;

import java.lang.Comparable;
import java.util.TreeSet;
import java.lang.reflect.*;
public class ClassName implements Item ,Comparable {

	String key;
	String completeName;
	TreeSet<ClassMethod> methodNames=new TreeSet<ClassMethod>();


	public ClassName() {
	}

	public ClassName(String paramkey,String name) {
		key=paramkey;
		completeName=name;
	}

	public String getName() {
		return this.key;
	}

	public String getCompleteName() {
		return this.completeName.replace('/','.');
	}

	public int compareTo(Object o) {
		Item tree=(Item)o;
		return(this.getName().compareTo(tree.getName()));
	}

	public void setMethodNames(Method[] methods) {
		for(Method m : methods) {
			String fullName = m.toString();
			//String[] bracketSeparated = fullName.split("\\(");
			//int lastDotBeforeBracket = bracketSeparated[0].lastIndexOf(".");
			methodNames.add(new ClassMethod(fullName));
		}
		//Collections.sort(methodNames);
	}
}
