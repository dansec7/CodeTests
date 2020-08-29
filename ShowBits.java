class ShowBits{
    int numbits;
    ShowBits(int n){
        numbits = n;
    }
    public void show(long val){
        long mask=1;
        mask<<=numbits-1;
        int spacer=0;
        while(mask!=0){
            if((val & mask)!=0)
                System.out.print("1");
            else{
                System.out.print("0");
                spacer++;
            }
            if((spacer % 8)==0){
                System.out.print(" ");
                spacer=0;
            }
            mask>>>=1;
        }
        System.out.println();
    }
}
class ShowBitsDemo{
    public static void main(String[] abc){
        ShowBits bits1 = new ShowBits(8);
        ShowBits bits2 = new ShowBits(32);
        ShowBits bits3 = new ShowBits(64);
        System.out.println("123 in binary");
        bits1.show(123);
        System.out.println("\n 87987 in binary");
        bits2.show(87987);
        System.out.println("\n 237658768 in binary");
        bits3.show(237658768);
    }
}