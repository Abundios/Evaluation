package org.pruebaEY.tomcat;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppLauncher {

    //private static final Logger log = Logger.getLogger(AppLauncher.class);

    public static void main(String[] ars) {
        AnnotationConfigApplicationContext ctx = null;
        try {
            ctx = new AnnotationConfigApplicationContext();
            ctx.register(ServerConfig.class);

            ctx.refresh();
            ctx.start();
        } catch (Exception e) {
            //log.error(e.getMessage(), e);
            System.out.println(e);
        }

    }

}
