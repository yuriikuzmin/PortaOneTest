import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class App {


    static String line;
    static StringBuffer bufferChar = new StringBuffer();
    static StringBuffer endBuffer = new StringBuffer();

    public App() {
    }
    public static void selected(String loWord){
        char ch, ch1;
        int count;
        int fl=1;

            for (int i = 0; i < loWord.length(); i++) {
                if(fl!=0){
                    count=0;
                    ch = loWord.charAt(i);

                    for (int j = 0; j < loWord.length(); j++) {
                        if (i != j) {
                            ch1 = loWord.charAt(j);

                            if (ch == ch1) {
                                count++;

                            }
                        }
                    }

                    if (count == 0) {
                        if (ch != ',' & ch != '.' & ch != '"' & ch != '-') {
                            bufferChar.append(ch);
                            fl = 0;
                        }
                    }
                }
            }
            System.out.println("В словах одиночных первых символов: "+bufferChar);
    }

    public static void endSelected(StringBuffer bufferChar){

        char buf, buf1;
        int count;


        for(int i=0; i<bufferChar.length(); i++ ){
            count = 0;
            buf=bufferChar.charAt(i);

            for(int j=0; j<bufferChar.length(); j++) {
                if(i!=j) {
                    buf1 = bufferChar.charAt(j);

                    if (buf == buf1) {
                        count++;

                    }
                }
            }
            if (count == 0) {
                endBuffer.append(buf);
            }

        }
        System.out.println("Результат работы программы : "+ endBuffer);
    }
   
    public static void main(String[] arg){
        FileReader reader;
        try {
             reader=new FileReader("intext.txt");

             Scanner scanner=new Scanner(reader);
             String loWord=null;
             while (scanner.hasNext()) {
                 line = scanner.nextLine();
                 System.out.println(line);
                 System.out.println(line.length());
                 String[] words = line.split(" ");
                 for (String word : words) {
                     loWord = word.toLowerCase();
                     selected(loWord);
                 }
             }

            endSelected(bufferChar);

            FileWriter writer=null;
            try {
            writer = new FileWriter("output.txt", true);
            writer.write(String.valueOf(endBuffer)+"\n");
            writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
   
}
