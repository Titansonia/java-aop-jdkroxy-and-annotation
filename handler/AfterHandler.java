package q2.aop_v4.handler;


import java.lang.reflect.Method;

/**
 * Created by titansonia on 2017/1/3.
 */
public abstract class AfterHandler extends AbstractHandler {

    public abstract void handleAfter(Object proxy, Method method, Object[] args);

}
