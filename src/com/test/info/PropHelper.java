package com.test.info;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.test.util.ApplicationServers;
import com.test.util.Log;
import com.test.util.ParseXml;

public class PropHelper {

	private final static Properties properties = new Properties();

	private final static ApplicationServers as=new ApplicationServers();
	
	public final static String browser;

	// public final static String FIREFOX_DRIVER;

	public final static String FIREFOX_DRIVER = PropHelper.getProperty("path.webdriver.firefox");

	public final static String CHROME_DRIVER;

	public final static String SERVER_INFO;

	public final static String URL;
	public final static String USERNAME;
	public final static String PASSWORD;

	public final static int waitTime;

	public final static boolean ENABLE_FILE_DOWNLOAD = Boolean.parseBoolean(PropHelper.getProperty("download.enable"));

	private static boolean hasload = false;

	public static Log log = new Log(PropHelper.class);

	/*
	 * static { ParseXml px=new ParseXml("config/config.xml"); browser
	 * =px.getElementText("config/browser"); System.out.println(browser);
	 * log.info("the browser is : "+browser); waitTime
	 * =Integer.valueOf(px.getElementText("config/waitTime"));
	 * log.info("the waitTime is : "+waitTime); }
	 */

	static {
		getProrerties();		
		browser = properties.getProperty("browser");
		waitTime = Integer.parseInt(properties.getProperty("waittime"));
		// FIREFOX_DRIVER=properties.getProperty("path.webdriver.firefox");
		CHROME_DRIVER = properties.getProperty("path.webdriver.chrome");
		SERVER_INFO = properties.getProperty("server.info");
		getServersInfoJson(SERVER_INFO);
		URL=as.getUrl();
		USERNAME=as.getUsername();
		PASSWORD=as.getPassword();
	}

	public static void getProrerties() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("config/config.properties");
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void getServersInfoJson(String json) {
		
		List<Object> list=new ArrayList<>();
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("config/"+json);
			String text = IOUtils.toString(inputStream, "utf8");
			Field[] fields=ApplicationServers.class.getDeclaredFields();
			JSONObject jobj = JSON.parseObject(text);
			JSONArray arr = jobj.getJSONArray("applicationServers");
			List<ApplicationServers> listBeans = JSON.parseArray(arr.toString(), ApplicationServers.class);
			// 遍历
			for (ApplicationServers bean : listBeans) {
				list.add(bean.getId());
				list.add(bean.getName());
				list.add(bean.getUrl());
				list.add(bean.getUsername());
				list.add(bean.getPassword());
			}
			
			for (int i=0;i<fields.length;i++) {
				try {
					fields[i].setAccessible(true);
					fields[i].set(as, list.get(i));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

	}

	private static void load(String filePath) {
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static boolean load() {
		String txt = System.getProperty("config.prop", "config.properties");
		load("config/" + txt);
		return true;
	}

	public static String getProperty(String key) {
		if (!hasload) {
			hasload = load();
		}
		return System.getProperty(key, properties.getProperty(key));
	}

	public static void main(String[] args) {
		getProrerties();
		String txt = System.getProperty("config.prop", "config.properties");
		System.out.println("config/" + txt);
		System.out.println(PASSWORD);
		System.out.println(URL);
		System.out.println(USERNAME);
	}

}
