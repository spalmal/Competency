package com.mycom.chartpoc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.chartpoc.service.EmployeeService;
import com.mycom.chartpoc.util.PieCharts;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private EmployeeService employeeservice;
	
	

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("mentors", employeeservice.getMentorNames());
		//PieCharts demo = new PieCharts();	
		//model.addAttribute("chart", demo.getChart(employeeservice.getEmployeSkils(),"vishwas").toURLString());
//		employeeservice.getSkillSet();
		return "index";
	}
	
	 @RequestMapping("/getCharts/{param}")
	    public String getCharts(@PathVariable String param) {
		 System.out.println("aplllleleeee");
	        return param;
	    }
	 
	
	@RequestMapping(value = "/search/{param}", method = RequestMethod.GET)
	public String getAssociateDetails(Locale locale, Model model,@PathVariable String param) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("skills", employeeservice.getEmployeSkils());
		PieCharts demo = new PieCharts();	
		model.addAttribute("chart1", demo.getChart(employeeservice.getEmployeSkils(),param).toURLString());

		return "pieCharts";
	}

	
	@RequestMapping(value = "/searchSkill/{param}", method = RequestMethod.GET)
	public String getSkillDetails(Locale locale, Model model,@PathVariable String param) {
		logger.info("Preparing chart details for skill {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("skills", employeeservice.getEmployeSkils());
		PieCharts demo = new PieCharts();	
		model.addAttribute("skillChart", demo.getSkillCharts(employeeservice.getEmployeSkils(),param).toURLString());
		
		return "pieCharts";
	}

}
