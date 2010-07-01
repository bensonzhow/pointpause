package fr.afcepf.ai77.g1.persistence.entity;

import java.util.Vector;


public class LoadingPolicy {
	private Vector<String> policies= new Vector<String>();

	public Vector<String> getPolicies() {
		return policies;
	}

	public void setPolicies(Vector<String> policies) {
		this.policies = policies;
	}

}
