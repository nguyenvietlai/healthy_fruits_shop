package www.HealthyShop2023.Utils;

import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Service.sessionServices;

public class ManagerUser {
	public static  Account checklogin(sessionServices sessionservice) {
		Account acc = sessionservice.get(constant.CURRENT_USER);
		return acc == null ? null : acc;
	}
}
