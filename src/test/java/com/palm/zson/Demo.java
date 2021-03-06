package com.palm.zson;

/**
 * Description: 专为测试人员打造的JSON解析器
 * @see github地址：https://github.com/zhangfei19841004/zson 
 */
public class Demo {

	public static void main(String[] args) {
		String s = "[{ \"firstName\": {\"a\":\"Eric\",\"b\":\"zhouqi\"}, \"lastName\": \"Clapton\", \"instrument\": \"guitar\" },{ \"firstName\": \"Sergei\", \"lastName\": \"Rachmaninoff\", \"instrument\": \"piano\" }] ";
		String s1 = "[0,1,2,\"[]3\",\"\"]";
		String s2 = "[\"a\",\"b\",\"c\",\"d\",\"\"]";
		Zson z = new Zson();
		String j = "{\"a\":[\"a1\"],\"c\\\"b\":{\"a\":1},\"d\":[\"a\",{\"a\":[1,20]},{\"a\":2},\"\"],\"e\":\"b\"}";

		String j1 = "[\"\\\"\"]";
		ZsonResult zr1 = z.parseJson(j);
		System.out.println(zr1.getValues("//*[0]"));
		System.out.println(zr1.getValues("//*[1]"));
		System.out.println(zr1.getValues("/a//*[0]"));
		System.out.println(zr1.getValues("//*[0]"));
		System.out.println(zr1.getList("/d"));

		
		ZsonResult zr2 = z.parseJson(s);
		System.out.println("zr2---"+zr2.getValue("/*[1]/firstName"));
		System.out.println(zr2.getMap("/*[0]/firstName"));
		
		
		ZsonResult zr3 = z.parseJson(s1);
		System.out.println(zr3.getValue("/*[1]"));
		
		ZsonResult zr4 = z.parseJson(s2);
		System.out.println(zr4.getValue("/*[1]"));
		
		ZsonResult zr6 = z.parseJson(j1);
		System.out.println(zr6.getValue("/*[0]"));
		
	}

}
