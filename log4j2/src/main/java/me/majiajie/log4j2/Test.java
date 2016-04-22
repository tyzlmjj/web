package me.majiajie.log4j2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test
{
    static final Logger logger = LogManager.getLogger(Test.class.getName());

    public boolean doIt()
    {
        logger.entry();
        logger.error("Did it again!");
        return logger.exit(false);
    }
}
