<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE
        mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package}.mapper.${table.daoName}.${table.className}Mapper">


    <#--查询sql片段提炼-->
    <sql id="selectSql">
        select
        <#list table.columnList as column>
        <#-- 最后一个逗号处理 -->
            <#if column_has_next>
                ${column.columnName} as ${column.attributeName},
            <#else >
                ${column.columnName} as ${column.attributeName}
            </#if>
        </#list>
        from ${table.tableName}
    </sql>

    <select id="get${table.className}ById" resultType="${table.className}" >
        <include refid="selectSql"/>
        <trim prefix="where" prefixOverrides="and | or">
            <if test="id != null">
                and id = ${r"#{id}"}
            </if>
        </trim>
    </select>

    <select id="get${table.className}ListByMap" resultType="${table.className}" parameterType="java.util.Map">
        <include refid="selectSql"/>
        <trim prefix="where" prefixOverrides="and | or">
            <#list table.columnList as column>
                <#if column_has_next>
                    <if test="${column.attributeName} != null and ${column.attributeName}!=''">
                        and ${column.columnName} = ${r"#{"}${column.attributeName}}
                    </if>
                </#if>
            </#list>
        </trim>
         order by creationDate desc
        <if test="beginPos != null and beginPos!='' and pageSize != null  and pageSize !='' ">
            limit ${r"#{"}beginPos},${r"#{"}pageSize}
        </if>
    </select>

    <select id="get${table.className}CountByMap" resultType="Integer"  parameterType="java.util.Map">
        select count(1) from ${table.tableName}
        <trim prefix="where" prefixOverrides="and | or">
            <#list table.columnList as column>
                <#if column_has_next>
                    <if test="${column.attributeName} != null and ${column.attributeName}!=''">
                        and ${column.columnName} = ${r"#{"}${column.attributeName}}
                    </if>
                </#if>
            </#list>
        </trim>
    </select>

    <insert id="insert${table.className}" parameterType="${table.className}">
        insert into ${table.tableName}
        (
            <#list table.columnList as column>
                <#if column_has_next>
                    ${column.columnName},
                <#else >
                    ${column.columnName}
                </#if>

            </#list>
        )
        values(
            <#list table.columnList as column>
                <#if column_has_next>
                    ${r"#{"}${column.attributeName}},
                <#else >
                    ${r"#{"}${column.attributeName}}
                </#if>
            </#list>
        )
    </insert>

    <update id="update${table.className}" parameterType="${table.className}">
        update ${table.tableName}
        <trim prefix="set" suffixOverrides="," suffix="where id=${r"#{"}id}">
            <#list table.columnList as column>
                <if test="${column.attributeName} != null">
                    ${column.columnName} = ${r"#{"}${column.attributeName}}
                </if>
            </#list>
        </trim>
    </update>

    <delete id="delete${table.className}ById" parameterType="Long">
        delete from ${table.tableName} where id = ${r"#{"}id}
    </delete>
</mapper>