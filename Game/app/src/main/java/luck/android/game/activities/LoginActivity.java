package luck.android.game.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import luck.android.game.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mPassword;
    private AutoCompleteTextView mEmail;
    private Button mLogin;
    private TextView skip, registration;
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
        skip = (TextView) findViewById(R.id.skip);
        registration = (TextView) findViewById(R.id.register);

        mLogin.setOnClickListener(this);
        skip.setOnClickListener(this);
        registration.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        if (view == skip) {
            intent = new Intent(LoginActivity.this,GameActivity.class);
            startActivity(intent);
        }
        else if (view == registration) {
            intent = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
        else if (view == mLogin)
        {
            String email,pass;
            email = mEmail.getText().toString();
            pass = mPassword.getText().toString();

            if (email.isEmpty()) {
                mEmail.setError(getString(R.string.cant_left_empty));
            }
            else if (pass.isEmpty()) {
                mPassword.setError(getString(R.string.cant_left_empty));
            }
            else {
                Toast.makeText(LoginActivity.this,"All Validation Done Login",Toast.LENGTH_LONG).show();
            }
        }

    }
}
