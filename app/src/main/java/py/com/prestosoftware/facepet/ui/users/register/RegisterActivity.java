package py.com.prestosoftware.facepet.ui.users.register;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import py.com.prestosoftware.facepet.R;

public class RegisterActivity extends AppCompatActivity {

    private static String APP_DIRECTORY = "FacePet";
    private static String MEDIA_DIRECTORY = APP_DIRECTORY+"Fotos";

    private final int MY_PERMISSIONS = 100;
    private final int PHOTO_CODE = 200;
    private final int SELECT_PICTURE = 300;

    private ImageView mSetImage;
    private FloatingActionButton mOptionButton;
    private RelativeLayout mRlView;

    private String mPath;

    private static final String TAG = RegisterActivity.class.getSimpleName();

    @BindView(R.id.edtEmail) EditText mEdtEmail;
    @BindView(R.id.edtNombre) EditText mEdtNombre;
    @BindView(R.id.edtPassword) EditText mEdtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mSetImage = (ImageView) findViewById(R.id.imgFoto);
        mOptionButton = (FloatingActionButton) findViewById(R.id.fbtnInsImagen);
        mRlView = (RelativeLayout) findViewById(R.id.rlView);

        if(mayRequestStoragePermission())
            mOptionButton.setEnabled(true);
        else
            mOptionButton.setEnabled(false);

        mOptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptions();
            }
        });

        ButterKnife.bind(this);
    }

    private boolean mayRequestStoragePermission() {
        return false;
    }
    private void showOptions(){

    }

    @OnClick(R.id.btnRegistrar)
    public void registerUser(){
        String email = mEdtEmail.getText().toString();
        String nombre = mEdtNombre.getText().toString();
        String password = mEdtPassword.getText().toString();

        if(!email.isEmpty() && !nombre.isEmpty() && !password.isEmpty()){
            Log.d(TAG, email);
            Log.d(TAG, nombre);
            Log.d(TAG, password);
        }
    }
}
