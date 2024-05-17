package sort;

public class MargetSort {
    public static void main(String[] args) {
        int [] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random()*8000000);
        }
        int[] temp = new int[arr.length + 1];
        long time1 = System.currentTimeMillis();
        mergeSort(arr,0, arr.length-1,temp);
        System.out.println(System.currentTimeMillis() - time1+"ms");
    }
    //分+合并的方法
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left< right){
            int mid = (left+right)/2;
            //向左递归进行分解
            mergeSort(arr,left,mid,temp);
            //向右分递归进行分解
            mergeSort(arr,mid+1,right,temp);
            //开始合并
            merge(arr,left,mid,right,temp);
        }
    }

    /**
     *
     * @param arr 排序的原始数组
     * @param left 数组的开始索引
     * @param mid 中间位置的索引
     * @param right 左边的索引
     * @param temp 临时的数组
     */
    public static void merge(int[] arr,int left,int  mid,int right,int[] temp){
        int i = left;//先初始化下标i
        int j = mid + 1;//这是第二部分数组的下标
        int t = 0;//临时数组的下标
        //1)先把左右两边（有序的数组）的数据按照规则填充到temp数组
        //直到左右两边都为有序序列，有一边处理完为止
        while (i <= mid && j <= right){
            //说明数组还没有排序完成
            if (arr[i] >= arr[j]){
                //当右边的数大于左边的数的时候，就把左边比右边小的数加入到临时数组中
                temp[t] = arr[j];
                t+=1;
                j+=1;
            }else {
                temp[t] = arr[i];
                t++;
                i+=1;
            }
        }
        //2)将剩下没有添加完的数据按顺序添加到temp中去
        while (i<=mid){
            temp[t] = arr[i];
            i++;
            t++;

        }
        while (j <= right){
            temp[t] = arr[j];
            t++;
            j++;
        }

        //3)将所以排好序的数组一次复制回原数组
        //注意，并不是拷贝所有
        int tempLeft = left;//临时的变量
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            tempLeft+=1;
            t+=1;
        }
    }
}