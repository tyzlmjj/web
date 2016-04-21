import me.majiajie.db.Main;
import me.majiajie.db.Mapper.UserMapper;
import me.majiajie.db.entity.UserEntity;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDB
{

    private SqlSession sqlSession;

    @Before
    public void init()
    {
        sqlSession = Main.getSqlSessionFactory().openSession();
    }

    @After
    public void close()
    {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectUser()
    {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserEntity userEntity = userMapper.selectUser(1);
        System.out.print("password"+userEntity.getPassword());
    }
}
