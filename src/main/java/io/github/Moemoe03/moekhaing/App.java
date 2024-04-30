package io.github.Moemoe03.moekhaing;

import java.util.List;

import io.github.Moemoe03.moekhaing.creation.bulider.Person;
import io.github.Moemoe03.moekhaing.creation.factory.Connection;
import io.github.Moemoe03.moekhaing.creation.factory.Connector;
import io.github.Moemoe03.moekhaing.creation.factory.ModernDatabaseServer;
import io.github.Moemoe03.moekhaing.creation.factory.MyOracle;
import io.github.Moemoe03.moekhaing.creation.factory.MySQL;
import io.github.Moemoe03.moekhaing.creation.factory.RdbmsFactory;
import io.github.Moemoe03.moekhaing.creation.singleton.Singleton;
import io.github.Moemoe03.moekhaing.structure.composite.Circle;
import io.github.Moemoe03.moekhaing.structure.composite.Graphics;
import io.github.Moemoe03.moekhaing.structure.composite.Line;
import io.github.Moemoe03.moekhaing.structure.composite.Point;
import io.github.Moemoe03.moekhaing.structure.flyWeight.Player;
import io.github.Moemoe03.moekhaing.structure.flyWeight.PlayerFactory;
import io.github.Moemoe03.moekhaing.structure.flyWeight.PlayerType;
import io.github.Moemoe03.moekhaing.structure.flyWeight.Weapon;
import io.github.Moemoe03.moekhaing.structure.proxy.ImageLoader;
import io.github.Moemoe03.moekhaing.structure.proxy.ProxyImageLoaderImpl;

public class App {
	
    public static void main( String[] args ) {
        //Singleton();
    	//Factory();
    	//AbstractFactory();
    	//Builder();
    	//Adapter();
        //Composite();
    	//Proxy();
    	FlyWeight();
    }
    	
   
    public static void Singleton() {
    	Singleton.getInstance();
    	Singleton.getInstance();
    	Singleton.getInstance();
    }
    public static void Factory() {
        Singleton dependencyRegistry = Singleton.getInstance();
    	
    	RdbmsFactory factory = dependencyRegistry.getRdbmsFactory();
    	Connection mySQL = factory.getDatabaseServer(Connector.MySQL);
    	Connection myOracle = factory.getDatabaseServer(Connector.MyOracle);
    	
    	List<Connection> connections = List.of(mySQL, myOracle);
    	
    	for (Connection out: connections) {
    		out.connect();
    	}
    	
    }
    public static void AbstractFactory() {
		Singleton dependencyRegistry = Singleton.getInstance();
    	Singleton.getInstance();
    	
    	Connection mySQL = dependencyRegistry.getAbstractRdbmsFactory(new MySQL()).getDatabaseServer();
    	Connection myOracle = dependencyRegistry.getAbstractRdbmsFactory(new MyOracle()).getDatabaseServer();
    	
    	List<Connection> connections = List.of(mySQL, myOracle);
    	
    	for (Connection out: connections) {
    		out.connect();
    	}
	}
    public static void Builder() {
    	Person prn = new Person.PersonBuilder("Aye Chan", 30)
    			.setHasNRC(true)
    			.setHasPassport(false)
    			.build();
    	
    	System.out.println(prn.toString());
    }
    public static void Adapter() {
    	Singleton dependencyRegistry = Singleton.getInstance();
    	Singleton.getInstance();
    	
    	Connection mySQL = dependencyRegistry.getAbstractRdbmsFactory(new MySQL()).getDatabaseServer();
    	Connection myOracle = dependencyRegistry.getAbstractRdbmsFactory(new MyOracle()).getDatabaseServer();
    	Connection modernDatabaseServer = dependencyRegistry.getConnection(new ModernDatabaseServer());
    	
    	List<Connection> connections = List.of(mySQL, myOracle, modernDatabaseServer);
    	
    	for (Connection out: connections) {
    		out.connect();
    	}
    }
    public static void Composite() {
        Point point = new Point(5, 5);
    	
    	Line line = new Line(0, 0);
    	line.move(1, 1);
    	
    	Circle circle = new Circle(1, 1, 5.3);
    	
    	List<Graphics> graphics = List.of(point, line, circle);
    	
    	for (Graphics out: graphics) {
    		out.draw();
    	}
    }
    public static void Proxy() {
    	/*
		 * String path = "C:\\Users\\User\\Desktop\\image.jpg";
		 * 
		 * ImageLoader img1 = new ImageLoaderImpl(path); ImageLoader img2 = new
		 * ImageLoaderImpl(path);
		 * 
		 * List<ImageLoader> imgs = List.of(img1, img2);
		 * 
		 * for(ImageLoader out: imgs) { out.load(); }
		 */
    	
    	String path = "C:\\Users\\User\\Desktop\\image1.jpg";
    	ImageLoader img1 = new ProxyImageLoaderImpl(path);
    	ImageLoader img2 = new ProxyImageLoaderImpl(path);
    	
    	List<ImageLoader> imgs = List.of(img1, img2);
    	
    	for(ImageLoader out: imgs) {
    		out.load(); 
    	}
    }
    public static void FlyWeight() {
    	Player player1 = PlayerFactory.getPlayer(PlayerType.Terrorist);
    	player1.assignWeapon(Weapon.Knife);
    	//player1.mission();
    	
    	Player player2 = PlayerFactory.getPlayer(PlayerType.CounterTerrorist);
    	player2.assignWeapon(Weapon.Pistol);
    	//player2.mission();
    	
    	Player player3 = PlayerFactory.getPlayer(PlayerType.CounterTerrorist);
    	player3.assignWeapon(Weapon.MachineGun);
    	//player3.mission();
    	
    	Player player4 = PlayerFactory.getPlayer(PlayerType.Terrorist);
    	player4.assignWeapon(Weapon.Pistol);
    	//player4.mission();
    	
    	List<Player> players = List.of(player1, player2, player3, player4);
    	
    	for(Player out: players) {
    		out.mission();
    	}
    }
 
}
    
