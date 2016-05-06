import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 16-5-6.
 */
public class test
{
    @Test
    public void test() throws NoSuchMethodException
    {
        Method method = me.majiajie.http.Test.class.getDeclaredMethod("setName",Object.class);
//        Method[] methods = me.majiajie.http.Test.class.getMethods();
//        for (Method m:
//             methods) {
//            System.out.println(m.getName());
//        }


    }
}
