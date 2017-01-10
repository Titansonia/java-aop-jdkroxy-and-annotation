package q2.aop_v4;


import q2.aop_v4.annotation.JoinPoint;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by titansonia on 2016/11/22.
 */
//具体的实现，在代理模式中它的实例被称为target
public class RealSubject implements Subject {
    private Map<String,String> msg = new ConcurrentHashMap<String,String>();

    //接合点 joinpoint
    @JoinPoint
    public void publish(String key, String content) {
        System.out.println("publish msg key is "+key+", content is "+ content);
        msg.put(key,content);

    }

    //joinpoint
    @JoinPoint
    public String subscribe(String key) {
        if (msg.containsKey(key)){
            String ret = msg.get(key);
            System.out.println("subscribe msg key is "+key+", result is "+ ret);
            return ret;
        }
        return null;
    }

    public void test(){
        System.out.println("\nNo proxy methods. Not joinpoint");
    }

}
