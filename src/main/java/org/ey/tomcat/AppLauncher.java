package org.ey.tomcat;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppLauncher {

    public static void main(String[] ars) {
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
