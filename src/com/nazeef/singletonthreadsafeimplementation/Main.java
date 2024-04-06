package com.nazeef.singletonthreadsafeimplementation;

public class Main {

	public static void main(String[] args) {
		ThreadSafeImplementation config = ThreadSafeImplementation.getInstance();
		System.out.println(config.getValue("mode"));
		System.out.println(config.getValue("font-size"));
		System.out.println(config.getValue("font-type"));
	}

}
