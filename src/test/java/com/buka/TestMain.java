package com.buka;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.Arrays;

public class TestMain {
    @Test
    public void test1() {
        String seatinfo = "[\n" +
                "[0,0,0,0,1,0,0,0,0],\n" +
                "[0,0,0,0,1,0,0,0,0],\n" +
                "[0,0,0,0,1,0,0,0,0],\n" +
                "[0,0,0,0,1,0,0,0,0]\n" +
                " ]";
        String seat = "[0,1]";
        Integer[] seatArr = JSON.parseObject(seat,Integer[].class);
        Integer[][] parseObject = JSON.parseObject(seatinfo,Integer[][].class);
        for (int i = 0;i<parseObject.length;i++){
            if (seatArr[0] == i){
                parseObject[i][seatArr[1]] = 2;
            }
            System.out.println(Arrays.toString(parseObject[i]));
        }


    }
/*

[
[0,0,0,0,1,0,0,0,0],
[0,0,0,0,1,0,0,0,0],
[0,0,0,0,1,0,0,0,0],
[0,0,0,0,1,0,0,0,0]
]
 */

}