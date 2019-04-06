package freedom.com.baitaplistview;

public class Legend {
    public int img;
    public String name;
    public String born;
    public int nation;

    public Legend() {
    }

    public Legend(int img, String name, String born, int nation) {
        this.img = img;
        this.name = name;
        this.born = born;
        this.nation = nation;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public int getNation() {
        return nation;
    }

    public void setNation(int nation) {
        this.nation = nation;
    }
}
