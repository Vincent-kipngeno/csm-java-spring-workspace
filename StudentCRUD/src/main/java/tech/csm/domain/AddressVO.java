package tech.csm.domain;

public class AddressVO {
	private String addressId;
	private String lane;
	private String city;
	private String state;
	private String zip;
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	public String getLane() {
		return lane;
	}
	public void setLane(String lane) {
		this.lane = lane;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	@Override
	public String toString() {
		return "AddressVO [addressId=" + addressId + ", lane=" + lane + ", city=" + city + ", state=" + state + ", zip="
				+ zip + "]";
	}
	
}
