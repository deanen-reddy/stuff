package caeser;

import java.util.HashMap;

public class DirectedGraph {

	private static final String FOX_STREET = "Fox Street";
	private static final String OWL_STREET = "Owl Street";
	private static final String PLEIN_STREET = "Plein Street";
	private static final String FULLER_STREET = "Fuller Street";
	public static final String JUNCTION_AVE = "Junction Ave";
	private HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
	
	private void addRoute(String location, String destination, Integer distance){
		HashMap<String, Integer> destinationMap;
		
		if(graph.containsKey(location)){
			destinationMap = graph.get(location);
		}else{
			destinationMap = new HashMap<>();
		}
		
		destinationMap.put(destination, distance);
		graph.put(location, destinationMap);				
	}
	
	public void addRoutes(String location, String destination, Integer distance){
		addRoute(location, destination, distance);
		addRoute(destination, location, distance);
	}
	
	public Integer getDistance(String startingPoint, String... destinations){
		Integer totalDistance = 0;
		HashMap<String, Integer> destinationMap = graph.get(startingPoint);
		System.out.print(startingPoint + " --> " + destinations[0] + " = ");		
		Integer distance = destinationMap.get(destinations[0]);
		System.out.println(distance);
		totalDistance += distance;
		for(int c = 0; c < destinations.length - 1; c ++){		
			totalDistance += getDistance(destinations[c], destinations[c+1]);			
		}
		return totalDistance;
	}
	
	public Integer getShortestRoute(String startingPoint, String destination){
		Integer shortest = null;
		HashMap<String, Integer> distanceMap = graph.get(startingPoint);
		
		if(startingPoint == destination)		
			return 0;
		
		for(String otherLocation: distanceMap.keySet()){
			Integer distance = calcRoute(startingPoint, otherLocation, destination, 0);
			Integer otherDistance = distanceMap.get(otherLocation);
			int totalDistance = distance + otherDistance;
			if(shortest == null || totalDistance < shortest){				
				shortest = totalDistance;
			}
		}		
		return shortest;
	}

	private Integer calcRoute(String initialRoute, String startingPoint, String destination, Integer totalDistance) {		
		HashMap<String, Integer> destinationMap = graph.get(startingPoint);
			
		if(destinationMap.containsKey(destination)){			
			Integer distance = destinationMap.get(destination);
			totalDistance += distance ;
			return totalDistance;
		}else{
			for(String otherLocation: destinationMap.keySet()){
				if(!destination.equals(initialRoute) && !destination.equals(startingPoint)){
					Integer destDistance = destinationMap.get(otherLocation);
					totalDistance += destDistance;
					totalDistance += calcRoute(initialRoute, otherLocation, destination, totalDistance);					
				}
			}			
		}	
		return totalDistance;
	}
		
	
	
	public static void main(String[] args) {
		DirectedGraph directedGraph = new DirectedGraph();
		directedGraph.addRoutes(JUNCTION_AVE, FULLER_STREET, 5);
		directedGraph.addRoutes(JUNCTION_AVE, PLEIN_STREET, 7);
		directedGraph.addRoutes(JUNCTION_AVE, OWL_STREET, 5);
		directedGraph.addRoutes(FULLER_STREET, FOX_STREET, 4);
		directedGraph.addRoutes(FULLER_STREET, PLEIN_STREET, 3);
		directedGraph.addRoutes(FOX_STREET, OWL_STREET, 8);
		directedGraph.addRoutes(FOX_STREET, PLEIN_STREET, 2);
		directedGraph.addRoutes(PLEIN_STREET, OWL_STREET, 6);
		
		System.out.println("Total: " + directedGraph.getDistance(JUNCTION_AVE, FULLER_STREET, FOX_STREET));
		System.out.println("Total: " + directedGraph.getDistance(JUNCTION_AVE, OWL_STREET, FOX_STREET));
		
		System.out.println("\nShortest route: ");
		System.out.println("Sortest distance: " + JUNCTION_AVE + " --> " + FOX_STREET + " = " + directedGraph.getShortestRoute(JUNCTION_AVE, FOX_STREET));
		System.out.println("Sortest distance: " + FOX_STREET + " --> " + FOX_STREET + " = " + + directedGraph.getShortestRoute(FOX_STREET, FOX_STREET));
		System.out.println("Sortest distance: " + OWL_STREET + " --> " + FULLER_STREET + " = " + + directedGraph.getShortestRoute(OWL_STREET, FULLER_STREET));
		System.out.println("Sortest distance: " + PLEIN_STREET + " --> " + FULLER_STREET + " = " + + directedGraph.getShortestRoute(PLEIN_STREET, FULLER_STREET));
		System.out.println("Sortest distance: " + FOX_STREET + " --> " + FULLER_STREET + " = " + + directedGraph.getShortestRoute(FOX_STREET, FULLER_STREET));
		System.out.println("Sortest distance: " + OWL_STREET + " --> " + FULLER_STREET + " = " + + directedGraph.getShortestRoute(OWL_STREET, FULLER_STREET));
		System.out.println("Sortest distance: " + FOX_STREET + " --> " + JUNCTION_AVE + " = " + + directedGraph.getShortestRoute(FOX_STREET, JUNCTION_AVE));
		System.out.println("Sortest distance: " + FULLER_STREET + " --> " + OWL_STREET + " = " + + directedGraph.getShortestRoute(FULLER_STREET, OWL_STREET));
		System.out.println("Sortest distance: " + OWL_STREET + " --> " + FOX_STREET + " = " + + directedGraph.getShortestRoute(OWL_STREET, FOX_STREET));
	}
}

