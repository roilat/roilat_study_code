<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.fsoa.corpmgr.mappers.CorpInfoMapper">
	<!-- 1、配置返回结果Map和参数Map -->
	<resultMap type="CorpInfo" id="corpInfoResultMap">
		<id property="csn" column="CSN"/>
		<result property="corpName" column="CORPNAME"/>
		<result property="encorpName" column="ENCORPNAME"/>
		<result property="entCertNo" column="ENT_CERT_NO"/>
		<result property="logo" column="LOGO"/>
		<result property="abStract" column="ABSTRACT"/>
		<result property="mainbiz" column="MAINBIZ"/>
		<result property="busiOperSite" column="BUSI_OPER_SITE"/>
		<result property="registerTime" column="REGISTER_TIME"/>
		<result property="registerAssets" column="REGISTER_ASSETS"/>
		<result property="honor" column="HONOR"/>
		<result property="prjexperience" column="PRJEXPERIENCE"/>
		<result property="creator" column="CREATOR"/>
		<result property="createTime" column="CREATETIME"/>
		<result property="modifier" column="MODIFIER"/>
		<result property="modifyTime" column="MODIFYTIME"/>
		<result property="departmentId" column="DEPARTMENT_ID"/>
	</resultMap>
	<resultMap type="CorpInfoVo" id="corpInfoResultMapVo" extends="corpInfoResultMap">
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
	</resultMap>
	<!-- <parameter property="deptId" javaType="string" jdbcType="VARCHAR"/> -->
	<parameterMap type="CorpInfo" id="corpInfoParameterMap">
		<parameter property="csn" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="corpName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="encorpName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="entCertNo" javaType="string" jdbcType="CHAR"/>
		<parameter property="logo" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="abStract" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="mainbiz" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="busiOperSite" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="registerTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="registerAssets" javaType="java.math.BigDecimal" jdbcType="DECIMAL"/>
		<parameter property="honor" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="prjexperience" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="creator" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="createTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="modifier" javaType="integer" jdbcType="INTEGER"/>
		<parameter property="modifyTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="departmentId" javaType="integer" jdbcType="INTEGER"/>
	</parameterMap>

	<!-- 2、各个SeqID -->
	<insert id="add" parameterMap="corpInfoParameterMap">
		INSERT INTO T_CORP_INFO (CSN, CORPNAME, ENCORPNAME, ENT_CERT_NO, LOGO, ABSTRACT, MAINBIZ, BUSI_OPER_SITE, REGISTER_TIME, REGISTER_ASSETS, HONOR, PRJEXPERIENCE, CREATOR, CREATETIME, MODIFIER, MODIFYTIME,DEPARTMENT_ID) VALUES (
			#{csn, jdbcType=INTEGER}, 
			#{corpName, jdbcType=VARCHAR}, 
			#{encorpName, jdbcType=VARCHAR}, 
			#{entCertNo, jdbcType=CHAR}, 
			#{logo, jdbcType=VARCHAR}, 
			#{abStract, jdbcType=VARCHAR}, 
			#{mainbiz, jdbcType=VARCHAR}, 
			#{busiOperSite, jdbcType=VARCHAR}, 
			#{registerTime, jdbcType=TIMESTAMP}, 
			#{registerAssets, jdbcType=DECIMAL }, 
			#{honor, jdbcType=VARCHAR}, 
			#{prjexperience, jdbcType=VARCHAR}, 
			#{creator, jdbcType=INTEGER}, 
			#{createTime, jdbcType=TIMESTAMP}, 
			#{modifier, jdbcType=INTEGER}, 
			#{modifyTime, jdbcType=TIMESTAMP},
			#{departmentId, jdbcType=INTEGER}
		)
	</insert>


<insert id="addCorpInfo" parameterMap="corpInfoParameterMap">
		REPLACE INTO T_CORP_INFO (CSN, CORPNAME, ENCORPNAME, ENT_CERT_NO, LOGO, ABSTRACT, MAINBIZ, BUSI_OPER_SITE, REGISTER_TIME, REGISTER_ASSETS, HONOR, PRJEXPERIENCE, CREATOR, CREATETIME, MODIFIER, MODIFYTIME,DEPARTMENT_ID) VALUES (
			#{csn, jdbcType=INTEGER}, 
			#{corpName, jdbcType=VARCHAR}, 
			#{encorpName, jdbcType=VARCHAR}, 
			#{entCertNo, jdbcType=CHAR}, 
			#{logo, jdbcType=VARCHAR}, 
			#{abStract, jdbcType=VARCHAR}, 
			#{mainbiz, jdbcType=VARCHAR}, 
			#{busiOperSite, jdbcType=VARCHAR}, 
			#{registerTime, jdbcType=TIMESTAMP}, 
			#{registerAssets, jdbcType=DECIMAL }, 
			#{honor, jdbcType=VARCHAR}, 
			#{prjexperience, jdbcType=VARCHAR}, 
			#{creator, jdbcType=INTEGER}, 
			#{createTime, jdbcType=TIMESTAMP}, 
			#{modifier, jdbcType=INTEGER}, 
			#{modifyTime, jdbcType=TIMESTAMP},
			#{departmentId, jdbcType=INTEGER}
		)
	</insert>
	<!-- 判断不可重复的属性是否已经存在，这里默认只判断deptName属性，具体的业务再进行修改添加 -->
	<!--
	<select id="isExists" resultType="integer" parameterMap="corpInfoParameterMap">
		SELECT COUNT(1) FROM T_CORP_INFO WHERE DEPT_NAME=#{deptName}
		<if test="deptId != null and deptId !='' ">
			<![CDATA[ AND DEPT_ID <> #{deptId, jdbcType=VARCHAR} ]]>
		</if>
	</select>
	-->
	<!-- 登陆用户为会员单位，项目经历不可以查看 -->
	<select id="getByIdCorp" resultMap="corpInfoResultMapVo" parameterType="java.lang.String">
		SELECT CSN, CORPNAME, ENCORPNAME, ENT_CERT_NO, LOGO, ABSTRACT, MAINBIZ, BUSI_OPER_SITE, 
		REGISTER_TIME, REGIS