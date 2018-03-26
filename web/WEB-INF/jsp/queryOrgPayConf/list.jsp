<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.dataservice.sys.mapper.QueryOrgRegistMapper">

	<!-- 1、配置返回结果Map和参数Map -->

	<resultMap type="QueryOrgRegist" id="baseQueryOrgRegistResultMap">
		<id property="orgId" column="ORG_ID"/>
		<result property="orgName" column="ORG_NAME"/>
		<result property="orgType" column="ORG_TYPE"/>
		<result property="registTime" column="REGIST_TIME"/>
		<result property="userName" column="USER_NAME"/>
		<result property="passwd" column="PASSWD"/>
		<result property="acctNo" column="ACCT_NO"/>
		<result property="acctStatus" column="ACCT_STATUS"/>
		<result property="consumeMethod" column="CONSUME_METHOD"/>
		<result property="updateTime" column="UPDATE_TIME"/>
		<result property="ticket" column="TICKET"/>
		<result property="token" column="TOKEN"/>
		<result property="privateKey" column="PRIVATE_KEY"/>
		<result property="publicKey" column="PUBLIC_KEY"/>
		<result property="tokenUpdateTime" column="TOKEN_UPDATE_TIME"/>
		<result property="keypairUpdateTime" column="KEYPAIR_UPDATE_TIME"/>
		<result property="acctBal" column="ACCT_BAL"/>
		<result property="concat" column="CONCAT"/>
		<result property="telphone" column="TELPHONE"/>
		<result property="email" column="EMAIL"/>
	</resultMap>

	<resultMap type="QueryOrgRegist" id="queryOrgRegistResultMap" extends="baseQueryOrgRegistResultMap">
	</resultMap>

	<!-- <parameter property="deptId" javaType="string" jdbcType="VARCHAR"/> -->
	<parameterMap type="QueryOrgRegist" id="queryOrgRegistParameterMap">
		<parameter property="orgId" javaType="long" jdbcType="BIGINT"/>
		<parameter property="orgName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="orgType" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="registTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="userName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="passwd" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="acctNo" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="acctStatus" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="consumeMethod" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="updateTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="ticket" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="token" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="privateKey" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="publicKey" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="tokenUpdateTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="keypairUpdateTime" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="acctBal" javaType="BigDecimal" jdbcType="DECIMAL"/>
		<parameter property="concat" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="telphone" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="email" javaType="string" jdbcType="VARCHAR"/>
	</parameterMap>


	<!-- 2、各个SeqID -->

	<insert id="add" parameterMap="queryOrgRegistParameterMap">
		<selectKey keyProperty="orgId" resultType="long" order="BEFORE">
			SELECT SEQ_QUERY_ORG_REGIST.nextval from dual
		</selectKey>
		INSERT INTO T_Query_Org_Regist (ORG_ID, ORG_NAME, ORG_TYPE, REGIST_TIME, USER_NAME, PASSWD, ACCT_NO, ACCT_STATUS, CONSUME_METHOD, UPDATE_TIME, TICKET, TOKEN, PRIVATE_KEY, PUBLIC_KEY, TOKEN_UPDATE_TIME, KEYPAIR_UPDATE_TIME,ACCT_BAL,CONCAT,TELPHONE,EMAIL) VALUES (
			#{orgId, jdbcType=BIGINT}, 
			#{orgName, jdbcType=VARCHAR}, 
			#{orgType, jdbcType=VARCHAR}, 
			#{registTime, jdbcType=TIMESTAMP}, 
			#{userName, jdbcType=VARCHAR}, 
			#{passwd, jdbcType=VARCHAR}, 
			#{acctNo, jdbcType=VARCHAR}, 
			#{acctStatus, jdbcType=VARCHAR}, 
			#{consumeMethod, jdbcType=VARCHAR}, 
			#{updateTime, jdbcType=TIMESTAMP}, 
			#{ticket, jdbcType=VARCHAR}, 
			#{token, jdbcType=VARCHAR}, 
			#{privateKey, jdbcType=VARCHAR}, 
			#{publicKey, jdbcType=VARCHAR}, 
			#{tokenUpdateTime, jdbcType=TIMESTAMP}, 
			#{keypairUpdateTime, jdbcType=TIMESTAMP},
			#{acctBal, jdbcType=DECIMAL},
			#{concat, jdbcType=VARCHAR}, 
			#{telphone, jdbcType=VARCHAR},
			#{email, jdbcType=VARCHAR}
		)
	</insert>

	<!-- 判断不可重复的属性是否已经存在，这里默认只判断deptName属性，具体的业务再进行修改添加 -->
	
	<select id="isExists" resultType="integer" parameterMap="queryOrgRegistParameterMap">
		SELECT COUNT(1) FROM T_Query_Org_Regist
		<trim prefix="WHERE" prefixOverrides="OR">  
		    <if test="userName != null and userName !=''">  
		        OR USER_NAME = #{userName}  
		    </if>  
		    <if test="orgId != null">  
		        AND ORG_ID !=#{orgId}  
		    </if>  

		</trim> 
	</select>
	

	<select id="getById" resultMap="queryOrgRegistResultMap" parameterType="long">
		SELECT * FROM T_Query_Org_Regist WHERE ORG_ID = #{value}
	</select>
	<select id="queryOrgRegistInfoByToken" resultMap="queryOrgRegistResultMap" parameterType="string">
		SELECT * FROM T_Query_Org_Regist WHERE TOKEN = #{value}
	</select>

	<select id="page" resultMap="queryOrgRegistResultMap" parameterType="java.util.Map">
		SELECT * FROM T_Query_Org_Regist WHERE 1=1
		<!-- 各种条件 --> 
		<if test="queryOrgRegist.orgName != null and queryOrgRegist.orgName !='' ">
			AND ORG_NAME LIKE CONCAT(CONCAT('%', #{queryOrgRegist.orgName}),'%')
		</if>
		order by REGIST_TIME desc
	</select>

	<select id="totalCount" resultType="long" parameterType="QueryOrgRegist">
		SELECT COUNT(1) FROM T_Query_Org_Regist WHERE 1=1
		<!-- 各种条件 --> 
		<!-- 各种条件 --> 
		<if test="orgName != null and orgName !='' ">
			AND ORG_NAME LIKE CONCAT(CONCAT('%', #{orgName}),'%')
		</if>
	</select>
	
	<select id="getByName" resultMap="queryOrgRegistResultMap" parameterType="string">
		SELECT * FROM T_Query_Org_Regist WHERE USER_NAME=#{value}
	</select>

	<delete id="delete" parameterType="java.util.List">
		DELETE FROM T_Query_Org_Regist WHERE ORG_ID IN
		<foreach collection="list" index="index" item="item" open="(" separator="," close=")"> 
        #{item} 
    	</foreach>
	</delete>

	<update id="edit" parameterType="QueryOrgRegist">
		UPDATE T_Query_Org_Regist 
		<!-- 各种更改的字段 --> 
		<trim prefix="set" suffixOverrides=",">
			<if test="orgName != null and orgName !='' ">
				ORG_NAME = #{orgName, jdbcType=VARCHAR}, 
			</if>
			<if test="orgType != null and orgType !='' ">
				ORG_TYPE = #{orgType, jdbcType=VARCHAR}, 
			</if>
			<if test="registTime != null and registTime !='' ">
				REGIST_TIME = #{registTime, jdbcType=TIMESTAMP}, 
			</if>
			<if test="userName != null and userName !='' ">
				USER_NAME = #{userName, jdbcType=VARCHAR}, 
			</if>
			<if test="passwd != null and passwd !='' ">
				PASSWD = #{passwd, jdbcType=VARCHAR}, 
			</if>
			<if test="acctNo != null and acctNo !='' ">
				ACCT_NO = #{acctNo, jdbcType=VARCHAR}, 
			</if>
			<if test="acctStatus != null and acctStatus !='' ">
				ACCT_STATUS = #{acctStatus, jdbcType=VARCHAR}, 
			</if>
			<if test="consumeMethod != null and consumeMethod !='' ">
				CONSUME_METHOD = #{consumeMethod, jdbcType=VARCHAR}, 
			</if>
			<if test="updateTime != null and updateTime !='' ">
				UPDATE_TIME = #{updateTime, jdbcType=TIMESTAMP}, 
			</if>
			<if test="ticket != null and ticket !='' ">
				TICKET = #{ticket, jdbcType=VARCHAR}, 
			</if>
			<if test="token != null and token !='' ">
				TOKEN = #{token, jdbcType=VARCHAR}, 
			</if>
			<if test="privateKey != null and privateKey !='' ">
				PRIVATE_KEY = #{privateKey, jdbcType=VARCHAR}, 
			</if>
			<if test="publicKey != null and publicKey !='' ">
				PUBLIC_K