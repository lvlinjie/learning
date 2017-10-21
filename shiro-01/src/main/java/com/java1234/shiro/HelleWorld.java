package com.java1234.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


/**
 *
 * 2.1、首先通过new IniSecurityManagerFactory并指定一个ini配置文件来创建一个SecurityManager工厂；
 *2.2、接着获取SecurityManager并绑定到SecurityUtils，这是一个全局设置，设置一次即可；
 *2.3、通过SecurityUtils得到Subject，其会自动绑定到当前线程；如果在web环境在请求结束时需要解除绑定；然后获取身份验证的Token，如用户名/密码；
 *2.4、调用subject.login方法进行登录，其会自动委托给SecurityManager.login方法进行登录；
 *2.5、如果身份验证失败请捕获AuthenticationException或其子类，常见的如： DisabledAccountException（禁用的帐号）、LockedAccountException（锁定的帐号）、UnknownAccountException（错误的帐号）、ExcessiveAttemptsException（登录失败次数过多）、IncorrectCredentialsException （错误的凭证）、ExpiredCredentialsException（过期的凭证）等，具体请查看其继承关系；对于页面的错误消息展示，最好使用如“用户名/密码错误”而不是“用户名错误”/“密码错误”，防止一些恶意用户非法扫描帐号库；
 *2.6、最后可以调用subject.logout退出，其会自动委托给SecurityManager.logout方法退出。
 * */

public class HelleWorld {

	public static void main(String[] args) {
		// 读取配置文件，初始化SecurityManager工厂
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:shiro.ini");
		// 获取securityManager实例
		SecurityManager securityManager=factory.getInstance();
		// 把securityManager实例绑定到SecurityUtils
		SecurityUtils.setSecurityManager(securityManager);
		// 得到当前执行的用户
		Subject currentUser=SecurityUtils.getSubject();
		// 创建token令牌，用户名/密码
		UsernamePasswordToken token=new UsernamePasswordToken("zhang", "123");
		try{
			// 身份认证
			currentUser.login(token);
			System.out.println("身份认证成功！");
		}catch(AuthenticationException e){
			e.printStackTrace();
			System.out.println("身份认证失败！");
		}
		// 退出
		currentUser.logout();
	}
}
