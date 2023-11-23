package com.srmaca.model.ecommerce.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class AddTextData {
    private String fontsize;
    private String title;
    private String buttonbg1;
    private String buttonbg2;
    private String buttontc1;
    private String buttontc2;
    private String buttongo1;
    private String buttongo2;
    private String buttontitle1;
    private String buttontitle2;

    // Metodos de Serializacion JSON

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(this);
        return json;
    }

    public static AddTextData fromJson(String json) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper(); 
        AddTextData addTextData = mapper.readValue(json, AddTextData.class);
        return addTextData;
    }
}