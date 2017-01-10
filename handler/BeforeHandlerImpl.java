package q2.aop_v4.handler;


import java.lang.reflect.Method;

/**
 * Created by titansonia on 2017/1/3.
 */
public class BeforeHandlerImpl extends BeforeHandler {

    String methodName = "";
    @Override
    public void handleBefore(Object proxy, Method method, Object[] args) {
        System.out.println("\n---------Before execution of "+ getClassName() + "#" + methodName);
    }

    //@Before
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        methodName = method.getName().toString();
        if (getMethodNames().contains(methodName)) {
            handleBefore(proxy, method, args);
            Object result = method.invoke(getTargetObject(), args);
            return result;
        }else{
            Object result = method.invoke(getTargetObject(), args);
            return result;
        }
    }
}
