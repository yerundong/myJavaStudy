package IO流.练习;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

public class Base {
    /**
     * @题目： 遍历指定目录下所有文件，将后缀为“.png”的文件对象放在集合中返回
     */
    @Test
    public void exe1(){
        File parentDir = new File("IOTestFile");
        ArrayList<File> pspFileNames = getPngFile(parentDir);
        System.out.println(pspFileNames);
    }

    public ArrayList<File> getPngFile(File parentDir) {
        File[] fileArr = parentDir.listFiles();
        ArrayList<File> list = new ArrayList<>();
        for (File f : fileArr) {
            if(f.getName().toLowerCase().endsWith(".png")){
                list.add(f);
            }
        }
        return list;
    }

    /**
     * @题目： 遍历指定目录下所有文件，包含子目录下的文件，将文件对象放在集合中返回。
     */
    @Test
    public void exe2(){
        File parentDir = new File("IOTestFile");
        ArrayList<File> pspFileNames = getAllFiles(parentDir, new ArrayList<File>());
        System.out.println(pspFileNames);
    }

    public ArrayList<File> getAllFiles(File parentDir, ArrayList<File> list) {
        File[] fileArr = parentDir.listFiles();
        for (File f : fileArr) {
            if(f.isFile()){// 文件
                list.add(f);
            }else{// 文件夹
                this.getAllFiles(f, list);
            }
        }
        return list;
    }
}
