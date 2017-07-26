package com.bibik.project3.textparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bibik.project3.textcomposite.TextComponent;
import com.bibik.project3.textcomposite.TextComposite;

public class SentenceParser extends AbstractParser{

	public SentenceParser() {
		super();
	}

	public SentenceParser(AbstractParser p) {
		super();
		next = p;
	}

	@Override
	void parseString(String s, TextComponent c) {
		//System.out.println("\n----SENTENCE PARRSER");
		if (c instanceof TextComposite) {
			Pattern pat = Pattern.compile("[ \t\\p{Punct}]*\\w*");
			Matcher m = pat.matcher(s);
			while(m.find()) {
				TextComposite lexComp = new TextComposite();
				((TextComposite) c).add(lexComp);
				//System.out.println(m.group());
				if (next != null) {
					next.parseString(m.group(), lexComp);
				}
			}
		}
	}

}
