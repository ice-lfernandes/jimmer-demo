package br.com.ldf.medium.jimmer_demo;

import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JimmerDemoApplication {

    @Autowired
    private JSqlClient sqlClient;

    public static void main(String[] args) {
        SpringApplication.run(JimmerDemoApplication.class, args);
    }

}
