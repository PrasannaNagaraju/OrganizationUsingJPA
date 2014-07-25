import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import play.Application;
import play.GlobalSettings;


public class Global extends GlobalSettings {
	static ApplicationContext ctx;
	@Override
	public void onStart(Application app)
	{
		System.out.println("Application started...!");
	    String springConfigurationName = "Beans.xml";
	    ctx = new ClassPathXmlApplicationContext(springConfigurationName);
	    play.Logger.debug("Loading spring configuration: {}", springConfigurationName);
	}

	@Override
	public <A> A getControllerInstance(Class<A> clazz)
	{
	    return ctx.getBean(clazz);
	}	
}
