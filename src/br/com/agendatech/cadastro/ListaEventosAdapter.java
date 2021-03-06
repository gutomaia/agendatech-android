package br.com.agendatech.cadastro;

import java.util.List;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.agendatech.modelo.Evento;

public class ListaEventosAdapter extends ArrayAdapter<Evento> {

	public ListaEventosAdapter(Context context, List<Evento> eventos) {
		super(context, R.layout.evento_linha, R.id.nome_evento, eventos);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final Evento evento = getItem(position);

		View pai = super.getView(position, convertView, parent);

		final ImageView logo = (ImageView) pai.findViewById(R.id.logo);
		
		logo.setImageResource(R.drawable.ic_launcher_bw);

		AsyncTask<String, ProgressDialog, Bitmap> imageLoad = new BitmapGenerator(logo);
		imageLoad.execute(evento.getLogo());

		TextView data = (TextView) pai.findViewById(R.id.data_cidade_evento);
		data.setText(evento.getData() + "-" +evento.getEstado());

		return pai;
	}


}