package freedom.com.baitaptuan6_bai3.model;

public class Goods {
    private String mId;
    private String mName;

    public Goods() {
    }

    public Goods(String mId, String mName) {
        this.mId = mId;
        this.mName = mName;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String toString() {
        return this.mId + " - " + this.mName;
    }
}
