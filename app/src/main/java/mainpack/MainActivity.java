package mainpack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.myapplication.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static int newButts = 0;
    private static ArrayList<Item> items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn;
        items = new ArrayList<>();
        items = new ArrayList<>();




       // System.out.println(Arrays.toString(folder.listFiles()));

        addItems(new File ("/data/data/com.example.myapplication/cache/assets"));
        System.out.println(items.size());

        Collections.sort(items);

        for(int x = 0; x < items.size(); x++){
            createButton(items.get(x));

        }






    }

    protected  void createButton(){
        newButts++;
        LinearLayout layout = (LinearLayout)findViewById(R.id.bombLayout);
        Button btn2 = new Button(this);
        btn2.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT));
        btn2.setText("New Button" + newButts);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createButton();
            }
        });
        layout.addView(btn2);
    }

    protected  void createButton(Item item){


        final String name = item.getName();
        final String baseDesc = item.getBasicDescription();
        final String tags = item.getTags();
        final String usage = item.getUsage();
        final String activation = item.getActivate();
        final String bulk = item.getBulk();
        LinearLayout layout = findViewById(R.id.bombLayout);

        if(tags.contains("Bomb")){
            layout = (LinearLayout) findViewById(R.id.bombLayout);
        }else if(tags.contains("Elixir")){
            layout = findViewById(R.id.elixerLayout);
        }else if(tags.contains("Poison")){
            layout = findViewById(R.id.poisonLayout);
        }else{
            layout =findViewById(R.id.toolLayout);
        }

        Button btn2 = new Button(this);
        btn2.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, AbsListView.LayoutParams.MATCH_PARENT));
        btn2.setText(item.getName());
        layout.addView(btn2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ItemInfoScreen.class);

                intent.putExtra("name",name);
                intent.putExtra("baseDesc", baseDesc);
                intent.putExtra("tags",tags);
                intent.putExtra("usage",usage);
                intent.putExtra("activation",activation);
                intent.putExtra("bulk",bulk);

                startActivity(intent);
            }
        });


    }

    private static void addItems(File folder) {

        File[] files = folder.listFiles();
        System.out.println(folder);
        if(files != null) {
            for (File fileEntry : files) {
                if (fileEntry.isDirectory()) {
                    addItems(fileEntry);
                } else {
                    Item b = new Item(fileEntry);
                    items.add(b);
                }
            }
        }else {
            System.out.println("NULL");
        }

    }




}
