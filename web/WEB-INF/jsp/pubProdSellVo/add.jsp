<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.hansy.dataservice.sys.mapper.OrgAcctLedgerMapper">

	<!-- 1、配置返回结果Map和参数Map -->
<!-- 1、配置返回结果Map和参数Map -->

	<resultMap type="OrgAcctLedger" id="baseOrgAcctLedgerMapperResultMap">
		<result property="flowId" column="FLOW_ID"/>
		<result property="orgId" column="ORG_ID"/>
		<result property="orgName" column="ORG_NAME"/>
		<result property="acctNo" column="ACCT_NO"/>
		<result property="transAmt" column="TRANS_AMT"/>
		<result property="transTime" column="TRANS_TIME"/>
		<result property="tansType" column="TANS_TYPE"/>
		<result property="acctBal" column="ACCT_BAL"/>
		<result property="insertUser" column="INSERT_USER"/>
		<result property="insertTime" column="INSERT_TIME"/>
	</resultMap>

	<resultMap type="OrgAcctLedger" id="OrgAcctLedgerResultMap" extends="baseOrgAcctLedgerMapperResultMap">
	</resultMap>


	<parameterMap type="OrgAcctLedger" id="OrgAcctLedgerarameterMap">
		<parameter property="flowId" javaType="long" jdbcType="VARCHAR"/>
		<parameter property="orgId" javaType="long" jdbcType="BIGINT"/>
		<parameter property="orgName" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="acctNo" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="transAmt" javaType="bigDecimal" jdbcType="DECIMAL"/>
		<parameter property="transTime" javaType="date" jdbcType="TIMESTAMP"/>	
		<parameter property="tansType" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="acctBal" javaType="bigDecimal" jdbcType="DECIMAL"/>
		<parameter property="insertUser" javaType="string" jdbcType="VARCHAR"/>
		<parameter property="insertTime" javaType="string" jdbcType="VARCHAR"/>
	</parameterMap>
	
<select id="getOrgAcctLedgerList" parameterType="java.util.Map" resultMap="OrgAcctLedgerResultMap">
	select *
	<!-- FLOW_ID,
	ORG_ID,
	ORG_NAME,
	ACCT_NO,
	TRANS_AMT,
	TRANS_TIME,
	TANS_TYPE,
	ACCT_BAL,
	INSERT_USER,
	INSERT_TIME -->
	from T_ORG_ACCT_LEDGER t
	<trim prefix="WHERE" prefixOverrides="AND |OR ">
			<if test="orgName != null and orgName != ''">
			<!-- and t.orgName like concat(concat('%',#{orgName}),'%') -->
				AND t.ORG_NAME like concat(concat('%',#{orgName}),'%')
			</if>
			<if test="acctNo != null and acctNo != ''">
				AND t.ACCT_NO = #{acctNo}
			</if>
			<if test="transTimeBg != null and transTimeBg != ''">
				AND to_char(t.TRANS_TIME,'yyyy-mm-dd') >= #{transTimeBg}
			</if>
			<if test="transTimeEnd != null and transTimeEnd != ''">
				AND to_char(t.TRANS_TIME,'yyyy-mm-dd') &lt;= #{transTimeEnd}
			</if>
		</trim>
</select>

<select id="getAcctBal" parameterType="java.util.Map" resultMap="OrgAcctLedgerResultMap">
	select * from T_ORG_ACCT_LEDGER t
	 <trim prefix="WHERE" prefixOverrides="AND |OR ">
			<if test="orgName != null and orgName != ''">
				AND t.ORG_NAME = #{orgName}
			</if>
			<if test="acctNo != null and acctNo != ''">
				AND t.ACCT_NO = #{acctNo}
			</if>
		</trim>
</select>
<select id="getById" parameterType="java.lang.Long" resultMap="OrgAcctLedgerResultMap">
	select * from T_ORG_ACCT_LEDGER t
	where ORG_ID = #{value}
</select> 
<select id="page" resultMap="OrgAcctLedgerResultMap" parameterType="java.util.Map">
		SELECT * FROM T_ORG_ACCT_LEDGER t
		<trim prefix="WHERE" prefixOverrides="AND |OR ">
			<if test="orgName != null and orgName != ''">
			<!-- and t.orgName like concat(concat('%',#{orgName}),'%') -->
				AND t.ORG_NAME like concat(concat('%',#{orgName}),'%')
			</if>
			<if test="acctNo != null and acctNo != ''">
				AND t.ACCT_NO = #{acctNo}
			</if>
			<if test="transTimeBg != null and transTimeBg != ''">
				AND to_char(t.TRANS_TIME,'yyyy-mm-dd') >= #{transTimeBg}
			</if>
			<if test="transTimeEnd != null and transTimeEnd != ''">
				AND to_char(t.TRANS_TIME,'yyyy-mm-dd') &lt;= #{transTimeEnd}
			</if>
		</trim>
		order by t.TRANS_TIME desc
	</select>

	<select id="pageCount" resultType="long" parameterType="java.util.Map">
		SELECT COUNT(1) FROM T_ORG_ACCT_LEDGER t
		<!-- 各种条件 --> 
		<!-- 各种条件 --> 
		<trim prefix="WHERE" prefixOverrides="AND |OR ">
			<if test="orgName != null and orgName != ''">
			<!-- and t.orgName like concat(concat('%',#{orgName}),'%') -->
				AND t.ORG_NAME like concat(concat('%',#{orgName}),'%')
			</if>
			<if test="acctNo != null and acctNo != ''">
				AND t.ACCT_NO = #{acctNo}
			</if>
			<if test="transTimeBg != null and transTimeBg != ''">
				AND to_char(t.TRANS_TIME,'yyyy-mm-dd') >= #{transTimeBg}
			</if>
			<if test="transTimeEnd != null and transTimeEnd != ''">
				AND to_char(t.TRANS_TIME,'yyyy-mm-dd') &lt;= #{transTimeEnd}
			</if>
		</trim>
	</select>


<!-- <select id="getAcctBal1" parameterType="java.lang.String" resultType="java.lang.String">
	select * from T_ORG_ACCT_LEDGER t
	 where acctNo = #{acctNo}
</select> -->
<!-- <update id="update