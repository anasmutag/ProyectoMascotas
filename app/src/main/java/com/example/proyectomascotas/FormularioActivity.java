package com.example.proyectomascotas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class FormularioActivity extends AppCompatActivity {
    private TextInputEditText etNombre, etEmail, etMensaje;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNombre = (TextInputEditText) findViewById(R.id.etNombre);
        etEmail = (TextInputEditText) findViewById(R.id.etEmail);
        etMensaje = (TextInputEditText) findViewById(R.id.etMensaje);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Properties properties = new Properties();

                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");

                Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Utils.EMAIL, Utils.PASSWORD);
                    }
                });

                try {
                    MimeMessage mimeMessage = new MimeMessage(session);

                    mimeMessage.setFrom(new InternetAddress(Utils.EMAIL));
                    mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(etEmail.getText().toString().trim())));
                    mimeMessage.setSubject("Comentario: " + etNombre.getText().toString().trim());
                    mimeMessage.setText(etMensaje.getText().toString().trim());

                    new SendMail().execute(mimeMessage);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private class SendMail extends AsyncTask<Message, String, String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(FormularioActivity.this, "Enviando", "Transacción en proceso", true, false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);

                return "Ok";
            } catch (MessagingException e) {
                e.printStackTrace();

                return "Error";
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();

            if (s.equals("Ok")) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FormularioActivity.this);

                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Operación exitosa</font>"));
                builder.setMessage("Comentario enviado exitosamente");
                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();

                        etNombre.setText("");
                        etEmail.setText("");
                        etMensaje.setText("");

                        etNombre.clearFocus();
                        etEmail.clearFocus();
                        etMensaje.clearFocus();
                    }
                });

                builder.show();
            } else {
                Toast.makeText(getApplicationContext(), "Ocurrió un error!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}