plugins {
    id("java")
}

group = "org.ey"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/javax.servlet/jstl
    //implementation("javax.servlet:jstl:1.2")
    // https://mvnrepository.com/artifact/javax.persistence/javax.persistence-api
    implementation("javax.persistence:javax.persistence-api:2.2")
    // https://mvnrepository.com/artifact/org.springframework/spring-web
    implementation("org.springframework:spring-web:4.3.11.RELEASE")
    // https://mvnrepository.com/artifact/org.springframework/spring-context
    implementation("org.springframework:spring-context:4.1.6.release")
    // https://mvnrepository.com/artifact/org.apache.tomcat/catalina
    //compileOnly("org.apache.tomcat:catalina:6.0.26")
    // https://mvnrepository.com/artifact/org.apache.tomcat/tomcat-catalina
    //implementation("org.apache.tomcat:tomcat-catalina:7.0.25")
    //implementation("org.apache.tomcat:tomcat-catalina:8.5.2")
    implementation("org.apache.tomcat:tomcat-catalina:8.5.97")
    //implementation("org.apache.tomcat:tomcat-jaspic-api:11.0.0-M15")
    // https://mvnrepository.com/artifact/org.springframework/spring-webmvc
    implementation("org.springframework:spring-webmvc:5.3.31")
    // https://mvnrepository.com/artifact/org.springframework/spring-web
    implementation("org.springframework:spring-web:3.0.2.RELEASE")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
    //implementation("com.fasterxml.jackson.core:jackson-core:2.16.1")
    // https://mvnrepository.com/artifact/com.fasterxml.jackson.dataformat/jackson-dataformat-xml
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.16.1")
    // https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa
    implementation("org.springframework.data:spring-data-jpa:2.4.4")
    // https://mvnrepository.com/artifact/org.hibernate/hibernate-core
    //implementation("org.hibernate:hibernate-core:4.1.5.Final")
    // https://mvnrepository.com/artifact/org.hibernate/hibernate-entitymanager
    //implementation("org.hibernate:hibernate-entitymanager:6.0.0.Alpha7")
    implementation("org.hibernate:hibernate-entitymanager:4.1.9.Final")
    // https://mvnrepository.com/artifact/org.hsqldb/hsqldb
    implementation("org.hsqldb:hsqldb:2.3.2")
    //https://mvnrepository.com/artifact/com.h2database/h2
    //testImplementation("com.h2database:h2:2.2.224")
    // https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp
    implementation("commons-dbcp:commons-dbcp:1.4")
    // https://mvnrepository.com/artifact/org.hibernate/hibernate-core
    implementation("org.hibernate:hibernate-core:4.1.9.Final")
    // https://mvnrepository.com/artifact/org.springframework.security/spring-security-web
    implementation("org.springframework.security:spring-security-web:5.2.1.RELEASE")
    // https://mvnrepository.com/artifact/org.springframework.security/spring-security-config
    implementation("org.springframework.security:spring-security-config:5.2.1.RELEASE")
    // https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt
    implementation("io.jsonwebtoken:jjwt:0.9.1")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")}

tasks.test {
    useJUnitPlatform()
}