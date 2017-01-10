package q2.aop_v4.handler;

import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Created by titansonia on 2017/1/3.
 */
public class AroundHandlerImpl extends AroundHandler {
    long startTime = 0;
    String methodName = "";

    @Override
    public void handleAroundBefore(Object proxy, Method method, Object[] args) {
        startTime = System.nanoTime();
        System.out.println("\n---------Before around execution of "+ getClassName() + "#" +
                methodName);

    }

    @Override
    public void handleAroundAfter(Object proxy, Method method, Object[] args) {
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Execution of " + getClassName() + "#" + methodName + " "
                + "ended in " + new BigDecimal(elapsedTime).divide(new BigDecimal(1000000))
                + " milliseconds");
        System.out.println("==========After around execution of "
                + getClassName() + "#"
                + methodName+"\n");

    }
    //@Around()
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        methodName = method.getName().toString();
        if (getMethodNames().contains(methodName)) {
            handleAroundBefore(proxy, method, args);
            Object result = method.invoke(getTargetObject(), args);
            handleAroundAfter(proxy, method, args);
            return result;
        } else {
            Object result = method.invoke(getTargetObject(), args);
            return result;
        }

    }


}
