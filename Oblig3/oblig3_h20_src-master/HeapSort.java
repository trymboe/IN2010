class HeapSort extends Sorter {

    void sort() {
        buildMaxHeap(A, n);
        for(int i = n-1; i > 0; i--){
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;
            bubbleDown(A, 0, i);
        }
    }

    void buildMaxHeap(int[] A, int n){
        for(int i = n/2; i > 0; i--){
            bubbleDown(A, i , n);
        } 
    }

    void bubbleDown(int[] A, int i, int n){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left < n && A[largest] < A[left]){
            int temp = largest;
            largest = left;
            left = temp;
        }

        if(right < n && A[largest] < A[right]){
            int temp = largest;
            largest = right;
            right = temp;
        }

        if(i != largest){
            int temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            bubbleDown(A, largest, n);
        }
    }

    String algorithmName() {
        return "HeapSort";
    }
}
