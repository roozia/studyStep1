package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    // @Slf4j 어노테이션으로 log를 사용할 수 있다. (Lombok이 자동으로 제공)
    // private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "spring";

        System.out.println("name = " + name);
        //log.info("info log=" + name);
        log.trace("trace my log=" + name); // 지양, Log level에 따라 출력 x 상태로 연산만 할 수 있다. (리소스 사용)

        log.trace("trace log={}", name); // 출력하지 않을 경우 연산도 진행되지 않는다.
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }

}
