package com.bibik.project3.textcomposite;

import java.util.ArrayList;

//Composite
public class TextComposite implements TextComponent {
	public ArrayList<TextComponent> childComponents = new ArrayList<TextComponent>();
	
	@Override
	public void print() {
		//System.out.println(textElement); - extending Chain of Responsibility
		for (TextComponent c : childComponents) {
			c.print();
        }

	}


	public void add(TextComponent c) {
		childComponents.add(c);
	}


	public void remove(TextComponent c) {
		childComponents.remove(c);
	}

	
	public ArrayList<TextComponent> getAllChilds() {
		return childComponents;
	}


	@Override
	public void buildText(StringBuilder sb) {
		for (TextComponent c : childComponents) {
			c.buildText(sb);
		}
	}

}
