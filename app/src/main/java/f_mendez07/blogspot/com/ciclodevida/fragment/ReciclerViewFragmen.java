package f_mendez07.blogspot.com.ciclodevida.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import f_mendez07.blogspot.com.ciclodevida.R;
import f_mendez07.blogspot.com.ciclodevida.adapter.ContactoAdapter;
import f_mendez07.blogspot.com.ciclodevida.pojo.Contacto;
import f_mendez07.blogspot.com.ciclodevida.presentador.IRecyclerViewFragmentPresenter;
import f_mendez07.blogspot.com.ciclodevida.presentador.RecyclerViewFragmentPresenter;

public class ReciclerViewFragmen extends Fragment implements IRecyclerViewFragmentView {
    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private IRecyclerViewFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_recicler_view,container,false);
        listaContactos = v.findViewById(R.id.rvContactos);

        presenter = new RecyclerViewFragmentPresenter(this,getContext());

        return v;

    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        // StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(linearLayoutManager);
    }

    @Override
    public ContactoAdapter crearAdaptador(ArrayList<Contacto> contactos) {
        return new ContactoAdapter(contactos,getActivity());
    }

    @Override
    public void inicializarAdaptadorRV(ContactoAdapter adapter) {
        listaContactos.setAdapter(adapter);
    }
}
