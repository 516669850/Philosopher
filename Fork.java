package philosopher;

public class Fork {
    private boolean[] used = {false,false,false,false,false};

    public synchronized void takeFork(){
        String name = Thread.currentThread().getName();
        int i = Integer.parseInt(name.split("-")[1]);
        while(used[i] || used[(i + 1) % 5]){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        used[i] = true;
        used[(i + 1) % 5] = true;
    }

    public synchronized void putFork(){
        String name = Thread.currentThread().getName();
        int i = Integer.parseInt(name.split("-")[1]);
        used[i] = false;
        used[(i + 1) % 5] = false;
        notifyAll();
    }
}
