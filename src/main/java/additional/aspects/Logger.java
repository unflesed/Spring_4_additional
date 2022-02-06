package additional.aspects;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    private ApplicationContext applicationContext;

    public void afterThrowing(Exception ex) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\user\\IdeaProjects\\Spring_4_Additional\\src\\main\\java\\additional\\aspects\\log.txt"));
            String log = "***********************************\r\n" +
                         "*********** Log : error ***********\r\n" +
                         "Exception : " + ex.getMessage() + "\r\n" +
                         "Class : " + ex.getClass() + "\r\n" +
                         "Method : " + ex.getStackTrace()[0] + "\r\n" +
                         "Date/Time : " + LocalDateTime.now() + "\r\n" +
                         "***********************************" + "\r\n";
            bw.write(log);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
