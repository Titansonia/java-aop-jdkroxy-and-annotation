package q2.aop_v4.aspect;


import q2.aop_v4.annotation.Around;
import q2.aop_v4.handler.AbstractHandler;

import java.lang.reflect.Method;
import java.math.BigDecimal;

/**
 * Created by titansonia on 2017/1/6.
 */
public class Aspect extends AbstractHandler {

    String methodName = "";
    long startTime = 0;

    //@Before
    //public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //    methodName = method.getName().toString();
    //    if (getMethodNames().contains(methodName)) {
    //        handleBefore(proxy,method,args);
    //        Object result = method.invoke(getTargetObject(), args);
    //        return result;
    //    }else{
    //        Object result = method.invoke(getTargetObject(), args);
    //        return result;
    //    }
    //}

    @Around
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


    //@After
    //public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //    methodName = method.getName().toString();
    //    if (getMethodNames().contains(methodName)) {
    //        Object result = method.invoke(getTargetObject(), args);
    //        handleAfter(proxy, method, args);
    //        return result;
    //    } else {
    //        Object result = method.invoke(getTargetObject(), args);
    //        return result;
    //    }
    //}


    //在handleAroundBefore方法中获得原方法执行前的时间
    public void handleAroundBefore(Object proxy, Method method, Object[] args) {
        startTime = System.nanoTime();
        System.out.println("\n---------Before around execution of "+ getClassName() + "#" +
                methodName);

    }
    //在handleAroundAfter方法中获得原方法执行耗时
    public void handleAroundAfter(Object proxy, Method method, Object[] args) {
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println("Execution of " + getClassName() + "#" + methodName + " "
                + "ended in " + new BigDecimal(elapsedTime).divide(new BigDecimal(1000000))
                + " milliseconds");
        System.out.println("==========After around execution of "
                + getClassName() + "#"
                + methodName+"\n");

    }

    //public void handleBefore(Object proxy, Method method, Object[] args) {
    //    System.out.println("\n---------Before execution of "+ getClassName() + "#" + methodName);
    //}
    //
    //public void handleAfter(Object proxy, Method method, Object[] args) {
    //    System.out.println("---------After execution of "+ getClassName() + "#" + methodName+"\n");
    //
    //}
    //
}
