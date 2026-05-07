import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalPlays = new HashMap<>();
        Map<String, List<Song>> songs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
            songs.putIfAbsent(genres[i], new ArrayList<>());
            songs.get(genres[i]).add(new Song(i, plays[i]));
        }
        List<String> genreList = new ArrayList<>(totalPlays.keySet());
        genreList.sort((a, b) -> totalPlays.get(b) - totalPlays.get(a));
        List<Integer> list = new ArrayList<>();
        for (String genre : genreList) {
            List<Song> songList = songs.get(genre);
            songList.sort((a, b) -> b.plays - a.plays);
            list.add(songList.get(0).index);
            if (songList.size() == 1) continue;
            list.add(songList.get(1).index);
        }
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
    
    class Song {
        int index;
        int plays;
        public Song(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }
}