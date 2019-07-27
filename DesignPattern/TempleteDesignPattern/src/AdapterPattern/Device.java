package AdapterPattern;

public  class Device implements DeviceController{
	
	DeviceAdapter deviceAdapter;


	public Device(String name) {
		if(name.equals("mouse")) {
			buildMouse();
		}
		else buildDevice(name);
	}

	private void buildMouse() {
		// TODO Auto-generated method stub
		System.out.println(" I create mouse");
	}

	@Override
	public void buildDevice(String name) {
		// TODO Auto-generated method stub
		deviceAdapter = new DeviceAdapter(name);
		deviceAdapter.buildDevice(name);
	}

}
