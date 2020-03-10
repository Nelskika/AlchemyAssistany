package mainpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class ItemInfoScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        Intent payload = getIntent();

        TextView name = (TextView) findViewById(R.id.itemName);

        TextView baseDesc = (TextView)findViewById(R.id.basicDesc);

        TextView activation = (TextView)findViewById(R.id.activation);
        TextView usage = (TextView)findViewById(R.id.usage);
        TextView bulk = (TextView)findViewById(R.id.bulk);
        TextView tags = (TextView)findViewById(R.id.tags);


        if(payload.hasExtra("name")){

            name.setText(payload.getStringExtra("name"));
            baseDesc.setText(payload.getStringExtra("baseDesc"));
            activation.setText(payload.getStringExtra("activation"));
            usage.setText(payload.getStringExtra("usage"));
            bulk.setText(payload.getStringExtra("bulk"));
            tags.setText(payload.getStringExtra("tags"));
        }


    }
}
