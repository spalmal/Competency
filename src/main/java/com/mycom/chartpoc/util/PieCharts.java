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
			if (skill.getEmployee().getEmployeeFirstName()
					.equalsIgnoreCase(name))

				slice.add(Slice.newSlice(skill.getEmployeeSkillRating(),
						skill.getEmployeeSkillRating() + ", "
								+ skill.getSkill().getSkillName()));
		}

		PieChart pChart = GCharts.newPieChart(slice);
		pChart.setTitle(name + " Skill Details ", Color.BLACK, 15);
		pChart.setSize(600, 360);
		pChart.setThreeD(true);
		return pChart;
	}

	public PieChart getSkillCharts(Collection<EmployeeSkill> skills,
			String skillName) {
		slice = new ArrayList<Slice>();
		StringBuilder sb0 = new StringBuilder("Nill :");
		StringBuilder sb1 = new StringBuilder("Poor :");
		StringBuilder sb2 = new StringBuilder("Average :");
		StringBuilder sb3 = new StringBuilder("Good :");
		StringBuilder sb4 = new StringBuilder("Experienced :");
		StringBuilder sb5 = new StringBuilder("Expert :");
		for (EmployeeSkill skill : skills) {

			int skillRating = skill.getEmployeeSkillRating();
			if (skill.getSkill().getSkillName().equalsIgnoreCase(skillName)) {
				switch (skillRating) {
				case 1:
					sb1.append(skill.getEmployee().getEmployeeFirstName()+" ");
					
					break;
				case 2:
					sb2.append(skill.getEmployee().getEmployeeFirstName()+" ");
					sb1.append("\n");
					break;
				case 3:
					sb3.append(skill.getEmployee().getEmployeeFirstName()+" ");
					sb1.append("\n");
					break;
				case 4:
					sb4.append(skill.getEmployee().getEmployeeFirstName()+" ");
					sb1.append("\n");
					break;
				case 5:
					sb5.append(skill.getEmployee().getEmployeeFirstName());
					sb1.append("\n");
					break;
				default:
					sb0.append(skill.getEmployee().getEmployeeFirstName());
					sb1.append("\n");
					break;

				}
			}
		}
		slice.add(Slice.newSlice(0, sb0.toString()));
		slice.add(Slice.newSlice(1, sb1.toString()));
		slice.add(Slice.newSlice(2, sb2.toString()));
		slice.add(Slice.newSlice(3, sb3.toString()));
		slice.add(Slice.newSlice(4, sb4.toString()));
		slice.add(Slice.newSlice(5, sb5.toString()));

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
								+ skill.getEmployee().getEmployeeFirstName()));
		}

		PieChart pChart = GCharts.newPieChart(slice);
		pChart.setTitle(skillName + " Associate Details ", Color.BLACK, 15);
		pChart.setSize(700, 360);
		pChart.setThreeD(true);
		return pChart;
	}

}
