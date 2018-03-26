<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.dataservice.sysmgr.mapper.SysOrgMapper">

	<!-- 1、配置返回结果Map和参数Map -->

	<resultMap type="SysOrg" id="baseSysOrgResultMap">
		<id property="orgId" column="ORG_ID"/>
		<result property="orgNo" column="ORG_NO"/>
		<result property="orgName" column="ORG_NAME"/>
		<result property="orgLevel" column="ORG_LEVEL"/>
		<result property="parOrgId" column="PAR_ORG_ID"/>
		<result property="state" column="STATE_"/>
		<result property="orgAre" column="ORG_ARE"/>
		<result property="createDt" column="CREATE_DT"/>
		<result property="updateDt" column="UPDATE_DT"/>
	</resultMap>
	<resultMap type="SysOrg" id="sysOrgResultMap" extends="baseSysOrgResultMap">
	</resultMap>
	<parameterMap type="SysOrg" id="sysOrgParameterMap">
		<parameter property="orgNo" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="orgName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="orgLevel" javaType="int" jdbcType="BIGINT"/>
		<parameter property="parOrgId" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="state" javaType="int" jdbcType="BIGINT"/>
		<parameter property="orgAre" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="createDt" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="updateDt" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="orgId" javaType="string" jdbcType="VARCHAR"/>
	</parameterMap>



	<!-- 2、各个SeqID -->

	<insert id="create" parameterMap="sysOrgParameterMap">
	<!-- <selectKey keyProperty="id" resultType="string" order="BEFORE">
			SELECT SEQ_BIZ_TYPE.nextval from dual
		</selectKey> -->
		INSERT INTO SYS_ORG (ORG_ID, ORG_NO, ORG_NAME,ORG_LEVEL,PAR_ORG_ID,STATE_,ORG_ARE,CREATE_DT,UPDATE_DT) VALUES (
			#{orgId, jdbcType=VARCHAR}, 
			#{orgNo, jdbcType=VARCHAR}, 
			#{orgName, jdbcType=VARCHAR},
			#{orgLevel, jdbcType=BIGINT}, 
			#{parOrgId, jdbcType=VARCHAR}, 
			#{state, jdbcType=BIGINT},
			#{orgAre, jdbcType=VARCHAR}, 
			#{createDt, jdbcType=TIMESTAMP}, 
			#{updateDt, jdbcType=TIMESTAMP}
		)
	</insert>

	<!-- 判断不可重复的属性是否已经存在，这里默认只判断deptName属性，具体的业务再进行修改添加 -->
	
	<select id="isExists" resultType="integer" parameterMap="sysOrgParameterMap">
		SELECT COUNT(1) FROM SYS_ORG WHERE 1 = 1
		<if test="orgName != null and orgName !='' ">
			<![CDATA[ and ORG_NAME = #{ORG_NAME, jdbcType=VARCHAR} ]]>
		</if>
		<!-- <if test="typeCode != null and typeCode !='' ">
			<![CDATA[ and TYPE_CODE = #{typeCode, jdbcType=VARCHAR} ]]>
		</if> -->
	</select>
	

	<select id="getById" resultMap="sysOrgResultMap" parameterType="string">
		SELECT * FROM SYS_ORG WHERE ORG_ID = #{value}
	</select>
	<select id="getByParId" resultMap="sysOrgResultMap" parameterType="string">
		select *
from sys_org
start with org_id = #{value}
connect by prior org_id = par_org_id 
	</select>
	<select id="getByOrgId" resultType="com.hansy.dataservice.sysmgr.bo.SysOrgBo" parameterType="string">
		select  o1.ORG_ID orgId, o1.ORG_NO orgNo, 
		o1.ORG_NAME orgName,o1.ORG_LEVEL orgLevel,
		o1.PAR_ORG_ID parOrgId,o1.STATE_ state,
		o1.ORG_ARE orgAre,o1.CREATE_DT createDt,
		o1.UPDATE_DT updateDt,o2.org_name parOrgName from sys_org o1,sys_org o2 where o1.par_org_id = o2.org_id and o1.org_id = #{value}
	</select>

	<!-- resultMap="sysOrgResultMap" -->

	<select id="page"  resultMap="sysOrgResultMap" parameterType="java.util.Map">
		SELECT * FROM SYS_ORG WHERE STATE_ = 1
	
	</select>
	<select id="getTotal" resultType="long" parameterType="java.util.Map">
		SELECT COUNT(1) FROM SYS_ORG WHERE STATE_ = 1
	</select>

	<delete id="delete" parameterType="string">
		DELETE FROM SYS_ORG WHERE ORG_ID = #{value}
	</delete>

	<update id="edit" parameterMap="sysOrgParameterMap">
		UPDATE SYS_ORG 
		<!-- 各种更改的字段  -->
		 <trim prefix="set" suffixOverrides=","> 
			<if test="orgNo!= null and orgNo !='' ">
				ORG_NO = #{orgNo, jdbcType=VARCHAR},
			</if>
			<if test="orgName != null and orgName !='' ">
				ORG_NAME = #{orgName, jdbcType=VARCHAR}, 
			</if>
			<if test="orgLevel != null ">
				ORG_LEVEL = #{orgLevel, jdbcType=BIGINT} ,
			</if>
			<if test="parOrgId != null and parOrgId !='' ">
				PAR_ORG_ID = #{parOrgId, jdbcType=VARCHAR} ,
			</if>
			<if test="state != null  ">
				STATE_ = #{state, jdbcType=BIGINT}, 
			</if>
			<if test="orgAre != null and orgAre !='' ">
				ORG_ARE = #{orgAre, jdbcType=VARCHAR} ,
			</if>
			<if test="createDt != null and createDt !='' ">
				CREATE_DT = #{createDt, jdbcType=TIMESTAMP} ,
			</if>
			<if test="updateDt != null and updateDt !='' ">
				UPDATE_DT = #{updateDt, jdbcType=TIMESTAMP} 
			</if>
		 	</trim> 
			WHERE ORG_ID = #{orgId, jdbcType=VARCHAR}
		
	</update>
	<!-- 获取树 -->
	<select id="getZtree" resultType="com.hansy.dataservice.sysmgr.bo.BaseZtree">
	select ORG_ID id,PAR_ORG_ID pid,ORG_NAME name from SYS_ORG where STATE_=1
	</select>
	<!-- 