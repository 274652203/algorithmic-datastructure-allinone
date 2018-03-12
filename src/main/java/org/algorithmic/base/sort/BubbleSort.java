package org.algorithmic.base.sort;
/**
 * 冒泡排序
 * 
 * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，
 * 自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
 * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 * 
 * @author herry
 */
public class BubbleSort {
	public void sort(int[] a) {
		if(a==null||a.length<2){
			return;
		}
		print("冒泡排序前：", a);
		boolean flag=true;//当一趟比较后，如果没有元素的替换。就可以结束了。
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				// 这里-i主要是每遍历一次都把最大的个数沉到最底下去了，没有必要再进行比较了
				if (a[j] > a[j + 1]) {
					flag=false;//修改标记位
					swap(a, j, j + 1);//交换两个元素
				}
			}
			if(flag){
				break;
			}
		}
		print("冒泡排序后：", a);
	}
	
	/**
	 * 交换一个数组中元素i和j的位置。
	 * @param data
	 * @param i
	 * @param j
	 */
	private void swap(int[] data, int i, int j) {
		// 方式1：不需要余外的空间
		if (i != j) {// i=j，会变成0
			data[j] = data[i] + data[j];
			data[i] = data[j] - data[i];
			data[j] = data[j] - data[i];
		}
		//方式2： 需要一个余外的空间
		// int tmp = data[i];
		// data[i] = data[j];
		// data[j] = tmp;
	}
	
	
	private void print(String message, int[] a) {
		System.out.println(message);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
//		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1 };
//		int[] a = null;
		int[] a = { 1, 12, 13, 27, 34, 38, 49, 49, 64, 65, 76, 78, 97  };
		BubbleSort sort = new BubbleSort();
		sort.sort(a);

	}
}
