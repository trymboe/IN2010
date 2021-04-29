import java.io.*;

class BalanceArray{
    static Node midten;

    //lager noder
    class Node{
        Node venstre, hoyre;
        int innhold;

        Node(int x){
            innhold = x;
            Node venstre, hoyre = null;
        }
    }


    Node sorter(int[] liste, int start, int slutt){
        //stopper rekrusjonen
        if(start>slutt){
            return null;
        }

        //Finner midtverdien og setter den som rotnode.
        int mid = (start + slutt)/2;
        Node node = new Node(liste[mid]);

        //kjører rekrusivt for å finne alle løvnodene.
        node.hoyre = sorter(liste, mid+1, slutt);
        node.venstre = sorter(liste, start, mid-1);

        return node;
    }

    void skrivUt(Node node){
        if(node == null){
            return;
        }
        //skriver rekrusivt ut alle nodene
        System.out.println(node.innhold);

        skrivUt(node.venstre);
        skrivUt(node.hoyre);
    }


    public static void main(String args[]){

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] list = in.lines().mapToInt(i -> Integer.parseInt(i)).toArray();

        BalanceArray t = new BalanceArray();
        int lengde = list.length;

        midten = t.sorter(list, 0, lengde-1);
        t.skrivUt(midten);


    }
}
