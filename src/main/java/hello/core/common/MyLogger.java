package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // request스코프이므로 프록시모드를 통해서 가짜프록시빈 주입
public class MyLogger {
    private UUID uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "][" + requestURL + "]" + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID();
        System.out.println("[" + uuid + "] request scope create :" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope close :" + this);
    }
}
