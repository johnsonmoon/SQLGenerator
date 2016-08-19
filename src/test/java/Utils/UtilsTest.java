package Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xuyh at 2016/08/19 下午 01:15.
 */
public class UtilsTest {
    public static void main(String args[]){
        testInsertSentense();
    }

    public static void testInsertSentense(){
        String tableName = "Accounts";
        List<String> values = new ArrayList<String>();
        values.add("123456");
        System.out.println(SQLUtils.insertSentense(tableName, values));
        values.add("321564");
        values.add("456789");
        values.add("987654");
        System.out.println(SQLUtils.insertSentense(tableName, values));
    }
}
