package org.example.springselenium;

import org.example.springselenium.config.Config;
import org.example.springselenium.bag.Example;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Config.class)
public class TestInjection {
    @Test
    public void hereWeGo(@Autowired Example example) {
        example.load();
    }
}
