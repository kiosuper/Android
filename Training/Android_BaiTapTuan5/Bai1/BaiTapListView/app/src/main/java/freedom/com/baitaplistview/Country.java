package freedom.com.baitaplistview;

public class Country {
    public int icon;
    public String name;
    public int populations;

    public Country() {
    }

    public Country(int icon, String name, int populations) {
        this.icon = icon;
        this.name = name;
        this.populations = populations;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulations() {
        return populations;
    }

    public void setPopulations(int populations) {
        this.populations = populations;
    }
}
