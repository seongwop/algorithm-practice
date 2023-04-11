class Solution {
    public int solution(String s) {
        
        int result = 0;
        String answer = "";
        
        // 문자열 캐릭터 배열로 나누기
        char[] charList = s.toCharArray();
        
        int i = 0;
        
        // 캐릭터의 10진수 아스키값이 숫자를 가르킬 경우 추가
        while (i < charList.length) {
            if (charList[i] >= 48 && charList[i] <= 57) {
                answer += charList[i];
                i++;
            }
            // 인덱스로 영단어의 모든 케이스 체크
            else {
                if (charList[i] == 'z') {
                    answer += '0';
                    i += 4;
                } else if (charList[i] == 'o') {
                    answer += '1';
                    i += 3;
                } else if (charList[i] == 't' && charList[i + 1] == 'w') {
                    answer += '2';
                    i += 3;
                } else if (charList[i] == 't' && charList[i + 1] == 'h') {
                    answer += '3';
                    i += 5;
                } else if (charList[i] == 'f' && charList[i + 1] == 'o') {
                    answer += '4';
                    i += 4;
                } else if (charList[i] == 'f' && charList[i + 1] == 'i') {
                    answer += '5';
                    i += 4;
                } else if (charList[i] == 's' && charList[i + 1] == 'i') {
                    answer += '6';
                    i += 3;
                } else if (charList[i] == 's' && charList[i + 1] == 'e') {
                    answer += '7';
                    i += 5;
                } else if (charList[i] == 'e') {
                    answer += '8';
                    i += 5;
                } else if (charList[i] == 'n') {
                    answer += '9';
                    i += 4;
                }
            }
        }
        result = Integer.parseInt(answer);
        return result;        
        
//         replace 메서드를 사용한 답
        
//         s=s.replace("zero","0");
//         s=s.replace("one","1");    
//         s=s.replace("two","2");
//         s=s.replace("three","3");
//         s=s.replace("four","4");
//         s=s.replace("five","5");
//         s=s.replace("six","6");
//         s=s.replace("seven","7");
//         s=s.replace("eight","8");
//         s=s.replace("nine","9");

//         result = Integer.parseInt(s);
//         return result;     
    }
}