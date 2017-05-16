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

@WebServlet(name = "WeatherServlet", urlPatterns = {"/WeatherServlet"})
public class WeatherServlet extends HttpServlet {

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //++++++++++++ METODOS DE SERVIÇO DO SERVLET ++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //***********GET***************
    //*****************************
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String city = request.getParameter("city");
        String country = request.getParameter("country");

        //pedido http para weather api
        WeatherApiService was = new WeatherApiService();
        CityWeatherResponse cwr = was.getWeatherObj(city, country);
        
        //resposta
        PrintWriter w = response.getWriter(); //criar objecto PrintWriter para poder enviar o HTML
        w.println("CITY: " + city + "," + country);
        w.println("WEATHER FORECAST: " + cwr.getWeather().get(0).getDescription());
    }
}
