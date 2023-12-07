package com.example.demo.Controller;

import com.example.demo.Core.CustomResponse.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@RestController("api/v1/payments")
public class PaymentController {


    @PostMapping("purchase")
    public ResponseEntity<Object> executeCurl(String xmlData) throws IOException, InterruptedException {
        StringBuilder builder = new StringBuilder();
        String location = System.getenv("paymentLocation");
        String curl = "curl --location '" + location + "' \\ ";
        String certificateLocation = "Users/ahmadovmt/Documents/paymentTest/test.crt";
        String keyLocation = "Users/ahmadovmt/Documents/paymentTest/test.key";
        builder.append(curl);
        builder.append("--header 'Content-Type: application/xml' \\ ");
        builder.append("--key '");
        builder.append(keyLocation + "' \\");
        builder.append("--cert '");
        builder.append(certificateLocation + "' \\");
        builder.append("--data ");
        builder.append("'");
        builder.append(xmlData);
        builder.append("'");

        ProcessBuilder pb = new ProcessBuilder(builder.toString());
        Process pr = pb.start();
        pr.waitFor();

        BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
        System.out.println(br.readLine());

        return ResponseHandler.generateResponse("sicccess", HttpStatus.ACCEPTED,null);
    }

    @PostMapping("postPayment")
    public ResponseEntity<Object> callApi(String xmlData) throws IOException {
        var externalURL = new URL("https://tstpg.kapitalbank.az:5443/Exec");
        //RestTemplate tmpl = new RestTemplate();
        //String result = tmpl.getForObject(externalURL,String.class);
        //return ResponseHandler.generateResponse("success",HttpStatus.OK,result);


        HttpsURLConnection connection = (HttpsURLConnection) externalURL.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        connection.setSSLSocketFactory(sslsocketfactory);

        connection.addRequestProperty("Content-Type", "text/xml; charset=utf-8");
        connection.addRequestProperty("Accept", "text/xml");
        try (var os = connection.getOutputStream()) {
            byte[] input = xmlData.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }
        int responseCode = connection.getResponseCode();
        String responseJsonString = null;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            var br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            String inputLine;
            var sb = new StringBuilder();

            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            br.close();
            responseJsonString = sb.toString();
        } else {
            throw new IOException("Error occurred, try later !");
        }
        return ResponseHandler.generateResponse("success",HttpStatus.ACCEPTED,responseJsonString);
    }


}
