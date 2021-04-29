import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Teque {
    public Node start, slutt;
    public int antall = 0;

    //lager noder
    class Node{
        public Node neste, forrige;
        public int innhold;

        public Node(int innhold){
          this.innhold = innhold;
        }
    }

    public Teque(){
        //lager start og slutt-noder som brukses som referanser
        start = new Node(0);
        slutt = new Node(0);
        slutt.forrige = start;
        start.neste = slutt;
      }

    //her byttes det på pekere slik at de nye nodene blir lagt inn først og sist
    public void push_back(int x){
        Node n = new Node(x);
        slutt.forrige.neste = n;
        n.forrige = slutt.forrige;
        n.neste = slutt;
        slutt.forrige = n;
        antall++;
    }

    public void push_front(int x){
        Node n = new Node(x);
        n.neste = start.neste;
        n.forrige = start;
        start.neste.forrige = n;
        start.neste = n;
        antall++;
    }

    //Denne metoden ittererer gjennom halve listen og legger inn den nye noden der.
    public void push_middle(int x){
        Node tellenode = start;
        Node n = new Node(x);
        int index = 0;
        if(antall%2==0){
            index = antall/2;
        }
        else{
            index=(antall+1)/2;
        }
        for(int i = 0; i < index; i++){
            tellenode = tellenode.neste;
        }
        n.neste = tellenode.neste;
        n.forrige = tellenode;
        n.forrige.neste = n;
        n.neste.forrige = n;
        antall++;
    }


    //her ittereres det gjennom lenkelisten i ganger, enten fra start eller slutt
    //alt etter hvilken node vi skal finne.
    public void get(int i){
        Node tellenode = start;
        int teller = -1;
        if(i<=Math.floor(antall/2)){
            tellenode = start;
            while(teller != i){
                tellenode = tellenode.neste;
                teller++;
            }
        }
        else{
            tellenode = slutt;
            teller = antall;
            while(teller != i){
                tellenode = tellenode.forrige;
                teller--;
            }
        }
        System.out.println(tellenode.innhold);
    }


    public static void main(String args[]){
        try {
            Teque t = new Teque();

            File minFil = new File(args[0]);
            Scanner leser = new Scanner(minFil);


            while(leser.hasNextLine()){
                String[] a = leser.nextLine().trim().split(" ");
                if(a[0].contains("push_back")){
                    t.push_back(Integer.parseInt(a[1]));
                }
                if(a[0].contains("push_front")){
                    t.push_front(Integer.parseInt(a[1]));
                }
                if(a[0].contains("push_middle")){
                    t.push_middle(Integer.parseInt(a[1]));
                }
                if(a[0].contains("get")){
                    t.get(Integer.parseInt(a[1]));
                }
                if(a[0].contains("print_alt")){
                    t.print_alt();
                }
            }
        }
        catch (FileNotFoundException e){
        System.out.println("Fant ikke fil. Prøv igjen");
        System.exit(0);
      }
  }
}
