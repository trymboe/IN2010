class SelectionSort extends Sorter {

    void sort() {
        for(int i = 0; i < (n-1); i++){
            int k = i;
            for(int j = i+1; j < (n-1); j++){
                if(A[j] < A[k]){
                    k = j;
                }
            }
            if(i != k){
                int temp = A[i];
                A[i] = A[k];
                A[k] = temp;
            }
        }
    }

    String algorithmName() {
        return "SelectionSort";
    }
}
