package hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class TracfficController {

    @GetMapping("cpu")
    public String cp() {
        log.info("cpu");
        long value = 0;
        for(long i =0; i < 1000000000000L; i++) {
            value++;
        }
        return "ok value="+value;
    }

    List<String> list =new ArrayList<String>();
    @GetMapping("jvm")
    public String jvm() {
        log.info("jvm");

        for(int i =0; i< 1000000; i++) {
            list.add("hgfdg" + i);
        }
        return "ok";
    }

    @Autowired
    DataSource dataSource;
    public String jdbc() throws Exception {
        log.info("jdbc");
        Connection con = dataSource.getConnection();
        log.info("connection info ={}", con);
                // close()를 하지않는다.
        return "ok;";
    }

    @GetMapping("/error-log")
    public String errorlog(){
        log.error("error log");
        return "error";
    }
}
