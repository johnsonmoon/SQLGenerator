package Utils;

import java.util.*;

/**
 * Created by Xuyh at 2016/08/19 下午 01:15.
 */
public class UtilsTest {
    public static void main(String args[]){
        //testSelectSentence2();
        //testSelectSentence3();
        //testSelectSentence();
        //testInsertSentense();
        //testDeleteSentense();
        //testUpdateSentence2();
        //testUpdateSentence();
        //testDeleteSentense2();
        //String sql = "Acc_ID = 'aa' and ";
        //System.out.println(sql.substring(0, sql.length()-5));
    }

    public static void testDeleteSentense2(){
        String tableName = "Accounts";
        System.out.println(SQLUtils.deleteSentence(tableName));
    }

    public static void testSelectSentence(){
        String tableName = "Accounts";
        System.out.println(SQLUtils.selectSentence(tableName));
    }

    public static void testSelectSentence3(){
        String tableName = "Accounts";
        Map<String, Object> where = new HashMap<String, Object>();
        where.put("Acc_ID", "lkj");
        System.out.println(SQLUtils.selectSentence(tableName, where));
        where.put("Acc_name", "adad");
        where.put("Acc_lvl", 4);
        System.out.println(SQLUtils.selectSentence(tableName, where));
    }

    public static void testSelectSentence2(){
        String tableName = "Accounts";
        List<String> selectParam = new ArrayList<String>();
        selectParam.add("Acc_name2");
        Map<String, Object> where = new HashMap<String, Object>();
        where.put("Acc_ID", "lkj");
        System.out.println(SQLUtils.selectSentence(tableName, selectParam, where));
        selectParam.add("Acc_name");
        selectParam.add("Acc_loc");
        where.put("Acc_name", "adad");
        where.put("Acc_lvl", 4);
        System.out.println(SQLUtils.selectSentence(tableName, selectParam, where));
    }

    public static void testUpdateSentence2(){
        String tableName = "Accounts";
        Map<String, Object> update = new HashMap<String, Object>();
        update.put("Acc_pwd", "jk");
        System.out.println(SQLUtils.updateSentence(tableName, update));
        update.put("Acc_name", "ji");
        update.put("Acc_lvl", 8);
        System.out.println(SQLUtils.updateSentence(tableName, update));
    }

    public static void testUpdateSentence(){
        String tableName = "Accounts";
        Map<String, Object> update = new HashMap<String, Object>();
        Map<String, Object> where = new HashMap<String, Object>();
        update.put("Acc_pwd", "jk");
        where.put("Acc_ID", "jldaks");
        System.out.println(SQLUtils.updateSentence(tableName, update, where));
        update.put("Acc_name", "ji");
        update.put("Acc_lvl", 8);
        where.put("Acc_name2", "jhf");
        System.out.println(SQLUtils.updateSentence(tableName, update, where));
    }

    public static void testDeleteSentense(){
        String tableName = "Accounts";
        Map<String, Object> where = new HashMap<String, Object>();
        where.put("Acc_ID", "lkjdjahskjh");
        System.out.println(SQLUtils.deleteSentence(tableName, where));
        where.put("Acc_name", "dalkhf");
        where.put("Acc_lvl", 9);
        System.out.println(SQLUtils.deleteSentence(tableName, where));
    }

    public static void testInsertSentense(){
        String tableName = "Accounts";
        List<Object> values = new ArrayList<Object>();
        values.add("123456");
        System.out.println(SQLUtils.insertSentence(tableName, values));
        values.add("321564");
        values.add("456789");
        values.add("987654");
        values.add(1.1);
        values.add(33);
        values.add(105);
        values.add(DateUtils.parseDate(DateUtils.currentDate()));
        System.out.println(SQLUtils.insertSentence(tableName, values));
    }
}
