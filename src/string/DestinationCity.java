package string;
import java.util.*;

//1436. Destination City https://leetcode.com/problems/destination-city/
public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        String location = "";
        int i = 0;
        for (List<String> path : paths) {
            if (i == 0)
                location = path.get(0);
            map.put(path.get(0), path.get(1));

        }
        String dest = "";
        while (location != null) {
            dest = location;
            location = map.get(location);

        }

        return dest;


    }
}
