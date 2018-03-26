<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.fsoa.corpmgr.mappers.CorpInfoTmpMapper">
	<!-- 1、配置返回结果Map和参数Map -->
	<resultMap type="CorpInfoTmp" id="corpInfoTmpResultMap">
		<id property="CSN" column="CSN"/>
		<result property="CORPNAME" column="CORPNAME"/>
		<result property="ENCORPNAME" column="ENCORPNAME"/>
		<result property="entCertNo" column="ENT_CERT_NO"/>
		<result property="LOGO" column="LOGO"/>
		<result property="ABSTRACT" column="ABSTRACT"/>
		<result property="MAINBIZ" column="MAINBIZ"/>
		<result property="busiOperSite" column="BUSI_OPER_SITE"/>
		<result property="registerTime" column="REGISTER_TIME"/>
		<result property="registerAssets" column="REGISTER_ASSETS"/>
		<result property="HONOR" column="HONOR"/>
		<result property="PRJEXPERIENCE" column="PRJEXPERIENCE"/>
		<result property="CREATOR" column="CREATOR"/>
		<result property="CREATETIME" column="CREATETIME"/>
		<result property="MODIFIER" column="MODIFIER"/>
		<result property="MODIFYTIME" column="MODIFYTIME"/>
		<result property="approveResult" column="APPROVE_RESULT"/>
		<result property="departmentId" column="DEPARTMENT_ID"/>
	</resultMap>

	<resultMap type="CorpInfoTmpVo" id="corpInfoResultMapVo" extends="corpInfoTmpResultMap">
	</resultMap>
	
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
	
	<resultMap type="CorpCertification" id="corpCertificationResultMap">
		<id property="tableKey" column="TABLE_KEY"/>
		<result property="CSN" column="CSN"/>
		<result property="certificationSrc" column="CERTIFICATION_SRC"/>
		<result property="certificationNo" column="CERTIFICATION_NO"/>
		<result property="certificationName" column="CERTIFICATION_NAME"/>
		<result property="STATS" column="STATS"/>
	</resultMap>	<!-- <parameter property="deptId" javaType="string" jdbcType="VARCHAR"/> -->
	<parameterMap type="CorpInfoTmp" id="corpInfoTmpParameterMap">
		<parameter property="CSN" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="CORPNAME" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="ENCORPNAME" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="entCertNo" javaType="string" jdbcType="CHAR"/>
		<parameter property="LOGO" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="ABSTRACT" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="MAINBIZ" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="busiOperSite" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="registerTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="registerAssets" javaType="java.math.BigDecimal" jdbcType="DECIMAL"/>
		<parameter property="HONOR" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="PRJEXPERIENCE" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="CREATOR" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="CREATETIME" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="MODIFIER" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="MODIFYTIME" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="approveResult" javaType="string" jdbcType="CHAR"/>
		<parameter property="departmentId" javaType="integer" jdbcType="INTEGER"/>
	</parameterMap>

	<!-- 2、各个SeqID -->
	<insert id="add" parameterMap="corpInfoTmpParameterMap">
		INSERT INTO T_CORP_INFO_TMP (CSN, CORPNAME, ENCORPNAME, ENT_CERT_NO, LOGO, ABSTRACT, MAINBIZ, BUSI_OPER_SITE, REGISTER_TIME, REGISTER_ASSETS, HONOR, PRJEXPERIENCE, CREATOR, CREATETIME, MODIFIER, MODIFYTIME, APPROVE_RESULT, DEPARTMENT_ID) VALUES (
			#{CSN, jdbcType=INTEGER}, 
			#{CORPNAME, jdbcType=VARCHAR}, 
			#{ENCORPNAME, jdbcType=VARCHAR}, 
			#{entCertNo, jdbcType=CHAR}, 
			#{LOGO, jdbcType=VARCHAR}, 
			#{ABSTRACT, jdbcType=VARCHAR}, 
			#{MAINBIZ, jdbcType=VARCHAR}, 
			#{busiOperSite, jdbcType=VARCHAR}, 
			#{registerTime, jdbcType=TIMESTAMP}, 
			#{registerAssets, jdbcType=DECIMAL }, 
			#{HONOR, jdbcType=VARCHAR}, 
			#{PRJEXPERIENCE, jdbcType=VARCHAR}, 
			#{CREATOR, jdbcType=INTEGER}, 
			#{CREATETIME, jdbcType=TIMESTAMP}, 
			#{MODIFIER, jdbcType=INTEGER}, 
			#{MODIFYTIME, jdbcType=TIMESTAMP}, 
			#{approveResult, jdbcType=CHAR}, 
			#{departmentId, jdbcType=INTEGER}
		)
	</insert>
	<!-- 判断不可重复的属性是否已经存在，这里默认只判断deptName属性，具体的业务再进行修改添加 -->
	<!--
	<select id="isExists" resultType="integer" parameterMap="corpInfoTmpParameterMap">
		SELECT COUNT(1) FROM T_CORP_INFO_TMP WHERE DEPT_NAME=#{deptName}
		<if test="deptId != null and deptId !='' ">
			<![CDATA[ AND DEPT_ID <> #{deptId, jdbcType=VARCHAR} ]]>
		</if>
	</select>
	-->
	<select id="getByDPId" resultMap="corpInfoResultMapVo" parameterType="java.lang.String">
		SELECT info.*,app.APPROVE_DESC approveDesc FROM T_CORP_INFO_TMP info LEFT JOIN T_CORP_INFO_APPROVE app on app.csn = info.csn 
		where info.DEPARTMENT_ID = #{value} ORDER BY app.APPROVETIME desc LIMIT 1
	</select>
	
	<select id="getByCSnId" resultMap="corpAttachmentResultMap" parameterType="java.lang.String">
		SELECT * FROM T_CORP_ATTACHMENT WHERE CSN = #{value} AND STATS in ('1','3')
	</select>
	
	<select id="getCertifi" resultMap="corpCertificationResultMap" parameterType="java.lang.String">
		SELECT * FROM T_CORP_CERTIFICATION WHERE CSN = #{value} AND STATS in ('1','3')
	</select>
	<select id="page" resultMap="corpInfoTmpResultMap" parameterType="CorpInfoTmp">
		SELECT * FROM T_CORP_INFO_TMP WHERE 1=1
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<![CDATA[ AND DEPT_NAME LIKE CONCAT(CONCAT('%', #{deptName}),'%')]]>
		</if>
		-->
		<if test="CORPNAME != null and CORPNAME !='' ">
			<![CDATA[ AND CORPNAME LIKE CONCAT(CONCAT('%', #{CORPNAME}),'%')]]>
		</if>
		<if test="approveResult != null and approveResult !='' ">
			AND APPROVE_RESULT =#{approveResult}
		</if>
	</select>
	<select id="getTotal" resultType="long" parameterType="CorpInfoTmp">
		SELECT COUNT(1) FROM T_CORP_INFO_TMP WHERE 1=1
		<!-- 各种条件 --> 
		<!--
		<if test="deptName != null and deptName !='' ">
			<!