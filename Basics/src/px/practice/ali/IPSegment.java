package px.practice.ali;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IPSegment {
	/*
	 * 给定IP段列表，每行包含一个IP段和对应的阿里巴巴机房位置；IP段的数量会比较多；任何两段IP不会存在冲突；
10.20.86.0/24 千岛湖机房
192.168.0.0/24 张北机房
192.168.1.0/24 张北机房
11.20.84.0/22   上海机房
…
请设计程序任意给定一个IP，请输出给定IP所在的IP段和机房信息；要求尽可能少占用空间和时间；
输入：192.168.0.1
输出：192.168.0.0/24 张北机房

192.168.0.1
10.20.86.0/24 千岛湖机房
end
	 */
	
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String ipMatch(String ip, String[] ipRangeList) {
    	for (int i = 0; i < ipRangeList.length; i++) {
			String[] tmp = ipRangeList[i].split(" ")[0].trim().split("/");
			int bitNum = Integer.valueOf(tmp[1]);
			String[] ipSegs = ip.split("\\.");
			String[] rangeSegs = tmp[0].split("\\.");
			int matchBit;
			if (bitNum > 24) {
				matchBit = 3;
			} else if (bitNum > 16) {
				matchBit = 2;
			} else if (bitNum > 8) {
				matchBit = 1;
			} else {
				matchBit = 0;
			}
			boolean match = true;
			for (int j = 0; j < matchBit; j++) {
				if (!ipSegs[i].equals(rangeSegs[i])) {
					match = false;
				}
			}
			if (match && segMatch(rangeSegs[matchBit], ipSegs[matchBit], bitNum-matchBit*8)) {
				return ipRangeList[i];
			}
		}
    	return null;
    }
    
    public static boolean segMatch(String standard, String target, int shouldMatchNumOfOne) {
		return (Integer.valueOf(standard) ^ Integer.valueOf(target)) < (1 << 8-shouldMatchNumOfOne);
	}

    public static void main(String[] args){
    	
        Scanner in = new Scanner(System.in);
        String res;
        
        String _ip;
        try {
            _ip = in.nextLine();
        } catch (Exception e) {
            _ip = null;
        }
        
        List<String> _ipRangeList = new ArrayList<>();
        
        while (in.hasNextLine()) {
            try {
                String temp = in.nextLine();

                if ("end".equals(temp.trim())) {
                    break;
                }

                _ipRangeList.add(temp);

            } catch (Exception e) {
        
            }
        }
        
        res = ipMatch(_ip, _ipRangeList.toArray(new String[_ipRangeList.size()]));
        System.out.println(res);
    }
}