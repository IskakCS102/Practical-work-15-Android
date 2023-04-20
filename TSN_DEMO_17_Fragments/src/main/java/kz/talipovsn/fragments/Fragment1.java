package kz.talipovsn.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    // Метод создания первого фрагмента
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Установка разметки фрагмента и доступ к компонентам фрагмента
        final View fragmentView = inflater.inflate(R.layout.fragment1, container, false);

        // Поиск компонента кнопки и установка ей обработчика нажатия
        Button beginBtn = fragmentView.findViewById(R.id.beginBtn);
        beginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Загрузка второго фрагмента в окно
                MainActivity.setFragment(getActivity(), new Fragment2());
            }
        });

        return fragmentView;
    }

}
