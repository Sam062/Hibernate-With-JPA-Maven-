package in.nit.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import in.nit.config.AppDbConfig;
import in.nit.config.AppWebConfig;

//FC: DispatcherServlet using  Annotation Configuration starter
public class AppInit 
	extends AbstractAnnotationConfigDispatcherServletInitializer
{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		//DB Config File input to FC
		return new Class[] {AppDbConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		//MVC Config File input to FC
		return new Class[] {AppWebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		//URL Pattern
		return new String[] {"/"};
	}

}
