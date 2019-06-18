package org.jmusixmatch.model;

public class NameAndArtist {

	String name;
	String artist;

	public NameAndArtist() {
		super();
	}

	public NameAndArtist(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

}
