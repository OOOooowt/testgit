package bao;

import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlSchemaStatVisitor;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.util.JdbcConstants;

/**
 * TODO
 *
 * @author laowang
 * @date 2022/9/28
 * @Version 1.0
 */
public class TestDruid {
//    static String SQL = "select  name ,id ,select money from user  from acct where id =10";
    static String SQL = "update user ";
//    static String SQL = "select * from t where id = 1";

    public static void main(String[] args) {

        SQLStatementParser parser = new MySqlStatementParser(SQL);
        SQLStatement sqlStatement = parser.parseStatement();
        MySqlSchemaStatVisitor visitor = new MySqlSchemaStatVisitor();
        sqlStatement.accept(visitor);
        System.out.println(visitor.getColumns());
        System.out.println(visitor.getTables());
        System.out.println(visitor.getConditions());
        System.out.println(visitor.getDbType());

//        SQLStatementParser parser = new MySqlStatementParser("select * from t where id = 1");
//        SQLStatement sqlStatement = parser.parseStatement();
//        System.out.println(SQLUtils.toSQLString(sqlStatement, JdbcConstants.MYSQL));


//        String sql = "select * from t where id = 1";
//        SQLStatementParser parser = new MySqlStatementParser(sql);
//        SQLStatement sqlStatement = parser.parseStatement();
//        System.out.println(SQLUtils.toSQLString(sqlStatement, JdbcConstants.MYSQL));


//        SQLExpr sqlExpr = SQLUtils.toSQLExpr("(id=1 or name='test' and age=14)", JdbcConstants.MYSQL);
//        System.out.println(SQLUtils.toSQLString(sqlExpr, JdbcConstants.MYSQL));


    }
}
