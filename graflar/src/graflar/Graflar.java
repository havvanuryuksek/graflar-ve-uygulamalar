
package graflar;

public class Graflar {

   public class yigit{
       private int maxSIZE;
       private int[]st;
       private int top;
       
    public yigit(int size){ //kurucu
       maxSIZE=size;    
        st= new int [maxSIZE]; // dizi olusturduk
       top=-1;
   }    
      public void push (int j){ //ekleme
       st[++top]=j;
   }
   public int pop()//çıkarma
   {
       return st[top--];
   }   
   public int peek()//yigitin tepesi
   {
       return st[top];
       
   }
   public boolean isEmpty(){ //bosmu
    return (top==-1);   
   }
   }
   
   class vertex{
       public char label;
       public boolean wasVisited;
       
       public vertex(char lab){
           label=lab;
           wasVisited = false;
       }
   }
 class graph{
     private final int maxDugum =20;
     private vertex dugumListesi[];
     private int komsuluk [][];
     private int dugumSayisi;
      yigit theStack;
     
     public graph(){
     dugumListesi= new vertex[maxDugum];
     komsuluk = new int [maxDugum][maxDugum];
     dugumSayisi=0;
     for(int j=0; j<maxDugum; j++){
      for(int k=0; k<maxDugum; k++){
              komsuluk[j][k]=0;}}
              theStack = yigit();
 }
     
     public void addVertex(char lab)//etiketlab yerine)
     {
        dugumListesi[dugumSayisi++]= new vertex(lab);// etiket lab yerine);
     }
public void addEdge(int start,int end){
    komsuluk[start][end]=1;
    komsuluk[end][start]=1;
}
public void displayVertex(int v){
    System.out.print(dugumListesi[v].label);
    
}
public void dfs(){
    dugumListesi[0].wasVisited = true;
    displayVertex(0);
    theStack.push(0);
    
      while(!theStack.isEmpty()){
   int v = gidilmeyenKomsuBul(theStack.peek()); // gidilmeyen komsudaan bir düğüm gelecek 
      if(v==-1)// gidilmeyen komsu yok
      theStack.pop();
  else{
      dugumListesi[v].wasVisited = true;
      displayVertex(v);
      theStack.push(v);
 }
}
      for(int j=0; j<dugumSayisi; j++)
          dugumListesi[j].wasVisited = false;
}
   public int gidilmeyenKomsuBul(int v){
       for(int j = 0; j<dugumSayisi; j++)
           if(komsuluk[v][j]==1 && dugumListesi[j].wasVisited==false)
               return j;
       return-1;
   }

        private yigit yigit() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
 }
 class DFSApp{
     public static void main(String[] args) {
    
    graph G = new graph();
    G.addVertex('A');//0
    G.addVertex('B');//1
    G.addVertex('C');//2
    G.addVertex('D');//3
    G.addVertex('E');//4

    G.addEdge(0,1); 
    G.addEdge(1,2); 
    G.addEdge(0,3); //AD
    G.addEdge(3,4); //DE
G.dfs(); //depth-first search
 }
     }
       }
   

 


   
  