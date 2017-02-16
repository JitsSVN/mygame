package luck.android.game.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import luck.android.game.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mPassword;
    private AutoCompleteTextView mEmail;
    private Button mLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //initiate views
        initiateViews();
    }

    private void initiateViews () {
        mPassword = (EditText) findViewById(R.id.password);
        mEmail = (AutoCompleteTextView) findViewById(R.id.email);
        mLogin = (Button) findViewById(R.id.email_sign_in_button);

        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String email,pass;
        email = mEmail.getText().toString();
        pass = mPassword.getText().toString();

       if (email.isEmpty()) {
            mEmail.setError(getString(R.string.cant_left_empty));
        }
        else if (pass.isEmpty()) {
            mPassword.setError(getString(R.string.cant_left_empty));
        }

    }
}
