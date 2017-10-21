package com.java1234.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroUtil {


    public static Subject login(String configFile, String userName, String password) {
        // ��ȡ�����ļ�����ʼ��SecurityManager����

        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);
        // ��ȡsecurityManagerʵ��
        SecurityManager securityManager = factory.getInstance();
        // ��securityManagerʵ���󶨵�SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        // �õ���ǰִ�е��û�,��Ҫ��ִ����֤���û�
        Subject currentUser = SecurityUtils.getSubject();
        // ����token���ƣ��û���/����
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            // �����֤
            currentUser.login(token);
            System.out.println("�����֤�ɹ���");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("�����֤ʧ�ܣ�");
        }
        return currentUser;
    }
}
