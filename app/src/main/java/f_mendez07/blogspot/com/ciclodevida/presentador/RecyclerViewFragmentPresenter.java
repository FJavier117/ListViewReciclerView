package f_mendez07.blogspot.com.ciclodevida.presentador;

import android.content.Context;

import java.util.ArrayList;

import f_mendez07.blogspot.com.ciclodevida.db.ConstructorContactos;
import f_mendez07.blogspot.com.ciclodevida.fragment.IRecyclerViewFragmentView;
import f_mendez07.blogspot.com.ciclodevida.pojo.Contacto;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {
    private ConstructorContactos constructorContactos;
    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ArrayList<Contacto>contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerContactosDB();
    }

    @Override
    public void obtenerContactosDB() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerContactos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
