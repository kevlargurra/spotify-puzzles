import java.io.*;
import java.util.*;

public class Zipfsong {

	static class Song implements Comparable<Song> {
	    private String songName;
	    private int quality;
	    private int songOrder;
	    
	    Song (String songName, int quality, int songOrder) {
	        this.songName = songName;
	        this.quality = quality;
	        this.songOrder = songOrder;
	    }
	    
	    public int compareTo(Song song) {
        	int qualityDiff = song.getQuality() - quality;
	    	
	    	if(qualityDiff != 0) {
	    		return qualityDiff;
	    	}
	    	else  {
	    		return songOrder - song.songOrder;
	    	}
        }
	    
	    public int getQuality() {
	        return quality;
	    }
	    
	    public int getSongOrder() {
	        return songOrder;
	    }
	    
	    public String getSongName() {
	        return songName;
	    }
	}
	
    public static void main (String[] args) {
    
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = null;
        
        try {
            input = br.readLine();
        }
        catch(IOException ioe) {
            System.exit(0);
        }
        
        String[] allAndSelectedSongs = input.split(" ");
        int songsOnAlbum = Integer.parseInt(allAndSelectedSongs[0]);
        int songsToSelect = Integer.parseInt(allAndSelectedSongs[1]);
        
        int songOrder = 1;
        int quality;
        int numOfPlays;
        
        Song[] qualityList = new Song[songsOnAlbum];
        
        String songName = "";
        String[] numOfPlaysAndSongName;
        int firstSongNoOfPlays = 0;
        
        for (int i = 0; i < songsOnAlbum; i++) {
            try {
                input = br.readLine();
            }
            catch(IOException ioe) {
                System.exit(0);
            }
            
            numOfPlaysAndSongName = input.split(" ");
            try {
	            numOfPlays = Integer.parseInt(numOfPlaysAndSongName[0]);
            }
            catch(NumberFormatException e) {
            	numOfPlays = 0;
            }
            songName = numOfPlaysAndSongName[1];
            if (songOrder == 1) {
                firstSongNoOfPlays = numOfPlays;
            }
            
            if (firstSongNoOfPlays == 0) {
                quality = 0;
            }
            else {
            	quality = songOrder * numOfPlays;
            }
            
            qualityList[songOrder - 1] = new Song(songName, quality, songOrder);;

            songOrder++;
        }

        Arrays.sort(qualityList);
        
        for (int i = 0; i < songsToSelect; i++) {
            System.out.println(qualityList[i].getSongName());
        }
    }
}
