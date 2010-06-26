package fr.afcepf.ai77.g1.metiers.tests;

import fr.afcepf.ai77.g1.metiers.dto.ExampleDTO;
import fr.afcepf.ai77.g1.metiers.implementations.IExampleDTOImpl;

public class TestInterfaces {
	private IExampleDTOImpl exampleDTOimpl;

	public IExampleDTOImpl getExampleDTOimpl() {
		return exampleDTOimpl;
	}

	public void setExampleDTOimpl(IExampleDTOImpl exampleDTOimpl) {
		this.exampleDTOimpl = exampleDTOimpl;
	}
	
	public static void main(String[] args) {
		TestInterfaces test = new TestInterfaces();
		
		ExampleDTO object = test.getExampleDTOimpl().getExampleDTOByNumero(10);
		
		System.out.println(object.getNumero());
	}
}
