/**
 * 
 */
package com.rising.controller;

/**
 * @author pg
 * @日期 2017-5-6
 */
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * 测试
 * 
 * @authorAngel(QQ:412887952)
 * 
 * @version v.0.1
 */

@Controller
public class HelloController {

	// 从 application.properties 中读取配置，如取不到默认值为HelloShanhy

	// @Value("${application.hello:Hello Angel}")

	private String hello;

	@RequestMapping("/helloJsp")
	public String helloJsp(Map<String, Object> map) {

		System.out.println("HelloController.helloJsp().hello=" + hello);
		this.hello = "so hello";
		map.put("hello", hello);

		return "helloJsp";

	}

}
