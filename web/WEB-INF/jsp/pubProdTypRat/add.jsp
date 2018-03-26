<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.fsoa.corpmgr.mappers.CorpAttachmentMapper">
	<!-- 1、配置返回结果Map和参数Map -->
	<resultMap type="CorpAttachment" id="corpAttachmentResultMap">
		<id property="tableKey" column="TABLE_KEY"/>
		<result property="CSN" column="CSN"/>
		<result property="attachType" column="ATTACH_TYPE"/>
		<result property="attachFormat" column="ATTACH_FORMAT"/>
		<result property="displayName" column="DISPLAY_NAME"/>
		<result property="savePath" column="SAVE_PATH"/>
		<result property="STATS" column="STATS"/>
		<result property="UPLOADER" column="UPLOADER"/>
		<result property="UPLOADTIME" column="UPLOADTIME"/>
		<result property="downloadTimes" column="DOWNLOAD_TIMES"/>
	</resultMap>
	<!-- <parameter property="deptId" javaType="string" jdbcType="VARCHAR"/> -->
	<parameterMap type="CorpAttachment" id="corpAttachmentParameterMap">
		<parameter property="tableKey" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="CSN" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="attachType" javaType="string" jdbcType="CHAR"/>
		<parameter property="attachFormat" javaType="string" jdbcType="CHAR"/>
		<parameter property="displayName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="savePath" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="STATS" javaType="string" jdbcType="CHAR"/>
		<parameter property="UPLOADER" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="UPLOADTIME" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="downloadTimes" javaType="integer" jdbcType="INTEGER"/>
	</parameterMap>

	<!-- 2、各个SeqID -->
	<insert id="add" parameterMap="corpAttachmentParameterMap">
		INSERT INTO T_CORP_ATTACHMENT (TABLE_KEY, CSN, ATTACH_TYPE, ATTACH_FORMAT, DISPLAY_NAME, SAVE_PATH, STATS, UPLOADER, UPLOADTIME, DOWNLOAD_TIMES) VALUES (
			#{tableKey, jdbcType=INTEGER}, 
			#{CSN, jdbcType=INTEGER}, 
			#{attachType, jdbcType=CHAR}, 
			#{attachFormat, jdbcType=CHAR}, 
			#{displayName, jdbcType=VARCHAR}, 
			#{savePath, jdbcType=VARCHAR}, 
			#{STATS, jdbcType=CHAR}, 
			#{UPLOADER, jdbcType=INTEGER}, 
			#{UPLOADTIME, jdbcType=TIMESTAMP}, 
			#{downloadTimes, jdbcType=INTEGER}
		)
	</insert>
	<!-- 判断不可重复的属性是否已经存在，这里默认只判断deptName属性，具体的业务再进行修改添加 -->
	<!--
	<select id="isExists" resultType="integer" parameterMap="corpAttachmentParameterMap">
		SELECT COUNT(1) FROM T_CORP_ATTACHMENT WHERE DEPT_NAME=#{deptName}
		<if test="deptId != null and deptId !='' ">
			<![CDATA[ AND DEPT_ID <> #{deptId, jdbcType=VARCHAR} ]]>
		</if>
	</select>
	-->

		<select id="getById" resultMap="corpAttachmentResultMap" parameterType="java.lang.String">
		SELECT * FROM T_CORP_ATTACHMENT WHERE CSN = #{value}
	</select>
	<select id="page" resultMap="corpAttachmentResultMap" parameterType="CorpAttachment">
		SELECT * FROM T_CORP_ATTACHMENT WHERE 1=1
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
	</select>
	<select id="getTotal" resultType="long" parameterType="CorpAttachment">
		SELECT COUNT(1) FROM T_CORP_ATTACHMENT WHERE 1=1
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
	</select>
	<delete id="deleteById" parameterType="string">
		DELETE FROM T_CORP_ATTACHMENT WHERE TABLE_KEY = #{value}
	</delete>
	<update id="edit" parameterType="CorpAttachment">
		UPDATE T_CORP_ATTACHMENT 
		<!-- 各种更改的字段 --> 
		<set>
			<if test="CSN != null and CSN !='' ">
				CSN = #{CSN, jdbcType=INTEGER}, 
			</if>
			<if test="attachType != null and attachType !='' ">
				ATTACH_TYPE = #{attachType, jdbcType=CHAR}, 
			</if>
			<if test="attachFormat != null and attachFormat !='' ">
				ATTACH_FORMAT = #{attachFormat, jdbcType=CHAR}, 
			</if>
			<if test="displayName != null and displayName !='' ">
				DISPLAY_NAME = #{displayName, jdbcType=VARCHAR}, 
			</if>
			<if test="savePath != null and savePath !='' ">
				SAVE_PATH = #{savePath, jdbcType=VARCHAR}, 
			</if>
			<if test="STATS != null and STATS !='' ">
				STATS = #{STATS, jdbcType=CHAR}, 
			</if>
			<if test="UPLOADER != null and UPLOADER !='' ">
				UPLOADER = #{UPLOADER, jdbcType=INTEGER}, 
			</if>
			<if test="UPLOADTIME != null and UPLOADTIME !='' ">
				UPLOADTIME = #{UPLOADTIME, jdbcType=TIMESTAMP}, 
			</if>
			<if test="downloadTimes != null and downloadTimes !='' ">
				DOWNLOAD_TIMES = #{downloadTimes, jdbcType=INTEGER}, 
			</if>


		</set>
			WHERE TABLE_KEY = #{tableKey, jdbcType=INTEGER} 
	</update>
	
	<update id="editBatch" parameterType="java.util.Map">
		UPDATE T_CORP_ATTACHMENT 
		SET STATS = #{status} WHERE TABLE_KEY in 
			<fore