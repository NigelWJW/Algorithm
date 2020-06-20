package String;
/**
 * 暴力匹配字符串
 */
public class ViolenceMatch {
        public static void main(String[] args) {
            //测试暴力匹配算法
            String str1 = "暴力破解数组破解暴力字符数组暴力数组";
            String str2 = "暴力数组";
            int index = violenceMatch(str1, str2);
            System.out.println("index=" + index);
        }
        // 暴力匹配算法实现
        public static int violenceMatch(String str1, String str2) {
            char[] s1 = str1.toCharArray();//字符转数组
            char[] s2 = str2.toCharArray();
            int s1Len = s1.length;//获得长度
            int s2Len = s2.length;
            int i = 0; // i索引指向s1
            int j = 0; // j索引指向s2
            while (i < s1Len && j < s2Len) {// 保证匹配时，不越界
                if(s1[i] == s2[j]) {//匹配ok
                    i++;
                    j++;
                } else { //没有匹配成功
                    //如果失配（即str1[i]! = str2[j]），令i = i - (j - 1)，j = 0。回到匹配之前的下一位回溯
                    i = i - (j - 1);
                    j = 0;
                }
            }
            //判断是否匹配成功，返回匹配字符串的第一位索引
            if(j == s2Len) {//j到达终点
                return i - j;
            } else {
                return -1;
            }
        }
    }

