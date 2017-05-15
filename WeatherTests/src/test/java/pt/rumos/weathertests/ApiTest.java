/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.rumos.weathertests;

import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.junit.Test;

/**
 *
 * @author Utilizador
 */
public class ApiTest {

    private static final String APP_KEY = "82e8405ce7ac327e50a24d8540f44c43";

    @Test
    public void testApiCall() throws IOException {

        CloseableHttpClient client = HttpClientBuilder.create().build();

        CloseableHttpResponse response = client.execute(new HttpGet("http://api.openweathermap.org/data/2.5/weather?q=Oporto,pt&appid=82e8405ce7ac327e50a24d8540f44c43"));
        String bodyAsString = EntityUtils.toString(response.getEntity());
        System.out.println("RESPONSE:" + bodyAsString);
        //assertThat(bodyAsString, notNullValue());
    }

}
