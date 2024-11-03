import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AndroidActivity extends Activity {
    private float fontSize = 24;
    private int colorIndex = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final TextView textView = findViewById(R.id.textView1);
        Button increaseFontButton = findViewById(R.id.button1);
        Button changeColorButton = findViewById(R.id.button2);

        increaseFontButton.setOnClickListener(view -> {
            textView.setTextSize(fontSize);
            fontSize = (fontSize == 40) ? 20 : fontSize + 4;
        });

        changeColorButton.setOnClickListener(view -> {
            switch (colorIndex) {
                case 1:
                    textView.setTextColor(Color.BLUE);
                    break;
                case 2:
                    textView.setTextColor(Color.GREEN);
                    break;
                case 3:
                    textView.setTextColor(Color.RED);
                    break;
                case 4:
                    textView.setTextColor(Color.parseColor("#800000"));
                    break;
            }
            colorIndex = (colorIndex == 4) ? 1 : colorIndex + 1;
        });
    }
}
