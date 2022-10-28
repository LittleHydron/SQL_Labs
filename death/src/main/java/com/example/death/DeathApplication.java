package com.example.death;

import com.example.death.view.MyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DeathApplication implements CommandLineRunner {
    @Autowired
    private MyView myView;

    public static void main(String[] args) {
        SpringApplication.run(DeathApplication.class, args);
    }

    @Override
    public void run(String ...args) throws Exception{
        myView.show();
    }

}
