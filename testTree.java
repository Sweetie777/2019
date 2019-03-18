package testdemo;

/**
 * Author: Sweetie77
 * Created: 2019/3/18
 */
public class testTree {


    public static void main(String[] args) {
        getLeaveNum(680);//例如3个节点时
    }

    public static  void getLeaveNum(int count) {
        int deepth = (int) Math.ceil(Math.log(count) / Math.log(2));
        int upLevelSumCount = (int) Math.pow(2, deepth - 1) - 1;
        int upLevelCount = (int) Math.pow(2, deepth - 2);
        int lastLevelLeavesCount = count - upLevelSumCount;
        int parentCount = lastLevelLeavesCount % 2 == 1 ? lastLevelLeavesCount / 2+1
                : lastLevelLeavesCount / 2;
        int upLevelLeaves=upLevelCount-parentCount;
        System.out.println("leaves count: "+(upLevelLeaves+lastLevelLeavesCount));

    }
}