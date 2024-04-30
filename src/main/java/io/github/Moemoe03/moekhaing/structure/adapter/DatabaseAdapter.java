package io.github.Moemoe03.moekhaing.structure.adapter;

import io.github.Moemoe03.moekhaing.creation.factory.Connection;
import io.github.Moemoe03.moekhaing.creation.factory.ModernDatabaseServer;
import lombok.Getter;

public class DatabaseAdapter implements Connection {

	@Getter
	private ModernDatabaseServer modernDatabaseServer;
	
	public DatabaseAdapter(ModernDatabaseServer modernDatabaseServer) {
		this.modernDatabaseServer = modernDatabaseServer;
	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub
		modernDatabaseServer.connectToDatabase();
	}
}
