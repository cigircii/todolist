package models;

/**
 *
 * @author workplz
 */
public class Task {
    
    private String voor;
    private String wat;
    private String waneer;
    
    public Task(){
        
    }

    public Task(String voor, String wat, String waneer) {
        this.voor = voor;
        this.wat = wat;
        this.waneer = waneer;
    }

    public String getVoor() {
        return voor;
    }

    public void setVoor(String voor) {
        this.voor = voor;
    }

    public String getWat() {
        return wat;
    }

    public void setWat(String wat) {
        this.wat = wat;
    }

    public String getWaneer() {
        return waneer;
    }

    public void setWaneer(String waneer) {
        this.waneer = waneer;
    }

    @Override
    public String toString() {
        return "task{" + "voor=" + voor + ", wat=" + wat + ", waneer=" + waneer + '}';
    }
}
