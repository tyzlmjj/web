package me.majiajie.http.utils;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;

public class ServletUtil
{
    public static <T> T toModel(HttpServletRequest request,Class<T> typeClass)
    {
        T obj= null;

        try
        {
            obj = typeClass.newInstance();
            Enumeration<String> enumeration = request.getParameterNames();

            while(enumeration.hasMoreElements())
            {
                String paramName = enumeration.nextElement();
                String methodName = "set"+getMethodName(paramName);

                Class<?> fieldType = typeClass.getDeclaredField(paramName).getType();

                Method method = typeClass.getMethod(methodName,fieldType);

                method.invoke(obj,fieldType.cast(request.getParameter(paramName)));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return obj;
    }


    private static String getMethodName(String fildeName) {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
}
