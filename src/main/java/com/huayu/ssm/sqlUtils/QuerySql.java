package com.huayu.ssm.sqlUtils;

import com.huayu.ssm.pojo.Emp;
import org.springframework.util.StringUtils;

public class QuerySql {

    public String queryStuArr(Emp emp){
        StringBuffer sql = new StringBuffer("SELECT * FROM emp WHERE 1=1 ");
        if(!StringUtils.isEmpty(emp.getEname())){
            sql.append("ename LIKE '%${ename}%' ");
        }

        return sql.toString();
    }
}
