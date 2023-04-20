package kz.talipovsn.fragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TableLayout;

import androidx.fragment.app.Fragment;

public class Fragment4 extends Fragment {

    // Метод создания четвертого фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Установка разметки фрагмента и доступ к компонентам фрагмента
        final View rootView = inflater.inflate(R.layout.fragment4, container, false);

        TableLayout tableLayout = rootView.findViewById(R.id.tableLayout);

        final int ROW_COUNT = 2;
        final int COL_COUNT = 2;
        String[][] results = new String[ROW_COUNT][COL_COUNT];

        results[0][0] = getResources().getString(R.string.question1);
        results[1][0] = getResources().getString(R.string.question2);
        results[0][1] =  MainActivity.radioGroupValue1;
        results[1][1] =  MainActivity.radioGroupValue2;

        // Формирование строк таблицы
        for (int row = 0; row < ROW_COUNT; row++) {
            TableRow tableRow = new TableRow(rootView.getContext());
            LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            tableRow.setLayoutParams(params);
            tableRow.setGravity(Gravity.CENTER);
            TableRow.LayoutParams param = new TableRow.LayoutParams();

            // Формирование столбцов таблицы
            for (int col = 0; col < COL_COUNT; col++) {
                EditText value = new EditText(rootView.getContext());
                value.setText(results[row][col]);
                value.setLayoutParams(param);
                value.setTextSize(18);
                value.setGravity(Gravity.CENTER);
                value.setBackgroundResource(R.drawable.back);
                value.setPadding(5, 5, 5, 5);
                tableRow.addView(value, col);
            }
            tableLayout.addView(tableRow, row);
        }

        // Обработчик кнопки Назад
        Button BackBtn = rootView.findViewById(R.id.backBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null) {
                    MainActivity.setFragment(getActivity(), new Fragment3());
                }
            }
        });

        // Обработчик кнопки Заново
        Button AgainBtn = rootView.findViewById(R.id.againBtn);
        AgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment1 fragment1 = new Fragment1();
                if (getActivity() != null) {
                    MainActivity.setFragment(getActivity(), new Fragment1());
                }
            }
        });

        return rootView;
    }

}
