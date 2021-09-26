package com.toolc.stmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StmapApplication {
  public static final String APPLICATION_LOCATIONS = "spring.config.location="
    + "classpath:application.yaml,"
    + "classpath:aws.yaml";

  public static void main(String[] args) {
    new SpringApplicationBuilder(StmapApplication.class)
      .properties(APPLICATION_LOCATIONS)
      .run(args);
  }

}
