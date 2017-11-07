package com.sogeti.us;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class App 
{
    @Bean
    public Gson gson() {
        return new Gson();
    }

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
