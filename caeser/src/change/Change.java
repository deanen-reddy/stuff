package change;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Change {

	public static List<List<Integer>> getPermutations(List<Integer> input){
		ArrayList<List<Integer>> permutations = new ArrayList<>(); 
					
		for(Integer val: input){
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			arrayList.add(val);
			permutations.add(arrayList);
		}
		
		
		ArrayList<List<Integer>> permutationsTemp = new ArrayList<>(permutations);
		for(Integer value: input){
			ArrayList<Integer> newCombo;			
			for(List<Integer> perm: permutations){			
				newCombo = new ArrayList<>(perm);
				if (!newCombo.contains(value)){
					newCombo.add(value);
					Collections.sort(newCombo);
					if(!permutations.contains(newCombo)){
						permutationsTemp.add(newCombo);
						permutations = new ArrayList<>(permutationsTemp);
					}
				}				
			}			
		}
			
		return permutationsTemp;
	}
	
	public static void getChange(List<Integer> combo, int amount) {
		if(combo != null && combo.size() != 0 ){
			Integer demonitation = combo.get(0);
			int remainder = amount % demonitation;
			int total = amount / demonitation;
			if(remainder >= 0){				
				combo.remove(demonitation);					
				if(remainder == 0 && total != 0){					
					System.out.println("outer " + demonitation + " = " + total);								
				}else if (total != 0){							
					getChange(combo, amount - remainder);
					System.out.println("else " + demonitation + " = " + total);		
				}				
			}else{
				System.out.println("outer else " + demonitation + " = " + total);
			}
		}		
	}
	
	public static void main(String[] args) {
		Integer[] values ={1,2,3};
		List<List<Integer>> permutations = getPermutations(Arrays.asList(values));
		
		for(List<Integer> integers: permutations){
			Collections.reverse(integers);
			System.out.println(Arrays.toString(integers.toArray()));		
			getChange(integers,7);
		}
	}

	

}
