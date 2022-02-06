package additional.aspects;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;

import static java.lang.System.out;

public class Logger {
    private ApplicationContext applicationContext;

    public void afterThrowing(Exception ex, JoinPoint joinPoint) {

        out.println("***********************************");
        out.println("*********** Log : error ***********");
        out.println("Exception : " + ex.getMessage());
        out.println("Class : " + ex.getClass());
        out.println("Method : " + joinPoint.getSignature().getName());
        out.println("Date/Time : " + LocalDateTime.now());
        out.println("***********************************");
    }


    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
