package com.jacken.java_tomcat.tomcat;

import com.jacken.java_tomcat.servlet.IndexServlet;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * 使用java代码创建tomcat 服务器   实现springmvc的基本功能
 * 访问地址：
 * http://localhost:9090/java_tomcat/index?name=lisi
 */
public class Test001 {
    public static void main(String[] args) {
        //创建tomcat服务器
        Tomcat tomcatServer = new Tomcat();
        tomcatServer.setPort(9090);
        //是否设置自动部署
        tomcatServer.getHost().setAutoDeploy(false);
        //创建上下文
        StandardContext standardContext = new StandardContext();
        standardContext.setPath("/java_tomcat");
        //监听上下文
        standardContext.addLifecycleListener(new Tomcat.FixContextListener());
        tomcatServer.getHost().addChild(standardContext);
        //创建servlet 指定相对路径
        tomcatServer.addServlet("/java_tomcat","IndexServlet",new IndexServlet());
        //servlet 映射
        standardContext.addServletMappingDecoded("/index","IndexServlet");
        try {
            tomcatServer.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }

        System.out.println("tomcat  启动成功！！！");

        //异步接受请求
        tomcatServer.getServer().await();





    }
}
