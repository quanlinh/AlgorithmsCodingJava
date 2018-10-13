import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class stripe {
    public static void main(String[] args) throws IOException {
//        DecimalFormat df = new DecimalFormat("###.#");
//        System.out.println(df.format(0.49));
//        System.out.println(Math.floor(0.5));

        String val = "API: amount=1000&merchant=123&dest[account]=111&des[amount]=877";
        String rem = val.substring(0,3);
        String rem1 = val.substring(4);
        System.out.println(rem);
        System.out.println(rem1);
        String[] valasf = rem1.split("&");
        System.out.println(Arrays.toString(valasf));
        for(String typeOfAccount: valasf ) {
            String[] typeString  = typeOfAccount.split("=");
            if(typeString[0].equals("merchant")) {
                System.out.println(typeString[1]);
            } else if(typeString[0].equals("destination[account]")) {

            }
            else if(typeString[0].equals("destination[amount]")) {

            }
            else { // if(typeString[0].equals("destination[amount]")) {

            }
        }
        }
}
