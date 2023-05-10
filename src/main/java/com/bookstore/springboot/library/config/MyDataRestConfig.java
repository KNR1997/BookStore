package com.bookstore.springboot.library.config;

import com.bookstore.springboot.library.entity.Book;
import com.bookstore.springboot.library.entity.Message;
import com.bookstore.springboot.library.entity.Review;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    private String theAllowedOrigins = "http://localhost:3000";

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnstopportedActions = {
                HttpMethod.POST,
                HttpMethod.PATCH,
                HttpMethod.DELETE,
                HttpMethod.PUT};

        config.exposeIdsFor(Book.class);
        config.exposeIdsFor(Review.class);
        config.exposeIdsFor(Message.class);

        disableHttpMethods(Book.class, config, theUnstopportedActions);
        disableHttpMethods(Review.class, config, theUnstopportedActions);
        disableHttpMethods(Message.class, config, theUnstopportedActions);

        /* Configure Cors Mapping */
        cors.addMapping(config.getBasePath() + "/**")
                .allowedOrigins(theAllowedOrigins);
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration().forDomainType(theClass).withItemExposure((metdata, httpMethods) ->
                httpMethods.disable(theUnsupportedActions)).withCollectionExposure((metdata, httpMethods) ->
                httpMethods.disable(theUnsupportedActions));
    }

}
