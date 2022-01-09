package ar.com.miura.jvm.graph;


/**
 * https://leetcode.com/problems/destination-city/
 * You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
 * <p>
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 */
public class DestinationCity {

    public String destCity(java.util.List<java.util.List<String>> paths) {
        java.util.Map<String, java.util.List<String>> adjacentList = new java.util.TreeMap();

        for (java.util.List<String> eachConnectionList : paths) {
            String originElement = eachConnectionList.get(0);
            String destinationElement = eachConnectionList.get(1);

            if (!adjacentList.containsKey(originElement)) {
                adjacentList.put(originElement, new java.util.ArrayList());
            }
            if (!adjacentList.containsKey(destinationElement)) {
                adjacentList.put(destinationElement, new java.util.ArrayList());
            }

            adjacentList.get(originElement).add(destinationElement);
        }

        java.util.Optional destinationEntry = adjacentList.entrySet().stream().filter(entry -> entry.getValue().size() == 0).findFirst();
        java.util.Map.Entry entry = (java.util.Map.Entry) destinationEntry.get();
        return entry.getKey().toString();
    }
}

