package com.tma.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ObjectMapperUtil {

    public final static ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LogManager.getLogger(ObjectMapperUtil.class);

    private ObjectMapperUtil(){
    }

    public static String writeListToJsonArray(ArrayList<String> list) throws IOException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        mapper.writeValue(out, list);
        final byte[] data = out.toByteArray();
        System.out.println(data);
        return new String((data));
    }

    /**
     * convert Object into String.
     * @param obj Object
     * @return String
     */
    public static String convertToString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String objectToJson = objectMapper.writeValueAsString(obj);
            System.out.println(objectToJson);
            return objectToJson;
        } catch (JsonProcessingException e) {
            logger.error("JsonProcessingException while converting Entity into string", e);
        }
        return null;
    }
}
