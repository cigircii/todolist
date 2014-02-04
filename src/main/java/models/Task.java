package models;

/**
 *
 * @author workplz
 */
public class Task {

    private int id;
    private String voor;
    private String wat;
    private String waneer;

    public Task() {

    }

    public Task(String voor, String wat, String waneer, int id) {
        this.voor = voor;
        this.wat = wat;
        this.waneer = waneer;
        this.id = id;
    }
    
        public Task(String voor, String wat, String waneer) {
        this.voor = voor;
        this.wat = wat;
        this.waneer = waneer;
    }

    public String getVoor() {
        return voor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Task{ " + "voor=" + voor + ", wat=" + wat + ", waneer=" + waneer + " }";
    }
}
