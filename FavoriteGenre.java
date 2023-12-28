// Problem Type: Array - 5
// LeetCode - NA

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
/**
 * Algo:
 * 
 * a. Flatten the genres map into song, genre map
 */
/**
 * TC: O(max(songs, users))
 * SC: O(songs)
 */

import java.util.*;
public class FavoriteGenre {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Map<String, List<String>> users = new HashMap<>();
        users.put("A", Arrays.asList("s4", "s2", "s7", "s9", "s10"));
        users.put("B", Arrays.asList("s1", "s2", "s3", "s12"));
        users.put("C", Arrays.asList("s5", "s3", "s6", "s8"));
        Map<String, List<String>> genres = new HashMap<>();
        genres.put("T", Arrays.asList("s5","s7","s6","s8"));
        genres.put("M", Arrays.asList("s1","s9","s10","s2"));
        genres.put("C", Arrays.asList("s3","s12","s4"));
        Map<String, List<String>> result = favGenre(users, genres);
        System.out.println(result);
    }
    
    public static Map<String, List<String>> favGenre(Map<String, List<String>> users, Map<String, List<String>> genres) {
        Map<String, List<String>> result = new HashMap<>();
        Map<String, String> songGenreMap = new HashMap<>();
        for(String genre:genres.keySet()) {
            for(String song: genres.get(genre)) {
                songGenreMap.put(song, genre);
            }
        }
        
        for(String user:users.keySet()) {
            Map<String, Integer> favCount = new HashMap<>();
            int max = 0;
            for(String song:users.get(user)) {
                String genre = songGenreMap.get(song);
                favCount.put(genre, favCount.getOrDefault(genre, 0) + 1);
                max = Math.max(max, favCount.get(genre));
            } 
            List<String> favs = new ArrayList<>();
            for(String genre : favCount.keySet()) {
                if(favCount.get(genre) == max) {
                    favs.add(genre);
                }
            }
            result.put(user, favs);
        }
        return result;
    }
}