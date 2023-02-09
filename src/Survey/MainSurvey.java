package Survey;

import urls.MainURLS;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainSurvey {
    private static void submit(URL url){
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            int statusCode = connection.getResponseCode();
            System.out.println(statusCode);

        } catch (IOException ex) {
            Logger.getLogger(MainURLS.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            connection.disconnect();
        }
    }


    public static void main(String[] args) {
        try {
            MainSurvey.submit(new URL("https://docs.google.com/forms/u/1/d/e/1FAIpQLSdV5QvhChK0fBpAMo5pN7sIvktqwHGu1vdoWJFvBguCeMvYUw/formResponse?entry.835030737=Testing+Radio&entry.1616686619=No"));

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
