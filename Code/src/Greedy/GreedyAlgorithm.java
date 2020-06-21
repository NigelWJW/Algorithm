package Greedy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 * ̰���㷨���򸲸�����
 */
public class GreedyAlgorithm {
        public static void main(String[] args) {
            //�����㲥��̨,���뵽Map
            HashMap<String, HashSet<String>> broadcasts = new HashMap<String, HashSet<String>>();
            //�Ƚ�������̨���뵽��Ӧ�ĸ�����
            HashSet<String> hashSet1 = new HashSet<String>();
            hashSet1.add("����");
            hashSet1.add("�Ϻ�");
            hashSet1.add("���");

            HashSet<String> hashSet2 = new HashSet<String>();
            hashSet2.add("����");
            hashSet2.add("����");
            hashSet2.add("����");

            HashSet<String> hashSet3 = new HashSet<String>();
            hashSet3.add("�ɶ�");
            hashSet3.add("�Ϻ�");
            hashSet3.add("����");

            HashSet<String> hashSet4 = new HashSet<String>();
            hashSet4.add("�Ϻ�");
            hashSet4.add("���");

            HashSet<String> hashSet5 = new HashSet<String>();
            hashSet5.add("����");
            hashSet5.add("����");

            //���뵽map
            broadcasts.put("K1", hashSet1);
            broadcasts.put("K2", hashSet2);
            broadcasts.put("K3", hashSet3);
            broadcasts.put("K4", hashSet4);
            broadcasts.put("K5", hashSet5);

            //allAreas������в��ظ��ĵ���
            HashSet<String> allAreas = new HashSet<String>();
            allAreas.add("����");
            allAreas.add("�Ϻ�");
            allAreas.add("���");
            allAreas.add("����");
            allAreas.add("����");
            allAreas.add("�ɶ�");
            allAreas.add("����");
            allAreas.add("����");

            //����ArrayList, �����ѡ��ĵ�̨����
            ArrayList<String> selects = new ArrayList<String>();

            //����һ����ʱ�ļ��ϣ��ڱ����Ĺ����У���ű��������еĵ�̨ȫ���ǵĵ����͵�ǰ��ǰ���ǵĵ����Ľ���
            HashSet<String> tempSet = new HashSet<String>();

            //�����maxKey��������һ�α��������У��ܹ����� ���δ���� �ĵ�����Ӧ�ĵ�̨��key���ؼ�
            //���maxKey ��Ϊnull , �����뵽 selects
            String maxKey = null;
            while(allAreas.size() != 0) { // ���allAreas ��Ϊ0, ���ʾ��û�и��ǵ����еĵ���
                //ÿ����һ��while,��Ҫ
                maxKey = null;
                //���� broadcasts, ȡ�����ж�Ӧkey
                for(String key : broadcasts.keySet()) {
                    //ÿ����һ��for
                    tempSet.clear();
                    //��ȡ��ǰ���key��ֵ���ܹ����ǵĵ���������temp����ͣ�仯
                    HashSet<String> areas = broadcasts.get(key);
                    tempSet.addAll(areas);
                    //���tempSet��allAreas���ϵĽ���������tempSet
                    tempSet.retainAll(allAreas);
                    //�����ǰ������ϰ�����δ���ǵ�������������maxKeyָ��ļ��ϵ�������
                    //����Ҫ����maxKey
                    // tempSet.size() >broadcasts.get(maxKey).size()) ���ֳ�̰���㷨���ص�,ÿ�ζ�ѡ�����ŵ�
                    if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size()) ){
                        maxKey = key;
                    }
                }
                //maxKey != null,ÿһ����Ͼ�Ӧ�ý�maxKey����selects�����
                if(maxKey != null) {
                    selects.add(maxKey);
                    //��maxKeyָ��Ĺ㲥��̨���ǵĵ������� allAreas ȥ��
                    allAreas.removeAll(broadcasts.get(maxKey));
                }
            }
            System.out.println("�õ���ѡ������" + selects);//[K1,K2,K3,K5]
        }
    }

