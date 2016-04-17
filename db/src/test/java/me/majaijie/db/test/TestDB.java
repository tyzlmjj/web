package me.majaijie.db.test;

import me.majiajie.db.address;
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

    @Test
    public void saveUser()
    {
        UserEntity userEntity = new UserEntity();
        address a = new address();
        a.setHost("akk");
        a.setLocaltion("hz");
        userEntity.setS(a);
        userEntity.setPassword("22222");
        userEntity.setUsername("lw");

        session.save(userEntity);
    }

    @After
    public void destory()
    {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }



}
