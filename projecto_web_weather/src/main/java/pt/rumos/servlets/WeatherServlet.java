package pt.rumos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pt.rumos.services.WeatherApiService;
import pt.rumos.entities.CityWeatherResponse;
import pt.rumos.utils.Converter;


@WebServlet(name = "WeatherServlet", urlPatterns = {"/WeatherServlet"})
public class WeatherServlet extends HttpServlet {

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++ METODOS DE SERVIÇO DO SERVLET ++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //***********GET***************
    //*****************************
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String StringImg;
        String city = request.getParameter("city");
        String country = request.getParameter("country");

        //pedido http para weather api
        WeatherApiService was = new WeatherApiService();
        CityWeatherResponse cwr = was.getWeatherObj(city, country);
        
        //resposta
        PrintWriter w = response.getWriter(); //criar objecto PrintWriter para poder enviar o HTML
        w.println("<html><body>");
        w.println("CITY: " + city + "," + country + "</br>");
        w.println("WEATHER FORECAST: " + cwr.getWeather().get(0).getDescription() + "</br>");
        w.println("Main: " + cwr.getWeather().get(0).getMain() + "</br>");
        w.println("Image: <img src=" + cwr.getWeather().get(0).getIcon() + ">");
       
       
        w.println("<br/>HUMIDICITY :"+cwr.getMain().getHumidity()+"<br/>");
        w.println("PRESSURE :"+cwr.getMain().getPressure()+"<br/><br/>");
        w.println("TEMP (Fº) :"+cwr.getMain().getTemp()+" Fº<br/>");
        w.println("TEMP_MAX (Fº) :"+cwr.getMain().getTemp_max()+" Fº<br/>");
        w.println("TEMP_min (Fº) :"+cwr.getMain().getTemp_min()+" Fº<br/><br/>");
     
        
      
        w.println("TEMP (Cº) :"+Converter.convertToCelsius(cwr.getMain().getTemp())+"<br/>");
        w.println("TEMP_MAX (Cº) :"+Converter.convertToCelsius(cwr.getMain().getTemp_max())+"Cº <br/>");
        w.println("TEMP_min (Cº) :"+Converter.convertToCelsius(cwr.getMain().getTemp_min())+"Cº <br/>");
        w.println("</body></html>");
        
         
        
    }
}
