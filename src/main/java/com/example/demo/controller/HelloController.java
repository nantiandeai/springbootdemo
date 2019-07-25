package com.example.demo.controller;

import com.example.demo.domain.Resource;
import com.example.demo.utils.JSONResult;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.Servlet;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/24.
 *
 * @author frank
 */
@Controller
public class HelloController {
	@Value("${com.didispace.blog.name}")
	private String name;

	@Autowired
	private Resource resource;

	@GetMapping(value = "/say")
	public String sayHello(HttpSession session, HttpServletRequest request) {
        /*String id = session.getId();
        System.out.println(session.getId());
        Cookie [] cookie = request.getCookies();
        for (Cookie cookie1 : cookie) {
            System.out.println(cookie1.getName());
        }
        System.out.println(Arrays.toString(cookie));*/

		return "hello";
	}

	@GetMapping(value = "/getPath")
	@ResponseBody
	public List path(String uuid,HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(uuid);
		ServletOutputStream out = null;
		FileInputStream ips = null;
		if (uuid!=null) {
			try {
				//获取图片存放路径

				ips = new FileInputStream(new File(uuid));
				response.setContentType("multipart/form-data");
				out = response.getOutputStream();
				//读取文件流
				int len = 0;
				byte[] buffer = new byte[1024 * 10];
				while ((len = ips.read(buffer)) != -1){
					out.write(buffer,0,len);
				}
				out.flush();
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				out.close();
				ips.close();
			}
		}
		return null;

	}

	@RequestMapping(value = "/createuser")
	@ResponseBody
	public void crateUser() throws IOException {
		String cc = "ccui:123456";
		String name = "test03";
		String curl = "http://inateck001.jios.org:9080/xwiki/rest/wikis/xwiki/spaces/XWiki/pages/"+name;
		String [] cmds = {"curl", "-v", "-u",cc,"-X", "PUT", "-H","Content-type: text/plain","--data-ascii","{{include document=\"XWiki.XWikiUserSheet\"/",curl};
		ProcessBuilder pb = new ProcessBuilder(cmds);
		pb.redirectErrorStream(true);
		Process p;
		try {
			p = pb.start();
			BufferedReader br = null;
			String line = null;

			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = br.readLine()) != null) {
				System.out.println("\t" + line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String host = "inateck001.jios.org";
		int port = 9080;
		String url = "http://inateck001.jios.org:9080/xwiki/rest/wikis/xwiki/spaces/XWiki/pages/test03/objects";
		String user = "ccui";
		String password = "123456";

		HttpHost target = new HttpHost(host, port, "http");
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				new AuthScope(target.getHostName(), target.getPort()),
				new UsernamePasswordCredentials(user, password));
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();

		try {
			// Create AuthCache instance
			AuthCache authCache = new BasicAuthCache();

			// Generate BASIC scheme object and add it to the local auth cache
			BasicScheme basicAuth = new BasicScheme();
			authCache.put(target, basicAuth);

			// Add AuthCache to the execution context
			HttpClientContext localContext = HttpClientContext.create();
			localContext.setAuthCache(authCache);
			localContext.setAttribute("preemptive-auth", basicAuth);

			HttpPost httpPost = new HttpPost(url);

			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("className", "XWiki.XWikiUsers"));
			nvps.add(new BasicNameValuePair("property#first_name", "test03"));
			nvps.add(new BasicNameValuePair("property#last_name", "test03"));
			nvps.add(new BasicNameValuePair("property#password", "123456"));
			nvps.add(new BasicNameValuePair("property#email", "lange@inateck.com"));
			nvps.add(new BasicNameValuePair("property#phone", "18888888888"));


			httpPost.addHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
			httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
			httpPost.setEntity(new UrlEncodedFormEntity(nvps));

			CloseableHttpResponse response = httpclient.execute(target, httpPost, localContext);

			try {
				// Request status
				int requestStatus = response.getStatusLine().getStatusCode();
				HttpEntity entity = response.getEntity();

				// do something useful with the response body

				// Request String response
				String requestResponse = EntityUtils.toString(entity);
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.close();
		}
	}

	/**
	 * 主页
	 * @param model 页面
	 * @return index
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String hello(Model model) {
		model.addAttribute("name", name);
		return "/index";
	}

	/**
	 * 跳转 重定向
	 *
	 * @return
	 */
	@RequestMapping("/redirect")
	public String page2(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("name");
		Cookie cName = new Cookie("username",username );
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Cookie cDate = new Cookie("lastVisited",format.format(new java.util.Date()));
		System.out.println(cName.getName());
		System.out.println(cName.getValue());
		session = request.getSession();
		System.out.println(session.getId());
		session.setAttribute("name","lisi");
		System.out.println(session.getAttribute("name"));
		System.out.println(session.getServletContext());
		return "redirect/redirect";
	}

	/**
	 * 视图
	 *
	 * @param model
	 * @return
	 */
	@RequestMapping("/model")
	public String page3(Model model) {
		model.addAttribute("name", "seawater");
		return "system/index";
	}

	@RequestMapping("/getResource")
	@ResponseBody
	public JSONResult getResource(){
		Resource bean = new Resource();
		BeanUtils.copyProperties(resource,bean);
		return JSONResult.ok(bean);
	}

	@RequestMapping(value = "/thymeleaf")
	public String thymeleafTest(ModelMap modelMap) {
		modelMap.addAttribute("name", "frank");
		modelMap.addAttribute("user", resource);
		return "hello";
	}

}
