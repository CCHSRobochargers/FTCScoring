package org.robochargers.ftcscoring;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements PopupMenu.OnMenuItemClickListener {
    RelativeLayout mainScreen;

    TextView ScoreView;
    int score = 0;

    Button AutoCornerParticlesMinus;
    TextView AutoCornerParticlesView;
    int AutoCornerParticlesNum = 0;
    Button AutoCornerParticlesPlus;

    Button AutoCenterParticlesMinus;
    TextView AutoCenterParticlesView;
    int AutoCenterParticlesNum = 0;
    Button AutoCenterParticlesPlus;

    ToggleButton AutoBeacon1;
    ToggleButton AutoBeacon2;

    CheckBox AutoCornerParkedNot;
    CheckBox AutoCornerParkedPart;
    CheckBox AutoCornerParkedFull;
    int cornerParkedScore = 0;

    CheckBox AutoCenterParkedNot;
    CheckBox AutoCenterParkedPart;
    CheckBox AutoCenterParkedFull;
    int centerParkedScore = 0;

    ToggleButton CapBall;

    Button TeleopCornerParticlesMinus;
    TextView TeleopCornerParticlesView;
    int TeleopCornerParticlesNum = 0;
    Button TeleopCornerParticlesPlus;

    Button TeleopCenterParticlesMinus;
    TextView TeleopCenterParticlesView;
    int TeleopCenterParticlesNum = 0;
    Button TeleopCenterParticlesPlus;

    Button TeleopBeaconsMinus;
    TextView TeleopBeaconsView;
    int BeaconNum = 0;
    Button TeleopBeaconsPlus;

    CheckBox TeleopCapBallNotRaised;
    CheckBox TeleopCapBallLittleRaised;
    CheckBox TeleopCapBallLotRaised;
    CheckBox TeleopCapBallCapped;
    int capballScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onStart() {
        super.onStart();

        mainScreen = (RelativeLayout) findViewById(R.id.activity_main);
        mainScreen.setBackgroundColor(getResources().getColor(R.color.backgroundTint));

        ScoreView = (TextView) findViewById(R.id.total_score);

        AutoCornerParticlesMinus = (Button) findViewById(R.id.auto_corner_down1);
        AutoCornerParticlesView = (TextView) findViewById(R.id.auto_corner_number);
        AutoCornerParticlesPlus = (Button) findViewById(R.id.auto_corner_up1);

        AutoCornerParticlesMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AutoCornerParticlesNum > 0) {
                    AutoCornerParticlesNum--;
                    AutoCornerParticlesView.setText(String.valueOf(AutoCornerParticlesNum));
                    score -= 5;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });
        AutoCornerParticlesPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AutoCornerParticlesNum++;
                AutoCornerParticlesView.setText(String.valueOf(AutoCornerParticlesNum));
                score += 5;
                ScoreView.setText(String.valueOf(score));
            }
        });

        AutoCenterParticlesMinus = (Button) findViewById(R.id.auto_center_down1);
        AutoCenterParticlesView = (TextView) findViewById(R.id.auto_center_number);
        AutoCenterParticlesPlus = (Button) findViewById(R.id.auto_center_up1);

        AutoCenterParticlesMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (AutoCenterParticlesNum > 0) {
                    AutoCenterParticlesNum--;
                    AutoCenterParticlesView.setText(String.valueOf(AutoCenterParticlesNum));
                    score -= 15;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });
        AutoCenterParticlesPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AutoCenterParticlesNum++;
                AutoCenterParticlesView.setText(String.valueOf(AutoCenterParticlesNum));
                score += 15;
                ScoreView.setText(String.valueOf(score));
            }
        });

        AutoBeacon1 = (ToggleButton) findViewById(R.id.auto_beacon_1);
        AutoBeacon2 = (ToggleButton) findViewById(R.id.auto_beacon_2);

        AutoBeacon1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    score += 30;
                } else {
                    score -= 30;
                }
                ScoreView.setText(String.valueOf(score));
            }
        });

        AutoBeacon2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    score += 30;
                } else {
                    score -= 30;
                }
                ScoreView.setText(String.valueOf(score));
            }
        });

        AutoCornerParkedNot = (CheckBox) findViewById(R.id.auto_corner_np);
        AutoCornerParkedPart = (CheckBox) findViewById(R.id.auto_corner_pp);
        AutoCornerParkedFull = (CheckBox) findViewById(R.id.auto_corner_fp);

        AutoCornerParkedNot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AutoCornerParkedPart.setChecked(false);
                    AutoCornerParkedFull.setChecked(false);
                    score -= cornerParkedScore;
                    cornerParkedScore = 0;
                    score += cornerParkedScore;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        AutoCornerParkedPart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AutoCornerParkedNot.setChecked(false);
                    AutoCornerParkedFull.setChecked(false);
                    score -= cornerParkedScore;
                    cornerParkedScore = 5;
                    score += cornerParkedScore;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        AutoCornerParkedFull.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AutoCornerParkedNot.setChecked(false);
                    AutoCornerParkedPart.setChecked(false);
                    score -= cornerParkedScore;
                    cornerParkedScore = 10;
                    score += cornerParkedScore;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        AutoCenterParkedNot = (CheckBox) findViewById(R.id.auto_center_np);
        AutoCenterParkedPart = (CheckBox) findViewById(R.id.auto_center_pp);
        AutoCenterParkedFull = (CheckBox) findViewById(R.id.auto_center_fp);

        AutoCenterParkedNot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AutoCenterParkedPart.setChecked(false);
                    AutoCenterParkedFull.setChecked(false);
                    score -= centerParkedScore;
                    centerParkedScore = 0;
                    score += centerParkedScore;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        AutoCenterParkedPart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AutoCenterParkedNot.setChecked(false);
                    AutoCenterParkedFull.setChecked(false);
                    score -= centerParkedScore;
                    centerParkedScore = 5;
                    score += centerParkedScore;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        AutoCenterParkedFull.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AutoCenterParkedNot.setChecked(false);
                    AutoCenterParkedPart.setChecked(false);
                    score -= centerParkedScore;
                    centerParkedScore = 10;
                    score += centerParkedScore;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        CapBall = (ToggleButton) findViewById(R.id.cap_ball);

        CapBall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    score -= 5;
                    ScoreView.setText(String.valueOf(score));
                } else {
                    score += 5;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        TeleopCornerParticlesMinus = (Button) findViewById(R.id.teleop_corner_down1);
        TeleopCornerParticlesView = (TextView) findViewById(R.id.teleop_corner_number);
        TeleopCornerParticlesPlus = (Button) findViewById(R.id.teleop_corner_up1);

        TeleopCornerParticlesMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TeleopCornerParticlesNum > 0) {
                    TeleopCornerParticlesNum--;
                    TeleopCornerParticlesView.setText(String.valueOf(TeleopCornerParticlesNum));
                    score -= 1;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });
        TeleopCornerParticlesPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeleopCornerParticlesNum++;
                TeleopCornerParticlesView.setText(String.valueOf(TeleopCornerParticlesNum));
                score += 1;
                ScoreView.setText(String.valueOf(score));
            }
        });

        TeleopCenterParticlesMinus = (Button) findViewById(R.id.teleop_center_down1);
        TeleopCenterParticlesView = (TextView) findViewById(R.id.teleop_center_number);
        TeleopCenterParticlesPlus = (Button) findViewById(R.id.teleop_center_up1);

        TeleopCenterParticlesMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TeleopCenterParticlesNum > 0) {
                    TeleopCenterParticlesNum--;
                    TeleopCenterParticlesView.setText(String.valueOf(TeleopCenterParticlesNum));
                    score -= 5;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });
        TeleopCenterParticlesPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeleopCenterParticlesNum++;
                TeleopCenterParticlesView.setText(String.valueOf(TeleopCenterParticlesNum));
                score += 5;
                ScoreView.setText(String.valueOf(score));
            }
        });

        TeleopBeaconsMinus = (Button) findViewById(R.id.teleop_beacons_down1);
        TeleopBeaconsView = (TextView) findViewById(R.id.teleop_beacons_number);
        TeleopBeaconsPlus = (Button) findViewById(R.id.teleop_beacons_up1);

        TeleopBeaconsMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BeaconNum > 0) {
                    BeaconNum--;
                    TeleopBeaconsView.setText(String.valueOf(BeaconNum));
                    score -= 10;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });
        TeleopBeaconsPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (BeaconNum < 4) {
                    BeaconNum++;
                    TeleopBeaconsView.setText(String.valueOf(BeaconNum));
                    score += 10;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        TeleopCapBallNotRaised = (CheckBox) findViewById(R.id.teleop_capball_nr);
        TeleopCapBallLittleRaised = (CheckBox) findViewById(R.id.teleop_capball_lr);
        TeleopCapBallLotRaised = (CheckBox) findViewById(R.id.teleop_capball_mr);
        TeleopCapBallCapped = (CheckBox) findViewById(R.id.teleop_capball_cp);

        TeleopCapBallNotRaised.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TeleopCapBallLittleRaised.setChecked(false);
                    TeleopCapBallLotRaised.setChecked(false);
                    TeleopCapBallCapped.setChecked(false);
                    score -= capballScore;
                    capballScore = 0;
                    score += capballScore;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        TeleopCapBallLittleRaised.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TeleopCapBallNotRaised.setChecked(false);
                    TeleopCapBallLotRaised.setChecked(false);
                    TeleopCapBallCapped.setChecked(false);
                    score -= capballScore;
                    capballScore = 10;
                    score += capballScore;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        TeleopCapBallLotRaised.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TeleopCapBallNotRaised.setChecked(false);
                    TeleopCapBallLittleRaised.setChecked(false);
                    TeleopCapBallCapped.setChecked(false);
                    score -= capballScore;
                    capballScore = 20;
                    score += capballScore;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        TeleopCapBallCapped.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    TeleopCapBallNotRaised.setChecked(false);
                    TeleopCapBallLittleRaised.setChecked(false);
                    TeleopCapBallLotRaised.setChecked(false);
                    score -= capballScore;
                    capballScore = 40;
                    score += capballScore;
                    ScoreView.setText(String.valueOf(score));
                }
            }
        });

        reset();
    }


    public void onOpenSettings(View view) {
        PopupMenu menu = new PopupMenu(this, view);
        menu.setOnMenuItemClickListener(this);
        menu.inflate(R.menu.menu);
        menu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                return true;
            case R.id.menu_exit:
                finishAffinity();
                return true;
            default:
                return false;
        }
    }

    public void resetGame(View view) {
        reset();
    }

    public void reset() {
        AutoCornerParticlesNum = 0;
        AutoCenterParticlesNum = 0;
        cornerParkedScore = 0;
        centerParkedScore = 0;
        TeleopCornerParticlesNum = 0;
        TeleopCenterParticlesNum = 0;
        BeaconNum = 0;
        capballScore = 0;

        AutoCornerParticlesView.setText("0");
        AutoCenterParticlesView.setText("0");
        AutoBeacon1.setChecked(false);
        AutoBeacon2.setChecked(false);
        AutoCornerParkedNot.setChecked(true);
        AutoCornerParkedPart.setChecked(false);
        AutoCornerParkedFull.setChecked(false);
        AutoCenterParkedNot.setChecked(true);
        AutoCenterParkedPart.setChecked(false);
        AutoCenterParkedFull.setChecked(false);
        CapBall.setChecked(true);
        TeleopCornerParticlesView.setText("0");
        TeleopCenterParticlesView.setText("0");
        TeleopBeaconsView.setText("0");
        TeleopCapBallNotRaised.setChecked(true);
        TeleopCapBallLittleRaised.setChecked(false);
        TeleopCapBallLotRaised.setChecked(false);
        TeleopCapBallCapped.setChecked(false);

        score = 0;
        ScoreView.setText("0");
    }
}