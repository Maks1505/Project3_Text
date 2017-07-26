package com.bibik.project3.textparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bibik.project3.textcomposite.TextComponent;
import com.bibik.project3.textcomposite.TextComposite;


public class TextParser extends AbstractParser {

	public TextParser() {
		super();
	}
	
	public TextParser(AbstractParser p) {
		super();
		next = p;
	}


	@Override
	public void parseString(String s, TextComponent c) {
		// parse text into paragraphs. Delimiter tab or four spaces
		//System.out.println("\nTEXT PARRSER");
		if (c instanceof TextComposite) {
			Pattern pat = Pattern.compile("\t[\\w [\\p{Punct}&&[^\t]]]*");
			Matcher m = pat.matcher(s);
			while(m.find()) {
				TextComposite parComp = new TextComposite();
				((TextComposite) c).add(parComp);
				//System.out.println(m.group());
				if (next != null) {
					next.parseString(m.group(), parComp);
				}
			}
		}
	}
}

