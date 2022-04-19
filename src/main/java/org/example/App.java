package org.example;

import service.ServiceRequest;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        ServiceRequest request = new ServiceRequest();
        request.MyGETRequest();
    }
}
