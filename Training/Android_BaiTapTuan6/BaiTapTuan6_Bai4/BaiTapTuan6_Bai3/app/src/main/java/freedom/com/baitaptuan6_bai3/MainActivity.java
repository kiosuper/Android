package freedom.com.baitaptuan6_bai3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import freedom.com.baitaptuan6_bai3.model.Catalog;
import freedom.com.baitaptuan6_bai3.model.Product;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerCategory;
    EditText editId, editName;
    Button btnSubmit;
    ListView listProduct;

    ArrayList<Catalog> arraySpinner = new ArrayList<Catalog>();
    ArrayAdapter<Catalog> adapterSpinner = null;

    ArrayList<Product> arrayListview = new ArrayList<Product>();
    ArrayAdapter<Product> adapterListview = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        createDataCatalog();
        setEvent();
    }


    private void setControl() {
        spinnerCategory = findViewById(R.id.spCategory);
        editId = findViewById(R.id.editId);
        editName = findViewById(R.id.editName);
        btnSubmit = findViewById(R.id.btnSubmit);
        listProduct = findViewById(R.id.listProduct);
        adapterSpinner = new ArrayAdapter<Catalog>(this, android.R.layout.simple_spinner_item, arraySpinner);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterSpinner);
        adapterListview = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, arrayListview);
        listProduct.setAdapter(adapterListview);
    }


    private void createDataCatalog() {
        Catalog catalog1 = new Catalog("1", "Samsung");
        Catalog catalog2 = new Catalog("2", "Iphone");
        Catalog catalog3 = new Catalog("3", "IPad");
        arraySpinner.add(catalog1);
        arraySpinner.add(catalog2);
        arraySpinner.add(catalog3);
        adapterSpinner.notifyDataSetChanged();
    }


    private void setEvent() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                addProductForCatalog();
            }
        });
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

                loadListProductByCatalog(arraySpinner.get(arg2));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });
    }


    private void addProductForCatalog() {
        Product product = new Product();
        product.setmId(editId.getText().toString());
        product.setmName(editName.getText().toString());
        Catalog catalog = (Catalog) spinnerCategory.getSelectedItem();
        catalog.addProduct(product);
        //Mỗi lần thêm xong thì cập nhập lại ListView
        loadListProductByCatalog(catalog);
    }


    private void loadListProductByCatalog(Catalog catalog) {

        arrayListview.clear();
        arrayListview.addAll(catalog.getListProduct());
        adapterListview.notifyDataSetChanged();
    }
}
