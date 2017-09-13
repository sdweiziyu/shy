package com.shy.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shy.service.UserOperationService;
import com.shy.util.EncryptUtil;
import com.shy.util.StringUtil;
import com.shy.vo.primary.User;

@Controller
public class LoginController {
	
		private String x =null;
		@Autowired
		private UserOperationService UserOperationService;
	
		@RequestMapping(value="/login")
		public String login(HttpServletRequest request, HttpServletResponse response){
			System.out.println("x==========="+x);
			String y = request.getParameter("y");
			System.out.println("y============"+y);
			x = y;
			return "login";
		}
		@RequestMapping(value="/welcome")
		public String welcome(HttpServletRequest request, HttpServletResponse response){
			
			return "welcome";
		}
		@RequestMapping(value="/loginOn")
		public String loginOn(HttpServletRequest request, HttpServletResponse response){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if(StringUtil.isNullStr(username)||StringUtil.isNullStr(password)){
				request.setAttribute("errorMsg", "用户名/密码为空！");
				return "login";
			}
			
			User user = UserOperationService.getUser(username);
			if(user==null){
				request.setAttribute("errorMsg", "用户不存在！");
				return "login";
			}
			password =EncryptUtil.encode(password, "MD5").toUpperCase();
			if(!password.equals(user.getLoginPassword())){
				request.setAttribute("errorMsg", "密码错误！");
				return "login";
			}
			HttpSession session = request.getSession();
			session.setAttribute("_userSelf", user);
			request.setAttribute("user", user);
			return "test";
		}
		
		@RequestMapping(value="/loginOut")
		public String loginOut(HttpServletRequest request, HttpServletResponse response){
			HttpSession session = request.getSession();
			if(session ==null){
				return "login";
			}
			session.invalidate();
			return "login";
		}
}
