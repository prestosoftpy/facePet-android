package py.com.prestosoftware.facepet.ui.main;

;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import butterknife.BindView;
import butterknife.ButterKnife;
import py.com.prestosoftware.facepet.R;
import py.com.prestosoftware.facepet.data.local.FacePetPreference;
import py.com.prestosoftware.facepet.ui.petshop.PetShopFragment;
import py.com.prestosoftware.facepet.ui.cities.CityFragment;
import py.com.prestosoftware.facepet.ui.reservations.List.ReservationListFragment;
import py.com.prestosoftware.facepet.ui.users.login.LoginActivity;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = MainActivity.class.getSimpleName();
   // @BindView(R.id.btnIrLogin) Button mbtnIrLogin; botones sacados
   // @BindView(R.id.message) TextView mTextMessage;
    @BindView(R.id.navigation) BottomNavigationView navigation;
    //@BindView(R.id.btnIrLogin) Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(FacePetPreference.getSesion(this)){
            android.support.v4.app.FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_container, showHomeView());//para que inicie con la pantalla que le das , showomeview para este
            transaction.commit();
        }else{
            startActivity(new Intent(this, LoginActivity.class));
        }



        /*android.support.v4.app.FragmentTransaction transactionCity= getSupportFragmentManager().beginTransaction();
        transactionCity.replace(R.id.main_container, showHomeViewCity());
        transactionCity.commit();*/

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

   /* @OnClick(R.id.btnIrLogin)
        public void goToLoginActivity() {

            if(!FacePetPreference.getSesion(this)) {
                startActivity(new Intent(this, LoginActivity.class));
            }else{
                //mBtnLogin.setText("Sesion Iniciada");
                mBtnLogin.setVisibility(View.GONE);//para ocultar el boton cuando la sesion este inciada
            }

    }

    @OnClick(R.id.btnIrPerfil)
    public void gotoProfileActivity(){
        startActivity(new Intent(this,ProfileActivity.class));
    }

*/
    // Local Methods
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment= null;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    //return true;
                    selectedFragment = showHomeView();
                    break;
                case R.id.navigation_dashboard:
                   // mTextMessage.setText(R.string.title_dashboard);
                    //return true;
                    selectedFragment = showHomeViewCity();
                    break;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    //return true;
                    selectedFragment = showReservationsList();
                    break;
                case R.id.navigation_account:
                    //mTextMessage.setText(R.string.title_account);
                    //return true;
                    selectedFragment = showHomeView();
                    break;
            }
            android.support.v4.app.FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.main_container, selectedFragment);
            transaction.commit();


            return true;
        }
    };

  /*  private LoginActivity showLogin(){
        return new LoginActivity();
    }*/
   private Fragment showHomeView(){
       return PetShopFragment.newInstance();
    }

   private Fragment showHomeViewCity(){
       return CityFragment.newInstance();
    }

    private Fragment showReservationsList(){
       return ReservationListFragment.newInstance();
   }


    // @Override
    // public void onListFragmentInteraction(DummyContent.DummyItem item) {
    //  Log.d(TAG, item.toString());
    }

