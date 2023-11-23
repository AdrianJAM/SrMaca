package com.srmaca.model.ecommerce;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class PillsData {
    private String principal;
    private String pils1;
    private String pils2;
    private String transitionname;
    private String transitionpils1;
    private String transitionpils2;

    // Metodos de Serializacion
    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(this);
        return json;
    }

    public static PillsData fromJson(String json) throws JsonProcessingException{
    
        ObjectMapper mapper = new ObjectMapper(); 
        
        PillsData pillsData = mapper.readValue(json, PillsData.class);
        
        return pillsData;
    }
}