package com.example;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	@Autowired
	ProductDAO dao;
	@Autowired
	UsersRepo repo;
	@Autowired
	PurchesedRepo repo1;
	@ResponseBody
	@RequestMapping("/")
	public String demo() {
		return "Welcome in the Application ";
	}
@ResponseBody
	@RequestMapping("/admin")
	public ModelAndView admin() {
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("admin.jsp");
		return mv;
	}

@ResponseBody
	@RequestMapping("/user")
	public ModelAndView user() {
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("user1.jsp");
		return mv;
	}
@RequestMapping("/addproduct")
public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) {
	Product p=new Product();
	ModelAndView mv=new ModelAndView();
	p.setPname(request.getParameter("pname"));
	p.setCost(Double.parseDouble(request.getParameter("cost")));
	Product pp= dao.insert(p);
	if(pp!=null) {
		mv.setViewName("admin.jsp");
	}
	return mv;
}
@RequestMapping("/getall")
public ModelAndView retrieve(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	List<Product> list=dao.getall();
	mv.setViewName("display.jsp");
	mv.addObject("list",list);
	return mv;
}
@RequestMapping("/getallitem")
public ModelAndView retrieveitem(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	List<Purchesed> list1=repo1.findAll();
	mv.setViewName("display2.jsp");
	mv.addObject("list",list1);
	return mv;
}
@RequestMapping("/getallproduct")
public ModelAndView retriev(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	List<Product> list=dao.getall();
	mv.setViewName("display1.jsp");
	mv.addObject("list",list);
	return mv;
}
@RequestMapping("/update")
public ModelAndView update(HttpServletRequest request,HttpServletResponse response) {
	Product p=new Product();
	ModelAndView mv=new ModelAndView();
	p.setPid(Integer.parseInt(request.getParameter("pid")));
	p.setPname(request.getParameter("pname"));
	p.setCost(Double.parseDouble(request.getParameter("cost")));
	Product pp= dao.update(p);
	if(pp!=null) {
		mv.setViewName("admin.jsp");
	}
	return mv;
}
@RequestMapping("/delete")
public ModelAndView delete(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	int id=Integer.parseInt(request.getParameter("pid"));
	dao.delete(id);
	mv.setViewName("admin.jsp");
	return mv;
}
@RequestMapping("/login")
public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {
	ModelAndView mv=new ModelAndView();
	String user= request.getParameter("user");
	if((repo.findByuser(user)!=null)&&(repo.findBypassword(request.getParameter("pwd"))!=null)) {
		if(repo.findByuser(user).equals(repo.findBypassword(request.getParameter("pwd"))))
		{
			mv.setViewName("user.jsp");
		}
		}
		else {
			mv.setViewName("fail.jsp");
		}
	return mv;
}
@RequestMapping("/insertuser")
public ModelAndView insertuser(HttpServletRequest request,HttpServletResponse response) {
	User u=new User();
	ModelAndView mv=new ModelAndView();
	u.setUser(request.getParameter("user"));
	u.setEmail(request.getParameter("email"));
	u.setPassword(request.getParameter("pwd"));
	User pp= repo.save(u);
	if(pp!=null) {
		mv.setViewName("admin.jsp");
	}
	return mv;
}
@RequestMapping("/purchased")
public ModelAndView soldr(HttpServletRequest request,HttpServletResponse response) {
	Purchesed u=new Purchesed();
	ModelAndView mv=new ModelAndView();
	u.setUser(request.getParameter("name"));
	u.setPname(request.getParameter("pname"));
	u.setCost(Double.parseDouble(request.getParameter("pcost")));
	Purchesed pp= repo1.save(u);
	if(pp!=null) {
		mv.setViewName("success.jsp");
	}
	return mv;
}
	
}

