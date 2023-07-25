package ir.mpj.client1;

import com.google.gson.Gson;
import ir.mpj.client1.data.MessageRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


@SpringBootApplication

public class Client1Application {
    @Value("${messenger.server.url}")
    static String uri;

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        SpringApplication.run(Client1Application.class, args);
         sendMessage();
    }

    public static void sendMessage() throws IOException, InterruptedException, URISyntaxException {
        Scanner input = new Scanner(System.in);


        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setPublisherId("hossA");
        messageRequest.setConsumerId("PV1");
        messageRequest.setConsumeType("PV");

        System.out.println("\nBody: ");

        messageRequest.setBody(input.next());

        Gson gson = new Gson();
        String jsonRequest = gson.toJson(messageRequest);
        System.out.println(jsonRequest);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .header("Content-Type" , "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());

        System.out.println(postResponse.body());
    }




}
