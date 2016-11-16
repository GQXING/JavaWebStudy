package com.gqx.randnum;

import java.util.Date;

public class MaoPao implements Runnable {
	private int[] array;

	public MaoPao(int[] array) {
		this.array = array;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long st = System.currentTimeMillis();
		System.out.println(new Date() + "¿ªÊ¼Ö´ÐÐ£¡");

		for (int i = 0; i < array.length - 1; i++) {

			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}

		}

		long ct = System.currentTimeMillis();
	
		this.array = array;
	}

	public int[] getArray() {
		return this.array;
	}

}
