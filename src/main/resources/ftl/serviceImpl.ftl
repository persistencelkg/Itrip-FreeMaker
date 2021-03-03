package ${package}.service.${table.daoName};
import ${package}.mapper.${table.daoName}.${table.className}Mapper;
import ${package}.pojo.${table.className};
import ${package}.common.Page;
import com.mysql.cj.util.StringUtils;
import ${package}.common.SysConstant;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class ${table.className}ServiceImpl implements ${table.className}Service {

    @Resource
    private ${table.className}Mapper ${table.daoName}Mapper;

    public ${table.className} get${table.className}ById(Long id)throws Exception{
        return ${table.daoName}Mapper.get${table.className}ById(id);
    }

    public List<${table.className}>	get${table.className}ListByMap(Map<String,Object> param)throws Exception{
        return ${table.daoName}Mapper.get${table.className}ListByMap(param);
    }

    public Integer get${table.className}CountByMap(Map<String,Object> param)throws Exception{
        return ${table.daoName}Mapper.get${table.className}CountByMap(param);
    }

    public Integer txAdd${table.className}(${table.className} ${table.daoName})throws Exception{
        ${table.daoName}.setCreationDate(new Date());
        return ${table.daoName}Mapper.insert${table.className}(${table.daoName});
    }

    public Integer txModify${table.className}(${table.className} ${table.daoName})throws Exception{
        ${table.daoName}.setModifyDate(new Date());
        return ${table.daoName}Mapper.update${table.className}(${table.daoName});
    }

    public Integer txDelete${table.className}ById(Long id)throws Exception{
        return ${table.daoName}Mapper.delete${table.className}ById(id);
    }

    public Page<${table.className}> query${table.className}PageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = ${table.daoName}Mapper.get${table.className}CountByMap(param);
        pageNo =  StringUtils.isNullOrEmpty(pageNo) ? SysConstant.DEFAULT_PAGE_NO : pageNo;
        pageSize =  StringUtils.isNullOrEmpty(pageSize) ? SysConstant.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<${table.className}> ${table.daoName}List = ${table.daoName}Mapper.get${table.className}ListByMap(param);
        page.setRows(${table.daoName}List);
        return page;
    }

}
