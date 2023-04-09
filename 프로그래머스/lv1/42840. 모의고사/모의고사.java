import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[] pattern_student1 = {1, 2, 3, 4, 5};
        int[] pattern_student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern_student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int student1, student2, student3, idx1, idx2, idx3;
        student1 = student2 = student3 = idx1 = idx2 = idx3 = 0;
        
        for (int i = 0; i < answers.length; i++) {
            
            // 수포자 1 채점
            idx1 %= 5;
            if (answers[i] == pattern_student1[idx1++]) student1++;

            // 수포자 2 채점
            idx2 %= 8;
            if (answers[i] == pattern_student2[idx2++]) student2++;

            // 수포자 3 채점
            idx3 %= 10;
            if (answers[i] == pattern_student3[idx3++]) student3++;
        }
        
        int[] score = {student1, student2, student3};
        int max = Math.max(student1, Math.max(student2, student3)); // 점수의 최댓값
        
        List<Integer> list = new ArrayList<>();
        
        // 최댓값을 받은 학생을 list에 add
        if (student1 == max) list.add(1);
        if (student2 == max) list.add(2);
        if (student3 == max) list.add(3);
            
        // ArrayList를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }
}