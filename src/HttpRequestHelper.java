import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author JingyuJung
 * @date 15
 * @version 1.0.0
* */

public class HttpRequestHelper {

    private String serverURL;
    private URL url;

    private DataOutputStream dos;
    private DataInputStream dis;

    private HttpURLConnection httpURLConnection;


    /**
     * Instance Constructor
     * @param serverURL URL that you can connect and post, get method.
     * @return -1 error, 0 connection OK
     * */
    public int HttpURLConnection(String serverURL){

        try {
            url = new URL(serverURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }



}
