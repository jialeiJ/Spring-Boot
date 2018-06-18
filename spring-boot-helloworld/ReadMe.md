入门篇
一、pom.xml中添加支持web的模块

	pom.xml文件中默认有两个模块：
	spring-boot-starter : 核心模块,包括自动配置支持、日志和YAML;
	spring-boot-starter-test : 测试模块,包括JUnit、Hamcrest、Mockito。
二、编写controller内容：

	@RestController 是controller里面的方法都以json格式输出,无需写jackjson配置
	启动主程序，打开浏览器访问http://localhost:8080/hello，就可以看到效果了，有木有很简单！
三、单元测试

	编写简单的http请求来测试；使用mockmvc进行，利用MockMvcResultHandlers.print()打印出执行结果。