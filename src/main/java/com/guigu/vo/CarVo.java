package com.guigu.vo;

public class CarVo {
	public Integer carId;
	public String carName;
	public String carPlatenumer;
	public String carState;
	public Integer carUser;
	public Integer carPrice;
	public Integer getCarId() {
		return carId;
	}
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarPlatenumer() {
		return carPlatenumer;
	}
	public void setCarPlatenumer(String carPlatenumer) {
		this.carPlatenumer = carPlatenumer;
	}
	public String getCarState() {
		return carState;
	}
	public void setCarState(String carState) {
		this.carState = carState;
	}
	public Integer getCarUser() {
		return carUser;
	}
	public void setCarUser(Integer carUser) {
		this.carUser = carUser;
	}
	public Integer getCarPrice() {
		return carPrice;
	}
	public void setCarPrice(Integer carPrice) {
		this.carPrice = carPrice;
	}
	@Override
	public String toString() {
		return "CarVo [carId=" + carId + ", carName=" + carName + ", carPlatenumer=" + carPlatenumer + ", carState="
				+ carState + ", carUser=" + carUser + ", carPrice=" + carPrice + "]";
	}
	public CarVo(Integer carId, String carName, String carPlatenumer, String carState, Integer carUser,
			Integer carPrice) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.carPlatenumer = carPlatenumer;
		this.carState = carState;
		this.carUser = carUser;
		this.carPrice = carPrice;
	}
	public CarVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}