package lx.edu.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lx.edu.springmvc.interceptor.LoginIntercepter;


@Configuration
@EnableWebMvc
@ComponentScan("lx.edu.springmvc")
public class WebMvcConfig implements WebMvcConfigurer{

	@Bean
	public InternalResourceViewResolver jspResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	/*
	 * <interceptors>
		<interceptor>
			<mapping path="/addrbook_list.do"/>
			<mapping path="/insert.do"/>
			<beans:bean class="lx.edu.springmvc.interceptor.LoginIntercepter"></beans:bean>
		</interceptor>
	</interceptors>
	 */
	@Bean
	public LoginIntercepter loginIntercepter() {
		return new LoginIntercepter();
	}
	
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginIntercepter()).addPathPatterns("/addrbook_list.do", "/insert.do");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  //<resources mapping="/resources/**" location="/resources/" />
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	
}
