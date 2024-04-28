package io.github.Moemoe03.moekhaing.creation.abstract_factory;

import io.github.Moemoe03.moekhaing.creation.factory.Connection;

public class AbstractRdbmsFactory {

	private Connection connection;
	
	public AbstractRdbmsFactory(Connection connection) {
		this.connection = connection;
	}
	
	public Connection getDatabaseServer() {
		return connection;
	}
}
