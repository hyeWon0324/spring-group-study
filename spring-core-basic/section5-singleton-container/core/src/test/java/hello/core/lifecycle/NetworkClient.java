package hello.core.lifecycle;

import org.springframework.beans.factory.InitializingBean;

public class NetworkClient implements InitializingBean {
    private String url;

    public NetworkClient() {
        System.out.println("생성자를 호출, url= " + url);
        connect();
        call("Initialized Connect Message");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
