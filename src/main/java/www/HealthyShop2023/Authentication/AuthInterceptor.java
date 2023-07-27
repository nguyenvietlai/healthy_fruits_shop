package www.HealthyShop2023.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Service.sessionServices;
import www.HealthyShop2023.Utils.constant;

@Service
public class AuthInterceptor implements HandlerInterceptor {
	@Autowired
	private sessionServices session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String currentUrl = request.getRequestURI();
		Account acc = session.get(constant.CURRENT_USER);
		
		String error = "";
		if(acc == null) { 
			error = "Please login!";
		}

		else if(!acc.getAdmin() && currentUrl.startsWith("/admin/")) {
			error = "Access denied!";
			response.sendRedirect("/home.php?error=" + error);
			return false;
		}
		
		if(error.length() > 0) {
			session.set("security-uri", currentUrl);
			response.sendRedirect("/login.php?error=" + error);
			return false;
		}
		
		return true;
	}

}
