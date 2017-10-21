package com.java1234.shiro;


import java.util.Arrays;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.java1234.common.ShiroUtil;

/**
 * ��ɫ��֤
 */


public class RoleTest {

    @Test
    public void testHasRole() {

        /**
         * ����Ҫ��util ����õ�����û���������û�ȥ��֤һ�Ρ�
         *
         * ��java1234��123456ȥ��֤һ�Ρ�����ȡ������û���role
         */

        Subject currentUser = ShiroUtil.login("classpath:shiro_role.ini", "java1234", "123456");
        // Subject currentUser=ShiroUtil.login("classpath:shiro_role.ini", "jack", "123");
        /*��֤�ɹ�֮�󣬵õ�����û���role*/


		/*currentUser.hasRole("role1")������ã�������true ,fales,����Ĳ���������һ��string ,Ҳ������һ������*/

        System.out.println(currentUser.hasRole("role1") ? "��role1�����ɫ" : "û��role1�����ɫ");


        boolean[] results = currentUser.hasRoles(Arrays.asList("role1", "role2", "role3"));

        System.out.println(results[0] ? "��role1�����ɫ" : "û��role1�����ɫ");
        System.out.println(results[1] ? "��role2�����ɫ" : "û��role2�����ɫ");
        System.out.println(results[2] ? "��role3�����ɫ" : "û��role3�����ɫ");
        System.out.println(currentUser.hasAllRoles(Arrays.asList("role1", "role2")) ? "role1,role2��������ɫ����" : "role1,role2���������ɫ��ȫ��");

        currentUser.logout();
    }

    @Test
    public void testCheckRole() {
        Subject currentUser = ShiroUtil.login("classpath:shiro_role.ini", "java1234", "123456");
        // Subject currentUser=ShiroUtil.login("classpath:shiro_role.ini", "jack", "123");

        /**
         * checkRole()���������û�з���ֵ ������д��󣬾ͻ��׳��쳣��û�д��������
         */

        currentUser.checkRole("role1");
    /**
     * checkRole()���������û�з���ֵ ������д��󣬾ͻ��׳��쳣��û�д��������
     */


        currentUser.checkRoles(Arrays.asList("role1", "role2"));

    /**
     * checkRole()���������û�з���ֵ ������д��󣬾ͻ��׳��쳣��û�д��������
     */

        currentUser.checkRoles("role1", "role2", "role3");

        currentUser.logout();
    }
}
