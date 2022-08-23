import java.util.*;

class Solution {
        public int solution(String s) {
        int answer;
        int min = 1000;
        if(s.length() == 1)
            return 1;

        for(int i=1; i<s.length(); i++){
            List<String> list = new ArrayList<>();

            for(int j=0; j<s.length(); j+=i){
                if(j+i>s.length())
                    list.add(s.substring(j));
                else
                    list.add(s.substring(j,j+i));
            }

            int cnt =0; // list 인덱스
            String result = "";
            int result_cnt = 1;
            String temp = "";

            for(String str : list){
                if(!temp.isEmpty()) {
                    if (str.equals(temp)) {
                        result_cnt++;
                    } else {
                        if (result_cnt > 1)
                            result += result_cnt + temp;
                        else
                            result += temp;
                        result_cnt = 1;
                    }
                }
                if (cnt == list.size()-1) {
                    if (str.equals(temp)) {
                        result += result_cnt + temp;
                    }
                    else{
                        result += str;
                    }
                }
                temp = str;
                cnt ++;
            }
            min = Math.min(min, result.length());
        }
        answer = min;
        return answer;
    }
}