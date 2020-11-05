package com.training.ykb.common.error;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.Response.Body;
import feign.codec.ErrorDecoder;

@Component
public class MyErrorDecoder implements ErrorDecoder {

    @Override
    public MyRestException decode(final String methodKeyParam,
                                  final Response responseParam) {
        try {
            if (responseParam.status() != 404) {
                Body bodyLoc = responseParam.body();
                ObjectMapper mapperLoc = new ObjectMapper();
                ErrorObject readValueLoc = mapperLoc.readValue(bodyLoc.asInputStream(),
                                                               ErrorObject.class);
                return new MyRestException(readValueLoc);
            } else {
                return new MyRestException();
            }
        } catch (Exception eLoc) {
            return new MyRestException();
        }
    }

}
