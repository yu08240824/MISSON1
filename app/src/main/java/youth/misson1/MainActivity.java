package youth.misson1;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import jp.co.yahoo.android.maps.GeoPoint;
import jp.co.yahoo.android.maps.MapController;
import jp.co.yahoo.android.maps.MapView;

//option+enter call what we need
public class MainActivity extends Activity {
    private MapView mMapView=null;//MapViewメンバー

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //MapViewのnew object make
        mMapView=new MapView(this,"dj0zaiZpPW81TlhPcmdFbm9rcyZzPWNvbnN1bWVyc2VjcmV0Jng9MWQ-");//アプリケーション名を入れた->KIMのAPPNUMBERです一旦これで今回のハッカソンでは開発しましょう
        MapController c = mMapView.getMapController();
        c.setCenter(new GeoPoint(35665721, 139731006)); //初期表示の地図を指定
        c.setZoom(1); 			       	      //初期表示の縮尺を指定
        setContentView(mMapView);

        //setContentView(R.layout.activity_main);
        //いらないToolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //削除setSupportActionBar(toolbar);

        /*いらないので
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //ついかしたOverrideは元のやつを変えるとき使う。そしてsuperは読んだ元のやつを行っていて今見ると元の機能をしていて追加機能もある
    @Override
    protected void  onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }
    //知らないもの、エラーなどはslackで一緒に悩みましょう〜
}
