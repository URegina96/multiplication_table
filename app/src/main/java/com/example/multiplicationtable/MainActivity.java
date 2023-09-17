package com.example.multiplicationtable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listViewNumders;
    private SeekBar seekBar;

    private ArrayList<Integer> numbers;

    private int max = 20;
    private int min = 1;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewNumders = findViewById(R.id.ListViewMultiplicationTable);
        seekBar = findViewById(R.id.seekBar);
        //устанавливаем max значение у seekBar
        seekBar.setMax(max);
        //массив пустой
        numbers = new ArrayList<>();
        //адаптер
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, numbers);
        listViewNumders.setAdapter(arrayAdapter);

        //слушатель события для реагирования на движение seekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) { //метод вызывается, когда изменен прогресс на seekBar

                //когда пользователь меняет прогресс , то необходимо , в данном случае, очистить массив чисел
                numbers.clear();


                for (int i = min; i <= count; i++) {
                    numbers.add(progress * i);
                }
                //сообщаем адаптеру
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { //метод вызывается, когда пользователь только начинает двигать кружочек
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { //метод вызывается, когда пользователь отпускает кружок
            }
        });
        //для того что бы при запуске приложения сразу вызвался метод  onProgressChanged изменяем прогресс на seekBar
        seekBar.setProgress(10);

    }
}