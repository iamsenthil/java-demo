package com.demo.java.blockchain;

public class Main {

	public static void main(String[] args) {

		System.out.println("Blockchain Start");

		BlockChain blockChain = new BlockChain();
		blockChain.addBlock("One");
		blockChain.addBlock("Two");
		blockChain.addInvalidBlock("Two");
		blockChain.addBlock("Two");
		blockChain.addBlock("Two");
		blockChain.addBlock("Two");
		blockChain.addBlock("Two");
		blockChain.printAll();
		if(!blockChain.isValid())
		{
			System.out.println("Invalid Blockchain");
		}
		System.out.println("Blockchain End");
	}

}
