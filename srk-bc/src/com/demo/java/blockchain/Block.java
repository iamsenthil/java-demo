package com.demo.java.blockchain;

import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;

public class Block {
	private int index;
	private String data;
	private String previousHash;
	private String nones = UUID.randomUUID().toString();//TODO: Check the implementation
	private Date timeStamp = new Date();//TODO: Change to Universal Standard Time
	private String hash;

	public Block(int index, String data, String previousHash) {
		this.index = index;
		this.data = data;
		this.previousHash = previousHash;
		this.hash = calaculateHash();
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
		return String.format("Index : " + index + ", Data : " + data + ", PreviousHash : " + previousHash + ", Nones : "
				+ nones + ", TimeStamp : " + timeStamp + ", Hash : " + hash);
	}

	private String sha256(String base) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(base.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public String calaculateHash() {
		return sha256(this.index + this.data + this.previousHash + this.timeStamp + this.nones);
	}
}
