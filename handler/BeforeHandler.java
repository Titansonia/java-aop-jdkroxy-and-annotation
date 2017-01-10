package q2.aop_v4.handler;


import java.lang.reflect.Method;

/**
 * Created by titansonia on 2017/1/3.
 */
public abstract class BeforeHandler extends AbstractHandler {

    public abstract void handleBefore(Object proxy, Method method, Object[] args);


}
