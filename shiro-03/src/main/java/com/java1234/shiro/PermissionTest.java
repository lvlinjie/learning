package com.java1234.shiro;


import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.java1234.common.ShiroUtil;


/**
 * Ȩ����֤
 */
public class PermissionTest {

	@Test
	public void testIsPermitted() {
		Subject currentUser=ShiroUtil.login("classpath:shiro_permission.ini", "java1234", "123456");
		// Subject currentUser=ShiroUtil.login("classpath:shiro_permission.ini", "jack", "123");

		/**
		 * currentUser.isPermitted("user:select")���ж�����û���Ȩ���У��Ƿ������Ȩ�ޡ�
		 *
		 * ��������еĲ���������һ��Sring��Ҳ������һ������
		 */

		System.out.println(currentUser.isPermitted("user:select")?"��user:select���Ȩ��":"û��user:select���Ȩ��");
		System.out.println(currentUser.isPermitted("user:update")?"��user:update���Ȩ��":"û��user:update���Ȩ��");


		/**
		 * currentUser..isPermitted("user:select","user:update","user:delete")���ж�����û���Ȩ���У��Ƿ������Ȩ�޶����⼸��Ȩ�ޡ�
		 */
		boolean results[]=currentUser.isPermitted("user:select","user:update","user:delete");


		System.out.println(results[0]?"��user:select���Ȩ��":"û��user:select���Ȩ��");
		System.out.println(results[1]?"��user:update���Ȩ��":"û��user:update���Ȩ��");
		System.out.println(results[2]?"��user:delete���Ȩ��":"û��user:delete���Ȩ��");
		System.out.println(currentUser.isPermittedAll("user:select","user:update")?"��user:select,update������Ȩ��":"user:select,update������Ȩ�޲�ȫ��");
		
		currentUser.logout();
	}

	@Test
	public void testCheckPermitted() {
		Subject currentUser=ShiroUtil.login("classpath:shiro_permission.ini", "java1234", "123456");
		// Subject currentUser=ShiroUtil.login("classpath:shiro_permission.ini", "jack", "123");

		/**
		 * checkPermission()�������ֻ���ж�����û��Ƿ�����һ��Ȩ��Ҫ�����û�У������쳣
		 */
		currentUser.checkPermission("user:select");


		/**
		 * checkPermission()�������ֻ���ж�����û��Ƿ�����ЩȨ�ޣ�ֻ��һ��û�У���ô�ͻ��쳣
		 */
		currentUser.checkPermissions("user:select","user:update","user:delete","user:insert");
		currentUser.logout();
	}
}
