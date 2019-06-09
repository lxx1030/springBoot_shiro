package com.yx1030.springbootshiro.filter;


import org.apache.shiro.web.filter.PathMatchingFilter;

public class URLPathMatchingFilter extends PathMatchingFilter {
	/*@Override
	protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		Subject subject = SecurityUtils.getSubject();
		// 如果没有登录，就跳转到登录页面
		if (!subject.isAuthenticated()) {
			WebUtils.issueRedirect(request, response, "login.html");
			System.out.println("================去登录页面============");
			return true;
		}
		return false;

	}*/
}



