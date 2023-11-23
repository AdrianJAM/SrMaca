package com.srmaca.model.ecommerce.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class Ingredients {
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private String ingredient4;
    
    // Metodos de Serializacion JSON

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(this);
        return json;
    }

    public static Ingredients fromJson(String json) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper(); 
        Ingredients ingredients = mapper.readValue(json, Ingredients.class);
        return ingredients;
    }
}
