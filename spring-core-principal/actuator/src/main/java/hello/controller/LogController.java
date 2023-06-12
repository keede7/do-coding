package hello.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class LogController {

    @GetMapping("/log")
    public String log() {
        log.trace("trace");
        log.info("info");
        log.debug("debug");
        log.error("error");
        log.warn("warn");
        return "ok";

    }
}
