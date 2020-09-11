package org.example.springselenium.bag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("application.properties")
@Component
public class Example {
    private final String urlPath;

    @Autowired
    public Example(@Value("${url.path}") String urlPath) {
        this.urlPath = urlPath;
    }

    public void load() {
        System.out.println("implementing the load method......");
        System.out.println("URL PATH: " + urlPath);
    }
}
