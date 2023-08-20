import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Song> hashMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!hashMap.containsKey(genres[i])) {
               hashMap.put(genres[i], new Song(plays[i], new int[]{i, plays[i]}));
            } else {
                Song value = hashMap.get(genres[i]);
                value.totalPlay += plays[i];
                value.al.add(new int[]{i, plays[i]});
            }
        }

        List<Map.Entry<String, Song>> entries = new ArrayList<>(hashMap.entrySet());
        Collections.sort(entries, (a, b) -> b.getValue().totalPlay - a.getValue().totalPlay);

        ArrayList<Integer> temp = new ArrayList<>();
        for (Map.Entry<String, Song> entry : entries) {
            Collections.sort(entry.getValue().al, (a, b) -> b[1] - a[1]);
            if(entry.getValue().al.size() == 1) {
                temp.add(entry.getValue().al.get(0)[0]);
            }
            else {
                temp.add(entry.getValue().al.get(0)[0]);
                temp.add(entry.getValue().al.get(1)[0]);
            }
        }
        return temp.stream().mapToInt(Integer::intValue).toArray();
    }
}

class Song {
    int totalPlay;
    ArrayList<int[]> al;

    public Song(int totalPlay, int[] play) {
        this.totalPlay = totalPlay;
        this.al = new ArrayList<>(List.of(play));
    }
}