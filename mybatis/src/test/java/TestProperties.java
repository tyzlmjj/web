import me.majiajie.db.Main;
import org.junit.Test;

public class TestProperties
{
    @Test
    public void getProperties()
    {
        String s = Main.getResourceBundle().getString("MyBatis.url");

        System.out.print(s);
    }
}
