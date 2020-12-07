package com.iremenber.api.arithmetic;

import org.junit.Test;
import org.springframework.util.StopWatch;

/**
 * @Author: zm
 * @Date: 2019/8/28 15:19
 * @Version: 1.0
 */
public class StringUtilsTest {
    @Test
    public void testCheckDuplicationString(){
        System.out.println(StringUtils.checkDuplicationString("我星斗范德萨发很过分具体的GV比偶素解耦if亢"));
    }
    @Test
    public void testCheckAnagram(){
        System.out.println(StringUtils.checkAnagram("我星斗范德萨发很过分具体的GV比偶素解耦if亢4具","4具我星斗范德萨发很过分具体的GV比偶素解耦if亢"));
    }
    @Test
    public void testReverse(){
        System.out.println(StringUtils.reverse("1234567"));
    }
    @Test
    public void testCompressString(){
        System.out.println(StringUtils.compressString("aaassssddddddfff"));
    }
    @Test
    public void testBufferCompressString(){
        String testStr = "aaassssddddddfffuuuuuuuuuuuuuuuuuiiiiiiiiiieeeeeeuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuutttttttttyyyyyyyyyyyyyyyyyyyyyyyyyttttttpopopopopopopyyyyyyyyyyyyyyyyyyyyyopopopopopopoyyyyyyyyyyyyyyyykkkkkkkkkkkkkkkkkkkkkkyyyyyyyyuuuuuuuuuuukkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkuuuuuuuuuuuuuuuuyyyyyyyyyyyykjljjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjqqqqqqqqqqqqqqqeeeeeeeeeeeiioooooooooooooooooooooooooooooooooeeeeeeeeerrrrriiiiiiiiiiiiiiiiiiiiiirrrrrrrrrrjjjjjjjjjjjjjjjjjjjjjjrrrrriiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiirrrrrtttttttjjjjjjjjjjjjjjjjjjjjttttttttttyyyyyyyyyyyyyyyiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiyyyyyyyyyy";
        StopWatch sw = new StopWatch();
        sw.start("buffer");
        System.out.println(StringUtils.bufferCompressString(testStr));
        sw.stop();

        sw.start("normal");
        System.out.println(StringUtils.compressString(testStr));
        sw.stop();
        String result = sw.prettyPrint();
        System.err.println(result);
    }
    public void testReplaceSpaces() {
//		System.out.println(StringUtils.replaceSpaces("dsafdsaf jkljfld;sja kjlkjlk; jkl;j fdjhguiyh".toCharArray()));
    }
}
