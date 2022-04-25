package service;


import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.util.Arrays;
import java.util.List;

public class ApacheHttpClientGet implements RequestImpl{

    @Override
    public void MyGETRequest() throws IOException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet("http://localhost:8080/api/smart-store/payment/charge/status");
        getRequest.addHeader("merchantID", "ABCDEFPVUTQXU1");

        HttpResponse response =  httpClient.execute(getRequest);

        //--------------------------------------Printing all Headers----------------------------------------------------

        List<Header> httpHeaders = Arrays.asList(getRequest.getAllHeaders());
        for(Header header : httpHeaders){
            System.out.println("Header.. name ,value : " + header.getName() + ", " + header.getValue());
        }

        if(response.getStatusLine().getStatusCode() != 200){
            throw new RuntimeException("Failed : HTTP error code");
        }

        BufferedReader br = new BufferedReader(
                new InputStreamReader((response.getEntity().getContent())));

        String output;

        System.out.println("-------------OUTPUT FROM SERVER-------------------");
        while ((output = br.readLine()) != null){
            System.out.println(output);
        }

        httpClient.getConnectionManager().shutdown();
    }

    @Override
    public void MyPOSTRequest() {

    }
}
