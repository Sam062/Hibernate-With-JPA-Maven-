package base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		String username="Systema32";
		
		Pattern p=Pattern.compile("[A-Z]?[a-z0-9]*");
		Matcher m=p.matcher(username);
		System.out.println(m.matches()); //true
	}

}
