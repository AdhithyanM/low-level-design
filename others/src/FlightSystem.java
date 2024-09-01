import java.util.*;

public class FlightSystem {
    Map<String, Map<String, List<String>>> network;

    public FlightSystem() {
        this.network = new HashMap<>();
    }

    public void addFlight(String flightCode, String origin, String destination) {
        network.putIfAbsent(origin, new HashMap<>());
        network.putIfAbsent(destination, new HashMap<>());
        network.get(origin).putIfAbsent(destination, new ArrayList<>());
        network.get(destination).putIfAbsent(origin, new ArrayList<>());

        // todo - have duplicate flightCode check
        network.get(origin).get(destination).add(flightCode);
        network.get(destination).get(origin).add(flightCode);
    }

    public boolean isDirectFlightAvailable(String origin, String destination) {
        return network.containsKey(origin) && network.get(origin).containsKey(destination);
    }

    // get available direct flights
    public List<String> getAvailableDirectFlights(String origin, String destination) {
        if(!network.containsKey(origin) || !network.get(origin).containsKey(destination)) {
            return new ArrayList<>();
        }
        return network.get(origin).get(destination);
    }

    // get all possible indirect flight routes
    // dfs + backtracking
    public List<List<String>> getPossibleIndirectRoutes(String origin, String destination) {
        List<List<String>> possibleRoutes = new ArrayList<>();
        List<String> currentPath = new ArrayList<>();
        // todo - check for invalid input
        Set<String> visited = new HashSet<>();
        dfs(origin, destination, currentPath, visited, possibleRoutes);
        return possibleRoutes;
    }

    // get the shortest routes from origin to destination
    public List<List<String>> getShortestRoutes(String origin, String destination) {
        List<List<String>> possibleRoutes = bfs(origin, destination);
        List<List<String>> onlyFlightsRoutes = new ArrayList<>();
        for(List<String> route : possibleRoutes) {
            List<String> onlyFlightsRoute = new ArrayList<>();
            for(int i = 1; i < route.size(); i += 2) {
                onlyFlightsRoute.add(route.get(i));
            }
            onlyFlightsRoutes.add(onlyFlightsRoute);
        }
        return onlyFlightsRoutes;
    }

    public void dfs(String current, String destination, List<String> currentPath, Set<String> visited, List<List<String>> possibleRoutes) {
        if(visited.contains(current)) {
            return;
        }

        if(current.equals(destination)) {
            possibleRoutes.add(new ArrayList<>(currentPath));
            return;
        }

        visited.add(current);
        Map<String, List<String>> connections = network.get(current);
        for(Map.Entry<String, List<String>> entry : connections.entrySet()) {
            String nextDestination = entry.getKey();
            for(String flight : entry.getValue()) {
                currentPath.add(flight);
                dfs(nextDestination, destination, currentPath, visited, possibleRoutes);
                currentPath.remove(currentPath.size() - 1); // backtrack
            }
        }
        visited.remove(current); // backtrack
    }

    public List<List<String>> bfs(String origin, String destination) {
        List<List<String>> possibleRoutes = new ArrayList<>();

        Queue<List<String>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new ArrayList<>(List.of(origin)));

        int shortestPath = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            List<String> path = queue.poll();
            String current = path.get(path.size() - 1);
            visited.add(current);

            if(current.equals(destination)) {
                if(path.size() < shortestPath) {
                    shortestPath = path.size();
                    possibleRoutes.add(new ArrayList<>(path));
                }
                else if(path.size() == shortestPath) {
                    possibleRoutes.add(new ArrayList<>(path));
                }
                continue;
            }

            Map<String, List<String>> connections = network.get(current);
            for(Map.Entry<String, List<String>> entry : connections.entrySet()) {
                String nextDestination = entry.getKey();
                if(!visited.contains(nextDestination)) {
                    for(String flight : entry.getValue()) {
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(flight);
                        newPath.add(nextDestination);
                        queue.offer(new ArrayList<>(newPath));
                    }
                }
            }
        }

        return possibleRoutes;
    }

    public static void main(String[] args) {
        FlightSystem flightSystem = new FlightSystem();

        // add flights
        flightSystem.addFlight("F1", "A", "B");
        flightSystem.addFlight("F2", "A", "B");
        flightSystem.addFlight("F3", "A", "B");
        flightSystem.addFlight("F6", "A", "E");
        flightSystem.addFlight("F4", "A", "C");
        flightSystem.addFlight("F7", "C", "E");
        flightSystem.addFlight("F5", "A", "C");
        flightSystem.addFlight("F9", "B", "D");
        flightSystem.addFlight("F8", "D", "E");
        flightSystem.addFlight("F10", "D", "F");
        flightSystem.addFlight("F11", "F", "G");
        flightSystem.addFlight("F12", "F", "G");
        flightSystem.addFlight("F13", "C", "B");

        System.out.println("The network: ");
        System.out.println(flightSystem.network);
        System.out.println();
        System.out.println("The Possible Routes using DFS: ");
        System.out.println("Between A to B: "+flightSystem.getPossibleIndirectRoutes("A", "B"));
        System.out.println("Between A to C: "+flightSystem.getPossibleIndirectRoutes("A", "C"));

        System.out.println();
        System.out.println("The Shortest Routes using BFS: ");
        System.out.println("Between A to D: "+flightSystem.getShortestRoutes("A", "D"));
        System.out.println("Between C to F: "+flightSystem.getShortestRoutes("C", "F"));

    }
}
