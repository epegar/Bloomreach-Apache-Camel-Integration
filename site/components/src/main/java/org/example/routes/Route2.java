package org.example.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Route2 extends RouteBuilder {

    @Override
    public void configure() {
        // subscribe on publish/edit workflow events
        from("hippoevent:?category=workflow&action=depublish")
                //.convertBodyTo(String.class)
                //.convertBodyTo(JSON.class)
                .log(LoggingLevel.ERROR, log, "Processing event, headers: ${headers} \n body: ${body}")
                .routeId("route2");
    }

}
