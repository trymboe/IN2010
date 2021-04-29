class Insertion extends Sorter {

    void sort() {
        for(int i = 1; i < n; i++){
            int j = i;
            while(j > 0 && A[j-1] > A[j]){
                int temp = A[j-1];
                A[j-1] = A[j];
                A[j] = temp;
                j -= 1;
            }
        }
    }

    String algorithmName() {
        return "insertion";
    }
}
