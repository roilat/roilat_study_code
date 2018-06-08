package cn.roilat.study.socket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class SalaryServerListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent sce) {
		/*SalaryServer salaryServer = new SalaryServer();
		try {
			salaryServer.startSalaryServer();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
		/*SalaryServer salaryServer = new SalaryServer();
		try {
			salaryServer.stopSalaryServer();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
	
}