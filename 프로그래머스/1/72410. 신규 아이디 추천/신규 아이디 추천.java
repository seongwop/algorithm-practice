class Solution {
    public String solution(String new_id) {
        String answer = "";
        answer = parse(new_id);
        return answer;
    }
    
    String parse(String id) {
        id = id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < id.length(); i++) {
            char c = id.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.')) continue;
            sb.append(c);
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (!sb2.isEmpty() && sb2.charAt(sb2.length() - 1) == '.' && c == '.')
                continue;
            sb2.append(c);
        }
        if (!sb2.isEmpty() && sb2.charAt(0) == '.') sb2.deleteCharAt(0);
        if (!sb2.isEmpty() && sb2.charAt(sb2.length() - 1) == '.') sb2.deleteCharAt(sb2.length() - 1);
        if (sb2.isEmpty()) {
            sb2 = new StringBuilder("a");
        }
        if (sb2.length() >= 16) {
            sb2.setLength(15);
            if (sb2.charAt(14) == '.') {
                sb2.setLength(14);
            }
        }
        if (!sb2.isEmpty() && sb2.length() <= 2) {
            char last = sb2.charAt(sb2.length() - 1);
            while (sb2.length() < 3) {
                sb2.append(last);
            }
        }  
        return sb2.toString();
    } 
}