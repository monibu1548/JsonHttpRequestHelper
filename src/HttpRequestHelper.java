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

    private String header = new String("Content-Type");
    private String headerValue = new String("application/json");

    private DataOutputStream dos;
    private DataInputStream dis;

    private int responseCode;
    private String response;

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


    /**
     * For posting json foramat data using http request
     * @param json format data
     * @return http post response string
     * */
    public String post(JSonObject json){

        try {
            url = new URL(serverURL);

            httpURLConnection = (HttpURLConnection)url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty(header, headerValue);

            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            dos = new DataOutputStream(httpURLConnection.getOutputStream());

            dos.write(json.toString().getBytes("UTF-8"));
            dos.flush();
            dos.close();

            int responseCode = httpURLConnection.getResponseCode();

            dis = new DataInputStream (httpURLConnection.getInputStream());

            response = dis.readLine();


            return response;

        }catch(Exception ee)
        {
            ee.printStackTrace();
        }

        return "ERROR";
    }

    /**
     * Get response code. you can check post condition
     * @param
     * @return response code
     * */
    public int getResponseCode(){
        return responseCode;
    }


    /**
     * You Can change post target server url
     * @param
     * @return
     * */
    public void setURL(String url){
        serverURL = url;

    }

    public void setHeader(String header, String headerValue){
        this.header = header;
        this.headerValue = headerValue;
    }

    public String getSettings(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{\n");
        stringBuffer.append("  ServerURL : " + serverURL);
        stringBuffer.append(",\n Header : " + header);
        stringBuffer.append(",\n Header-Value : " + headerValue);
        stringBuffer.append("\n  }");
        return stringBuffer.toString();
    }


}
