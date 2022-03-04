package com.iremember.learnPlan.utils;
//import com.iremenber.api.utils.FileUtil;
//import org.jaudiotagger.audio.AudioFile;
//import org.jaudiotagger.audio.AudioFileIO;
//import org.jaudiotagger.audio.AudioHeader;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

/**
 * @Author: zm
 * @Date: 2019/9/30 17:19
 * @Version: 1.0
 */
public class Review {

//    public static int getAudioFilesSecond(File file){
//        try {
//            AudioFile f = AudioFileIO.read(file);
//            AudioHeader audioHeader = f.getAudioHeader();
//            return audioHeader.getTrackLength();
//        } catch(Exception e) {
//            throw new RuntimeException("获取时长出错",e);
//        }
//    }
    public static void main(String[] args) {
        newplan();
//        /**
//         * 入参：
//         * 计划每日学习+复习秒数 overstepSeconds
//         * 开始日期 startDate
//         */
//        int overstepSeconds = 180 * 60;
//        /**
//         * 出参：
//         * 总体学习计划
//         * resultMap:{"2019-09-15":[1,2,3]}
//         * flagMap:{"2019-09-15":3}
//         */
//        Map<String,Integer> flagMap = new HashMap<>();
//        Map<String, Set<String>> resultMap = new TreeMap<>();
////        2019/9/15	2019/9/16	2019/9/18	2019/9/19	2019/9/22	2019/9/25	2019/9/26	2019/9/29	2019/10/3	2019/10/6	2019/10/10
//
//        String[] strs = new String[]{"D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇\\入门篇01.mp3|2019-09-15",
//                "D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇\\入门篇02.mp3|2019-09-16",
//                "D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇\\入门篇03.mp3|2019-09-18",
//                "D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇\\入门篇04.mp3|2019-09-19",
//                "D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇\\入门篇05.mp3|2019-09-22",
//                "D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇\\入门篇06.mp3|2019-09-25",
//                "D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇\\入门篇07.mp3|2019-09-26",
//                "D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇\\入门篇08.mp3|2019-09-29",
//                "D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇\\入门篇09.mp3|2019-10-03",
//                "D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇\\入门篇10.mp3|2019-10-06",
//                "D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇\\入门篇11.mp3|2019-10-10"
//                ,"D:\\BaiduNetdiskDownload\\赖世雄\\③美语从头学初级篇\\初级篇001.mp3|2019-10-08"
//                ,"D:\\BaiduNetdiskDownload\\赖世雄\\③美语从头学初级篇\\初级篇002.mp3|2019-10-08"
//                ,"D:\\BaiduNetdiskDownload\\赖世雄\\③美语从头学初级篇\\初级篇003.mp3|2019-10-11"
//                ,"D:\\BaiduNetdiskDownload\\赖世雄\\③美语从头学初级篇\\初级篇004.mp3|2019-10-11"
//        };
//
//        List<File> fs = new ArrayList<>();
//        List<String> sd = new ArrayList<>();
//        Set<String> hadfs = new HashSet<>();
//        for(String str : strs){
//            fs.add(new File(str.split("\\|")[0]));
//            sd.add(str.split("\\|")[1]);
//        }
//        fs.forEach(file -> {
//            hadfs.add(getLessonMinutes(file.getParentFile().getName(),file.getName(),getAudioFilesSecond(file)));
//        });
//
//        initResult(flagMap,resultMap,fs,sd);
////        System.out.println(flagMap);
////        System.out.println(resultMap);
//
//        List<File> files = new ArrayList<>(FileUtil.orderByName("D:\\BaiduNetdiskDownload\\赖世雄\\②美语从头学入门篇"));
////        files.addAll(FileUtil.orderByName("D:\\BaiduNetdiskDownload\\赖世雄\\③美语从头学初级篇"));
////        files.addAll(FileUtil.orderByName("D:\\BaiduNetdiskDownload\\赖世雄\\④美语从头学中级篇"));
//
////        files.addAll(FileUtil.orderByName("D:\\BaiduNetdiskDownload\\赖世雄\\⑤美语从头学高级篇"));
////        files.addAll(FileUtil.orderByName("D:\\BaiduNetdiskDownload\\赖世雄\\⑥赖世雄教你学英语语法\\赖世雄语法（上）"));
////        files.addAll(FileUtil.orderByName("D:\\BaiduNetdiskDownload\\赖世雄\\⑥赖世雄教你学英语语法\\赖世雄语法（下）"));
//
//
//        LocalDate startDate = LocalDate.of(2019,10,12);//1，根据输入的开始日期，初始化开始日期
//
//        plan(overstepSeconds, files, startDate, flagMap, resultMap,hadfs);
//        List<File> filecj = new ArrayList<>(FileUtil.orderByName("D:\\BaiduNetdiskDownload\\赖世雄\\③美语从头学初级篇"));
//        filecj.addAll(FileUtil.orderByName("D:\\BaiduNetdiskDownload\\赖世雄\\④美语从头学中级篇"));
//
//        startDate = LocalDate.of(2019,10,12);//1，根据输入的开始日期，初始化开始日期startDate = LocalDate.of(2019,10,12);//1，根据输入的开始日期，初始化开始日期
//        plan(overstepSeconds, filecj, startDate, flagMap, resultMap,hadfs);
//
//        List<File> yffiles = new ArrayList<>(FileUtil.orderByName("D:\\BaiduNetdiskDownload\\赖世雄\\⑥赖世雄教你学英语语法\\赖世雄语法（上）"));
//        yffiles.addAll(FileUtil.orderByName("D:\\BaiduNetdiskDownload\\赖世雄\\⑥赖世雄教你学英语语法\\赖世雄语法（下）"));
////
////        cyclicPlan(overstepSeconds, yffiles, LocalDate.of(2019,10,12), flagMap, resultMap);
//        Set<String> yf = new TreeSet<>();
//
//        yffiles.forEach(file -> {
//            yf.add(getLessonMinutes(file.getParentFile().getName(),file.getName(),getAudioFilesSecond(file)));
//        });
//        yf.forEach(y -> System.out.println(y));
//
//        //2019-01-01    课时1(时长1分钟20秒) 课时2(时长) 总时长20分钟10秒
//        //2019-01-02    课时1(时长1分钟20秒) 课时2(时长) 总时长20分钟10秒
//        resultMap.forEach((key,value) -> {
//            System.out.print(key);
//            for (String lessonStr : value){
//                System.out.print("\t" + getLesson(lessonStr) + "(" + getMinutes(lessonStr) + ")");
//            }
//            System.out.println("\t " + formatMinutes(flagMap.get(key)));
//        });

/**
 * 1，根据输入的开始日期，初始化开始日期
 * 2，循环课时数量
 * 3，根据开始日期，计算出Ebbinghaus curve日期列表
 * 4，循环Ebbinghaus curve列表，判断是否超出每天学习次数 overstepSeconds
 * 5，如果超出，则设置为下一开始日期并返回第3步
 * 6，如果都没有超出，则直接加入到学习计划
 * 7，课时循环结束，循环复习，插入空余课时
 */
    }
//    private static void cyclicPlan(int overstepSeconds, List<File> files, LocalDate startDate, Map<String, Integer> flagMap, Map<String, Set<String>> resultMap) {
//        LocalDate lastDate = LocalDate.of(2020,12,26);
//        int dayCount = 0;
//        parent:for(int i = 0;lastDate.isAfter(startDate);){//循环课时数量
//            String parentFileName = files.get(i).getParentFile().getName();
//            String fileName = files.get(i).getName();
//
//            int audioFilesSecond = getAudioFilesSecond(files.get(i));
//
//            List<LocalDate> dates = Arrays.asList(startDate);
//
//            if(toBeContinue(overstepSeconds, flagMap, audioFilesSecond, dates)){
//                dayCount = 0;
//                startDate = startDate.plusDays(1);
//                continue parent;
//            }
////            6，如果都没有超出，则直接加入到学习计划
//            addToResult(flagMap, resultMap, parentFileName, fileName, audioFilesSecond, dates);
//
//
//            i ++;
//            dayCount ++;
//            if (dayCount >=3){
//                startDate = startDate.plusDays(1);
//                dayCount = 0;
//            }
//            if(i >= files.size()){
//                i = 0;
//            }
//        }
//    }

//    public static void plan(int overstepSeconds, List<File> files, LocalDate startDate, Map<String, Integer> flagMap, Map<String, Set<String>> resultMap,Set<String> hadfs) {
//        parent:for(int i = 0;i < files.size(); ){//循环课时数量
//            String parentFileName = files.get(i).getParentFile().getName();
//            String fileName = files.get(i).getName();
//            int audioFilesSecond = getAudioFilesSecond(files.get(i));
//            if(hadfs.contains(getLessonMinutes(parentFileName,fileName,audioFilesSecond))){
//                i ++;
//                continue parent;
//            }
//
//
//
////            3，根据开始日期，计算出Ebbinghaus curve日期列表
//            List<LocalDate> ebbinghausCurveDates = getEbbinghausCurveDate(startDate);
//
//            if(toBeContinue(overstepSeconds, flagMap, audioFilesSecond, ebbinghausCurveDates)){
//                startDate = startDate.plusDays(1);
//                continue parent;
//            }
////            6，如果都没有超出，则直接加入到学习计划
//            addToResult(flagMap, resultMap, parentFileName, fileName, audioFilesSecond, ebbinghausCurveDates);
//            i ++;
//        }
//    }

    public static boolean toBeContinue(int overstepSeconds, Map<String, Integer> flagMap, int audioFilesSecond, List<LocalDate> ebbinghausCurveDates) {
        //            4，循环Ebbinghaus curve列表，判断是否超出每天学习秒数 overstepSeconds
        boolean toBeContinue = false;
        for (LocalDate ebbinghausCurveDate : ebbinghausCurveDates) {
            //                    5，如果超出，则设置为下一开始日期并返回第3步
            if(flagMap.containsKey(ebbinghausCurveDate.toString()) && flagMap.get(ebbinghausCurveDate.toString()) + audioFilesSecond > overstepSeconds){
                return true;
            }
        }
        return false;
    }

    public static void addToResult(Map<String, Integer> flagMap, Map<String, Set<String>> resultMap, String parentFileName, String fileName, int audioFilesSecond, List<LocalDate> ebbinghausCurveDates) {
        for (LocalDate ebbinghausCurveDate : ebbinghausCurveDates) {
            if(flagMap.containsKey(ebbinghausCurveDate.toString())){
                flagMap.put(ebbinghausCurveDate.toString(),flagMap.get(ebbinghausCurveDate.toString()) + audioFilesSecond);
                resultMap.get(ebbinghausCurveDate.toString()).add(getLessonMinutes(parentFileName, fileName, audioFilesSecond));
            }else{
                flagMap.put(ebbinghausCurveDate.toString(), audioFilesSecond);
                Set<String> set = new TreeSet<>();
                set.add(getLessonMinutes(parentFileName, fileName, audioFilesSecond));
                resultMap.put(ebbinghausCurveDate.toString(),set);
            }
        }
    }

    public static String getLessonMinutes(String parentFileName, String fileName, int audioFilesSecond) {
        return parentFileName + "_" + fileName + "|" + formatMinutes(audioFilesSecond);
    }

    private static String formatMinutes(int audioFilesSecond) {
        return (audioFilesSecond / 60) + "分" + (audioFilesSecond - (audioFilesSecond / 60) * 60) + "秒";
    }

    public static String getLesson(String lessonMinutes) {
        return lessonMinutes.split("\\|")[0];
    }
    public static String getMinutes(String lessonMinutes) {
        return lessonMinutes.split("\\|")[1];
    }
//    public static void initResult(Map<String, Integer> flagMap, Map<String, Set<String>> resultMap,List<File> files,List<String> startDateStrs){
//        for (int i = 0; i < files.size();i++){
//            File file = files.get(i);
//            String parentFileName = file.getParentFile().getName();
//            String fileName = file.getName();
//            int audioFilesSecond = getAudioFilesSecond(file);
//            LocalDate startDate = LocalDate.parse(startDateStrs.get(i));
//            List<LocalDate> ebbinghausCurveDates = getEbbinghausCurveDate(startDate);
//            addToResult(flagMap, resultMap, parentFileName, fileName, audioFilesSecond, ebbinghausCurveDates);
//        }
//    }

    public static List<LocalDate> getEbbinghausCurveDate(LocalDate startDate){
        LocalDate p = LocalDate.of(startDate.getYear(),startDate.getMonth(),startDate.getDayOfMonth()) ;
//        1
//        1
//        4
//        8
//        15
        List<LocalDate> res = new ArrayList<>();
        res.add(p);
        p = p.plusDays(1);
        res.add(p);
        p = p.plusDays(1);
        res.add(p);
        p = p.plusDays(4);
        res.add(p);
        p = p.plusDays(8);
        res.add(p);
        p = p.plusDays(15);
        res.add(p);
        return res;
    }
    public static List<LocalDate> getNewEbbinghausCurveDate(LocalDate startDate){
        LocalDate p = LocalDate.of(startDate.getYear(),startDate.getMonth(),startDate.getDayOfMonth()) ;
//        1
//        1
//        2
        List<LocalDate> res = new ArrayList<>();
        res.add(p);
        p = p.plusDays(1);
        res.add(p);
        p = p.plusDays(1);
        res.add(p);
        p = p.plusDays(2);
        res.add(p);
        return res;
    }

    public static void newplan(){
//        plan1(2020, 12, 8, 100, "Introduction_to_the_United_States_");
//        American Pronunciation Workshop  2周
        newplan2();
//        American Accent Training  2
//        newplan3();
//-----------------新计划
//        eslpod 100 3月
//        American Pronunciation Workshop 4月
//        EnglishPod 100 7月
//        American Accent Training
//        2021,8,1  英文开发视频，面试简历相关的也参与进来
//
//        看能否看懂英文开发视频和美剧，如果能，就光看开发视频和美剧，如果勉强，继续100+
    }

    private static void plan1(int i2, int i3, int i4,int start,int end, String introduction_to_the_united_states_) {
        LocalDate date = LocalDate.of(i2, i3, i4);
        Map<String, Set<String>> map = new TreeMap<>();

        for (int i = start; i <= end; i++) {
            /**
             * 获取艾宾浩斯日期
             * 写入map，每个map{"日期"：[Introduction_to_the_United_States_1，Introduction_to_the_United_States_2，Introduction_to_the_United_States_3，Introduction_to_the_United_States_4]}
             */
            List<LocalDate> dateList = getEbbinghausCurveDate(date);

            for (LocalDate tmp : dateList) {
                if (!map.containsKey(tmp.toString())) {
                    map.put(tmp.toString(), new TreeSet<>());
                }
                map.get(tmp.toString()).add(introduction_to_the_united_states_ + String.format("%03d", i));
            }
            date = date.plusDays(1);
        }
        map.forEach((key, value) -> {
            System.out.print(key);
            for (String lessonStr : value) {
                System.out.print("\t" + lessonStr);
            }
            System.out.println("\t " + value.size());
        });
    }

    public static void newplan2(){

        plan1(2021, 9, 6, 1,13, "English_Pod_");
    }

    public static void newplan3(){
        LocalDate date = LocalDate.of(2021,8,1);
        Map<String,Set<String>> map = new TreeMap<>();

        for(int i = 101 ;i <= 356 ; i++){
            /**
             * 获取艾宾浩斯日期
             * 写入map，每个map{"日期"：[English_Pod_1，English_Pod_2，English_Pod_3]}
             */
            List<LocalDate> dateList = getNewEbbinghausCurveDate(date);

            for(LocalDate tmp:dateList){
                if(!map.containsKey(tmp.toString())){
                    map.put(tmp.toString(),new TreeSet<>());
                }
                map.get(tmp.toString()).add("English_Pod_" + String.format("%03d",i));
            }
            date = date.plusDays(1);
        }
        map.forEach((key,value) -> {
            System.out.print(key);
            for (String lessonStr : value){
                System.out.print("\t" + lessonStr);
            }
            System.out.println("\t " + value.size());
        });
    }
}