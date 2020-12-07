package com.iremenber.api.utils;
 
 
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author KEVIN
 */
public interface FileUtil {

    static void main(String[] args) {
 
 
        File f = new File("D:\\mydir\\新建文件夹");
        System.out.println(f.getName());
 
 
        System.out.println("创建文件夹：" + createDirs("D:\\mydir\\新建文件夹"));
 
//        System.out.println("removed:" + remove(f));
 
    }
 
    /**
     * 递归删除文件（夹）
     *
     * @param file 待删除的文件（夹）
     * @return
     */
 
    static boolean remove(File file) {
        if (!file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        Arrays.asList(file.listFiles()).forEach(FileUtil::remove);
        return file.delete();
    }
    public static List<File> orderByName(String filePath) {
        File file = new File(filePath);
        File[] files = file.listFiles();
        List<File> fileList = Arrays.asList(files).stream().filter(f -> f.isFile()).collect(Collectors.toList());
        Collections.sort(fileList, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                if (o1.isDirectory() && o2.isFile())
                    return -1;
                if (o1.isFile() && o2.isDirectory())
                    return 1;
                return o1.getName().compareTo(o2.getName());
            }
        });
        return fileList;
    }

    /**
     * 创建多级目录
     *
     * @param dirPath
     * @return
     */
    static boolean createDirs(String dirPath) {
        if (Objects.equals("", dirPath) || Objects.equals(null, dirPath)) {
            return false;
        }
        File file = new File(dirPath);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }
}