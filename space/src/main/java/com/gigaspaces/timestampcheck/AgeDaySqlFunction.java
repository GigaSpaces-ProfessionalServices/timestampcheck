package com.gigaspaces.timestampcheck;

import com.gigaspaces.query.sql.functions.SqlFunction;
import com.gigaspaces.query.sql.functions.SqlFunctionExecutionContext;

public class AgeDaySqlFunction extends SqlFunction {

    public static final Long MS_IN_DAY = 24*60*60*1000L;

    @Override
    public Object apply(SqlFunctionExecutionContext context) {
        Long timestampColumn = (Long) context.getArgument(0);
        Long currentTimestamp = System.currentTimeMillis();
        Long rv = (currentTimestamp - timestampColumn) / MS_IN_DAY;
        return rv ;
    }

}
