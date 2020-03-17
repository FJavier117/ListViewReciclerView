package f_mendez07.blogspot.com.ciclodevida.fragment;

import java.util.ArrayList;

import f_mendez07.blogspot.com.ciclodevida.adapter.ContactoAdapter;
import f_mendez07.blogspot.com.ciclodevida.pojo.Contacto;

public interface IRecyclerViewFragmentView {
    //sera el modelo de mi recycler view de mi fragment

    public void generarLinearLayoutVertical();

    public ContactoAdapter crearAdaptador(ArrayList<Contacto> contactos);

    public void inicializarAdaptadorRV(ContactoAdapter adapter);

}
