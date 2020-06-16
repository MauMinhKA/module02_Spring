package champ;

public class Champ {
    private int ID;
    private String name;
    private String lane;
    private String role;
    private String images;

    public Champ() {
    }

    public Champ(int ID, String name, String lane, String role, String images) {
        this.ID = ID;
        this.name = name;
        this.lane = lane;
        this.role = role;
        this.images = images;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
