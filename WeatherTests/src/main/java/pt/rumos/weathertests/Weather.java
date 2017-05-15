/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.rumos.weathertests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author Utilizador
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
