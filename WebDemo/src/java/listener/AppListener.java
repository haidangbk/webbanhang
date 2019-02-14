/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import DAO.DBConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppListener implements ServletContextListener {

    // được gọi ngay khi khởi động web
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext app = sce.getServletContext();
        DBConfig.driver = app.getInitParameter("db.driver");
        DBConfig.user = app.getInitParameter("db.user");
        DBConfig.pass = app.getInitParameter("db.pass");
        DBConfig.url = app.getInitParameter("db.url");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
