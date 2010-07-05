package fr.afcepf.ai77.g1.presentation.bean;

import java.util.List;
import java.util.Vector;

import javax.faces.model.SelectItem;

public class TestBean {

	private SelectItem selected;
	private List<SelectItem> listeChoix;
	
	
	

	public List<SelectItem> getListeChoix() {
		return listeChoix;
	}

	public void setListeChoix(List<SelectItem> listeChoix) {
		this.listeChoix = listeChoix;
	}

	public SelectItem getSelected() {
		return selected;
	}

	public void setSelected(SelectItem selected) {
		this.selected = selected;
	}
	
	
	public String click(){
		
		System.out.println(selected.getValue().toString());
		return "ok";
	}
	
	public TestBean(){
		
		listeChoix = new Vector<SelectItem>();
		
		listeChoix.add(new SelectItem("1", "choix 1"));
		listeChoix.add(new SelectItem("2", "choix 2"));
		listeChoix.add(new SelectItem("3", "choix 3"));
		listeChoix.add(new SelectItem("4", "choix 4"));
		listeChoix.add(new SelectItem("5", "choix 5"));
		
		
		
	}
	
	
}
