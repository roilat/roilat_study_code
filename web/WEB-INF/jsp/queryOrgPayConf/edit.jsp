<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.dataservice.sysmgr.mapper.SysUserMapper">

	<!-- 1、配置返回结果Map和参数Map -->

	
	
<resultMap type="SysUser" id="baseSysUserResultMap">
		<id property="userId" column="USER_ID"/>
		<result property="userName" column="USER_NAME"/>
		<result property="userPwd" column="USER_PWD"/>
		<result property="userNetId" column="USER_NET_ID"/>
		<result property="userLastLogin" column="USER_LAST_LOGIN"/>
		<result property="userIp" column="USER_IP"/>
		<result property="userType" column="USER_TYPE"/>
		<result property="state_" column="STATE_"/>
		<result property="createDt" column="CREATE_DT"/>
		<result property="userKname" column="USER_KNAME"/>
		<result property="mailAdd" column="MAIL_ADD"/>
		<result property="userAutName" column="USER_AUT_NAME"/>
		<result property="userAutPwd" column="USER_AUT_PWD"/>
		<result property="type_" column="TYPE_"/>
		<result property="updateDt" column="UPDATE_DT"/>
		<result property="orgId" column="ORG_ID"/>
	</resultMap>

	<resultMap type="SysUser" id="sysUserResultMap" extends="baseSysUserResultMap">
	</resultMap>

	<parameterMap type="SysUser" id="sysUserParameterMap">
		<parameter property="userName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="userPwd" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="userNetId" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="userLastLogin" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="userIp" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="userType" javaType="bigDecimal" jdbcType="DECIMAL"/>
		<parameter property="state_" javaType="bigDecimal" jdbcType="DECIMAL"/>
		<parameter property="createDt" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="userKname" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="mailAdd" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="userAutName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="userAutPwd" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="type_" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="updateDt" javaType="date" jdbcType="TIMESTAMP"/>
		<parameter property="orgId" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="userId" javaType="string" jdbcType="VARCHAR"/>
	</parameterMap>



	<!-- 2、各个SeqID -->

	<insert id="create" parameterMap="sysUserParameterMap">
		<!-- <selectKey keyProperty="id" resultType="long" order="BEFORE">
			SELECT SEQ_SYS_USER.nextval as id from dual
		</selectKey> -->
		INSERT INTO SYS_USER (USER_ID,USER_NAME, USER_PWD, USER_NET_ID, USER_LAST_LOGIN, USER_IP, USER_TYPE, STATE_, CREATE_DT,USER_KNAME,MAIL_ADD,USER_AUT_NAME,USER_AUT_PWD,TYPE_,UPDATE_DT,ORG_ID) VALUES (
			#{userId, jdbcType=VARCHAR}, 
			#{userName, jdbcType=VARCHAR}, 
			#{userPwd, jdbcType=VARCHAR}, 
			#{userNetId, jdbcType=VARCHAR}, 
			#{userLastLogin, jdbcType=TIMESTAMP}, 
			#{userIp, jdbcType=VARCHAR}, 
			#{userType, jdbcType=DECIMAL}, 
			#{state_, jdbcType=DECIMAL}, 
			#{createDt, jdbcType=TIMESTAMP}, 
			#{userKname, jdbcType=VARCHAR},
			#{mailAdd, jdbcType=VARCHAR},
			#{userAutName, jdbcType=VARCHAR},
			#{userAutPwd, jdbcType=VARCHAR},
			#{type_, jdbcType=VARCHAR},
			#{updateDt, jdbcType=TIMESTAMP},
			#{orgId, jdbcType=VARCHAR}
		)

	</insert>

	<!-- 判断不可重复的属性是否已经存在，这里默认只判断deptName属性，具体的业务再进行修改添加 -->
	
	<select id="isExists" resultType="integer" parameterMap="sysUserParameterMap">
		SELECT COUNT(1) FROM SYS_USER WHERE 1 = 1
		<if test=" userName != null and userName !='' ">
			<![CDATA[ AND USER_NAME = #{userName, jdbcType=VARCHAR} ]]>
		</if>
		<if test=" userPwd != null and userPwd !='' ">
			<![CDATA[ AND USER_PWD = #{userPwd, jdbcType=VARCHAR} ]]>
		</if>
	</select>
	

	<select id="getById" resultMap="sysUserResultMap" parameterType="string">
		SELECT * FROM SYS_USER WHERE USER_ID = #{value}
	</select>
	<select id="getByUserName" resultMap="sysUserResultMap" parameterType="string">
		SELECT * FROM SYS_USER WHERE USER_NAME = #{value}
	</select>
<!-- resultMap="sysUserResultMap" -->
	<select id="page" resultMap="sysUserResultMap"  parameterType="java.util.Map">
		SELECT distinct * FROM SYS_USER WHERE STATE_ = 1
		<if test="userName != null and userName !='' ">
			AND USER_NAME like concat(concat('%',#{userName}),'%')
			</if>
		<!-- 各种条件 --> 
		order by user_id
	</select>

	<select id="getTotal" resultType="long" parameterType="java.util.Map">
		SELECT COUNT(1) FROM SYS_USER  WHERE STATE_ = 1
		<if test="userName != null and userName !='' ">
			AND USER_NAME like concat(concat('%',#{userName}),'%')
			</if>
	</select>
	
	<delete id="deleteById" parameterType="string">
		DELETE FROM SYS_USER WHERE USER_ID = #{value}
	</delete>

	<update id="edit" parameterType="SysUser">
		UPDATE SYS_USER 
		<!-- 各种更改的字段  -->
		<trim prefix="set" suffixOverrides=",">
			<if test="userName != null and userName !='' ">
				USER_NAME = #{userName, jdbcType=VARCHAR}, 
			</if>
			<if test="userPwd != null and userPwd !='' ">
				USER_PWD = #{userPwd, jdbcType=VARCHAR}, 
			</if>
			<if test="userNetId != null and userNetId !='' ">
				USER_NET_ID = #{userNetId, jdbcType=VARCHAR}, 