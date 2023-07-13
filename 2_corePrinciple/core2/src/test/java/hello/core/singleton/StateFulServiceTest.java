package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void statefuServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService stateFulService1 = ac.getBean(StateFulService.class);
        StateFulService stateFulService2 = ac.getBean(StateFulService.class);

        // ThreadA : A사용자 10000 주문
        int userAPrice = stateFulService1.order("userA", 10000);
        // ThreadB : B사용자 20000 주문
        int userBPrice = stateFulService2.order("userB", 20000);

        //ThreadA : 사용자A 주문금액 조회
        int price = userAPrice;
        System.out.println("price = "+ price);

        Assertions.assertThat(price).isEqualTo(10000);
    }

    static class  TestConfig{

        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }

}