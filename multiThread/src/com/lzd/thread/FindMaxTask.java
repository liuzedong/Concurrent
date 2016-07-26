package com.lzd.thread;

import java.util.concurrent.Callable;

/**
 * 找寻数组中的最大值
 * @date 2016年7月26日
 * @author lzd
 *
 */
public class FindMaxTask implements Callable<Integer>{

	private int[] data;
	private int start;
	private int end;
	
	public FindMaxTask(int[] data, int start, int end) {
		super();
		this.data = data;
		this.start = start;
		this.end = end;
	}



	@Override
	public Integer call() {
		// 获取int的最小值
		int max = Integer.MIN_VALUE;
		for (int i = start; i < end; i++) {
			if (data[i] > max) max = data[i];
		}
		return max;
	}

}
