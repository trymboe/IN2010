class binersok{
    public static void main(String args[]){
         int[] intArray = new int[]{6, 9, 13, 18, 29, 35, 36, 41, 44, 49, 50, 52, 56, 57, 65, 76, 80, 85, 96, 99};

        int min = 0;
        int max = intArray.length-1;
        int finn = 7;
        while (min <= max){
            double data = Math.floor((max+min)/2);
            int sjekk = (int)data;
            System.out.println(sjekk);
            if (intArray[sjekk] == finn){
                System.out.println("true");
                break;
            }
            if(intArray[sjekk]>finn){
                max = sjekk++;
            }
            if(intArray[sjekk]<finn){
                min = sjekk--;
            }
        }
    }
}
