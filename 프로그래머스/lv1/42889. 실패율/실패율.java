import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        List<Stage> stageList = new ArrayList<>();
        int[] answer = new int[N];
        double[] failed = new double[N + 2];
        
        double people = stages.length;
        for (int s : stages) failed[s]++;
        
        for (int i = 1; i <= N; i++) {
            if (people == 0) {
                stageList.add(new Stage(i, 0));
                continue;
            }
            stageList.add(new Stage(i, failed[i] / people));
            people -= failed[i];
        }

        Collections.sort(stageList, new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                return Double.compare(o2.failRate, o1.failRate);
            }
        });
        
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).stageNum;
        }

        
        
        
        
        
        
        
        
        
//         HashMap<Integer, Double> map = new HashMap<>();
//         List<Integer> list = new ArrayList<>();
//         int idx = 0;
//         double count = 0.0;
//         double len = stages.length;
        
//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < stages.length; j++) {
//                 if (stages[j] == i + 1) count++; 
//             }
//             map.put(i + 1, count / len);
            
//             len -= count;
//             count = 0;
//         }
  
//         int[] answer = map
//             .entrySet()
//             .stream()
//             .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//             .mapToInt(entry -> entry.getKey())
//             .toArray();

        return answer;
    }
}

class Stage {
    int stageNum;
    double failRate;
    
    public Stage(int stageNum, double failRate) {
        this.stageNum = stageNum;
        this.failRate = failRate;
    }
}