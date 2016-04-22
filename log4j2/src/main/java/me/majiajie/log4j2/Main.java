package me.majiajie.log4j2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main
{
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args)
    {
        new Thread(){
            @Override
            public void run() {
                logger.trace("Entering application.");
                Test test = new Test();
                if (!test.doIt()) {
                    logger.error("Didn't do it.");
                }
                logger.trace("Exiting application.");
            }
        }.start();
    }
}
