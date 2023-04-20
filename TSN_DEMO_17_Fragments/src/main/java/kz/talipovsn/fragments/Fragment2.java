package kz.talipovsn.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    // Метод создания второго фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Установка разметки фрагмента и доступ к компонентам фрагмента
        final View rootView = inflater.inflate(R.layout.fragment2, container, false);

        radioButton1 = rootView.findViewById(R.id.radioButton1);
        radioButton2 = rootView.findViewById(R.id.radioButton2);
        radioButton3 = rootView.findViewById(R.id.radioButton3);
        radioButton4 = rootView.findViewById(R.id.radioButton4);

        // Установка значения глобальной переменной MainActivity.radioGroupValue1
        MainActivity.radioGroupValue1 = radioButton1.getText().toString();

        RadioGroup radioGroup = rootView.findViewById(R.id.radioGroup);

        // Обработчик выбора значения в radioGroup
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        MainActivity.radioGroupValue1 = radioButton1.getText().toString();
                        break;
                    case R.id.radioButton2:
                        MainActivity.radioGroupValue1 = radioButton2.getText().toString();
                        break;
                    case R.id.radioButton3:
                        MainActivity.radioGroupValue1 = radioButton3.getText().toString();
                        break;
                    case R.id.radioButton4:
                        MainActivity.radioGroupValue1 = radioButton4.getText().toString();
                        break;
                    default:
                        MainActivity.radioGroupValue1 = radioButton1.getText().toString();
                        break;
                }
            }
        });
        radioGroup.check(R.id.radioButton1);

        // Обработчик кнопки Назад
        Button BackBtn = rootView.findViewById(R.id.backBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.setFragment(getActivity(), new Fragment1());
            }
        });

        // Обработчик кнопки Далее
        Button NextBtn = rootView.findViewById(R.id.nextBtn);
        NextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создание фрагмента с передачей ему параметров
                MainActivity.setFragment(getActivity(), new Fragment3());
            }
        });

        return rootView;
    }
}
