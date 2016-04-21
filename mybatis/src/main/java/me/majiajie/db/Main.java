package me.majiajie.db;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ResourceBundle;

public class Main
{

    private static ResourceBundle resourceBundle;

    private static SqlSessionFactory sqlSessionFactory;

    static
    {
        resourceBundle = ResourceBundle.getBundle("config");
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static ResourceBundle getResourceBundle()
    {
        return resourceBundle;
    }

	public static void main(String[] args)
    {

	}
}