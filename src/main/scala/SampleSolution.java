import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

class Business {
    String name;
    String location;
    String id;

    Business(String name, String location, String id) {
        this.name = name;
        this.location = location;
        this.id = id;
    }
}

class Chain {
    String name;
    Integer frequency;

    Chain(String name, Integer frequency) {
        this.name = name;
        this.frequency = frequency;
    }
}

public class SampleSolution {

    public static List<Chain> detectAndOrderChainBusiness(List<Business> businesses, String location) {
        Map<String, String> filteredByLocation = businesses.stream()
                .filter(b -> location.equals(b.location))
                .collect(Collectors.toMap(b -> b.name, b -> b.id, (id1, id2) -> id1 + "," + id2));

        Map<String, Integer> frequencyByBusiness = new HashMap<>();
        filteredByLocation.forEach((key, value) -> {
            int max = 0;
            Map<String, Integer> c = new HashMap<>();
            for (String id : value.split(",")) {
                c.putIfAbsent(id, 0);
                c.put(id, c.get(id) + 1);
                max = Math.max(max, c.get(id));
            }
            frequencyByBusiness.put(key, max);
        });

        return frequencyByBusiness.entrySet().stream()
                .map(e -> new Chain(e.getKey(), e.getValue()))
                .collect(Collectors.toList()).stream()
                .sorted((o1, o2) -> {
                    if (o1.frequency.equals(o2.frequency)) {
                        return o2.name.compareTo(o1.name);
                    } else {
                        return o2.frequency - o1.frequency;
                    }
                })
                .collect(Collectors.toList());
    }

    public static void main(String args[]) throws Exception {
        List<Chain> chains = detectAndOrderChainBusiness(new ArrayList<Business>() {{
            add(new Business("starbucks", "berlin", "1"));
            add(new Business("starbucks", "berlin", "2"));
            add(new Business("starbucks", "berlin", "2"));
            add(new Business("starbucks", "berlin", "2"));
            add(new Business("starbucks", "berlin", "3"));
            add(new Business("super kaffee", "munich", "4"));
            add(new Business("xyz", "berlin", "5"));
            add(new Business("xyz", "berlin", "5"));
            add(new Business("abc", "berlin", "6"));
            add(new Business("abc", "berlin", "6"));
        }}, "berlin");
        System.out.println(chains);
    }
}