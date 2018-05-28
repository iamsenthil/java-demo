package com.demo.java.blockchain;

import java.util.ArrayList;
import java.util.Iterator;

public class BlockChain {
	
	private ArrayList<Block> blockChain = new ArrayList<Block>();

	public BlockChain()
	{
		blockChain.add(createGenisiBlock());	
	}

	private Block createGenisiBlock() {
		return new Block(0,"Genesis Block","");
	}
public void addBlock(String data)
{
	String previousHash = blockChain.get(blockChain.size()-1).getHash();
	int index = blockChain.size();
    this.blockChain.add(new Block(index,data,previousHash));	
}

public void printAll() {

	for (Iterator<Block> iterator = blockChain.iterator(); iterator.hasNext();) {
		Block block = (Block) iterator.next();
		System.out.println(block.toString());
	}
}
}
