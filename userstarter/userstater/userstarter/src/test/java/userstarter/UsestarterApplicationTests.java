package userstarter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import autoc.service.RegisterService;

@SpringBootTest
public class UsestarterApplicationTests {

    @Autowired
    private RegisterService registerService;
    // @Autowired
    // private HelloService helloService;

    // @Test
    // void contextLoads() {
    // System.out.println(helloService.sayHello());
    //// registerService.register();
    // }

    @Test
    void testRegister() {
        registerService.register();
    }

}
