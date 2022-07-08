package com.xworkz.ormModule;

import com.xworkz.ormModule.dao.MobileDAOImpl;

public class mobileRunner {

	public static void main(String[] args) {
		MobileDAOImpl mobileDAOImpl = new MobileDAOImpl();
		mobileDAOImpl.getAllMobiles();
	}

}
