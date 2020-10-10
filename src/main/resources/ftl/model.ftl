package ${package}.pojo;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;



/**
 * ${table.comment}
 * @description:
 * @author: 浮沉
 * @create: ${.now}
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class ${table.className} extend BasePojo{
        <#list table.columnList as column>
        <#-- freemarker包括两个引号 -->
            <#if column.comment?trim?length gt 2>
            //${column.comment}
            </#if>
            private ${column.columnJavaType} ${column.attributeName};
        </#list>
}
