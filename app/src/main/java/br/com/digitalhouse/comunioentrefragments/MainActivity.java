package br.com.digitalhouse.comunioentrefragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import br.com.digitalhouse.comunioentrefragments.fragments.FirstFragment;
import br.com.digitalhouse.comunioentrefragments.fragments.SecondFragment;
import br.com.digitalhouse.comunioentrefragments.interfaces.Comunicador;
import br.com.digitalhouse.comunioentrefragments.model.Person;

public class MainActivity extends AppCompatActivity implements Comunicador {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        replaceFragment(R.id.container2, new FirstFragment());

    }

    public void replaceFragment(int container,Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(container, fragment)
                .commit();

    }

    @Override
    public void receberMensagem(Person person) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("PERSON",person);
        Fragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        replaceFragment(R.id.container1, secondFragment);
    }
}