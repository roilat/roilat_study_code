package cn.roilat.modules.home.constant;

public class Constant {
	//是否禁用
	public static final String[][] IS_DISABLE = {{"is_disable_0","否"},{"is_disable_1","是"}};
	//申请是否已处理
	public static final String[][] HANDLER_STATUS = {{"handler_status_0","未处理"},{"handler_status_1","已处理"}};
	//申请状态（大状态）
	public static final String[][] APPLY_STATUS = {{"apply_status_001","待发"},{"apply_status_002","审批中"},
													{"apply_status_003","已完成"},{"apply_status_004","已撤销"},
													{"apply_status_005","已删除"}};
	//行为日志操作状态结果
	public static final String[][] LOGGER_OPERTION_STATUS = {{"operation_status_0","失败"},{"operation_status_1","成功"}};
	//行为日志操作类型
	public static final String[][] LOGGER_OPERTION_TYPE = {{"operation_type_0","新增"},{"operation_type_1","修改"},
															{"operation_type_2","启用"},{"operation_type_3","禁用"},
															{"operation_type_4","登录"},{"operation_type_5","退出"}};
}
