package com.demo.java.blockchain;

import java.util.Date;

public class Block {
	private int index;
	private String data;
	private String previousHash;
	private String nones;
	private Date timeStamp;
	private String hash;

	public Block(int index,String data, String previousHash)
	{
		this.index = index;
		this.data = data;
		this.previousHash = previousHash;
	}
	public int getIndex() {
		return index;
	}
	public String getData() {
		return data;
	}
	public String getPreviousHash() {
		return previousHash;
	}
	public String getNones() {
		return nones;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public String getHash() {
		return hash;
	}
	
	@Override
    public String toString() {
        return String.format("Index : "+ index + 
        						", Data : " + data +
        						", PreviousHash : " + previousHash +
        						", Nones : " + nones +
        						", TimeStamp : " + timeStamp +
        						", Hash : " + hash 
        		);
    }
}
