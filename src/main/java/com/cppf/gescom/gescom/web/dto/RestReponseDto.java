package com.cppf.gescom.gescom.web.dto;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class RestReponseDto {

  public  static Map<Object, Object>  responsePaginate(Object results,Object last, Object totalPages,Object totalElements,Object currentPage, Object first,HttpStatus status){
      Map<Object, Object>  response = new HashMap<>();
      response.put("results", results);
      response.put("statut", status.value());
      response.put("last", last);
      response.put("totalPages",totalPages);
      response.put("totalElements",totalElements);
      response.put("currentPage",currentPage);
      response.put("first",first);
      return response;
  }

    public  static Map<Object, Object>  response(Object results,HttpStatus status){
        Map<Object, Object>  response = new HashMap<>();
        response.put("results", results);
        response.put("statut", status.value());
        return response;
    }
}
