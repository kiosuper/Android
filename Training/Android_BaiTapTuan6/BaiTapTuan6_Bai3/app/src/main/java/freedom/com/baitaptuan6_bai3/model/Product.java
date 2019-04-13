package freedom.com.baitaptuan6_bai3.model;

public class Product extends Goods {
    private Catalog mCatalog;

    public Product() {
        super();
    }

    public Product(String mId, String mName, Catalog mCatalog) {
        super(mId, mName);
        this.mCatalog = mCatalog;
    }

    public Catalog getmCatalog() {
        return mCatalog;
    }

    public void setmCatalog(Catalog mCatalog) {
        this.mCatalog = mCatalog;
    }
}
