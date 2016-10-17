package cn.apeius.usermanage.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

import java.awt.dnd.DropTarget;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

/**
 * Created by Asus on 2016/10/17.
 */
public class ApplicationEventListener implements ApplicationListener{
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        //容器关闭时触发的事件
        if(applicationEvent instanceof ContextClosedEvent){
            try {
                System.out.println("应用过程关闭");
                Enumeration<Driver> drivers = DriverManager.getDrivers();
                while(drivers.hasMoreElements()){
                    Driver driver = drivers.nextElement();
                    if(driver != null){
                        //DriverManager.getDriver(url)
                        DriverManager.deregisterDriver(driver);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
