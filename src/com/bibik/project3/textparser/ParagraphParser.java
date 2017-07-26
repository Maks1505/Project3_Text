package com.bibik.project3.textparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bibik.project3.textcomposite.TextComponent;
import com.bibik.project3.textcomposite.TextComposite;

public class ParagraphParser extends AbstractParser {
	
	public ParagraphParser(){
		super();
	}
	
	public ParagraphParser(AbstractParser p) {
		super();
		next = p;
	}
		
	@Override
	void parseString(String s, TextComponent c) {
		//System.out.println("\n--PARAGRAPH PARRSER");
		if (c instanceof TextComposite) {
			Pattern pat = Pattern.compile("[\\w \t]+[\\p{Punct}&&[^\t]]+");
			Matcher m = pat.matcher(s);
			while(m.find()) {
				TextComposite sentComp = new TextComposite();
				((TextComposite) c).add(sentComp);
				//System.out.println(m.group());
				if (next != null) {
					next.parseString(m.group(), sentComp);
				}
			}
		}
	}
	
}

