package com.cts.Flexride.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.Flexride.Entity.AdminEntity;
import com.cts.Flexride.Service.AdminService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller

public class FlexrideController {

	@Autowired
	private AdminService adminservice;

	@GetMapping("/")
	public String home() {
		return "front";
	}

	@GetMapping("/Login")
	public String Cuogin() {
		return "Login";
	}

	/* @GetMapping("/AdminLogin") public String Login() { return "AdminLogin"; } */

	@GetMapping("/signup")
	public String SignUp() {
		return "signup";
	}

	@GetMapping("/index")
	public String Index() {
		return "index";
	}

	@GetMapping("/front")
	public String front() {
		return "front";
	}

	@GetMapping("/contact")
	public String Contact() {
		return "contact";
	}

	@GetMapping("/book")
	public String book() {
		return "book";
	}

	
	/*
	 * @GetMapping("/dashboard") public String Dashboard() { return "dashboard"; }
	 */
	 

	@GetMapping("/customerdashboard")
	public String CustomerDashboard() {
		return "customerdashboard";
	}

	@GetMapping("/Cardetails")
	public String CarDetails() {
		return "Cardetails";
	}

	// Admin part
	@GetMapping("/AdminLogin")
	public String showAdminLoginPage(HttpSession httpSession, Model model) {
		httpSession.removeAttribute("error");
		return "AdminLogin";
	}

	/*
	 * @PostMapping("/AdminLogin") public String loginAdmin(@RequestParam("email")
	 * String email, @RequestParam("password") String password, Model model) {
	 * AdminEntity admin = adminservice.validateAdmin(email, password); if (admin !=
	 * null) { return "redirect:/dashboard"; } else { model.addAttribute("error",
	 * "Invalid email or password"); return "AdminLogin"; } }
	 * 
	 * 
	 * @GetMapping("/dashboard") public String showDashboard() { return "dashboard";
	 * }
	 */

	// Process Admin Login

	/*
	 * @PostMapping("/Adminlogin") public String processAdminLogin(@RequestParam
	 * String email,
	 * 
	 * @RequestParam String password, HttpSession session, Model model) { if
	 * (adminservice.validateAdmin((email, password)) {
	 * session.setAttribute("adminEmail", email); return
	 * "redirect:/admin/dashboard"; } else { model.addAttribute("error",
	 * "Wrong email or password!"); return "AdminLogin"; } }
	 */

	// Show Admin Dashboard

	/*
	 * @PostMapping("/AdminLogin") public String login(@RequestParam String
	 * email, @RequestParam String password, HttpSession session, Model model) {
	 * AdminEntity admin = adminservice.validateAdmin(email, password);
	 * 
	 * if (admin != null) { session.setAttribute("name", admin.getName()); // Store
	 * admin name in session return "redirect:/admin/dashboard"; // Redirect to
	 * update welcome message } else { model.addAttribute("error",
	 * "Wrong email or password"); return "Adminlogin"; } }
	 */

	/*
	 * @GetMapping("/dashboard") public String showLoginPage(HttpSession session,
	 * Model model, HttpServletResponse response) { String adminName = (String)
	 * session.getAttribute("adminName");
	 * 
	 * if (adminName == null) { // model.addAttribute("adminMessage",
	 * "Welcome Admin, " + adminName); return "redirect:/admin/adminLogin"; }
	 */

	
	/*
	 * @GetMapping("/dashboard") public String showLoginPage(HttpSession session,
	 * Model model, HttpServletResponse response) { String adminName = (String)
	 * session.getAttribute("adminName");
	 * 
	 * if (adminName == null) { // model.addAttribute("adminMessage",
	 * "Welcome Admin, " + adminName); return "redirect:/admin/AdminLogin"; }
	 */
	
	 @PostMapping("/AdminLogin")
	    public String login(@RequestParam String email,
	                        @RequestParam String password,
	                        HttpSession session,
	                        Model model) {
	        AdminEntity admin = adminservice.validateAdmin(email, password);

	        if (admin != null) {
	            session.setAttribute("name", admin.getName()); // Store admin name in session
	            return "redirect:/dashboard"; // Redirect to update welcome message
	        } else {
	            model.addAttribute("error", "Wrong email or password");
	            return "AdminLogin";
	        }
	    }
	 @GetMapping("/dashboard") public String showDashboard() { return "dashboard";}
	  
		/*
		 * @GetMapping("/dashboard") public String showLoginPage(HttpSession session,
		 * Model model) { String adminName = (String) session.getAttribute("name");
		 * 
		 * if (adminName == null) { return "redirect:/admin/AdminLogin"; }
		 * 
		 * model.addAttribute("name",name); return "dashboard"; }
		 */

	// Logout Function
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin/login";
	}

}
