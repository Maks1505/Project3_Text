package com.bibik.project3.textcomposite;

//Leaf
public class Symbol implements TextComponent {
	
	private String symbol; 
	
	
	public Symbol(String symbol) {
		super();
		this.symbol = symbol;
	}

	@Override
	public void print() {
		System.out.print(symbol);
	}

	@Override
	public void buildText(StringBuilder sb) {
		sb.append(symbol);
	}
	

}
