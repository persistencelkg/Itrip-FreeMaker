package ${package};
import java.time.LocalDateTime;
import lombok.Data;

/**
 * ${table.comment}
 * @description:
 * @author: ${user}
 * @create: ${.now}
 */
@Data
public class ${table.className} {
        <#list table.columnList as column>
        <#-- freemarker包括两个引号 -->

            <#if column.comment?trim?length gt 2>
            // ${column.comment}
            </#if>
            private ${column.columnJavaType} ${column.attributeName};
        </#list>
}
