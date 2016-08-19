package Utils;

import java.util.List;
import java.util.Map;

/**
 * 生成 JDBC SQL 语句的工具类
 *
 * Created by Xuyh at 2016/08/19 下午 01:13.
 */
public class SQLUtils {
    /**
     * 生成插入语句，注意value的顺序，顺序错误会导致数据插入错误
     *
     * @param tableName 表名
     * @param values 值列表
     * @return sql语句
     */
    public static String insertSentense(String tableName, List<Object> values){
        String sql = "insert into ";
        sql += "values(";
        if(values.size() == 1){
            sql += values.get(0);
        }else{
            sql += values.get(0);
            for(int i = 1; i < values.size(); i++){
                sql += (", " + values.get(i));
            }
        }
        sql += ")";
        return sql;
    }

    // delete from Accounts where Acc_ID = 'aa' and

    public static String deleteSentense(String tableName, Map<String, Object> where){
        String sql = "delete from " + tableName + " where ";

        return sql;
    }
}
