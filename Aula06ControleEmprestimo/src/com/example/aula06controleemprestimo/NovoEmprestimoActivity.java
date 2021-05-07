package com.example.aula06controleemprestimo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

@SuppressLint("NewApi") public class NovoEmprestimoActivity extends ListActivity {
	private Spinner ne_catg;
	private EditText ne_desc;
	private Spinner ne_nome;
	private EditText ne_data;
	private String[] listaCategoria;

	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_novo_emprestimo);
	    ne_catg = (Spinner) findViewById(R.id.ne_catg);
	    ne_desc = (EditText) findViewById(R.id.ne_desc);
	    ne_nome = (Spinner) findViewById(R.id.ne_nome);
	    ne_data = (EditText) findViewById(R.id.ne_data);
	    ne_data.setText(getData());
	    abrirCategorias();
	    abrirContatos();
	}
	
	private void abrirCategorias()
	{
	    listaCategoria = getResources().getStringArray(R.array.listaCategoria);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	        android.R.layout.simple_spinner_item, listaCategoria);
	    ne_catg.setAdapter(adapter);        
	}
	
	private void abrirContatos() {
	    Uri uri = ContactsContract.Contacts.CONTENT_URI;
	    Cursor c = this.getContentResolver().query(uri, null, null, null, null);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
	            android.R.layout.simple_spinner_item);
	    while (c.moveToNext()) {
	        String contato = c.getString(c.getColumnIndex(
	               ContactsContract.Contacts.DISPLAY_NAME)); 
	        adapter.add(contato); }
	    ne_nome.setAdapter(adapter);
	    c.close();
	}
	
	private String getData()
	{
	    String format = "dd/MM/yyyy";
	    SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
	    return String.format("%s", sdf.format(new Date()));
	}
	
	public void btnOkClick(View v)     {
	    if (validarEmprestimo())     {
	        Intent data = new Intent();
	        data.putExtra("catg", ne_catg.getSelectedItem().toString());
	        data.putExtra("desc", ne_desc.getText().toString());
	        data.putExtra("nome", ne_nome.getSelectedItem().toString());
	        data.putExtra("data", ne_data.getText().toString());
	        setResult(RESULT_OK, data);
	        finish();       
	    }
	}
	
	public void btnCancelClick(View v)
	{
	    setResult(RESULT_CANCELED);
	    finish();
	}

	private Boolean validarEmprestimo() {
	    AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setPositiveButton(R.string.ok, null);
	    builder.setTitle(R.string.app_name);
	    if (ne_desc.getText().toString().isEmpty()) {
	        builder.setMessage(R.string.infoDescricao);
	        AlertDialog dialog = builder.create();
	        dialog.show();
	        return false;
	     }
	    if (ne_nome.getSelectedItem().toString().isEmpty()) {
	        builder.setMessage(R.string.infoContato);
	        AlertDialog dialog = builder.create();
	        dialog.show();
	        return false; }
	    if (ne_data.getText().toString().isEmpty()) {
	        builder.setMessage(R.string.infoData);
	        AlertDialog dialog = builder.create();
	        dialog.show();
	        return false; }
	    return true;
	}	
}
