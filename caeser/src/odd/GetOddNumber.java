package odd;

import java.util.Arrays;
import java.util.HashMap;

public class GetOddNumber {

	public Integer oddSort(int[] numbers){
		int count = 0;				
		Integer currentNumber = null;
		Arrays.sort(numbers);
		
		for(int number: numbers){
			//System.out.print(number +"|");
			if(currentNumber == null || currentNumber != number){
				System.out.println(currentNumber + " " + count);
				if (count % 2 != 0)
					return currentNumber;
				currentNumber = number;
				count = 1;
			}else{
				count++;
			}
		}
		
		System.out.println(currentNumber + " " + count);
		
		if (count % 2 != 0)
			return currentNumber;
		
		return null;
	}

	public Object oddMap(int[] numbers) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(Integer number: numbers){
			if(!map.containsKey(number)){
				map.put(number, new Integer(1));
			}else{
				map.put(number, map.get(number) + 1);
			}
		}
		
		for(Integer number: map.keySet()){
			System.out.println(number + " " + map.get(number));
			if(map.get(number) % 2 != 0)
				return number;
		}
		
		return null;
	}
	
	
}
