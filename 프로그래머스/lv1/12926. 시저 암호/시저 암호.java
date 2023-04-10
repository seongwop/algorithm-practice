class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        // 캐릭터 배열로 변환
        char[] ch = s.toCharArray();
        
        int idx = 0;
        
        // n번까지 한번씩 아래 로직 수행
        while (idx++ < n) {
            for (int i = 0; i < ch.length; i++) {
                // 공백이 아닐 경우
                if (!(ch[i] == ' ')) {  
                    // 캐릭터가 z나 Z일 경우 a나 A로 변경
                    if(ch[i] == 'z' || ch[i] == 'Z') ch[i] -= 25; 
                    // 그 외엔 한칸 밀기
                    else ch[i]++;
                    }     
                 }
             }
        
        for (char c : ch) answer += c;
        return answer;
        }
    }
