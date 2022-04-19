package service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServiceRequest implements RequestImpl{

    @Override
    public void MyGETRequest() throws IOException{

        URL urlForGetRequest = new URL("http://localhost:8080/api/smart-store/payment/charge/status");
        String readLine = null;
        HttpURLConnection connection = (HttpURLConnection) urlForGetRequest.openConnection();
        connection.setRequestMethod("GET");
        //connection.setRequestProperty("usedId", "a1bcdef");
        int responseCode = connection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK){
            BufferedReader in = new BufferedReader(
                    new InputStreamReader((connection.getInputStream()))
            );
            StringBuffer response = new StringBuffer();
            while((readLine = in.readLine()) != null){
                response.append(readLine);
            }
            in.close();

            System.out.println("JSON String Result" + response.toString());
        }
        else {
            System.out.println("GET NOT WORKED");
        }
    }

    @Override
    public void MyPOSTRequest() {

    }
}
