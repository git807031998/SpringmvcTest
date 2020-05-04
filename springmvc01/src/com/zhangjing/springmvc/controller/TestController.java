package com.zhangjing.springmvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zhangjing.springmvc.model.User;

@Controller
@RequestMapping(value = { "testClass", "testClass01" })
public class TestController {

	@RequestMapping(value = "testMethod")
	public String test() {
		System.out.println("==test===");
		return "test";
	}

	@RequestMapping(value = "testMethod", method = RequestMethod.GET)
	public String test2() {
		System.out.println("=get=test===");
		return "test";
	}

	@RequestMapping(value = "testMethod", method = RequestMethod.POST)
	public String test3() {
		System.out.println("=post=test===");
		return "test";
	}

	@RequestMapping(value = "testMethodParam", params = { "username", "age" }, headers = { "!Accept-Language" })
	public String test4() {
		System.out.println("==test==param=header==");
		return "test";
	}

	/**
	 * testClass/testMethodPath/color/red
	 */

	@RequestMapping(value = "testMethodPath/{v_cata}/{v_color}")
	public String test5(@PathVariable("v_cata") String param1, @PathVariable("v_color") String param2) {
		System.out.println("==test==param=rest==");
		System.out.println(param1);
		System.out.println(param2);
		return "test";
	}

	/**
	 * testClass/testrequestparam?username=1&age=2&sex=f
	 */
	@RequestMapping(value = "testrequestparam")
	public String test6(@RequestParam("username") String p1,
			@RequestParam(value = "age", required = false, defaultValue = "0") int p2,
			@RequestParam(value = "sex", required = false) String p3,
			@RequestHeader(value = "Accept-Language") String acceptlang,
			@CookieValue(value = "JSESSIONID") String jsess) {

		System.out.println(p1 + p2 + p3 + acceptlang + jsess);
		return "test";

	}

	@RequestMapping("testUser")
	public String testUser(User user) {
		System.out.println(user);
		return "test";
	}

	@RequestMapping("testservletapi")
	public void test7(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		System.out.println("req:" + req);
		System.out.println("resp:" + resp);

		// req.getRequestDispatcher("/WEB-INF/views/hello.jsp").forward(req, resp);
		// resp.sendRedirect("http://www.baidu.com");
		resp.getWriter().print("xxxxxx");
	}

	/**
	 * 下载
	 */
	/**
	 * 使用HttpMessageConveter完成下载功能:
	 * 
	 * 支持 @RequestBody @ResponseBody HttpEntity ResponseEntity
	 * 
	 * 下载的原理: 将服务器端的文件 以流的形式 写到 客户端. ResponseEntity: 将要下载的文件数据，
	 * 以及响应信息封装到ResponseEntity对象中，浏览器端通过解析 发送回去的响应数据， 就可以进行一个下载操作.
	 */
	@RequestMapping("testdownload")
	public ResponseEntity<byte[]> testdownload(HttpSession session) throws Exception {
		byte[] imgs;

		// 将响应数据 以及一些响应头信息封装到ResponseEntity中
		/*
		 * 参数: 1. 发送给浏览器端的数据 2. 设置响应头 3. 设置响应码
		 */
		ServletContext sc = session.getServletContext();

		InputStream in = sc.getResourceAsStream("image/songlaoshi.jpg");

		imgs = new byte[in.available()];

		in.read(imgs);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment;filename=songlaoshi.jpg");
		HttpStatus statusCode = HttpStatus.OK; // 200
		ResponseEntity<byte[]> re = new ResponseEntity<byte[]>(imgs, headers, statusCode);
		return re;

	}

	@RequestMapping("/upload")
	public String testUpload(@RequestParam("desc") String desc, @RequestParam("uploadfile") MultipartFile uploadfile,
			HttpSession session) throws Exception {
		// 获取上传文件名
		String uploadfilename = uploadfile.getOriginalFilename();
		// 获取输入流
		InputStream in = uploadfile.getInputStream();
		// 获取服务器保存路径
		ServletContext sc = session.getServletContext();
		String realpath = sc.getRealPath("uploads");
		File targetfile = new File(realpath + "/" + uploadfilename);

		FileOutputStream os = new FileOutputStream(targetfile);

		// 写文件
		int i;
		while ((i = in.read()) != -1) {
			os.write(i);
		}

		in.close();
		os.close();

		// uploadFile.transferTo(targetFile);
		return "ok";
	}

}
