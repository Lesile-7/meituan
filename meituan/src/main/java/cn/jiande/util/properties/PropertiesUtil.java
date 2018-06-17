package cn.jiande.util.properties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**  
*   
* PropertiesUtil.java  
*  
* @desc properties 资源文件解析工具  
* @author MT  
* @datatime 2017年10月21日 
*  
*/
public class PropertiesUtil {

	private Properties props;
	private URI uri;

	/**
	 * 指定读取某一个配置文件 以/开头表示从classpath下面开始找
	 * @param fileName
	 */
	public PropertiesUtil(String fileName) {
		readProperties(fileName);
	}

	/**
	 * 读取配置文件，传入文件路径以/开头
	 * @param fileName
	 */
	private void readProperties(String fileName) {
		try {
			props = new Properties();
			InputStream fis = getClass().getResourceAsStream(fileName);
			props.load(fis);
			uri = this.getClass().getResource(fileName).toURI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**   
	* 获取某个属性   
	*/
	public String getProperty(String key) {
		return props.getProperty(key);
	}

	/**   
	* 获取所有属性，返回一个map,不常用   
	* 可以试试props.putAll(t)   
	*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map getAllProperty() {
		Map map = new HashMap();
		Enumeration enu = props.propertyNames();
		while (enu.hasMoreElements()) {
			String key = (String) enu.nextElement();
			String value = props.getProperty(key);
			map.put(key, value);
		}
		return map;
	}

	/**   
	* 在控制台上打印出所有属性，调试时用。   
	*/
	public void printProperties() {
		props.list(System.out);
	}

	/**   
	* 写入properties信息   
	*/
	public void writeProperties(String key, String value) {
		try {
			OutputStream fos = new FileOutputStream(new File(uri));
			props.setProperty(key, value);
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			props.store(fos, "『comments』Update key：" + key);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PropertiesUtil util = new PropertiesUtil("/config/wechat.properties");
		util.printProperties();
	}
}