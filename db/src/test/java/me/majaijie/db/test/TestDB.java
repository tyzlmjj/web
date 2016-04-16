package me.majaijie.db.test;

import me.majiajie.db.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.*;

import java.io.File;
import java.nio.file.Files;

public class TestDB
{
    private Session session;
    private SessionFactory sessionFactory;
    private Transaction transaction;


    @Before
    public void init()
    {


        File file = new File("src\\main\\java\\hibernate.cfg.xml");
        System.out.print("绝对路径"+file.getAbsolutePath());
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .configure(file)
                .build();
        sessionFactory = new MetadataSources( serviceRegistry ).buildMetadata().buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

    }

    @Test
    public void saveUser()
    {
        UserEntity userEntity = new UserEntity();
//        userEntity.setId(2);
        userEntity.setPassword("11111");
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
