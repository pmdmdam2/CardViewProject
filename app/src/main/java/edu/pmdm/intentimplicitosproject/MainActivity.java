package edu.pmdm.intentimplicitosproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int DURATION = 250;
    private ViewGroup linearLayoutDetails;
    private ImageView imageViewExpand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.linearLayoutDetails = findViewById(R.id.linearLayoutDetails);
        this.imageViewExpand = findViewById(R.id.imageViewExpand);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupCard();
    }

    /**
     * Configura la vista de tipo tarjeta con su barra de herramaientas
     */
    private void setupCard() {
        Toolbar toolbarCard = findViewById(R.id.toolbarCard);
        toolbarCard.setTitle(R.string.gambito);
        toolbarCard.setSubtitle(R.string.subtitulo);
        toolbarCard.inflateMenu(R.menu.main_menu);

        toolbarCard.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_option1:
                        Toast.makeText(MainActivity.this, R.string.director, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_option2:
                        Toast.makeText(MainActivity.this, R.string.pais, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_option3:
                        Toast.makeText(MainActivity.this, R.string.reparto, Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    /**
     * Evento clic sobre la imagen de la flecha hacia abajo para ver más detalles
     * @param view Origen del evento
     */
    public void moreDetails(View view) {
        if (linearLayoutDetails.getVisibility() == View.GONE) {
            ExpandCollapseView.expand(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.ic_more);
            rotate(-180.0f);
        } else {
            ExpandCollapseView.collapse(linearLayoutDetails, DURATION);
            imageViewExpand.setImageResource(R.mipmap.ic_less);
            rotate(180.0f);
        }
    }

    /**
     * Método para rotar la imagen del icono más y menos detalles
     * @param angle
     */
    private void rotate(float angle) {
        Animation animation = new RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setFillAfter(false);
        animation.setDuration(DURATION);
        imageViewExpand.startAnimation(animation);
    }
}