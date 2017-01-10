package q2.aop_v4.handler;

import java.lang.reflect.Method;

/**
 * Created by titansonia on 2017/1/3.
 */
public abstract class AroundHandler extends AbstractHandler {

    public abstract void handleAroundBefore(Object proxy, Method method, Object[] args);
    public abstract void handleAroundAfter(Object proxy, Method method, Object[] args);

}
