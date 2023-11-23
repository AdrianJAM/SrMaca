package com.srmaca.model.ecommerce.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class Comparation {
    private String natural1;
    private String natural2;
    private String natural3;
    private String artificial1;
    private String artificial2;
    private String artificial3;

    // Metodos de Serializacion JSON

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(this);
        return json;
    }

    public static Comparation fromJson(String json) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper(); 
        Comparation comparation = mapper.readValue(json, Comparation.class);
        return comparation;
    }
}
