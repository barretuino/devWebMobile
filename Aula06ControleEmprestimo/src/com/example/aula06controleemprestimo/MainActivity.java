package com.example.aula06controleemprestimo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;

@SuppressLint("NewApi") public class MainActivity extends ListActivity {
	private SharedPreferences prefs;
	private ArrayList<HashMap<String, String>> emps;
	private SimpleAdapter adapter;
	private final String Sep = "---";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		prefs = getSharedPreferences("arquivo", MODE_PRIVATE);
		emps = new ArrayList<HashMap<String, String>>();
		abrirEmprestimos();
		String[] from = new String[] { "catg", "desc", "nome", "data" };
		int[] to = new int[] { R.id.catg, R.id.desc, R.id.nome, R.id.data };
		int layout = R.layout.item_emprestimo;
		adapter = new SimpleAdapter(this, emps, layout, from, to);
		setListAdapter(adapter);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId())
		{
		case R.id.novo :
			Intent novo_contato = new Intent(this, NovoEmprestimoActivity.class);
			startActivityForResult(novo_contato, 0); 
			break;
		}
		return true;
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				String _catg = data.getCharSequenceExtra("catg").toString();
				String _desc = data.getCharSequenceExtra("desc").toString();
				String _nome = data.getCharSequenceExtra("nome").toString();
				String _data = data.getCharSequenceExtra("data").toString();
				salvarEmprestimo(_catg, _desc, _nome, _data);
			}
		}
	}

	private void salvarEmprestimo(String aCatg, String aDesc, String aNome, String aData) {
		SharedPreferences.Editor editor = prefs.edit();
		String chave = aCatg+Sep+aDesc;
		String valor = aNome+Sep+aData;
		editor.putString(chave, valor);
		editor.apply();
		HashMap<String, String> item = new HashMap<String, String>(); 
		item.put("catg", aCatg);
		item.put("desc", aDesc);
		item.put("nome", aNome);
		item.put("data", aData);
		emps.add(item);
		adapter.notifyDataSetChanged();
	}

	private void abrirEmprestimos() {
		Map<String,String> map = (Map<String,String>)prefs.getAll();
		for(Map.Entry<String,String> mapItem : map.entrySet())
		{
			String[] chave = mapItem.getKey().toString().split(Sep);
			String[] valor = mapItem.getValue().toString().split(Sep);
			HashMap<String, String> item = new HashMap<String, String>(); 
			item.put("catg", chave[0]);
			item.put("desc", chave[1]);
			item.put("nome", valor[0]);
			item.put("data", valor[1]);
			emps.add(item);
		}
	}    
}
