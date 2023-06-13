package org.o7planning.texttospeech;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import java.util.Locale;
public class MainActivity extends AppCompatActivity {
    EditText e1;
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText);
        t1=new TextToSpeech(getApplicationContext(), status -> {

            if(status!=TextToSpeech.ERROR){
                t1.setLanguage(Locale.UK);
            }
        });
    }
    public void convert(View V){
        String tospeak=e1.getText().toString();
        t1.speak(tospeak,TextToSpeech.QUEUE_FLUSH,null);
    }
}
