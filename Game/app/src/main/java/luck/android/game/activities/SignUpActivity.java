package luck.android.game.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import luck.android.game.R;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mPassword, mConfirmPass;
    private AutoCompleteTextView mEmail, mUserName;
    private Button mSignup;
    private RadioGroup genderGroup;
    private RadioButton male,female,transgender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        //initiate views
        initiateViews();
    }

    private void initiateViews () {
        mPassword = (EditText) findViewById(R.id.password);
        mConfirmPass = (EditText) findViewById(R.id.confirmPassword);
        mEmail = (AutoCompleteTextView) findViewById(R.id.signUpEmail);
        mUserName = (AutoCompleteTextView) findViewById(R.id.userName);
        mSignup = (Button) findViewById(R.id.email_sign_un_button);
        genderGroup = (RadioGroup) findViewById(R.id.genderGroup);
        male = (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        transgender = (RadioButton) findViewById(R.id.transgender);

        mSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String userName,email,pass,cnpass;
        userName = mUserName.getText().toString();
        email = mEmail.getText().toString();
        pass = mPassword.getText().toString();
        cnpass = mConfirmPass.getText().toString();

        if (userName.isEmpty()) {
            mUserName.setError(getString(R.string.cant_left_empty));
        }
        else if (email.isEmpty()) {
            mEmail.setError(getString(R.string.cant_left_empty));
        }
        else if (pass.isEmpty()) {
            mPassword.setError(getString(R.string.cant_left_empty));
        }
        else if (cnpass.isEmpty()) {
            mConfirmPass.setError(getString(R.string.cant_left_empty));
        }
        else if (genderGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(SignUpActivity.this,getString(R.string.select_gender),Toast.LENGTH_LONG).show();
        }

    }
}
