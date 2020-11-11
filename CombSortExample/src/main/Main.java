package main;

import java.text.ParseException;
import java.util.ArrayList;

import combsort.CombSortProcess;
import model.Person;
import util.DefineValues;
import util.ShowProcess;

public class Main {

	private static ArrayList<Person> personList = new ArrayList<>();
	private static ArrayList<Person> sortedpersonList = new ArrayList<>();
	
	public static void main(String[] args) throws ParseException {
		
		
		personList = DefineValues.defineValues(personList);
		
		
		System.out.println("---------------------------------");
		System.out.println("BEFORE COMB SORT byId");
		ShowProcess.showValues(personList);	
		

		System.out.println("AFTER COMB SORT byId");
		CombSortProcess.byId(personList);	
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE COMB SORT byLastName");		
		ShowProcess.showValues(personList);				
		
		System.out.println("AFTER COMB SORT byLastName");
		CombSortProcess.byLastName(personList);	
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE COMB SORT byName");
		ShowProcess.showValues(personList);

		System.out.println("AFTER COMB SORT byName");
		CombSortProcess.byName(personList);
		System.out.println("---------------------------------\n");
		
		System.out.println("BEFORE COMB SORT byAge");		
		ShowProcess.showValues(personList);

		System.out.println("AFTER COMB SORT byAge");
		CombSortProcess.byAge(personList);
		System.out.println("---------------------------------");
		
		System.out.println("BEFORE SHELL SORT byRegisterDate");		
		ShowProcess.showValues(personList);

		System.out.println("AFTER SHELL SORT byRegisterDate");
		CombSortProcess.byRegisterDate(personList);
		System.out.println("---------------------------------");
	}
}
