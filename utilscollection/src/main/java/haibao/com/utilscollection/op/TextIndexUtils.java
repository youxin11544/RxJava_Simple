package haibao.com.utilscollection.op;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/12/1 0001.
 */

public class TextIndexUtils {

    //获取第二个#的索引位置
    public static int getSecondIndex(String maxString, String minString) {

        // 定义统计变量
        int count = 0;
        int secondIndex = 0;
        // 在大串中查找小串第一次
        int index = maxString.indexOf(minString);
        if (index != -1) {
            secondIndex = index;
        }

        // 如果返回值不是-1，说明小串在大串中是存在的。
        while (index != -1) {
            // 统计变量++
            count++;
            // 把查找过的数据给截取掉,重新赋值给大串
            maxString = maxString.substring(index + minString.length());
            // 在新的大串中查找一次小串
            index = maxString.indexOf(minString);


            if (count == 1 && index != -1) {
                secondIndex = +index;

                return secondIndex;

            }
        }
        return secondIndex;
    }


    /**
     * 匹配话题在前面的情况。递归找到所有话题。
     *
     * @param totalContains
     * @param textContent
     */
    public static void findTopic(ArrayList<String> totalContains, String textContent) {
        textContent = textContent.trim();
        if (textContent.startsWith("#") && textContent.length() > 1) {
            int i = textContent.indexOf("#", 1);
            if (i != -1) {
                String topic;//表示找到第二个
                if (textContent.length() > i + 1) {
                    topic = textContent.substring(0, i + 1);
                    totalContains.add(topic);
                    String next = textContent.substring(i + 1);
                    findTopic(totalContains, next);
                } else {
                    topic = textContent;
                    totalContains.add(topic);
                }
            }
        }
    }

    /*
    话题中的最后一个#号的位置
    */
    public static int findHeadFirstSignature(int begin, String content) {
        if (content.length() > begin + 1 && content.indexOf("#", begin) == begin) {
            int pairIndex = content.indexOf("#", begin + 1);    //找到第二个的位置
            System.out.println("i2=" + pairIndex);
            //查询下一位是不是#,如果不是则返回
            if (pairIndex != -1) {  //找到了
                String topic;//表示找到第二个
                if (content.length() > pairIndex + 1) {     //还能继续找。从后一位开始找
                    return findHeadFirstSignature(pairIndex + 1, content);
                } else {        //到最后了。
                    return pairIndex;
                }
            } else {
                //没找到
                if (begin > 0) {  //如果开始的坐标大于0.则返回开始的坐标-1
                    return begin - 1;
                } else {
                    return 0;
                }
            }
        } else {
            if (begin > 0) {  //如果开始的坐标大于0.则返回开始的坐标-1
                return begin - 1;
            } else {
                return 0;
            }
        }
    }





}
