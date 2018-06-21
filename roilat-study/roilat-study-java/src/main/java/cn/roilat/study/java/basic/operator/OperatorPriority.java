package cn.roilat.study.java.basic.operator;

public class OperatorPriority {

    public static void main(String[] args) {

        /**
         * DEMO1
         * >>(正数时高位补0，负数是高位补1，即正数最小是0，负数运算结果最大是-1),<<（最低位始终补0）,>>>（最高位始终补0）运算优先级高于 位运算符
         */
        System.out.println(20 & 0xF0 >> 4);//0001 0100 & 0x0F = 4
        System.out.println((20 & 0xF0) >> 4);//0001 0000 >> 4 = 1

        /**
         * DEMO2
         * (++iTemp1 > 0)为true后，后续不再计算
         */
        int iTemp1 = 1, iTemp2 = 1, iTemp3 = 1;
        boolean bTemp1 = (++iTemp1 > 0) || (++iTemp2 > 0) && (++iTemp3 > 0);//
        System.out.println(bTemp1 + " " + iTemp1 + "" + iTemp2 + "" + iTemp3);//结果为211
        
        
        iTemp1 = 1;
        iTemp2 = 1;
        iTemp3 = 1;
        /**
         * DEMO3
         * 如果是按顺序计算的：(++iTemp1 > 3)为false后，则(++iTemp2 > 2)为false，false && (++iTemp3 > 0)<true>，则会false,但是iTemp3=2;
         * 实际上，&& 优先于||计算，当(++iTemp1 > 3)为true直接短路如@DEMO2,为false时，则计算后续((++iTemp2 > 2) && (++iTemp3 > 0))
         * 因为(++iTemp2 > 2)为false,在&&运算中，则不再进行计算(++iTemp3 > 0)，因为iTemp3=1;
         * 
         * TODO 由此可见，&&优先于||
         */
        bTemp1 = (++iTemp1 > 3) || (++iTemp2 > 2) && (++iTemp3 > 0);
        System.out.println(bTemp1 + " " + iTemp1 + "" + iTemp2 + "" + iTemp3);//结果为221
    }
}
