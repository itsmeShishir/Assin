package Week7;

class Multithreading implements Runnable
{
    int num;

    Multithreading(int num){
        this.num = num;
    }

    synchronized public void printTable()  {
        int n = this.num;
        for (int i = 1; i<=10; i++){
            System.out.println(i +"X"+n+": "+ i*n+ Thread.currentThread().getName());
            try{
                Thread.sleep(500);
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void run() {
        printTable();
    }
    public static void main(String[] args) throws Exception {
        int n = 10;

        for(int i = 1; i<=n; i++) {

            Thread t = new Thread(new Multithreading(i));
            t.start();
            t.join();
        }
    }

}


