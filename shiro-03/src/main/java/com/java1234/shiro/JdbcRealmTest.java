package com.java1234.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class JdbcRealmTest {

	public static void main(String[] args) {
		// ��ȡ�����ļ�����ʼ��SecurityManager����
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:jdbc_realm.ini");
		// ��ȡsecurityManagerʵ��
		SecurityManager securityManager=factory.getInstance();
		// ��securityManagerʵ���󶨵�SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// �õ���ǰִ�е��û�
		Subject currentUser=SecurityUtils.getSubject();
		// ����token���ƣ��û���/����
		UsernamePasswordToken token=new UsernamePasswordToken("java1234", "123456");
		try{
			// �����֤
			currentUser.login(token);	
			System.out.println("�����֤�ɹ���");
		}catch(AuthenticationException e){
			e.printStackTrace();
			System.out.println("�����֤ʧ�ܣ�");
		}
		// �˳�
		currentUser.logout();
	}
}
