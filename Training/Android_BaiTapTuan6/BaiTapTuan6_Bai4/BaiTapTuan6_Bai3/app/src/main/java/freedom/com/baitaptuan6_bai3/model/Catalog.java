package freedom.com.baitaptuan6_bai3.model;

import java.util.ArrayList;

public class Catalog extends Goods {
    private ArrayList<Product> listProduct = null;

    public Catalog() {
        super();
        this.listProduct = new ArrayList<Product>();
    }

    public Catalog(String mId, String mName) {
        super(mId, mName);
        this.listProduct = new ArrayList<Product>();
    }


    public boolean isduplicate(Product product) {
        for (Product p1 : listProduct) {
            if (p1.getmId().trim().equalsIgnoreCase(product.getmId().trim()))
                return true;
        }
        return false;
    }


    public boolean addProduct(Product product) {
        boolean isDuplicate = isduplicate(product);
        if (!isDuplicate) {
            product.setmCatalog(this);
            return listProduct.add(product);
        }
        return !isDuplicate;
    }

    public ArrayList<Product> getListProduct() {
        return this.listProduct;
    }

    public int size() {
        return listProduct.size();
    }

    public Product get(int i) {
        return listProduct.get(i);
    }
}
