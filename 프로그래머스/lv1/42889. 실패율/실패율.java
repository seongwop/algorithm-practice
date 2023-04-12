import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {

        List<Stage> stageList = new ArrayList<>();
        int[] answer = new int[N];
        double[] failed = new double[N + 2];
        
        // 스테이지 별 실패한 사용자 저장
        double people = stages.length;
        for (int s : stages) failed[s]++;
        // 스테이지 별 실패율을 스테이지 번호와 함께 객체로 저장
        for (int i = 1; i <= N; i++) {
            if (people == 0) {
                stageList.add(new Stage(i, 0));
                continue;
            }
            stageList.add(new Stage(i, failed[i] / people));
            people -= failed[i];
        }
        
        Collections.sort(stageList, (Stage a, Stage b) -> Double.compare(b.failRate, a.failRate));
        
        // 객체 정렬을 위한 compare 메서드 오버라이딩
        // Collections.sort(stageList, new Comparator<Stage>() {
        //     @Override
        //     public int compare(Stage o1, Stage o2) {
        //         return Double.compare(o2.failRate, o1.failRate);
        //     }
        // });
        
        for (int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).stageNum;
        }
        
        return answer;
        
//         2중 for문 + HashMap을 사용한 정답 (효율성이 안좋음)
        
//         HashMap<Integer, Double> map = new HashMap<>();
//         List<Integer> list = new ArrayList<>();
//         int idx = 0;
//         double count = 0.0;
//         double len = stages.length;
        
//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < stages.length; j++) {
//                 if (stages[j] == i + 1) count++; 
//             }
//             if (len == 0) {
//                 map.put(i + 1, 0.0);
//                 continue;
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

//         return answer;
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