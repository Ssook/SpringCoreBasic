package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {
    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)  // 스프링 컨테이너에 없는 빈, 자동 주입할 대상이 없으므로 실행 자체가 안됨
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);

        }

        @Autowired  // 스프링 컨테이너에 없는 빈, 호출은 되지만 null값을 가짐
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);

        }

        @Autowired  // 스프링 컨테이너에 없는 빈, 호출은 되지만 Optional.empty로 나옴
        public void setNoBean2(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);

        }
    }
}
