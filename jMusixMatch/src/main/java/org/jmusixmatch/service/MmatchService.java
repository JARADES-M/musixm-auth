package org.jmusixmatch.service;

import org.jmusixmatch.MusixMatch;
import org.jmusixmatch.MusixMatchException;
import org.jmusixmatch.entity.lyrics.Lyrics;
import org.jmusixmatch.entity.track.Track;
import org.jmusixmatch.entity.track.TrackData;
import org.springframework.stereotype.Service;

@Service
public class MmatchService implements MmatchServiceInter {
	
	@Override
	public String getLyricsBySongAndArtist(String trackName, String artistName) {
		
		String apiKey = "8cc3baff1601125977c4fe8f6d6b668d";
		// String apiKey = System.getenv("MM_API_KEY");
		
		MusixMatch musixMatch = new MusixMatch(apiKey);

		/*
			trackName = "Don't stop the Party";
			artistName = "The Black Eyed Peas";
		 */

		try {
			
			Track track = musixMatch.getMatchingTrack(trackName, artistName);
			TrackData data = track.getTrack();
	
			int trackID = data.getTrackId();
			System.out.printf("ID: %s%n", trackID);
	
			Lyrics lyrics = musixMatch.getLyrics(trackID);
	
			return lyrics.getLyricsBody();
			
		} catch (MusixMatchException mme) {
			mme.printStackTrace();
		}
		
		return "Erro ao pesquisar por letra";
		
	}
	
	@Override
	public String getLyricsById (Integer trackID) {
		
		String apiKey = "8cc3baff1601125977c4fe8f6d6b668d";
		// String apiKey = System.getenv("MM_API_KEY");
		
		MusixMatch musixMatch = new MusixMatch(apiKey);

		try {
	
			Lyrics lyrics = musixMatch.getLyrics(trackID);
	
			return lyrics.getLyricsBody();
			
		} catch (MusixMatchException mme) {
			mme.printStackTrace();
		}
		
		return "Erro ao pesquisar por letra";
		
	}

}
