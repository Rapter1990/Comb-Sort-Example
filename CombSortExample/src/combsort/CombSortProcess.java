package combsort;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

import model.Person;
import util.ShowProcess;

public class CombSortProcess {
	
	private static ArrayList<Person> sortedpersonList = new ArrayList<>();
	private static Person[] sortedPersonArray = null;
	
	public static void byId(ArrayList<Person> personList) {
		
		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				return Long.compare(p0.getId(), p1.getId());
			}
		};

		Person[] persons = convertListToArray(personList);
		sortedPersonArray = combSort(persons, compTr);

		sortedpersonList = convertArrayToList(sortedPersonArray);
		ShowProcess.showValues(sortedpersonList);
	}
	
	public static void byLastName(ArrayList<Person> personList) {
		
		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				Collator collator = Collator.getInstance(new Locale("tr", "TR"));
				return collator.compare(p0.getLastname(), p1.getLastname());
			}
		};

		Person[] persons = convertListToArray(personList);
		sortedPersonArray = combSort(persons,  compTr);

		sortedpersonList = convertArrayToList(sortedPersonArray);
		ShowProcess.showValues(sortedpersonList);
	}
	
	public static void byName(ArrayList<Person> personList) {
		
		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				Collator collator = Collator.getInstance(new Locale("tr", "TR"));
				return collator.compare(p0.getName(), p1.getName());
			}
		};

		Person[] persons = convertListToArray(personList);
		sortedPersonArray = combSort(persons, compTr);

		sortedpersonList = convertArrayToList(sortedPersonArray);
		ShowProcess.showValues(sortedpersonList);
	}
	
	public static void byAge(ArrayList<Person> personList) {
		
		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				return Integer.compare(p0.getAge(), p1.getAge());
			}
		};

		Person[] persons = convertListToArray(personList);
		sortedPersonArray = combSort(persons, compTr);

		sortedpersonList = convertArrayToList(sortedPersonArray);
		ShowProcess.showValues(sortedpersonList);
	}
	
	public static void byRegisterDate(ArrayList<Person> personList) {
		
		Comparator<Person> compTr = new Comparator<Person>() {
			@Override
			public int compare(Person p0, Person p1) {
				if (p0.getRegisterDate().before(p1.getRegisterDate())) {
					return -1;
				} else if (p0.getRegisterDate().after(p1.getRegisterDate())) {
					return 1;
				} else {
					return 0;
				}
			}
		};

		Person[] persons = convertListToArray(personList);
		sortedPersonArray = combSort(persons, compTr);

		sortedpersonList = convertArrayToList(sortedPersonArray);
		ShowProcess.showValues(sortedpersonList);
	}
	
	private static Person[] convertListToArray(ArrayList<Person> personList) {
		Person[] persons = personList.toArray(new Person[personList.size()]);
		return persons;
	}

	private static ArrayList<Person> convertArrayToList(Person[] persons) {
		ArrayList<Person> personList = new ArrayList<>(Arrays.asList(persons));
		return personList;
	}
	
	public static Person[] combSort(Person[] persons,Comparator comp) {
		Person[] sortedArray = sort(persons, comp);
		return sortedArray;
	}
	
	public static Person[] sort(Person[] array,Comparator comp) {
		Person[] sortedArray = sortProcess(array, 0, array.length, comp);
		return sortedArray;
    }
	
	private static Person[] sortProcess(Person[] array, int fromIndex, int toIndex, Comparator comp) {
		// TODO Auto-generated method stub
		
	    Person[] sortedPersonArray = sortImpl(array, fromIndex, toIndex, comp);	    
	    return sortedPersonArray;
	}

	private static Person[] sortImpl(Person[] array, int fromIndex, int toIndex, Comparator comp) {
		// TODO Auto-generated method stub
		
		int n = toIndex; 
		  
        // initialize gap 
        int gap = n; 
  
        // Initialize swapped as true to make sure that 
        // loop runs 
        boolean swapped = true; 
  
        // Keep running while gap is more than 1 and last 
        // iteration caused a swap 
        while (gap != 1 || swapped == true) { 
            // Find next gap 
            gap = getNextGap(gap); 
  
            // Initialize swapped as false so that we can 
            // check if swap happened or not 
            swapped = false; 
  
            // Compare all elements with current gap 
            for (int i = fromIndex; i < n - gap; i++) { 
                if (greaterThan(comp,array[i],array[i + gap])) { 
                    // Swap arr[i] and arr[i+gap] 
                    Person temp = array[i]; 
                    array[i] = array[i + gap]; 
                    array[i + gap] = temp; 
  
                    // Set swapped 
                    swapped = true; 
                } 
            } 
        } 
		
		return array;
	}
	
	 // To find gap between elements 
    private static int getNextGap(int gap) { 
        // Shrink gap by Shrink factor 
        gap = (gap * 10) / 13; 
        if (gap < 1) 
            return 1; 
        return gap; 
    } 

	// ASC
	private static boolean greaterThan(Comparator comp, Person x, Person y) {
		return comp.compare(x, y) > 0;
	}

	// DESC
	private static boolean lessThan(Comparator comp, Person x, Person y) {
		return comp.compare(x, y) < 0;
	}
}
