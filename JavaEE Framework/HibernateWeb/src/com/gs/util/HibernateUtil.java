package com.gs.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	 private static final SessionFactory sessionFactory = buildSessionFactory();
	
	/**
	 * ��ȡ���ڴ���Session���ӵĹ�����
	 * @return
	 */
	public static SessionFactory buildSessionFactory() {
		// Configureation���Ǹ����ȡhibernate.cfg.xml�ļ���һ���࣬�����������ļ�
		Configuration configuration = new Configuration().configure(); 
		// ��hibernate��ȡ�������ļ�����ȡ����ע����
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties()).build();
		// �ɷ���ע������ȡSessionFactory����
		return configuration.buildSessionFactory(serviceRegistry); 
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
