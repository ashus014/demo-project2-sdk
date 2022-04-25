package org.example;

import org.json.JSONException;
import service.ApacheHttpClientGet;
import service.ServiceRequest;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, JSONException {
//        ServiceRequest request = new ServiceRequest();
//        request.MyGETRequest();

        ApacheHttpClientGet apacheHttpClientGet = new ApacheHttpClientGet();
        apacheHttpClientGet.MyGETRequest();
    }
}
