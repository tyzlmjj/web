package me.majaijie.db.test;

import me.majiajie.db.entity.UserEntityAddress;
import me.majiajie.db.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.*;

public class TestDB
{
    private Session session;
    private SessionFactory sessionFactory;
    private Transaction transaction;


    @Before
    public void init()
    {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources( serviceRegistry ).buildMetadata().buildSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( serviceRegistry );
        }

    }

    @After
    public void destory()
    {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    //-------默认提供的四个方法save、get、update、delete--------------------------------------//

    @Test
    public void saveUser()
    {
        UserEntity userEntity = new UserEntity();
        UserEntityAddress address = new UserEntityAddress();
        address.setPostcode(311200);
        address.setLocaltion("hz");
        userEntity.setAddress(address);
        userEntity.setPassword("22222");
        userEntity.setUsername("lw");

        session.save(userEntity);
    }


    @Test
    public void getUser()
    {
        UserEntity userEntity =  session.get(UserEntity.class,2);
        System.out.println("id:"+userEntity.getId());
        System.out.println("username:"+userEntity.getUsername());
        System.out.println("password:"+userEntity.getPassword());
        System.out.println("postcode:"+userEntity.getAddress().getPostcode());
        System.out.println("localtion:"+userEntity.getAddress().getLocaltion());
    }

    @Test
    public void updateUser()
    {
        UserEntity userEntity =  session.get(UserEntity.class,2);
        userEntity.setPassword("aasdasdasd");
        session.update(userEntity);
    }

    @Test
    public void deleteUser()
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(2);
        session.delete(userEntity);
    }


    //-------结束 默认提供的四个方法save、get、update、delete--------------------------------------//



    



}
