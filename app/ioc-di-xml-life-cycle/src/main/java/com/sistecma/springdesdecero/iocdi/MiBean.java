package com.sistecma.springdesdecero.iocdi;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;

public class MiBean implements ApplicationContextAware,
ApplicationEventPublisherAware, BeanClassLoaderAware, BeanFactoryAware,
BeanNameAware, LoadTimeWeaverAware, MessageSourceAware,
NotificationPublisherAware, ResourceLoaderAware, InitializingBean, DisposableBean {

	public void customInit() {
        System.out.println("Metodo customInit() invocado...");
    }
 
    public void customDestroy(){
        System.out.println("Metodo customDestroy() invocado...");
    }

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
        System.out.println("Metodo destroy() invocado...");		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
        System.out.println("Metodo afterPropertiesSet() invocado...");		
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		// TODO Auto-generated method stub
        System.out.println("Metodo setResourceLoader() invocado...");			
	}

	@Override
	public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
		// TODO Auto-generated method stub
        System.out.println("Metodo setNotificationPublisher() invocado...");			
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		// TODO Auto-generated method stub
        System.out.println("Metodo setMessageSource() invocado...");			
	}

	@Override
	public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
		// TODO Auto-generated method stub
        System.out.println("Metodo setLoadTimeWeaver() invocado...");			
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
        System.out.println("Metodo setBeanName() invocado...");			
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
        System.out.println("Metodo setBeanFactory() invocado...");			
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		// TODO Auto-generated method stub
        System.out.println("Metodo setBeanClassLoader() invocado...");			
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		// TODO Auto-generated method stub
        System.out.println("Metodo setApplicationEventPublisher() invocado...");			
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
        System.out.println("Metodo setApplicationContext() invocado...");			
	}
	
	public String logicaNegocio() {
        return "Metodo logicaNegocio() invocado...";		
	}
}
