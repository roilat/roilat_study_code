<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.fsoa.publish.mappers.BireqPublishMapper">
	<!-- 1、配置返回结果Map和参数Map -->
	<resultMap type="BireqPublish" id="bireqPublishResultMap">
		<id property="sn" column="SN"/>
		<result property="title" column="TITLE"/>
		<result property="outline" column="OUTLINE"/>
		<result property="istender" column="ISTENDER"/>
		<result property="stats" column="STATS"/>
		<result property="creator" column="CREATOR"/>
		<result property="createtime" column="CREATETIME"/>
		<result property="modifier" column="MODIFIER"/>
		<result property="modifytime" column="MODIFYTIME"/>
		<result property="publisher" column="PUBLISHER"/>
		<result property="publishtime" column="PUBLISHTIME"/>
		<result property="departmentCodes" column="DEPARTMENT_CODES"/>
		<result property="deleteReason" column="DELETE_REASON"/>
	</resultMap>
	<resultMap type="BireqPublishVo" id="bireqPublishVoResultMap" extends="bireqPublishResultMap">
		<result property="publisherName" column="PUBLISHER_NAME"/>
		<result property="modifierName" column="MODIFIER_NAME"/>
		<result property="creatorName" column="CREATOR_NAME"/>
	</resultMap>	
	<!-- <parameter property="deptId" javaType="string" jdbcType="VARCHAR"/> -->
	<parameterMap type="BireqPublish" id="bireqPublishParameterMap">
		<parameter property="sn" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="title" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="outline" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="istender" javaType="string" jdbcType="CHAR"/>
		<parameter property="stats" javaType="string" jdbcType="CHAR"/>
		<parameter property="creator" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="createtime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="modifier" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="modifytime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="publisher" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="publishtime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="departmentCodes" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="deleteReason" javaType="string" jdbcType="VARCHAR"/>
	</parameterMap>

	<!-- 2、各个SeqID -->
	<insert id="add" parameterMap="bireqPublishParameterMap">
		INSERT INTO T_BIREQ_PUBLISH (SN, TITLE, OUTLINE, ISTENDER, STATS, CREATOR, CREATETIME, MODIFIER, MODIFYTIME, PUBLISHER, PUBLISHTIME, DEPARTMENT_CODES,DELETE_REASON) VALUES (
			#{sn, jdbcType=INTEGER}, 
			#{title, jdbcType=VARCHAR}, 
			#{outline, jdbcType=VARCHAR}, 
			#{istender, jdbcType=CHAR}, 
			#{stats, jdbcType=CHAR}, 
			#{creator, jdbcType=INTEGER}, 
			#{createtime, jdbcType=TIMESTAMP}, 
			#{modifier, jdbcType=INTEGER}, 
			#{modifytime, jdbcType=TIMESTAMP}, 
			#{publisher, jdbcType=INTEGER}, 
			#{publishtime, jdbcType=TIMESTAMP},
			#{departmentCodes, jdbcType=VARCHAR},
			#{deleteReason, jdbcType=VARCHAR}
		)
	</insert>
	
	<insert id="addTemp" parameterMap="bireqPublishParameterMap">
		INSERT INTO T_BIREQ_PUBLISH_TEMP (SN, TITLE, OUTLINE, ISTENDER, STATS, CREATOR, CREATETIME, MODIFIER, MODIFYTIME, PUBLISHER, PUBLISHTIME, DEPARTMENT_CODES,DELETE_REASON) VALUES (
			#{sn, jdbcType=INTEGER}, 
			#{title, jdbcType=VARCHAR}, 
			#{outline, jdbcType=VARCHAR}, 
			#{istender, jdbcType=CHAR}, 
			#{stats, jdbcType=CHAR}, 
			#{creator, jdbcType=INTEGER}, 
			#{createtime, jdbcType=TIMESTAMP}, 
			#{modifier, jdbcType=INTEGER}, 
			#{modifytime, jdbcType=TIMESTAMP}, 
			#{publisher, jdbcType=INTEGER}, 
			#{publishtime, jdbcType=TIMESTAMP},
			#{departmentCodes, jdbcType=VARCHAR},
			#{deleteReason, jdbcType=VARCHAR}
		)
	</insert>
	<!-- 判断不可重复的属性是否已经存在，这里默认只判断deptName属性，具体的业务再进行修改添加 -->
	<!--
	<select id="isExists" resultType="integer" parameterMap="bireqPublishParameterMap">
		SELECT COUNT(1) FROM T_BIREQ_PUBLISH WHERE DEPT_NAME=#{deptName}
		<if test="deptId != null and deptId !='' ">
			<![CDATA[ AND DEPT_ID <> #{deptId, jdbcType=VARCHAR} ]]>
		</if>
	</select>
	-->

	