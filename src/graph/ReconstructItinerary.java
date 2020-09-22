package graph;

import java.util.*;

/**
 *
 */
// 332. Reconstruct Itinerary
public class ReconstructItinerary {
    public static void main(String[] args) {

        String[][] internity = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        List<List<String>> i = new ArrayList();
        //List<String> z= new ArrayList<>();

        Arrays.stream(internity).forEach(m -> {
            List<String> z = new ArrayList<>();
            z.add(m[0]);
            z.add(m[1]);
            i.add(z);

        });
        ReconstructItinerary r = new ReconstructItinerary();
        System.out.println(r.findItinerary(i));
    }


    public List<String> findItinerary(List<List<String>> tickets) {

        //Find all the possible places and create indegree outdegree

        // Now Let us create an adjacency list to know all possible places we can visit
        Map<String, List<String>> adjacentStations = new HashMap<>();
        for(List<String> stationCodes: tickets){
            String key=stationCodes.get(0);
            List<String> possibleStations= adjacentStations.get(key);
            if(possibleStations==null){
                possibleStations= new ArrayList<String>();
            }
            possibleStations.add(stationCodes.get(1));
            adjacentStations.put(key,possibleStations );
        }
        //Since all need to be in lexical sorted lets sort all in adjaceny list
        Set<String> airPorts= adjacentStations.keySet();
        for(String s:adjacentStations.keySet()) {
            Collections.sort(adjacentStations.get(s));
        }

        List<String> st = new ArrayList<>();
        topologicalSort(adjacentStations, "JFK", st);
        return st;
    }

    private void topologicalSort(Map<String, List<String>> adjacencyList, String currentStation,
                                 List<String> result) {
        if (adjacencyList.containsKey(currentStation)) {
            List<String> destinations = adjacencyList.get(currentStation);
            while (!destinations.isEmpty()) {
                topologicalSort(adjacencyList, destinations.remove(0), result);
            }
        }
        result.add(0,currentStation);
    }
}
