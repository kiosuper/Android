package freedom.com.baitaptuan6_bai5.model;

import java.io.Serializable;

public class MyContact implements Serializable {
    private String mName;
    private String mPhone;

    public MyContact() {
    }

    public MyContact(String mName, String mPhone) {
        this.mName = mName;
        this.mPhone = mPhone;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmPhone() {
        return mPhone;
    }

    public void setmPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    @Override
    public String toString() {
        return this.mName + " [" + this.mPhone + "]";
    }
}
