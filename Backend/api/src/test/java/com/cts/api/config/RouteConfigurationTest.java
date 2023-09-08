package com.cts.api.config;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cts.api.filter.TokenValidationFilter;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class RouteConfigurationTest {

    @Test
    void testRoutes3() throws BeansException {

        RouteConfiguration routeConfiguration = new RouteConfiguration(new TokenValidationFilter(null));
        AnnotationConfigApplicationContext annotationConfigApplicationContext = mock(
                AnnotationConfigApplicationContext.class);
        when(annotationConfigApplicationContext.getBean((Class<PathRoutePredicateFactory>) any()))
                .thenReturn(new PathRoutePredicateFactory());
        routeConfiguration.routes(new RouteLocatorBuilder(annotationConfigApplicationContext)).getRoutes();
        verify(annotationConfigApplicationContext, atLeast(1)).getBean((Class<PathRoutePredicateFactory>) any());
    }
}

