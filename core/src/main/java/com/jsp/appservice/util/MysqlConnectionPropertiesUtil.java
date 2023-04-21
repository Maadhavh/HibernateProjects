package com.jsp.appservice.util;

import java.util.Properties;

public class MysqlConnectionPropertiesUtil {
	public static Properties getConnectionProperties() {
		
		Properties properties = new Properties();
		properties.setProperty("connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/realm_db");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.connection.password","root");
		properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		
		//This property gives the query which is being created by Hibernate for every database operations.
		//Like select, insert,update,delete
		properties.setProperty("hibernate.show_sql", "true");
		
		//This property is not recommended at all in companies as it gives access to hibernate to modify the tables data.
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		
		
		return properties;
	}
	

}
