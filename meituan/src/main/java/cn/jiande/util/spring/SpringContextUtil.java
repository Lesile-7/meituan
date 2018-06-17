package cn.jiande.util.spring;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/** 
* @author : MT
* @date 创建时间：2017年10月27日 上午9:44:27 
* @version 1.0 
*/
public class SpringContextUtil {
	private static ApplicationContext applicationContext;

	/** 
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量. 
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/** 
	 * 取得存储在静态变量中的ApplicationContext. 
	 */
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	/** 
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型. 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/** 
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型. 
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return (T) applicationContext.getBeansOfType(clazz);
	}

	/**
	 * 检测本类中的applicationContext是否为空
	 */
	private static void checkApplicationContext() {
		if (applicationContext == null)
			throw new IllegalStateException("applicaitonContext未注入,请在spring-mvc.xml中定义SpringContextUtil");
	}

	public static String getMessage(String key, HttpServletRequest request) {
		return applicationContext.getMessage(key, null, getLocal(request));
	}

	public static String getMessage(String key, String[] args, HttpServletRequest request) {
		return applicationContext.getMessage(key, args, getLocal(request));
	}

	public static Locale getLocal(HttpServletRequest request) {
		Locale locale = (Locale) request.getSession().getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		if (locale == null) {
			locale = request.getLocale();
		}

		return locale;
	}
}
