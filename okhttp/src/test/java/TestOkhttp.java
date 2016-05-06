import com.google.gson.Gson;
import me.majiajie.okhttp.Main;
import me.majiajie.okhttp.Student;
import me.majiajie.okhttp.f.OkHttpCallBack;
import me.majiajie.okhttp.f.OkHttpUtil;
import okhttp3.Call;
import okhttp3.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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
        Map<String,String> map = new HashMap<>();
        map.put("name","OkHttp");

        OkHttpUtil.doPost("https://localhost:8443/http/PostTest", map, new OkHttpCallBack() {
            @Override
            public void onFailure(Call call, IOException e) {
                super.onFailure(call, e);
                System.out.println("onFailure:"+e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                super.onResponse(call, response);
                System.out.println("body:"+response.body().string());
            }
        });
    }





}
