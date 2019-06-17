package com.sagar.algorithm;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Test1 {
public static void main(String[] args) throws UnsupportedEncodingException {
	String baseUrl = "https://eshop-uat.henkel-adhesives.com/forgotPassword?token=";
	String token =URLEncoder.encode("3VO7ptMvqpyE6YsdfvdkQGnbgQKzlUP9VxoM69pbfTLLBKnrWzx+uvr3yl1ybpk56s94Ch3f0rnW1Imx62dqy8cfBZ1bRoK3y4DftJ9lw/roj5aMd0MnU0k8qVKCUfc7", "UTF-8");
	String url = baseUrl+token;
	System.out.println(url);
}
}
