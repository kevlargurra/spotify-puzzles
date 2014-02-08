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
        
        String binNumber = Integer.toBinaryString(number);
        String newBinNumber = "";
        for (int i = binNumber.length() - 1; i >= 0; i--) {
            newBinNumber += binNumber.charAt(i);
        }
        
        System.out.println(Integer.parseInt(newBinNumber, 2));   
    }
}
