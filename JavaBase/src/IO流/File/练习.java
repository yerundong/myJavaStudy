package IO流.File;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public class 练习 {
    /**
     * @练习File： 遍历指定目录下所有文件，将后缀为“.png”的文件对象放在集合中返回
     */
    @Test
    public void exe1() {
        File parentDir = new File("IOTestFile");
        ArrayList<File> pspFileNames = getPngFile(parentDir);
        System.out.println(pspFileNames);
    }

    public ArrayList<File> getPngFile(File dir) {
        File[] fileArr = dir.listFiles();
        ArrayList<File> list = new ArrayList<>();
        for (File f : fileArr) {
            if (f.getName().toLowerCase().endsWith(".png")) {
                list.add(f);
            }
        }
        return list;
    }

    /**
     * @练习File： 遍历指定目录下所有文件，包含子目录下的文件，将文件对象放在集合中返回。
     */
    @Test
    public void exe2() {
        File parentDir = new File("IOTestFile");
        ArrayList<File> allFiles = getAllFiles(parentDir);
        System.out.println(allFiles);

        long totalLen = 0;
        for (File f : allFiles) {
            totalLen += f.length();
        }
        System.out.println(totalLen);
    }

    public ArrayList<File> getAllFiles(File dir) {
        ArrayList<File> list = new ArrayList<>();
        File[] fileArr = dir.listFiles();
        for (File f : fileArr) {
            if (f.isFile()) {// 文件
                list.add(f);
            } else {// 文件夹
                list.addAll(this.getAllFiles(f));
            }
        }
        return list;
    }

    /**
     * @练习File： 删除指定目录及其所有文件
     */
    @Test
    public void exe3() {
        this.deleteDir(new File("IOTestFile/ddd"));
    }

    public void deleteDir(File dir) {
        LinkedList<File> deleteSorts = this.getDeleteSorts(dir);
        // System.out.println(deleteSorts);
        for (File f : deleteSorts) {
            f.delete();
        }
    }

    public LinkedList<File> getDeleteSorts(File dir) {
        File[] fileArr = dir.listFiles();
        LinkedList<File> deleteSorts = new LinkedList<>();// 按序删除
        if (fileArr != null && fileArr.length > 0) {
            deleteSorts.addFirst(dir);
            for (File f : fileArr) {
                File[] fileArr2 = f.listFiles();
                if (fileArr2 != null && fileArr2.length > 0) {
                    deleteSorts.addAll(0, this.getDeleteSorts(f));
                } else {
                    deleteSorts.addFirst(f);
                }
            }
        } else {
            deleteSorts.addFirst(dir);
        }
        return deleteSorts;
    }

}
