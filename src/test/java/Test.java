import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import cn.hutool.core.convert.Convert;

public class Test {

    public static void main(String[] args) {
       // System.out.println(Convert.toStrArray("ggg").length);

        /**
         * MyTest qweMyTest = new MyTest(); qweMyTest.setGg("---------------");
         * 
         * // TODO Auto-generated method stub Map<String, Object> ddMap = new HashMap<String, Object>(); ddMap.put("gg",
         * "ggggggggggggg"); Map string = Convert.convert(Map.class, qweMyTest); System.out.println("test:" +
         * string.get("gg"));
         **/
    }

    static class MyTest {
        private String gg;

        public String getGg() {
            return gg;
        }

        public void setGg(String gg) {
            this.gg = gg;
        }
    }

}
