package org.ey;

import org.ey.model.EntityManagerUtil;
import org.ey.model.User;
import org.ey.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.ey.tomcat.ServerConfig;

import javax.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = null;
        try {
            ctx = new AnnotationConfigApplicationContext();
            ctx.register(ServerConfig.class);

            ctx.refresh();
            ctx.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}