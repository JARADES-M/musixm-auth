package org.jmusixmatch.service;

public interface MmatchServiceInter {

	String getLyricsBySongAndArtist(String trackName, String artistName);

	String getLyricsById(Integer trackID);

}