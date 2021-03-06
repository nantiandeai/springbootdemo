package com.example.demo.controller;

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
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.toilelibre.libe.curl.Curl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class xwiki {
    public static void main(String[] args) throws IOException {
//        createUser();
       /* String url = "-v -u ccui:123456 -X PUT -H \"Content-type: text/plain\" --data-ascii '{{include document=\"XWiki.XWikiUserSheet\"/}}' http://inateck001.jios.org:9080/xwiki/rest/wikis/xwiki/spaces/XWiki/pages/test03 \n";
        StringBuffer errSb = new StringBuffer();
        int result = Curl.curl(url, null, "/opt/testApp/vision222.flv", errSb);*/

      /*  String[] cmds = {"curl", "-i", "-w", "状态%{http_code}；DNS时间%{time_namelookup}；"
                + "等待时间%{time_pretransfer}TCP 连接%{time_connect}；发出请求%{time_starttransfer}；"
                + "总时间%{time_total}", "http://www.baidu.com"};*/

        String cc = "ccui:123456";
        String name = "test03";
        String url = "http://inateck001.jios.org:9080/xwiki/rest/wikis/xwiki/spaces/XWiki/pages/"+name;
        System.out.println(url);

        String [] cmds = {"curl", "-v", "-u",cc,"-X", "PUT", "-H","Content-type: text/plain","--data-ascii","{{include document=\"XWiki.XWikiUserSheet\"/",url};
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
        createUser();
    }

    private static void createUser() throws IOException {
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

    private static void update() throws IOException {
        String host = "inateck001.jios.org";
        int port = 9080;
        String url = "http://localhost:8080/xwiki/rest/wikis/xwiki/spaces/XWiki/pages/JohnDoe/objects/XWiki.XWikiUsers/0/properties/email";
        String user = "Admin";
        String password = "admin";

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

            HttpPut httpPut = new HttpPut(url);

            List <NameValuePair> nvps = new ArrayList <NameValuePair>();
            nvps.add(new BasicNameValuePair("property#email", "john.doe@xwiki.com"));
            httpPut.addHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            httpPut.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            httpPut.setEntity(new UrlEncodedFormEntity(nvps));

            CloseableHttpResponse response = httpclient.execute(target, httpPut, localContext);

            try {
                // Request status
                int requestStatus = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();

                // Do something useful with the response body

                // Request String response
                String requestResponse = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
    }
}