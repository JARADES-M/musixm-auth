package org.jmusixmatch.controller;

import org.jmusixmatch.model.NameAndArtist;
import org.jmusixmatch.service.MmatchService;
import org.jmusixmatch.service.MmatchServiceInter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class MmatchApp {

	public static void main(String[] args) {
		SpringApplication.run(MmatchApp.class, args);
	}

}



@RestController
class MmatchController {
	
	MmatchServiceInter mService = new MmatchService();
	
	@GetMapping("/musixmatch/lyrics")
	public String getLyrics(@RequestBody NameAndArtist nameAndArtist) {
		
		String lyrics = mService.getLyricsBySongAndArtist(nameAndArtist.getName(), nameAndArtist.getArtist());
		
		return lyrics;
	}
	
	
	@GetMapping("/musixmatch/lyrics/{trackID}")
	public String getLyricsById(@PathVariable("trackID") Integer trackID) {
		
		String lyrics = mService.getLyricsById(trackID);
		
		return lyrics;
	}

}
