package www.HealthyShop2023.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	private AuthInterceptor auth;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(auth)
		.addPathPatterns("/cart/view","/checkout.php","/profile.php","/orderhistory.php",
				"/admin/**");
	}
	
}
