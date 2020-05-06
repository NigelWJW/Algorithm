package SeqVector;

public class VectorTest {

    public static void main(String[] args){
        Vector v = new Vector();
        for (int i=0;i<10;i++){
            v.insert(i,i);
            v.size++;
        }
//        System.out.println("size: "+v.size);
        v.print();
//
//        v.insert(10,5);
//        v.print(v.elem);
//
//        System.out.println(v.find(3,0,19));
        v.remove(1,4);
        v.print();





    }
}
