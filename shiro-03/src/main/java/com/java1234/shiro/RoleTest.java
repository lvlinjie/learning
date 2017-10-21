package com.java1234.shiro;


import java.util.Arrays;

import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.java1234.common.ShiroUtil;

/**
 * 角色认证
 */


public class RoleTest {

    @Test
    public void testHasRole() {

        /**
         * 这里要从util 里面得到这个用户，用这个用户去认证一次。
         *
         * 用java1234，123456去认证一次。并获取到这个用户的role
         */

        Subject currentUser = ShiroUtil.login("classpath:shiro_role.ini", "java1234", "123456");
        // Subject currentUser=ShiroUtil.login("classpath:shiro_role.ini", "jack", "123");
        /*认证成功之后，得到这个用户的role*/


		/*currentUser.hasRole("role1")这个方得，返回是true ,fales,里面的参数可以是一个string ,也可以是一个数组*/

        System.out.println(currentUser.hasRole("role1") ? "有role1这个角色" : "没有role1这个角色");


        boolean[] results = currentUser.hasRoles(Arrays.asList("role1", "role2", "role3"));

        System.out.println(results[0] ? "有role1这个角色" : "没有role1这个角色");
        System.out.println(results[1] ? "有role2这个角色" : "没有role2这个角色");
        System.out.println(results[2] ? "有role3这个角色" : "没有role3这个角色");
        System.out.println(currentUser.hasAllRoles(Arrays.asList("role1", "role2")) ? "role1,role2这两个角色都有" : "role1,role2这个两个角色不全有");

        currentUser.logout();
    }

    @Test
    public void testCheckRole() {
        Subject currentUser = ShiroUtil.login("classpath:shiro_role.ini", "java1234", "123456");
        // Subject currentUser=ShiroUtil.login("classpath:shiro_role.ini", "jack", "123");

        /**
         * checkRole()这个方法，没有返回值 ，如果有错误，就会抛出异常，没有错误就算了
         */

        currentUser.checkRole("role1");
    /**
     * checkRole()这个方法，没有返回值 ，如果有错误，就会抛出异常，没有错误就算了
     */


        currentUser.checkRoles(Arrays.asList("role1", "role2"));

    /**
     * checkRole()这个方法，没有返回值 ，如果有错误，就会抛出异常，没有错误就算了
     */

        currentUser.checkRoles("role1", "role2", "role3");

        currentUser.logout();
    }
}
