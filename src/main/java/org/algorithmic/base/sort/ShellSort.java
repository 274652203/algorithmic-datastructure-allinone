package org.algorithmic.base.sort;
/**
 * 希尔排序
 * 
 * 算法思想：
 * 
 * 希尔排序是插入排序的改进版，也是第一个突破O(N*N)的排序算法。
 * 先取一个小于数组长度的整数d作为第一个增量，把文件的全部记录分成d多个组。
 * 所有距离为d的倍数的记录放在同一个组中。
 * 先在各组内进行直接插入排序；
 * 然后，取第二个增量d/2
 * 重复上述的分组和排序，直至所取的增量为“1”即所有记录放在同一组中进行直接插入排序为止。
 * 该方法实质上是一种分组插入排序。通过多次分组避免了插入排序时，要移动很多数据。
 * 
 * @author herry
 * 
 *
 */
public class ShellSort {
	
	public void sort(int[] a) {
		if(a==null||a.length<2){
			return;
		}
		print("希尔排序前：", a);
		int d = a.length;
		while (d > 1) {
			d = d / 2;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i = i + d) {
					int temp = a[i];
					int j;
					for (j = i - d; j >= 0 && a[j] > temp; j = j - d) {
						a[j + d] = a[j];
					}
					a[j + d] = temp;
				}
			}
		}
		print("希尔排序后：", a);
	}

	private void print(String message, int[] a) {
		System.out.println(message);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
//		int[] a = null;
//		int[] a = { 1, 12, 13, 27, 34, 38, 49, 49, 64, 65, 76, 78, 97  };
		ShellSort sort = new ShellSort();
		sort.sort(a);

	}
}
