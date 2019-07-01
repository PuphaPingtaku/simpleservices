package com.pupha.restful.java.simpleservices;

public class FactorialObject {

	private long input;
	private long output;
	
	public FactorialObject(long in, long out) {

		setInput(in);
		setOutput(out);
	}
	
	public long getInput() {
		return input;
	}
	public void setInput(long input) {
		this.input = input;
	}
	public long getOutput() {
		return output;
	}
	public void setOutput(long output) {
		this.output = output;
	}
}
