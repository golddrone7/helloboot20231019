package tobyspring.study;


import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import tobyspring.helloboot.HelloController;
import tobyspring.helloboot.HelloService;
import tobyspring.helloboot.HellobootApplication;
import tobyspring.helloboot.SimpleHelloService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 구성 정보
@Configuration
@ComponentScan
public class StudyApplication {

    @Bean
    public ServletWebServerFactory servletWebServerFactory(){
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet(){
        return new DispatcherServlet();
    }

    // 팩토리 메서드를 통해 빈을 만들어라
    @Bean
    public StudyController studyController(StudyService studyService){
        return new StudyController(studyService);
    }
    @Bean
    public StudyService helloService(){
        return new SimpleStudyService();
    }

    public static void main(String[] args){
        MySpringApplication.run(HellobootApplication.class, args);
    }


}
