package com.mycom.chartpoc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.googlecode.charts4j.AxisLabels;
import com.googlecode.charts4j.AxisLabelsFactory;
import com.googlecode.charts4j.AxisStyle;
import com.googlecode.charts4j.AxisTextAlignment;
import com.googlecode.charts4j.Color;
import com.googlecode.charts4j.DataUtil;
import com.googlecode.charts4j.GCharts;
import com.googlecode.charts4j.Line;
import com.googlecode.charts4j.LineChart;
import com.googlecode.charts4j.LineStyle;
import com.googlecode.charts4j.Plots;
import com.googlecode.charts4j.Shape;
import com.mycom.chartpoc.entity.EmployeeSkill;

public class SequencialPlot {

	public LineChart createLineCharts(List<EmployeeSkill> employeSkills) {

		Map<String, List<Integer>> map = new HashMap<>();

		List<Integer> skills = new ArrayList<>();
		Set<String> skillName = new LinkedHashSet<String>();
		for (EmployeeSkill e : employeSkills) {

			if (!map.containsKey(e.getEmployee().getEmployeeFirstName())) {
				map.put(e.getEmployee().getEmployeeFirstName(), null);
				skills = new ArrayList<Integer>();
			}
			if (map.containsKey(e.getEmployee().getEmployeeFirstName())) {
				skills.add(e.getEmployeeSkillRating());
				skillName.add(e.getSkill().getSkillName());
				map.put(e.getEmployee().getEmployeeFirstName(), skills);
			}

		}
		
	    Color[] colour = {Color.RED,Color.SILVER,Color.GOLD,Color.BLUE,Color.TOMATO,Color.BLANCHEDALMOND};
	    int c=0;
		List<Line> lines = new ArrayList<>();
		Set<String> employees = map.keySet();
		for (String employee : employees) {
			// plots.add(Plots.newPlot(Data.newData(map.get(employee))));
			Line line2 = (Plots.newLine(
					DataUtil.scaleWithinRange(0, 6, map.get(employee)),
					colour[c++], employee));
			line2.setLineStyle(LineStyle.newLineStyle(3, 1, 0));
			line2.addShapeMarkers(Shape.CIRCLE, Color.LIME, 10);
			line2.addShapeMarkers(Shape.CIRCLE, Color.BLACK, 7);

			lines.add(line2);
		}

		// Plot plot = Plots.newPlot(Data.newData(0, 10, 20, 30, 40, 50, 60, 70,
		// 80, 90));

		// plot.addShapeMarkers(Shape.DIAMOND, Color.BLUE, 12);
		LineChart lineChart = GCharts.newLineChart(lines);
		lineChart.setSize(800, 300);
		
		//set the axis.
		List<String> skillNames =new ArrayList<>();
		List<String> skillNamesSet1 =new ArrayList<>();
		List<String> skillNamesSet2 =new ArrayList<>();
		List<String> skillNamesSet3 =new ArrayList<>();
		skillNames.addAll(skillName);
		Iterator<String> itr = skillNames.iterator();
		while(itr.hasNext()) {
			skillNamesSet1.add(itr.next());
			if(itr.hasNext())
			skillNamesSet2.add(itr.next());
			if(itr.hasNext())
			skillNamesSet3.add(itr.next());
		}
		AxisStyle axisStyle = AxisStyle.newAxisStyle(Color.BLACK, 10, AxisTextAlignment.CENTER);
        AxisLabels yAxis = AxisLabelsFactory.newNumericRangeAxisLabels(0,6,1);
        yAxis.setAxisStyle(axisStyle);
        AxisLabels xAxis1 = AxisLabelsFactory.newAxisLabels(skillNamesSet1);
        xAxis1.setAxisStyle(axisStyle);
        AxisLabels xAxis2 = AxisLabelsFactory.newAxisLabels(skillNamesSet2);
        xAxis2.setAxisStyle(axisStyle);
        AxisLabels xAxis3 = AxisLabelsFactory.newAxisLabels(skillNamesSet3);
        xAxis3.setAxisStyle(axisStyle);

        // Adding axis info to chart.
        lineChart.addYAxisLabels(yAxis);
        lineChart.addXAxisLabels(xAxis1);
        lineChart.addXAxisLabels(xAxis2);
        lineChart.addXAxisLabels(xAxis3);
        
		return lineChart;
	}

}
