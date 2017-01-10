package q2.aop_v4.handler;

import java.lang.reflect.Method;

/**
 * Created by titansonia on 2017/1/3.
 */
public class AfterHandlerImpl extends AfterHandler {
    String methodName = "";

    @Override
    public void handleAfter(Object proxy, Method method, Object[] args) {
        String className = method.getDeclaringClass().getName();
        String methodName = method.getName();
        System.out.println("---------After execution of "+ className + "#" + methodName+"\n");

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        methodName = method.getName().toString();
        if (getMethodNames().contains(methodName)) {
            Object result = method.invoke(getTargetObject(), args);
            handleAfter(proxy, method, args);
            return result;
        } else {
            Object result = method.invoke(getTargetObject(), args);
            return result;
        }
    }
}
