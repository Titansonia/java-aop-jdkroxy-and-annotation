package q2.aop_v4;

/**
 * Created by titansonia on 2016/11/22.
 */
public interface Subject {
    void publish(String key, String content);
    String subscribe(String key);
    void test();
}
