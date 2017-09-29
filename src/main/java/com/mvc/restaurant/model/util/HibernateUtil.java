package com.mvc.restaurant.model.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY;

	static {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		SESSION_FACTORY = configuration.buildSessionFactory(standardServiceRegistry);
	}

	private HibernateUtil() {
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
