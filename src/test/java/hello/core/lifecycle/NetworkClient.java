package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// 인터페이스로 라이프 사이클 관리하는 방법은 잘 쓰이지 않음
//public class NetworkClient implements InitializingBean, DisposableBean {
public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connet url = " + url);
    }

    public void call(String message) {
        System.out.println("call:" + url + "message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect() {
        System.out.println("disconnect url = " + url);
    }

    // 스프링 빈이 생성되고 난 후 호출
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("NetworkClient.afterPropertiesSet");
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    // 스프링 빈이 종료되기 전에 호출
//    @Override
//    public void destroy() throws Exception {
//        System.out.println("NetworkClient.destroy");
//        disconnect();
//    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
