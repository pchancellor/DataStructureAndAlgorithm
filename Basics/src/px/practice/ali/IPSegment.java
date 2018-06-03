package px.practice.ali;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IPSegment {
	/*
	 * ����IP���б�ÿ�а���һ��IP�κͶ�Ӧ�İ���Ͱͻ���λ�ã�IP�ε�������Ƚ϶ࣻ�κ�����IP������ڳ�ͻ��
10.20.86.0/24 ǧ��������
192.168.0.0/24 �ű�����
192.168.1.0/24 �ű�����
11.20.84.0/22   �Ϻ�����
��
����Ƴ����������һ��IP�����������IP���ڵ�IP�κͻ�����Ϣ��Ҫ�󾡿�����ռ�ÿռ��ʱ�䣻
���룺192.168.0.1
�����192.168.0.0/24 �ű�����

192.168.0.1
10.20.86.0/24 ǧ��������
end
	 */
	
    /** ������������������ʵ����ĿҪ��Ĺ��� **/
    /** ��Ȼ����Ҳ���Բ��������ģ����������ȫ�����Լ����뷨�� ^-^  **/
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