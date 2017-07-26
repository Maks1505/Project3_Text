package com.bibik.project3.textparser;

import com.bibik.project3.textcomposite.TextComponent;

public abstract class AbstractParser {
	AbstractParser next;
	abstract void parseString(String s, TextComponent tc);
	
	public AbstractParser getNext() {
		return next;
	}
	public void setNext(AbstractParser next) {
		this.next = next;
	}
	
	
}
