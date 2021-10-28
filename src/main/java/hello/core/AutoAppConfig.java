package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member", // 컴포넌스 스캔할 패키지의 시작 위치를 지정한다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 예시로 만든 AppConfig제외
)  // @Component 어노테이션이 붙은 것들을 다 스프링빈으로 등록해준다.
public class AutoAppConfig {

}
