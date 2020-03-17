package f_mendez07.blogspot.com.ciclodevida;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import f_mendez07.blogspot.com.ciclodevida.adapter.ContactoAdapter;
import f_mendez07.blogspot.com.ciclodevida.adapter.PageAdapter;
import f_mendez07.blogspot.com.ciclodevida.fragment.PerfilFragment;
import f_mendez07.blogspot.com.ciclodevida.fragment.ReciclerViewFragmen;
import f_mendez07.blogspot.com.ciclodevida.pojo.Contacto;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);


        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }

        setuUpViewPager();









    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment>fragments = new ArrayList<>();
        fragments.add(new ReciclerViewFragmen());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    public void setuUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),1,agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_virtual);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_prog);

    }

    //menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_setting:
                Intent intent1 = new Intent(this,Configuracion.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent1);
                break;
            case R.id.actionbar_about:
                Intent intent2 = new Intent(this,Acerca.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent2);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
