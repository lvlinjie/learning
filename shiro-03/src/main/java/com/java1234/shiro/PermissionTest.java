package com.java1234.shiro;


import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.java1234.common.ShiroUtil;


/**
 * 权限认证
 */
public class PermissionTest {

	@Test
	public void testIsPermitted() {
		Subject currentUser=ShiroUtil.login("classpath:shiro_permission.ini", "java1234", "123456");
		// Subject currentUser=ShiroUtil.login("classpath:shiro_permission.ini", "jack", "123");

		/**
		 * currentUser.isPermitted("user:select")，判断这个用户的权限中，是否有这个权限。
		 *
		 * 这个方法中的参数可以是一个Sring，也可以是一个数组
		 */

		System.out.println(currentUser.isPermitted("user:select")?"有user:select这个权限":"没有user:select这个权限");
		System.out.println(currentUser.isPermitted("user:update")?"有user:update这个权限":"没有user:update这个权限");


		/**
		 * currentUser..isPermitted("user:select","user:update","user:delete")，判断这个用户的权限中，是否有这个权限都有这几个权限。
		 */
		boolean results[]=currentUser.isPermitted("user:select","user:update","user:delete");


		System.out.println(results[0]?"有user:select这个权限":"没有user:select这个权限");
		System.out.println(results[1]?"有user:update这个权限":"没有user:update这个权限");
		System.out.println(results[2]?"有user:delete这个权限":"没有user:delete这个权限");
		System.out.println(currentUser.isPermittedAll("user:select","user:update")?"有user:select,update这两个权限":"user:select,update这两个权限不全有");
		
		currentUser.logout();
	}

	@Test
	public void testCheckPermitted() {
		Subject currentUser=ShiroUtil.login("classpath:shiro_permission.ini", "java1234", "123456");
		// Subject currentUser=ShiroUtil.login("classpath:shiro_permission.ini", "jack", "123");

		/**
		 * checkPermission()这个方法只是判断这个用户是否有这一个权限要，如果没有，就是异常
		 */
		currentUser.checkPermission("user:select");


		/**
		 * checkPermission()这个方法只是判断这个用户是否有这些权限，只有一个没有，那么就会异常
		 */
		currentUser.checkPermissions("user:select","user:update","user:delete","user:insert");
		currentUser.logout();
	}
}
