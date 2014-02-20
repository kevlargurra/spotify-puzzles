import java.util.*;

public class Zipfsong {

    static class Song implements Comparable<Song> {
        private String songName;
        private long quality;
        private long songOrder;
        
        Song (String songName, long quality, long songOrder) {
            this.songName = songName;
            this.quality = quality;
            this.songOrder = songOrder;
        }
        
        @Override
        public int compareTo(Song song) {
            long qualityDiff = song.getQuality() - quality;
            
            if(qualityDiff > 0) {
                return 1;
            }
            else if(qualityDiff < 0) {
                return -1;
            }
            else  if(songOrder - song.getSongOrder() > 0) {
                return 1;
            }
            else {
                return -1;
            }
        }
        
        public long getQuality() {
            return quality;
        }
        
        public long getSongOrder() {
            return songOrder;
        }
       
        public String getSongName() {
            return songName;
        }
    }
    
    public static void main (String[] args) {
    	try {
	        Kattio io = new Kattio(System.in, System.out);
	    
	        int songsOnAlbum = io.getInt();
	        int songsToSelect = io.getInt();
	        StringBuilder sb = new StringBuilder();
	        long songOrder = 1;
	        long quality;
	        long numOfPlays;
	        
	        List<Song> qualityList = new ArrayList<Song>();
	        String songName = "";
	        
	        for (int i = 0; i < songsOnAlbum && io.hasMoreTokens(); i++) {
	            numOfPlays = io.getLong();
	            songName = io.getWord();
	            quality = songOrder * numOfPlays;
	            qualityList.add(new Song(songName, quality, songOrder));
	            songOrder++;
	        }
	
	        Collections.sort(qualityList);
	        Iterator<Song> it = qualityList.iterator();
	        
	        for (int i = 0; i < songsToSelect && it.hasNext(); i++) {
	            sb.append(it.next().getSongName()).append("\n");
	        }
	        io.print(sb);
	        io.close();
	    }
    	catch(Exception e) {
    		System.exit(0);
        }
    }
    
    
}
