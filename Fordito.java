import java.io.*;

public class Fordito {
    /*Készítsen egy egyszerű titkosítást lehetővé alkalmazást,
    amely egy szöveges állományban a karaktereket a rákövetkezőre cseréli ki. (Pl alma bmnb)
    Az alkalmazástól elvárjuk, hogy tetszőleges hosszúságú szöveges állományokat képes legyen kezelni*/

    public static void main(String args[]) throws IOException {

        File f = new File("kodolatlan-szoveg.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        OutputStream out = new FileOutputStream("kodolt-szoveg.txt");

        int c;
        while ((c = br.read()) != -1) {

            if (c < 65 || (c>90 && c<97) || c>122){
                char characterNew = (char) c;
                out.write(characterNew);
            }
            else if (c<91){
                char characterNew = (char) (((c - 'A' + 1) % 26) + 'A');
                out.write(characterNew);
            }
            else {
                char characterNew = (char) (((c - 'a' + 1) % 26) + 'a');
                out.write(characterNew);
            }
        }
        out.flush();
        out.close();
    }
}
