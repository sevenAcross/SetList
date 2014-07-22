package uk.co.carnige.nigel.setlist;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


public class Sets extends Activity {

    List<Map<String, String>> setList = new ArrayList<Map<String, String>>();

    private void initList ()
    {
        setList.add(createSetList("setList", "Rifleman"));
        setList.add(createSetList("setList", "The Fox"));
        setList.add(createSetList("setList", "The Herald"));
    }

    private HashMap<String, String> createSetList ( String key, String name )
    {
        HashMap<String, String> setList = new HashMap<String, String>();
        setList.put ( key, name );
        return setList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

        initList();

        ListView listView = (ListView) findViewById ( R.id.listView );

        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                setList,
                android.R.layout.simple_list_item_1,
                new String[] {"setList"},
                new int[] {android.R.id.text1}
        );

        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        // We know the view is a TextView
                        TextView clickedView = (TextView) view;

                        Toast.makeText(
                                Sets.this,
                                "Item with ID ["+id+"] - Position ["+position+"] - SetList ["+clickedView.getText()+"]",
                                Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.sets, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
