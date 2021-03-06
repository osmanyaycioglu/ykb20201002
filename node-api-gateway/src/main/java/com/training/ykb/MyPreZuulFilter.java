package com.training.ykb;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class MyPreZuulFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        HttpServletRequest requestLoc = RequestContext.getCurrentContext()
                                                      .getRequest();
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("PRE FILTER");
        return null;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}
