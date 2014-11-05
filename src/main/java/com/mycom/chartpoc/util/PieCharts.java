package com.mycom.chartpoc.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jfree.chart.LegendItem;

import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.LegendPosition;
import com.googlecode.charts4j.PieChart;
import com.googlecode.charts4j.Slice;
import com.mycom.chartpoc.entity.EmployeeSkill;

public class PieCharts {

	private static final long serialVersionUID = 1L;
	private List<Slice> slice;

	public PieChart getChart(List<EmployeeSkill> skills, String name) {
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
		pChart.setSize(830, 360);
		pChart.setThreeD(true);
		return pChart;
	}

	/**
	 * @param skills
	 * @param skillName
	 * @return
	 */
	public PieChart getSkillCharts(Collection<EmployeeSkill> skills,
			String skillName) {
		slice = new ArrayList<Slice>();
		StringBuilder sb0 = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();
		StringBuilder sb5 = new StringBuilder();
		int [] counter = {0,0,0,0,0,0};
		for (EmployeeSkill skill : skills) {

			int skillRating = skill.getEmployeeSkillRating();
			if (skill.getSkill().getSkillName().equalsIgnoreCase(skillName)) {
				switch (skillRating) {
				case 1:
					sb1.append(skill.getEmployee().getEmployeeFirstName());
					counter[1]++;
					sb1.append(", ");
					break;
				case 2:
					sb2.append(skill.getEmployee().getEmployeeFirstName());
					sb2.append(", ");
					counter[2]++;
					break;
				case 3:
					sb3.append(skill.getEmployee().getEmployeeFirstName());
					sb3.append(", ");
					counter[3]++;
					break;
				case 4:
					sb4.append(skill.getEmployee().getEmployeeFirstName());
					sb4.append(", ");
					counter[4]++;
					break;
				case 5:
					sb5.append(skill.getEmployee().getEmployeeFirstName());
					sb5.append(", ");
					counter[5]++;
					break;
				default:
					sb0.append(skill.getEmployee().getEmployeeFirstName());
					sb0.append(", ");
					counter[0]++;
					break;

				}
			}
		}
		slice.add(Slice.newSlice(counter[0],Color.BISQUE, sb0.toString(),"No Experience"));
		slice.add(Slice.newSlice(counter[1],Color.CADETBLUE, sb1.toString(),"Poor"));
		slice.add(Slice.newSlice(counter[2],Color.BURLYWOOD, sb2.toString(),"Average"));
		slice.add(Slice.newSlice(counter[3],Color.BLUEVIOLET, sb3.toString(),"Good"));
		slice.add(Slice.newSlice(counter[4],Color.WHEAT, sb4.toString(),"Experienced"));
		slice.add(Slice.newSlice(counter[5],Color.CHOCOLATE, sb5.toString(),"Expert"));

		PieChart pChart = GCharts.newPieChart(slice);
		pChart.setTitle(skillName + " Associate Details ", Color.BLACK, 15);
	
		pChart.setSize(850, 350);
		pChart.setThreeD(true);
		return pChart;
	}

	/**
	 * 
	 * Skill details for an associate
	 * @param skills
	 * @param skillName
	 * @return
	 */
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
		pChart.setSize(850, 350);
		pChart.setThreeD(true);
		
		pChart.setLegendPosition(LegendPosition.TOP_VERTICAL);
		return pChart;
	}

}
