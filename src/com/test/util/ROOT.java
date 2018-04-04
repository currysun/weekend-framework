package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.*;

public class ROOT {
	private List<ApplicationServers> applicationServers;

	public void setApplicationServers(List<ApplicationServers> applicationServers) {
		this.applicationServers = applicationServers;
	}

	public List<ApplicationServers> getApplicationServers() {
		return this.applicationServers;
	}

	public static void ReadWithFastJson() throws IOException {

		InputStream inputStream = new FileInputStream("config/TestEnv.json");
		String text = IOUtils.toString(inputStream, "utf8");
		//System.out.println(text);
		// 把字符串转为Json对象，这是因为我的json数据首先是json对象
		JSONObject jobj = JSON.parseObject(text);
		// 然后是jsonArray，可以根据我的json数据知道
		JSONArray arr = jobj.getJSONArray("applicationServers");
		// 根据Bean类的到每一个json数组的项
		List<ApplicationServers> listBeans = JSON.parseArray(arr.toString(), ApplicationServers.class);
		// 遍历
		for (ApplicationServers bean : listBeans) {
			// 我这个demo的json数据获得第一层的数据
			System.out.println(bean.getUrl());
			System.out.println(bean.getUsername());
			System.out.println(bean.getPassword());
			// 我这个demo的json数据获得第二层的数据
		}

	}

	public static void main(String[] args) {
		try {
			ReadWithFastJson();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
