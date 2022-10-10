package com.masterteknoloji.net.web.rest.vm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DailyChartVM {
	
	Set<String> labels = new HashSet<String>();
	Set<String> series = new HashSet<String>();
	List<List<Integer>> datas = new ArrayList<List<Integer>>();
	public Set<String> getLabels() {
		return labels;
	}
	public void setLabels(Set<String> labels) {
		this.labels = labels;
	}
	public Set<String> getSeries() {
		return series;
	}
	public void setSeries(Set<String> series) {
		this.series = series;
	}
	public List<List<Integer>> getDatas() {
		return datas;
	}
	public void setDatas(List<List<Integer>> datas) {
		this.datas = datas;
	}
	
	

}
