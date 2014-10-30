package com.mycom.chartpoc;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.mycom.chartpoc.entity.EmployeeSkill;
import com.mycom.chartpoc.service.EmployeeService;
import com.mycom.chartpoc.util.BarGraph;
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
		return "index";
	}
	
	@RequestMapping(value = "/getMentee/{employeeId}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getMentee(Model model,@PathVariable int employeeId) {
		logger.info("Serach for mentees under mentor id ,{}",employeeId);
		model.addAttribute("mentees", employeeservice.getMenteeName(employeeId));
		System.out.println("employeeId "+employeeId);
		model.addAttribute("skillSet", employeeservice.getSkillSet());
		return employeeservice.getMenteeName(employeeId);
	}
	
	@RequestMapping(value ="/getMenteeSkillSets/{employeeName}", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getMenteeSkills(Model model,@PathVariable String employeeName) {
		logger.info("Serach for mentees skill for  ,{}",employeeName);
	//	model.addAttribute("skillDetails", employeeservice.getEmployeSkills(employeeName));
		System.out.println(employeeservice.getEmployeSkills(employeeName));
		Gson gson = new Gson();
		 
		// convert java object to JSON format,
		// and returned as JSON formatted string
		
		JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
	    List<EmployeeSkill> employeeSkill = employeeservice.getEmployeSkills(employeeName);
	    for(EmployeeSkill e : employeeSkill) {
	        JSONObject formDetailsJson = new JSONObject();
	        formDetailsJson.put("name", e.getEmployee().getEmployeeFirstName());
	        formDetailsJson.put("skill", e.getSkill().getSkillName());
	        formDetailsJson.put("skillRating", e.getEmployeeSkillRating());
	        jsonArray.add(formDetailsJson);
	    }
		//String json = gson.toJson(employeeservice.getEmployeSkills(employeeName));
	    responseDetailsJson.put("forms", jsonArray);//Here you can see the data in json format

		return responseDetailsJson;
	
	}
	
	 @RequestMapping("/getCharts/{param}")
	    public String getCharts(@PathVariable String param) {
		 System.out.println("aplllleleeee");
	        return param;
	    }
	 
	
	@RequestMapping(value = "/search/{param}", method = RequestMethod.GET)
	public String getAssociateDetails(Locale locale, Model model,@PathVariable String param) {
		logger.info("Querying for associate details, {}" , param);
		model.addAttribute("skills", employeeservice.getEmployeSkills(param));
		PieCharts demo = new PieCharts();	
		model.addAttribute("chart1", demo.getChart(employeeservice.getEmployeSkills(param),param).toURLString());

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
		model.addAttribute("skills", employeeservice.getEmployeSkills());
		PieCharts demo = new PieCharts();	
		model.addAttribute("skillChart", demo.getSkillCharts(employeeservice.getEmployeSkills(),param).toURLString());
		BarGraph bar = new BarGraph();
		model.addAttribute("barGraph", bar.getChart(employeeservice.getEmployeSkills()).toURLString());
		
		return "pieCharts";
	}

}
