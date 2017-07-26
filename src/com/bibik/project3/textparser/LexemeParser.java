package com.bibik.project3.textparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bibik.project3.textcomposite.Symbol;
import com.bibik.project3.textcomposite.TextComponent;
import com.bibik.project3.textcomposite.TextComposite;

public class LexemeParser extends AbstractParser {

	@Override
	void parseString(String s, TextComponent c) {
		//System.out.println("\n------LEXEME PARRSER");
		if (c instanceof TextComposite) {
			Pattern pat = Pattern.compile(".");
			Matcher m = pat.matcher(s);
			while(m.find()) {
				Symbol symb = new Symbol(m.group());
				((TextComposite) c).add(symb);
				//System.out.println(m.group());
			}
		}
	}
}
