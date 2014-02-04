import java.io.*;

public class Reversebinary {

    public static void main (String[] args) {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = null;
        
        try {
            input = br.readLine();
        }
        catch(IOException ioe) {
            System.exit(1);
        }
        
        int number = Integer.parseInt(input);
        
        String bin_number = Integer.toBinaryString(number);
        String new_bin_number = "";
        for (int i = bin_number.length() - 1; i >= 0; i--) {
            new_bin_number += bin_number.charAt(i);
        }
        
        System.out.println(Integer.parseInt(new_bin_number, 2));   
    }
}
