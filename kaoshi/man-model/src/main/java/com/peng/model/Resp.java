package com.peng.model;




import java.io.Serializable;

public class Resp<T> implements Serializable {

	public  final  static  String DEFAULT_DISPLAY_ERRORMSG="系统繁忙，请稍后再试";
	/**
	 * 
	 */
	private static final long serialVersionUID = -4147760503941116603L;
	/**
	 * 操作结果
	 */
	private String code;

	/**
	 * 说明信息
	 */
	private String msg;

	/**
	 * 数据信息
	 */
	private T data;


	public String getInnerExceptionMsg() {
		return innerExceptionMsg;
	}

	public void setInnerExceptionMsg(String innerExceptionMsg) {
		this.innerExceptionMsg = innerExceptionMsg;
	}

	private  String innerExceptionMsg;

	public Resp() {
		code = ServiceStatus.SUCCESS.getCode();
		msg = ServiceStatus.SUCCESS.getDetail();
	}


	/**
	 *  成功时候的调用
	 * */
	public static  <T> Resp<T> success(T data){
		return new Resp<T>(data);
	}

	private Resp(T data) {
		this.code = ServiceStatus.SUCCESS.getCode();
		this.msg = ServiceStatus.SUCCESS.getDetail();
		this.data = data;
	}
	public static  <T> Resp<T> error(T data){
		return new Resp<T>(data);
	}
	/**
	 *  失败时候的调用
	 * */
	public static<T> Resp<T> error(ServiceStatus serviceStatus){
		return new Resp<T>(serviceStatus);
	}
	public Resp(ServiceStatus serviceStatus) {
		if(serviceStatus != null) {
			this.code = serviceStatus.getCode();
			this.msg = serviceStatus.getDetail();
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}


	/**
	 *  失败时候的调用
	 * */
	public static<T> Resp<T> error(String code,String msg, String innerException){
		Resp<T> resp=new Resp<>();
		resp.setCode(code);
		resp.setMsg(msg);
		resp.setInnerExceptionMsg(innerException);
		return  resp;
	}

	public static<T> Resp<T> error(ServiceStatus serviceStatus,String msg){
		Resp<T> resp=new Resp<>();
		resp.setCode(serviceStatus.getCode());
		resp.setMsg(serviceStatus.getDetail()+msg);
		return  resp;
	}

	public static<T> Resp<T> error(ServiceStatus serviceStatus,T Data){
		Resp<T> resp=new Resp<>();
		resp.setCode(serviceStatus.getCode());
		resp.setMsg(serviceStatus.getDetail());
		resp.setData(Data);
		return  resp;
	}

}
