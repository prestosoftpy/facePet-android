package py.com.prestosoftware.facepet.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.local.FacePetPreference;
import py.com.prestosoftware.facepet.ui.petshop.PetShopFragment;
import py.com.prestosoftware.facepet.ui.petshop.dummy.DummyContent;
import py.com.prestosoftware.facepet.ui.users.login.LoginActivity;
import py.com.prestosoftware.facepet.ui.users.profile.ProfileActivity;

public class MainActivity extends AppCompatActivity implements PetShopFragment.OnListFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();

//    @BindView(R.id.btnIrLogin) Button mbtnIrLogin;
//    @BindView(R.id.message) TextView mTextMessage;

    @BindView(R.id.navigation) BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container, showHomeView());
        transaction.commit();


        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

//    @OnClick(R.id.btnIrLogin)
    public void goToLoginActivity() {
        if (!FacePetPreference.getSesion(this)) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            //mBtnLogin.setText("Iniciado Sesión");
//            mbtnIrLogin.setVisibility(View.GONE);
        }
    }

//    @OnClick(R.id.btnIrPerfil)
    public void gotoProfileActivity(){
        startActivity(new Intent(this,ProfileActivity.class));
    }


    // Local Methods
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = showHomeView();
                    break;

                case R.id.navigation_dashboard:
                    selectedFragment = showHomeView();
                    break;

                case R.id.navigation_notifications:
                    selectedFragment = showHomeView();
                    break;

                case R.id.navigation_account:
                    selectedFragment = showHomeView();
                    break;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_container, selectedFragment);
            transaction.commit();

            return true;
        }
    };

    private Fragment showHomeView() {
        return PetShopFragment.newInstance(1);
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.d(TAG, item.toString());
    }
}
