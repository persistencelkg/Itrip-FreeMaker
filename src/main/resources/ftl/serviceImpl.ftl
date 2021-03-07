package ${package}.service.${table.daoName};

import ${package}.mapper.${table.daoName}.${table.className}Mapper;
import ${package}.entity.${table.className};
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class ${table.className}ServiceImpl extends ServiceImpl<${table.className}Mapper, ${table.className}> implements ${table.className}Service, BaseService<${table.className}>{

}
