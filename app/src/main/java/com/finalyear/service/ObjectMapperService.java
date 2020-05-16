package com.finalyear.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.util.List;

/**
 * Object mapper service . Method deserialize string into a list
 */
public class ObjectMapperService {

   private static final ObjectMapper objectMapper = new ObjectMapper();

   public static <T> List<T> readValueAsList(String object, Class<T> classType) {
      try {
         CollectionType type = objectMapper.getTypeFactory().constructCollectionType(List.class, classType);
         return objectMapper.readValue(object, type);
      } catch (JsonProcessingException e) {
         throw new RuntimeException(e);
      }
   }





}
