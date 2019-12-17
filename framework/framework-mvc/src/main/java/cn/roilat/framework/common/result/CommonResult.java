package cn.roilat.framework.common.result;

public class CommonResult<T> extends BaseResult {

	/**  */
	private static final long serialVersionUID = -3803768200600232932L;

	public CommonResult() {
	};

	public CommonResult(String msg, Boolean success, T data) {
		super(msg, success);
		this.data = data;
	}

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CommonResult [data=" + data + ", msg=" + msg + ", success=" + success + "]";
	}

	public static <T> CommonResult<T> fail(String msg) {
		return new CommonResult<T>(msg, false, null);
	}

	public static <T> CommonResult<T> succ(String msg, T data) {
		return new CommonResult<T>(msg, true, data);
	}
}
