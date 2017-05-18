package pt.rumos.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


//A anotação @ManagedBean regista esta classe como 1 recurso dos JSF.
//Com esta anotação, esta classe passa a ser gerida pelo servidor. Não precisamos de a instanciar
@ManagedBean
@RequestScoped //Este Bean é valido até ao fim da sessão
public class WeatherBean {

    public WeatherBean() {
    }
    
}
