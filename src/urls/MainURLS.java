package urls;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainURLS {
    private static void printContent(URL url, String header){
        InputStream in;
        char[] cbuf = new char[512];
        int caractersLlegits;
        String test = null;
        try {
            in = url.openStream();
            InputStreamReader inr = new InputStreamReader(in);
            while((caractersLlegits=inr.read(cbuf))!=-1){
                String str = String.copyValueOf(cbuf, 0, caractersLlegits);
                String[] lines = str.split("\n");
                for (String line : lines) {
                    if (line.startsWith(header)) {
                        System.out.println(line);
                    }
                }
            }
            System.out.println();
        } catch (IOException ex) {
            Logger.getLogger(MainURLS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public static void main(String[] args) {
        String header = "<" + args[1];
        try {
            MainURLS.printContent(new URL(args[0]), header);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
