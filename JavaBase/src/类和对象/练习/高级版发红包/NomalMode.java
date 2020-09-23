package 类和对象.练习.高级版发红包;

import java.util.ArrayList;

public class NomalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(final int totalMoney, final int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        int avg = totalMoney / totalCount; // 平均值
        int mod = totalMoney % totalCount; // 余数，模，零头

        // 注意totalCount - 1代表，最后一个先留着
        for (int i = 0; i < totalCount - 1; i++) {
            list.add(avg);
        }

        // 有零头，需要放在最后一个红包当中
        list.add(avg + mod);

        return list;
    }
}
