package py.com.prestosoftware.facepet.ui.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.ui.events.EventsFragment;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    //@BindView(R.id.btnIrLogin) Button mbtnIrLogin;
    //@BindView(R.id.message) TextView mTextMessage;
    @BindView(R.id.navigation) BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container , showHomeView());
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
//        public void goToLoginActivity() {
//
//            if(!FacePetPreference.getSesion(this)) {
//                startActivity(new Intent(this, LoginActivity.class));
//            }else{
//                //mBtnLogin.setText("Sesion Iniciada");
//               // mbtnIrLogin.setVisibility(View.GONE);//para ocultar el boton cuando la sesion este inciada
//            }
//
//    }

//    @OnClick(R.id.btnIrPerfil)
//    public void gotoProfileActivity(){
//        startActivity(new Intent(this,ProfileActivity.class));
//    }


    // Local Methods
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectedFragment = showHomeView();
                    //mTextMessage.setText(R.string.title_home);
                    //return true;
                    break;
                case R.id.navigation_dashboard:
                    selectedFragment = showHomeView();
                    //mTextMessage.setText(R.string.title_dashboard);
                    //return true;
                    break;
                case R.id.navigation_notifications:
                    selectedFragment = showHomeView();
                    //mTextMessage.setText(R.string.title_notifications);
                    //return true;
                    break;
                case R.id.navigation_account:
                    selectedFragment = showHomeView();
                    //mTextMessage.setText(R.string.title_account);
                    //return true;
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_container , selectedFragment);
            transaction.commit();
            return true;
        }
    };

    private Fragment showHomeView(){
        return EventsFragment.newInstance();
    }

}
