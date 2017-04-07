package it.polito.ai.lab2;

import org.hibernate.*;
import org.hibernate.boot.*;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

import it.polito.ai.lab2.entities.*;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();

	public static SessionFactory buildSessionFactory() {
		// TODO Auto-generated method stub
		try {
		ServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySetting(Environment.DRIVER, "org.postgresql.Driver")
				.applySetting(Environment.USER, "postgres")
				.applySetting(Environment.PASS, "ai-user-password")
				.applySetting(Environment.URL, "jdbc:postgresql://localhost/trasporti")
				.applySetting(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect")
				.applySetting(Environment.HBM2DDL_AUTO, "validate")
				.applySetting(Environment.FORMAT_SQL, "true")
				.applySetting(Environment.SHOW_SQL, "true")
				.applySetting(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread")
				.build();
		
		Metadata metadata = new MetadataSources(registry)
				.addAnnotatedClass(BusLine.class)
				.addAnnotatedClass(BusStop.class)
				.getMetadataBuilder()
				.applyImplicitNamingStrategy( ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
				.build();
		
		return metadata.getSessionFactoryBuilder().build();

		} catch (Throwable ex) {
			System.err.println("initial SessionFactory creation failed. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}