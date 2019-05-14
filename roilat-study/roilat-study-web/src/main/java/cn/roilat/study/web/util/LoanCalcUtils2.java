
package cn.roilat.study.web.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * javadoc for com.hansy.p2p.tool.LoanCalcUtils
 * @Copyright: 2016成都环赛信息技术有限公司 
 * @author: roilat-D
 * @since: 2016年5月23日
 */
public class LoanCalcUtils2 {

	/**
	 * BigDecimal[0]	月应还金额
	 * BigDecimal[1]	应还本金金额
	 * BigDecimal[2]	应还利息金额
	 */

	private static int[] daysForPerMonthConstant = {
			31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30
	};

	/**
	 * @description: 等额本息-按月份算（1）
	 * @creator: roilat-D
	 * @createDate: 2016年5月23日 
	 * @modifier:
	 * @modifiedDate:
	 * @param loanAmt		借款金额
	 * @param prftRat		产品利率
	 * @param prodPerdSum	产品期数
	 * @return
	 * @throws Exception 
	 */
	public static List<BigDecimal[]> calcForEqualCapitalPlusInterestByMonth(BigDecimal loanAmt, BigDecimal prftRat, int prodPerdSum) throws Exception {
		/**
		 * 等额本息的还款方式，每月的还款金额X,融资金额A,年化收益B,总期数M,月利率m
		 * X=((A*B/12*(1+B/12)^m)/((1+B/12)^m-1)
		 * 经过推导得到:(AB(12+B)^m)/(12*(12+m)^m-12^(m+1))
		 * 每月所还的利息：当月本金余额*B/12
		 * 每月所还的本金：X-每月所还的利息
		 */
		List<BigDecimal[]> results = new ArrayList<BigDecimal[]>(prodPerdSum);

		BigDecimal t0 = prftRat.add(new BigDecimal(12));
		BigDecimal t1 = ArithUtil.pow(t0, prodPerdSum);
		BigDecimal fz = loanAmt.multiply(prftRat).multiply(t1);
		BigDecimal fm = t1.multiply(new BigDecimal(12)).add(new BigDecimal(Math.pow(12, prodPerdSum+1)).negate());
		BigDecimal monthRepay = fz.divide(fm,6,BigDecimal.ROUND_HALF_UP);
		BigDecimal totalAmt = new BigDecimal("0");
		System.out.println("monthRepay----" + monthRepay);
		BigDecimal[] result;
		BigDecimal surplusAmt = loanAmt;//首月的剩余额为贷款总额
		while (prodPerdSum-- > 0) {
			result = new BigDecimal[3];
			result[0] = monthRepay;//月应还金额
			result[2] = surplusAmt.multiply(prftRat).divide(new BigDecimal(12),6,BigDecimal.ROUND_HALF_UP);//应还利息=剩余金额*月利率
			result[0] = result[0].setScale(2,BigDecimal.ROUND_HALF_UP);//四舍五入
			result[2] = result[2].setScale(2,BigDecimal.ROUND_HALF_UP);//四舍五入
			totalAmt = totalAmt.add(monthRepay.add(result[0].negate()));//计算总金额每次四舍五入的误差（6位小数）
			result[1] = result[0].add(result[2].negate());
			
			surplusAmt = surplusAmt.add(result[1].negate());//剩余本金=上次剩余本金-本次应还本金（两位小数）
			if(prodPerdSum == 0){//最后一个月
				result[0] = result[0].add(totalAmt.setScale(2,BigDecimal.ROUND_HALF_UP));
				result[1] = result[1].add(surplusAmt);
				result[2] = result[2].add(surplusAmt.negate()).add(totalAmt.setScale(2,BigDecimal.ROUND_HALF_UP));
			}
			results.add(result);
		}
		return results;
	}

	/**
	 * @description: 等额本金-按月份算（2）
	 * @creator: roilat-D
	 * @createDate: 2016年5月24日 
	 * @modifier:
	 * @modifiedDate:
	 * @param loanAmt		借款金额
	 * @param prftRat		产品利率
	 * @param prodPerdSum	产品期数
	 * @return
	 * @throws Exception
	 */
	public static List<BigDecimal[]> calcForEqualCapitalByMonth(BigDecimal loanAmt, BigDecimal prftRat, int prodPerdSum) throws Exception {
		/**
		 * 等额本金的还款方式，每月的还款金额X,融资金额A,年化收益B,总期数M
		 * 每月还款本金：A/M
		 * 每月还款利息：上期所剩本金*B/12
		 * X=每月还款本金+每月还款利息
		 * */
		List<BigDecimal[]> results = new ArrayList<BigDecimal[]>(prodPerdSum);

		BigDecimal monthCapital = loanAmt.divide(new BigDecimal(prodPerdSum),6,BigDecimal.ROUND_HALF_UP);//A/M，应还本金(6位)
		BigDecimal totalIntAmt = new BigDecimal("0");
		System.out.println("monthCapital----" + monthCapital);
		BigDecimal[] result;
		BigDecimal surplusAmt = loanAmt;//首月的剩余额为贷款总额
		while (prodPerdSum-- > 0) {
			result = new BigDecimal[3];
			result[1] = monthCapital;//应还本金
			result[2] = prftRat.multiply(surplusAmt).divide(new BigDecimal(12),6,BigDecimal.ROUND_HALF_UP);//应还利息=剩余金额*月利率
			totalIntAmt = totalIntAmt.add(result[2].add(result[2].setScale(2, BigDecimal.ROUND_HALF_UP).negate()));//计算利息每次四舍五入的误差（6位小数）
			
			result[1] = result[1].setScale(2,BigDecimal.ROUND_HALF_UP);//四舍五入
			result[2] = result[2].setScale(2,BigDecimal.ROUND_HALF_UP);//四舍五入
			result[0] = result[1].add(result[2]);

			surplusAmt = surplusAmt.add(result[1].negate());//剩余本金=上次剩余本金-本次应还本金(两位小数)
			if(prodPerdSum == 0){//最后一个月
				result[1] = result[1].add(surplusAmt.setScale(2,BigDecimal.ROUND_HALF_UP));
				result[2] = result[2].add(totalIntAmt.setScale(2,BigDecimal.ROUND_HALF_UP));
				result[0] = result[1].add(result[2]);
			}
			results.add(result);
		}
		return results;
	}

	/**
	 * @description: 等额本金-按天份算（3）
	 * @creator: roilat-D
	 * @createDate: 2016年5月24日 
	 * @modifier:
	 * @modifiedDate:
	 * @param loanAmt		借款金额
	 * @param prftRat		产品利率
	 * @param prodPerdSum	产品期数
	 * @param prodPerdSum	每期的天数
	 * @return
	 * @throws Exception
	 */
	public static List<BigDecimal[]> calcForEqualCapitalByDays(BigDecimal loanAmt, BigDecimal prftRat, int prodPerdSum, int[] daysPerMonth) throws Exception {
		/**
		 * 等额本金的还款方式，每天的还款金额X,融资金额A,年化收益B,总期数M,每月天数D
		 * 每月还款本金：A/M
		 * 每月还款利息：上期所剩本金*B/1年天数*本期天数
		 * X=每月还款本金+每月还款利息
		 * */

		if (daysPerMonth.length != prodPerdSum) {
			throw new Exception("每期的天数列表和实际期数不一致！");
		}
		List<BigDecimal[]> results = new ArrayList<BigDecimal[]>(prodPerdSum);

		BigDecimal monthCapital = loanAmt.divide(new BigDecimal(prodPerdSum),6,BigDecimal.ROUND_HALF_UP);//A/M，应还本金
		BigDecimal[] result;
		BigDecimal totalIntAmt = new BigDecimal("0");
		BigDecimal surplusAmt = loanAmt;//首月的剩余额为贷款总额
		int i = 0;
		while (i < prodPerdSum) {
			result = new BigDecimal[3];
			result[1] = monthCapital;//应还本金
			result[2] = prftRat.multiply(surplusAmt).multiply(new BigDecimal(daysPerMonth[i])).divide(new BigDecimal(365),6,BigDecimal.ROUND_HALF_UP);//应还利息=剩余金额*天利率*天数
			totalIntAmt = totalIntAmt.add(result[2].add(result[2].setScale(2, BigDecimal.ROUND_HALF_UP).negate()));//计算利息每次四舍五入的误差（6位小数）
			
			result[1] = result[1].setScale(2,BigDecimal.ROUND_HALF_UP);//四舍五入
			result[2] = result[2].setScale(2,BigDecimal.ROUND_HALF_UP);//四舍五入
			result[0] = result[1].add(result[2]);

			surplusAmt = surplusAmt.add(result[1].negate());//剩余本金=上次剩余本金-本次应还本金(两位小数)
			if(prodPerdSum == i+1){//最后一个月
				result[1] = result[1].add(surplusAmt.setScale(2,BigDecimal.ROUND_HALF_UP));
				result[2] = result[2].add(totalIntAmt.setScale(2,BigDecimal.ROUND_HALF_UP));
				result[0] = result[1].add(result[2]);
			}
			
			results.add(result);
			i++;
		}
		return results;
	}

	/**
	 * @description: 每月还利息，到期还本金-按月份算(4)
	 * @creator: roilat-D
	 * @createDate: 2016年5月24日 
	 * @modifier:
	 * @modifiedDate:
	 * @param loanAmt		借款金额
	 * @param prftRat		产品利率
	 * @param prodPerdSum	产品期数
	 * @return
	 * @throws Exception
	 */
	public static List<BigDecimal[]> calcForRepayInterestPerMonthByMonth(BigDecimal loanAmt, BigDecimal prftRat, int prodPerdSum) throws Exception {
		/**
		 * 每月还利息，到期还本金。每月的还款金额X,融资金额A,年化收益B,总期数M
		 * 每月还款本金：0，最后一个月为A
		 * 每月还款利息：A*B/12
		 * X=每月还款本金+每月还款利息101
		 */
		List<BigDecimal[]> results = new ArrayList<BigDecimal[]>(prodPerdSum);

		BigDecimal[] result;
		BigDecimal totalIntAmt = new BigDecimal("0");

		while (prodPerdSum-- > 0) {
			result = new BigDecimal[3];
			if (prodPerdSum == 0) {
				result[1] = loanAmt;//应还本金
			} else {
				result[1] = new BigDecimal(0);//应还本金
			}

			result[2] = prftRat.multiply(loanAmt).divide(new BigDecimal(12),6,BigDecimal.ROUND_HALF_UP);//应还利息
			totalIntAmt = totalIntAmt.add(result[2]).add(result[2].setScale(2, BigDecimal.ROUND_HALF_UP).negate());
			result[1] = result[1].setScale(2,BigDecimal.ROUND_HALF_UP);
			result[2] = result[2].setScale(2,BigDecimal.ROUND_HALF_UP);
			
			if (prodPerdSum == 0) {
				result[2] = result[2].add(totalIntAmt.setScale(2,BigDecimal.ROUND_HALF_UP));
			}
			
			result[0] = result[1].add(result[2]);//月应还金额=应还本金+应还利息
			
			results.add(result);
		}
		return results;
	}

	/**
	 * @description: 每月还利息，到期还本金-按天计算(5)
	 * @creator: roilat-D
	 * @createDate: 2016年5月24日 
	 * @modifier:
	 * @modifiedDate:
	 * @param loanAmt		借款金额
	 * @param prftRat		产品利率
	 * @param prodPerdSum	产品期数
	 * @return
	 * @throws Exception
	 */
	public static List<BigDecimal[]> calcForRepayInterestPerMonthByDays(BigDecimal loanAmt, BigDecimal prftRat, int prodPerdSum, int[] daysPerMonth) throws Exception {
		/**
		 * 每月还利息，到期还本金。每月的还款金额X,融资金额A,年化收益B,总期数M,,每月天数D
		 * 每月还款本金：0，最后一个月为A
		 * 每月还款利息：A*B/365*本期天数
		 * X=每月还款本金+每月还款利息101
		 */

		if (daysPerMonth.length != prodPerdSum) {
			throw new Exception("每期的天数列表和实际期数不一致！");
		}
		List<BigDecimal[]> results = new ArrayList<BigDecimal[]>(prodPerdSum);

		BigDecimal totalIntAmt = new BigDecimal("0");
		BigDecimal[] result;
		int i = 0;
		while (prodPerdSum > i) {
			BigDecimal monthIntAmt = prftRat.multiply(loanAmt).multiply(new BigDecimal(daysPerMonth[i])).divide(new BigDecimal(365),6,BigDecimal.ROUND_HALF_UP);//A*dayRat*天数，应还利息
			result = new BigDecimal[3];
			if (prodPerdSum == i+1) {
				result[1] = loanAmt;//应还本金
			} else {
				result[1] = new BigDecimal(0);//应还本金
			}

			result[2] = monthIntAmt;//应还利息
			totalIntAmt = totalIntAmt.add(result[2]).add(result[2].setScale(2, BigDecimal.ROUND_HALF_UP).negate());
			result[1] = result[1].setScale(2,BigDecimal.ROUND_HALF_UP);
			result[2] = result[2].setScale(2,BigDecimal.ROUND_HALF_UP);
			
			if (prodPerdSum == i+1) {
				result[2] = result[2].add(totalIntAmt.setScale(2,BigDecimal.ROUND_HALF_UP));
			}
			
			result[0] = result[1].add(result[2]);//月应还金额=应还本金+应还利息
			
			results.add(result);
			i++;
		}
		return results;
	}

	/**
	 * @description: 到期还本还息-按月份算(6)
	 * @creator: roilat-D
	 * @createDate: 2016年5月24日 
	 * @modifier:
	 * @modifiedDate:
	 * @param loanAmt		借款金额
	 * @param prftRat		产品利率
	 * @param prodPerdSum	产品期数
	 * @return
	 * @throws Exception
	 */
	public static List<BigDecimal[]> calcForRepayOnceExpireByMonth(BigDecimal loanAmt, BigDecimal prftRat, int prodPerdSum) throws Exception {
		/**
		 * 到期还本还息
		 * 还款日还款，本金+利息
		 */
		List<BigDecimal[]> results = new ArrayList<BigDecimal[]>(prodPerdSum);

		BigDecimal[] result;
		int i = 0;
		while (prodPerdSum > i) {
			result = new BigDecimal[3];
			if (i == prodPerdSum-1) {
				result[1] = loanAmt;//应还本金
				result[2] = prftRat.multiply(loanAmt).multiply(new BigDecimal(prodPerdSum)).divide(new BigDecimal(12),6,BigDecimal.ROUND_HALF_UP);//应还利息:A*B*月数/12
			}else{
				result[1] = new BigDecimal(0);//应还本金
				result[2] = new BigDecimal(0);//应还利息
			}
			
			result[1] = result[1].setScale(2,BigDecimal.ROUND_HALF_UP);
			result[2] = result[2].setScale(2,BigDecimal.ROUND_HALF_UP);
			
			result[0] = result[1].add(result[2]);//月应还金额=应还本金+应还利息
			results.add(result);
			i++;
		}
		return results;
	}

	/**
	 * @description: 到期还本还息-按天计算(7)
	 * @creator: roilat-D
	 * @createDate: 2016年5月24日 
	 * @modifier:
	 * @modifiedDate:
	 * @param loanAmt		借款金额
	 * @param prftRat		产品利率
	 * @param prodPerdSum	产品期数
	 * @return
	 * @throws Exception
	 */
	public static List<BigDecimal[]> calcForRepayOnceExpireByDay(BigDecimal loanAmt, BigDecimal prftRat, int prodPerdSum, int[] daysPerMonth) throws Exception {
		/**
		 * 到期还本还息
		 * 还款日还款，本金+利息
		 */
		if (daysPerMonth.length != prodPerdSum) {
			throw new Exception("每期的天数列表和实际期数不一致！");
		}

		List<BigDecimal[]> results = new ArrayList<BigDecimal[]>(prodPerdSum);

		BigDecimal[] result;
		int i = 0;
		int totalDays = 0;
		while (prodPerdSum > i) {
			totalDays += daysPerMonth[i];
			result = new BigDecimal[3];
			if (prodPerdSum == i+1) {
				result[1] = loanAmt;//应还本金
				result[2] = prftRat.multiply(loanAmt).multiply(new BigDecimal(totalDays)).divide(new BigDecimal(365),6,BigDecimal.ROUND_HALF_UP);//年利率*总天数*本金/365=应还利息
			} else {
				result[1] = new BigDecimal(0);//应还本金
				result[2] = new BigDecimal(0);//应还利息

			}
			
			result[1] = result[1].setScale(2,BigDecimal.ROUND_HALF_UP);
			result[2] = result[2].setScale(2,BigDecimal.ROUND_HALF_UP);
			
			result[0] = result[1].add(result[2]);//月应还金额=应还本金+应还利息
			results.add(result);
			i++;
		}
		return results;
	}

	/**
	 * @description: 根据上线时间和期数，计划每期的天数
	 * @creator: roilat-D
	 * @createDate: 2016年5月24日 
	 * @modifier:
	 * @modifiedDate:
	 * @param onlineDate	上线时间
	 * @param prodPerdSum	产品总期数
	 * @return
	 */
	public static int[] calcDaysForPerMonth(Date onlineDate, int prodPerdSum) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(onlineDate);
		int[] result = new int[prodPerdSum];
		int month = cal.get(Calendar.MONTH);//获取上线月份（比实际月份小1)
		int i = 0;
		month ++;//上线日期的下个月开始
		while (i < prodPerdSum) {
			if (month == 12) {
				month = 0;
			}
			result[i++] = daysForPerMonthConstant[month++];
		}
		return result;
	}


	public static void main(String[] args) throws Exception {
		List<BigDecimal[]> list = LoanCalcUtils2.calcForEqualCapitalByMonth(new BigDecimal("10000"), new BigDecimal("0.10"), 12);
		BigDecimal sum = new BigDecimal(0);
		for(BigDecimal[] decimals:list){
			sum = sum.add(decimals[2]);
		}
		System.out.println(sum);
	}
}
