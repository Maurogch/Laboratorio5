package edu.utn.ExecutorServiceThreadPools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ExecutorServiceThreadPoolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExecutorServiceThreadPoolsApplication.class, args);
	}

}
