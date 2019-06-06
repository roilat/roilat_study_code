package cn.roilat.mybatis.core;

import javax.sql.DataSource;
import java.util.List;

public class TableDefinition {
    private String tableName;
    private String comment;
    private List<ColumnDefinition> fieldDefinitions;
}
