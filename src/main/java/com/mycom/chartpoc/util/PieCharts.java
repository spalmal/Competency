package com.mycom.chartpoc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;
import com.mycom.chartpoc.entity.EmployeeSkill;

public class PieCharts {

	private static final long serialVersionUID = 1L;
	private List<Slice> slice;

	public PieChart getChart(Collection<EmployeeSkill> skills, String name) {
		slice = new ArrayList<Slice>();

		for (EmployeeSkill skill : skills) {
			if (skill.getEmployee().getEmployeeName().equalsIgnoreCase(name))

				slice.add(Slice.newSlice(skill.getEmployeeSkillRating(),
						skill.getEmployeeSkillRating() + ", "
								+ skill.getSkill().getSkillName()));
		}

		PieChart pChart = GCharts.newPieChart(slice);
		pChart.setTitle(name + " Skill Details ", Color.BLACK, 15);
		pChart.setSize(700, 360);
		pChart.setThreeD(true);
		return pChart;
	}

	public PieChart getSkillCharts(Collection<EmployeeSkill> skills,
			String skillName) {
		slice = new ArrayList<Slice>();
		for (EmployeeSkill skill : skills) {
			if (skill.getSkill().getSkillName().equalsIgnoreCase(skillName))

				slice.add(Slice.newSlice(skill.getEmployeeSkillRating(),
						skill.getEmployeeSkillRating() + ", "
								+ skill.getEmployee().getEmployeeName()));
		}

		PieChart pChart = GCharts.newPieChart(slice);
		pChart.setTitle(skillName + " Associate Details ", Color.BLACK, 15);
		pChart.setSize(700, 360);
		pChart.setThreeD(true);
		return pChart;
	}
	
	public PieChart getAllSkillDetails(Collection<EmployeeSkill> skills,
			String skillName) {
		slice = new ArrayList<Slice>();
		for (EmployeeSkill skill : skills) {
			if (skill.getSkill().getSkillName().equalsIgnoreCase(skillName))

				slice.add(Slice.newSlice(skill.getEmployeeSkillRating(),
						skill.getEmployeeSkillRating() + ", "
								+ skill.getEmployee().getEmployeeName()));
		}

		PieChart pChart = GCharts.newPieChart(slice);
		pChart.setTitle(skillName + " Associate Details ", Color.BLACK, 15);
		pChart.setSize(700, 360);
		pChart.setThreeD(true);
		return pChart;
	}

}
