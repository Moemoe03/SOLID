package io.github.Moemoe03.moekhaing.structure.proxy;

public class ImageLoaderImpl implements ImageLoader {

	private String path;
	
	public ImageLoaderImpl(String path) {
		System.out.println("Image is created!");
		this.path = path;
	}
	
	@Override
	public void load() {
		// TODO Auto-generated method stub
		System.out.println("Image is loaded at "+path+".");
	}

}
