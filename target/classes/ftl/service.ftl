package ${package}.service.${table.daoName};
import ${package}.pojo.${table.className};
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Page;


/**
* @description:
* @author: 浮~沉
* @create: ${.now}
*/
public interface ${table.className}Service {

    public ${table.className} get${table.className}ById(Long id)throws Exception;

    public List<${table.className}>	get${table.className}ListByMap(Map<String,Object> param)throws Exception;

    public Integer get${table.className}CountByMap(Map<String,Object> param)throws Exception;

    public Integer txAdd${table.className}(${table.className} ${table.daoName})throws Exception;

    public Integer txModify${table.className}(${table.className} ${table.daoName})throws Exception;

    public Integer txDelete${table.className}ById(Long id)throws Exception;

    public Page<${table.className}> query${table.className}PageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;
}
