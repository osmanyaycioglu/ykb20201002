package com.training.ykb.error;

import java.util.ArrayList;
import java.util.List;

public class ErrorObject {

    private List<ErrorObject> subError;
    private String            domain;
    private String            subdomain;
    private String            boundedContext;
    private String            microservice;
    private String            message;
    private int               errorCause;


    public ErrorObject() {
    }


    public ErrorObject(final List<ErrorObject> subErrorParam,
                       final String domainParam,
                       final String subdomainParam,
                       final String boundedContextParam,
                       final String microserviceParam,
                       final String messageParam,
                       final int errorCauseParam) {
        super();
        this.subError = subErrorParam;
        this.domain = domainParam;
        this.subdomain = subdomainParam;
        this.boundedContext = boundedContextParam;
        this.microservice = microserviceParam;
        this.message = messageParam;
        this.errorCause = errorCauseParam;
    }

    public ErrorObject addSubError(final ErrorObject errorObjectParam) {
        if (this.subError == null) {
            this.subError = new ArrayList<>();
        }
        this.subError.add(errorObjectParam);
        return this;
    }

    public List<ErrorObject> getSubError() {
        return this.subError;
    }


    public String getDomain() {
        return this.domain;
    }

    public ErrorObject setDomain(final String domainParam) {
        this.domain = domainParam;
        return this;
    }

    public String getSubdomain() {
        return this.subdomain;
    }

    public ErrorObject setSubdomain(final String subdomainParam) {
        this.subdomain = subdomainParam;
        return this;
    }

    public String getBoundedContext() {
        return this.boundedContext;
    }

    public ErrorObject setBoundedContext(final String boundedContextParam) {
        this.boundedContext = boundedContextParam;
        return this;
    }

    public String getMicroservice() {
        return this.microservice;
    }

    public ErrorObject setMicroservice(final String microserviceParam) {
        this.microservice = microserviceParam;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ErrorObject setMessage(final String messageParam) {
        this.message = messageParam;
        return this;
    }

    public int getErrorCause() {
        return this.errorCause;
    }

    public ErrorObject setErrorCause(final int errorCauseParam) {
        this.errorCause = errorCauseParam;
        return this;
    }

    public static void main(final String[] args) {
        ErrorObject errorObjectLoc = new ErrorObject().setBoundedContext(null)
                                                      .setDomain(null)
                                                      .setErrorCause(0)
                                                      .setSubdomain(null)
                                                      .setMessage(null);
    }


}
