# SQLGenerator
生成SQL语句的工具

## 基本类
- xuyihao.sql.generator.core.Order
	排序条件生成类
- xuyihao.sql.generator.core.Criteria
	查询条件生成类
- xuyihao.sql.generator.core.Query
	查询sql语句生成类
- xuyihao.sql.generator.core.Delete
	删除sql语句生成类
- xuyihao.sql.generator.core.Insert
	插入sql语句生成类
- xuyihao.sql.generator.core.Update
	更新sql语句生成类
	
## 用法
### 插入语句
```
Insert insert = Insert.insertInto("student").values("Johnson", "12345678", "123456789", "123456@qq.com", 12);
System.out.println(insert.getSql());

结果
INSERT INTO student VALUES ('Johnson', '12345678', '123456789', '123456@qq.com', 12)
```


```
Insert insert1 = Insert.insertInto("student").fields("name", "email", "level").values("Johnson", "123456@qq.com", 12);
System.out.println(insert1.getSql());

结果
INSERT INTO student  ( name, email, level ) VALUES ('Johnson', '123456@qq.com', 12)
```

### 条件语句
```
Criteria criteria = Criteria.where("field1").in("select * from table").and("field2").notIn("select * from table");
System.out.println(criteria.getCriteria());

结果
WHERE field1 IN ( select * from table ) AND field2 NOT IN ( select * from table )
```

### 删除语句
```
System.out.println(Delete.deleteFrom("student").getSql());

结果
DELETE FROM student
```

```
System.out.println(Delete.deleteFrom("student").addWhere(Criteria.where("name").is("Johnson")).getSql());

结果
DELETE FROM student WHERE name = 'Johnson'
```

### 排序语句
```
System.out.println(Order.orderBy("name", "phoneNumber").direction_DESC().getOrder());

结果
ORDER BY name, phoneNumber DESC
```

### 查询语句
```
Query query = Query.selectAll().from("table1");
String sql = query.getSql();
System.out.println(sql);

结果
SELECT * FROM table1
```

```
Query query1 = Query.selectDistinct("name as A", "address as B", "phoneNumber as C", "email as B").from("student as s").innerJoin("teacher as t").addWhere(Criteria.where("name").is("johnson"));
String sql1 = query1.getSql();
System.out.println(sql1);

结果
SELECT DISTINCT name as A, address as B, phoneNumber as C, email as B FROM student as s INNER JOIN teacher as t WHERE name = 'johnson'
```

```
Query query2 = Query.selectAll().from("student").leftJoin("teacher")
        .addWhere(Criteria.where("student.teacherId").equalsField("teacher.id"))
        .addOrderBy(Order.orderBy("student.name").direction_ASC());
String sql2 = query2.getSql();
System.out.println(sql2);

结果
SELECT * FROM student LEFT JOIN teacher WHERE student.teacherId = teacher.id ORDER BY student.name ASC
```

```
Query query3 = Query.select("name", "id", "phoneNumber").from("student")
        .addWhere(Criteria.where("age").notBetween(10, 12))
        .addOrderBy(Order.orderBy("name").direction_DESC());
System.out.println(query3.getSql());

结果
SELECT name, id, phoneNumber FROM student WHERE age NOT BETWEEN 10 AND 12 ORDER BY name DESC
```


```
Query query5 = Query.select("name").from("temp_student").addWhere(Criteria.where("score").gte(80));
Query query4 = Query.selectAll().from("student").addWhere(Criteria.where("name").in(query5));
System.out.println(query4.getSql());

结果
SELECT * FROM student WHERE name IN ( SELECT name FROM temp_student WHERE score >= 80 )
```

```
System.out.println(Query.select("COUNT(DISTINCT name)").from("student").getSql());

结果
SELECT COUNT(DISTINCT name) FROM student
```


```
System.out.println(Query.select("stu_id", "SUM(score) AS sum_score").from("student_score").addGorupBy("stu_id").getSql());

结果
SELECT stu_id, SUM(score) AS sum_score FROM student_score GROUP BY stu_id
```

### 更新语句
```
Update update = Update.update("student").set("name", "Johnson").set("phoneNumber", "123456887").set("level", 13)
    .addWhere(Criteria.where("score").between(60, 100));
System.out.println(update.getSql());

结果
UPDATE student SET phoneNumber = '123456887', level = 13, name = 'Johnson' WHERE score BETWEEN 60 AND 100
```