package com.gqx.randnum;

import java.util.Random;

public class RandNum {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		int[] array1 = getRandom();
		int[] array2 = getRandom();
		int[] array3 = getRandom();
		int[] array4 = getRandom();
		int[] array5 = getRandom();
		long t1 = System.currentTimeMillis();
		MaoPao maoPao1 = new MaoPao(array1);
		MaoPao maoPao2 = new MaoPao(array2);
		MaoPao maoPao3 = new MaoPao(array3);
		MaoPao maoPao4 = new MaoPao(array4);
		MaoPao maoPao5 = new MaoPao(array5);
		Thread thread1 = new Thread(maoPao1);
		Thread thread2 = new Thread(maoPao2);
		Thread thread3 = new Thread(maoPao3);
		Thread thread4 = new Thread(maoPao4);
		Thread thread5 = new Thread(maoPao5);

		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		thread5.join();
		int[] a1 = maoPao1.getArray();
		int[] a2 = maoPao2.getArray();
		int[] a3 = maoPao3.getArray();
		int[] a4 = maoPao4.getArray();
		int[] a5 = maoPao5.getArray();
		int[] aa1 = sort(a1, a2);
		int[] aa2 = sort(a3, a4);
		int[] aa3 = sort(aa1, aa2);
		int[] aa = sort(a5, aa3);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		show(aa);

	}

	public static int[] getRandom() {

		int[] nums = new int[2000];
		for (int i = 0; i < nums.length; i++) {
			Random random = new Random();
			nums[i] = random.nextInt(100000);
		}
		return nums;
	}

	// ¹é²¢ÅÅÐò
	public static int[] sort(int[] a, int[] b) {
		int len = a.length + b.length;
		int[] c = new int[len];
		int m = 0, n = 0, k = 0;
		while (m < a.length && n < b.length) {
			if (a[m] < b[n]) {
				c[k++] = a[m++];
			} else {
				c[k++] = b[n++];
			}
		}
		while (m < a.length) {
			c[k++] = a[m++];
		}
		while (n < b.length) {
			c[k++] = b[n++];
		}
		return c;
	}

	public static void show(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (i % 100 == 0) {
				System.out.println();
				if (i%1000==0) {
					System.out.println();
				}
			}
			System.out.print(a[i] + "  ");
		}
	}

}
