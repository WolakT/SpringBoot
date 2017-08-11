package pl.sda.name;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by RENT on 2017-08-11.
 */

@SpringBootApplication(scanBasePackages = "pl.sda")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(pl.sda.name.Application.class, args);
    }
}