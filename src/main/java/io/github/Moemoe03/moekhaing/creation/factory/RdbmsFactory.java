package io.github.Moemoe03.moekhaing.creation.factory;

public class RdbmsFactory {

	public Connection getDatabaseServer(Connector connector) {
		
		switch (connector) {
			case MySQL:
				return new MySQL();
			case MyOracle:
				return new MyOracle();
			default:
				return null;
		}
	}
}