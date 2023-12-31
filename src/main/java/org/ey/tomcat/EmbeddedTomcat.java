package org.ey.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Component
public class EmbeddedTomcat {

    @Value("${tomcat.web.content.folder.path:src/main/webapp/}")
    private String webContentFolder;

    @Value("${tomcat.web.base.folder.path:target/}")
    private String webBaseFolder;

    @Value("${tomcat.port:7070}")
    private String port;

    private Tomcat tomcat = new Tomcat();

    @PostConstruct
    public void start() throws Exception {

        System.setProperty("org.apache.catalina.startup.EXIT_ON_INIT_FAILURE", "true");
        tomcat.setPort(Integer.valueOf(port));
        tomcat.setBaseDir(webBaseFolder);
        StandardContext ctx = (StandardContext) tomcat.addWebapp("", webContentFolder);
        ctx.setParentClassLoader(AppLauncher.class.getClassLoader());
        tomcat.start();
        System.out.println("Tomcat Server Started at " + new Date());
        tomcat.getServer().await();

    }

    @PreDestroy
    public void stop() throws LifecycleException {

        tomcat.stop();
    }

}