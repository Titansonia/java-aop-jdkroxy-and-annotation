package q2.aop_v4;

import q2.aop_v4.annotation.After;
import q2.aop_v4.annotation.Around;
import q2.aop_v4.annotation.Before;
import q2.aop_v4.annotation.JoinPoint;
import q2.aop_v4.aspect.Aspect;
import q2.aop_v4.handler.AbstractHandler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by titansonia on 2017/1/3.
 * 代理工厂，创建根据Annotation创建代理Bean
 *
 */
public class ProxyFactory {
    public static <T> T getProxyBean(Class<T> clazz) {
        T t = (T) newInstance(clazz);
        Method[] methods = clazz.getMethods();
        try {

            Boolean isAroundPresent = Aspect.class.getMethod("invoke", Object.class,
                    Method.class, Object[].class).isAnnotationPresent(Around.class);
            Boolean isBeforePresent = Aspect.class.getMethod("invoke", Object.class,
                    Method.class, Object[].class).isAnnotationPresent(Before.class);
            Boolean isAfterPresent = Aspect.class.getMethod("invoke", Object.class,
                    Method.class, Object[].class).isAnnotationPresent(After.class);

            AbstractHandler handler = (AbstractHandler) newInstance(Aspect.class);
            handler.setTargetObject(t);
            handler.setClassdName(t.getClass().getName());
            if (isAroundPresent || isBeforePresent || isAfterPresent) {

                for (int i = 0; i < methods.length; i++) {
                    if (methods[i].isAnnotationPresent(JoinPoint.class)) {
                        handler.setMethodNames(methods[i].getName());
                    }
                }
                t = (T) Proxy.newProxyInstance(t.getClass().getClassLoader(),
                        t.getClass().getInterfaces(), handler);
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return t;
    }

    private static Object newInstance(final Class clazz){
        try {
            Constructor cons = clazz.getConstructor();
            return cons.newInstance(new Class[]{});
        } catch (SecurityException e) {
            e.printStackTrace();
        //} catch (NoSuchMethodException e) {
        //    e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        //} catch (InvocationTargetException e) {
        //    e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}