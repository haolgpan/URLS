package Survey;

import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SurveyURLConn {
    private static void fillForm(URL url, String formData) {
        URLConnection connection = null;
        try {
            connection = url.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
            out.write(formData);
            System.out.println(connection.getIfModifiedSince());
            out.flush();
            out.close();
            connection.getInputStream();
        } catch (Exception ex) {
            Logger.getLogger(MainSurvey.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        try {
            String formData = "entry.835030737=Sad+dreams&entry.1616686619=Si";
            URL responseUrl = new URL("https://docs.google.com/forms/u/1/d/e/1FAIpQLSdV5QvhChK0fBpAMo5pN7sIvktqwHGu1vdoWJFvBguCeMvYUw/formResponse?");

            fillForm(responseUrl, formData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
