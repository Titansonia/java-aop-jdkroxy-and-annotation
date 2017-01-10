package q2.aop_v4;

/**
 * Created by titansonia on 2017/1/3.
 */
public class AOPMain {
    public static void main(String[] args){

        Subject proxy = ProxyFactory.getProxyBean(RealSubject.class);
        proxy.publish("key-1","content-1");
        proxy.subscribe("key-1");
        proxy.test();
    }
}
