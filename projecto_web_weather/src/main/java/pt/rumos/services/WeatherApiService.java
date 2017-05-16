package pt.rumos.services;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import pt.rumos.entities.CityWeatherResponse;

/**
 *
 * @author Nanda
 */
public class WeatherApiService {

    public CityWeatherResponse getWeatherObj(String city, String country) throws IOException{
     CloseableHttpClient client = HttpClientBuilder.create().build();

        CloseableHttpResponse responseApi = client.execute(new HttpGet("http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&appid=82e8405ce7ac327e50a24d8540f44c43"));
        String bodyAsString = EntityUtils.toString(responseApi.getEntity());
        System.out.println("RESPONSE:" + bodyAsString);   
        
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        CityWeatherResponse responseAsObj = objectMapper.readValue(bodyAsString, CityWeatherResponse.class);;
        
        return responseAsObj;
    }
    

}
