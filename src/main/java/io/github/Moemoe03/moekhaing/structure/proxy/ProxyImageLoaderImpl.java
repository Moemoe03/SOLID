package io.github.Moemoe03.moekhaing.structure.proxy;

public class ProxyImageLoaderImpl implements ImageLoader {

	private static ImageLoaderImpl imageLoaderImpl;
	
	public ProxyImageLoaderImpl(String path) {
		if (imageLoaderImpl==null) imageLoaderImpl = new ImageLoaderImpl(path);
	}
	
	@Override
	public void load() {
		// TODO Auto-generated method stub
		imageLoaderImpl.load();
	}
}