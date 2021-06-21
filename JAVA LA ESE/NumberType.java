import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NumberType{
    public static void main(String[] args) throws IOException
    {
        int ch;
        FileReader fr=null;
        ArrayList<String> al = new ArrayList<String>();

        //get the file
        try{
            fr = new FileReader("numbers.txt");
        }
        catch (FileNotFoundException fe){
            System.out.println(fe);
        }

        //get all numbers
        String s = "";
        while ((ch=fr.read())!=-1)
        {    
            char c = (char)ch;
            if(c=='\n')
            {
                al.add(s);
                s = "";
            }
            else
            {
                s += c;
            }
        }

        //final number of the file
        al.add(s);
        s="";

        fr.close();

        //parse all numbers and get required count
        int count_positive=0, count_negative=0, count_fraction=0;
        for(String st: al)
        {
            Double thatNum = Double.parseDouble(st);
            if(thatNum < 0)
            {
                count_negative++;
            }
            else
            {
                //we assume 0 to be positive
                count_positive++;
            }
            
            if(thatNum%1 != 0)
            {
                count_fraction++;
            }
        }

        //printing output
        System.out.println("For the Numbers in numbers.txt:\n");
        System.out.println("Count of Positive Numbers: "+String.valueOf(count_positive));
        System.out.println("Count of Negative Numbers: "+String.valueOf(count_negative));
        System.out.println("Count of Fractional Numbers: "+String.valueOf(count_fraction));
    }
}