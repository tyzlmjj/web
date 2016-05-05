import com.google.gson.Gson;
import me.majiajie.okhttp.Main;
import me.majiajie.okhttp.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class TestOkhttp
{
    Main main = new Main();

    Gson gson = new Gson();

    @Before
    public void start()
    {

    }

    @After
    public void finish()
    {

    }

    @Test
    public void Posttest() throws IOException
    {
        String str = main.post("http://localhost:8080/http/PostTest","");
        System.out.println(str);
    }

    @Test
    public void Jsontest()
    {

        Student student = new Student();

        student.setId(2);
        student.setName("大白");

        String jsonStr = gson.toJson(student);

        System.out.println(jsonStr);

    }

    @Test
    public void Jsontest2() throws IOException
    {
        String str = main.post("http://localhost:8080/http/PostTest","");
        Student student = gson.fromJson(str,Student.class);

        System.out.println(student.toString());
    }

    @Test
    public void OkhttpTest()
    {
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.connectTimeout(3000, TimeUnit.MILLISECONDS);
//        builder.readTimeout(3000, TimeUnit.MILLISECONDS);

//        OkHttpUtil.okHttpClient
//        System.out.println(OkHttpUtil.okHttpClient == null);
    }





}
