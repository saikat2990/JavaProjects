package AdapterPattern;

public class DeviceAdapter implements DeviceController{

	ElectronicDevice electronicDevice;

	public DeviceAdapter(String name) {
		
	}
	
	
	public void buildDevice(String name) {
		// TODO Auto-generated method stub
		if(name.equals("laptop")) {
			electronicDevice = new Laptop();
			electronicDevice.buildLaptop();
		}else {
			electronicDevice = new Tv();
			electronicDevice.buildTv();
		}
		
	}

}
