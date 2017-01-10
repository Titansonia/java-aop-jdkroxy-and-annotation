package q2.aop_v4.handler;

import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by titansonia on 2017/1/3.
 */
public abstract class AbstractHandler implements InvocationHandler{
    //要代理的目标对象
    private Object targetObject;
    //获得当前代理的方法
    private List<String> methodNames = new ArrayList<>();
    //获得当前代理的类
    private String className;


    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }
    public Object getTargetObject(){
        return this.targetObject;
    }

    public void setMethodNames(String methodName){
        this.methodNames.add(methodName);

    }
    public List<String> getMethodNames(){
        return this.methodNames;
    }

    public void setClassdName(String className){
        this.className = className;
    }
    public String getClassName(){
        return this.className;
    }

}
