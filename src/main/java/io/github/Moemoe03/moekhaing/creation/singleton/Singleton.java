package io.github.Moemoe03.moekhaing.creation.singleton;

import io.github.Moemoe03.moekhaing.creation.abstract_factory.AbstractRdbmsFactory;
import io.github.Moemoe03.moekhaing.creation.factory.Connection;
import io.github.Moemoe03.moekhaing.creation.factory.ModernDatabaseServer;
import io.github.Moemoe03.moekhaing.creation.factory.RdbmsFactory;
import io.github.Moemoe03.moekhaing.structure.adapter.DatabaseAdapter;

public class Singleton {

	private static Singleton instance;
	
	private Singleton() {
		System.out.println("Created object!");
	}
	
	public static Singleton getInstance() {
		if (instance==null) {
			synchronized (Singleton.class) {
				instance = new Singleton();
			}
		}
		return instance;
	}
	
	public RdbmsFactory getRdbmsFactory() {
		return new RdbmsFactory();
	}
	
	public AbstractRdbmsFactory getAbstractRdbmsFactory(Connection connection) {
		return new AbstractRdbmsFactory(connection);
	}
	public Connection getConnection(ModernDatabaseServer modernDatabaseServer) {
		return new DatabaseAdapter(modernDatabaseServer);
	}
}