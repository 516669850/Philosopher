package philosopher;

public class Philosopher extends Thread {
    private String name;
    private Fork fork;
    public Philosopher(String name,Fork fork){
        this.name = name;
        this.fork = fork;
    }

    public void run(){
        while(true){
            thinking();
            fork.takeFork();
            eating();
            fork.putFork();
        }
    }

    public void thinking(){
        System.out.println(name + ": I am thinking");
        try{
            sleep(1000);//模拟思考
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void eating(){
        System.out.println(name + ": I am eating");
        try{
            sleep(1000);//模拟吃饭
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
