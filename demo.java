class A extends Thread {
    public void run() {
        for(int i=1;i<=25;i++){
            System.out.println("Hello");
        }
    }
}
class B extends Thread{
    public void run(){
        for(int i=1;i<=25;i++){
            System.out.println("Hello java");
        }
    }
}
public  class demo{
    public static void main(String[]args){
        A a= new A();
        B b=new B();
        a.start();
        b.start();
    }
}