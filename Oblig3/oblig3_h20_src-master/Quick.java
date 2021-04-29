class Quick extends Sorter {

    void sort() {
        quickSort(0, n-1);
    }

    int partition(int low, int high){
        int p = choosePivot(low, high);
        int temp = A[high];
        A[high] = A[p];
        A[p] = temp;
        int pivot = A[high];
        int left = low;
        int right = high - 1;
       

        while (left <= right){
            while(left <= right && A[left] <= pivot){
                left++;
            }
            while(right >= left &&  A[right] >= pivot){
                right--;
            }
            if (left < right){
                temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }
        temp = A[left];
        A[left] = A[high];
        A[high] = temp;
        return left;
    }

    

    int[] quickSort(int low, int high){
        if(low >= high){
            return A;
    }
 
        int p = partition(low, high);
        quickSort(low, p - 1);
        quickSort(p + 1, high);
        return A;
    }

    //Denne metoden velger medianen av forste, midterste og siste tallet i A
    int choosePivot(int low, int high){
        int a = A[low];
        int b = A[Math.round(high/2)];
        int c = A[high];

        if(a > b && b > c){
            return Math.round(high/2);
        }
        else if(b > a && a > c){
            return low;
        }
        else{
            return high;
        }
    }

    String algorithmName() {
        return "quick";
    }
}
