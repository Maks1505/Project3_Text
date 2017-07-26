package com.bibik.project3.runner;

import com.bibik.project3.textcomposite.Symbol;
import com.bibik.project3.textcomposite.TextComposite;
import com.bibik.project3.textparser.LexemeParser;
import com.bibik.project3.textparser.ParagraphParser;
import com.bibik.project3.textparser.SentenceParser;
import com.bibik.project3.textparser.TextParser;

public class TextProjectRunner {

	public static void main(String[] args) {
		String text = "	First paragraph here. Sentence 2.	Second paragraph there.";
		
		
		System.out.println("\nINITIALIZE CHAIN\n***********************");
		
		LexemeParser lp = new LexemeParser();
		SentenceParser sp = new SentenceParser(lp);
		ParagraphParser pp = new ParagraphParser(sp);
		TextParser tp = new TextParser(pp);
		
		TextComposite root = new TextComposite();
		tp.parseString(text, root);

		System.out.println("\nPRINT INITIAL TEXT\n***********************");
		System.out.println(text);
		System.out.println("\nPRINT TEXT FROM COMPOSITE\n***********************");
		root.print();
		System.out.println("\n\nBUILD TEXT FROM COMPOSITE & PRINT\n***********************");
		StringBuilder sb = new StringBuilder();
		root.buildText(sb);
		System.out.println(sb.toString());
	}

}
