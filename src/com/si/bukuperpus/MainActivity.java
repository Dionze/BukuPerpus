package com.si.bukuperpus;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.os.*;
import android.graphics.*;
import android.app.ActionBar.LayoutParams;
import android.content.DialogInterface;

public class MainActivity extends Activity implements OnClickListener {
	
	BukuActivity bukuActivity = new BukuActivity();
	TableLayout tableLayout;
	Button buttonTambahBuku;
	ArrayList<Button>buttonEdit 	= new ArrayList<Button>();
	ArrayList<Button>buttonDelete 	= new ArrayList<Button>();
	JSONArray arrayBuku;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	// Jika SDK Android diatas API Ver.9
		if (android.os.Build.VERSION.SDK_INT > 9) {
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
		.permitAll().build();
		StrictMode.setThreadPolicy(policy);
	}
	// Mendapatkan data widget dari XML Activity melalui ID
		tableLayout 			= (TableLayout) findViewById(R.id.tableBuku);
		buttonTambahBuku 		= (Button) findViewById(R.id.buttonTambahBuku);
		buttonTambahBuku.setOnClickListener(this);
		
	//Menambah baris untuk tabel
		TableRow barisTabel = new TableRow(this);
		barisTabel.setBackgroundColor(Color.CYAN);
		
	// Menambahkan tampilan teks untuk judul pada tabel
		TextView viewHeaderID 			= new TextView(this);
		TextView viewHeaderKategori 	= new TextView(this);
		TextView viewHeaderJudul 		= new TextView(this);
		TextView viewHeaderPengarang 	= new TextView(this);
		TextView viewHeaderTerbit 		= new TextView(this);
		TextView viewHeaderPenerbit 	= new TextView(this);
		TextView viewHeaderIsbn 		= new TextView(this);
		TextView viewHeaderJumlah 		= new TextView(this);
		TextView viewHeaderLokasi 		= new TextView(this);
		TextView viewHeaderGambar 		= new TextView(this);
		TextView viewHeaderInput 		= new TextView(this);
		TextView viewHeaderStatus 		= new TextView(this);
		TextView viewHeaderAction 		= new TextView(this);
		
		viewHeaderID.setText		("ID");
		viewHeaderKategori.setText	("Kategori");
		viewHeaderJudul.setText		("Judul Buku");
		viewHeaderPengarang.setText	("Pengarang");
		viewHeaderTerbit.setText	("Tahun Terbit");
		viewHeaderPenerbit.setText	("Penerbit");
		viewHeaderIsbn.setText		("Isbn");
		viewHeaderJumlah.setText	("Jumlah");
		viewHeaderLokasi.setText	("Lokasi");
		viewHeaderGambar.setText	("Gambar");
		viewHeaderInput.setText		("Tanggal Input");
		viewHeaderStatus.setText	("Status Buku");
		viewHeaderAction.setText	("Action");
		
		viewHeaderID.setPadding			(5, 1, 5, 1);
		viewHeaderKategori.setPadding	(5, 1, 5, 1);
		viewHeaderJudul.setPadding		(5, 1, 5, 1);
		viewHeaderPengarang.setPadding	(5, 1, 5, 1);
		viewHeaderTerbit.setPadding		(5, 1, 5, 1);
		viewHeaderPenerbit.setPadding	(5, 1, 5, 1);
		viewHeaderIsbn.setPadding		(5, 1, 5, 1);
		viewHeaderJumlah.setPadding		(5, 1, 5, 1);
		viewHeaderLokasi.setPadding		(5, 1, 5, 1);
		viewHeaderGambar.setPadding		(5, 1, 5, 1);
		viewHeaderInput.setPadding		(5, 1, 5, 1);
		viewHeaderStatus.setPadding		(5, 1, 5, 1);
		viewHeaderAction.setPadding		(5, 1, 5, 1);
		
	// Menampilkan tampilan TextView ke dalam tabel
		barisTabel.addView(viewHeaderID);
		barisTabel.addView(viewHeaderKategori);
		barisTabel.addView(viewHeaderJudul);
		barisTabel.addView(viewHeaderPengarang);
		barisTabel.addView(viewHeaderTerbit);
		barisTabel.addView(viewHeaderPenerbit);
		barisTabel.addView(viewHeaderIsbn);
		barisTabel.addView(viewHeaderJumlah);
		barisTabel.addView(viewHeaderLokasi);
		barisTabel.addView(viewHeaderGambar);
		barisTabel.addView(viewHeaderInput);
		barisTabel.addView(viewHeaderStatus);
		barisTabel.addView(viewHeaderAction);
		
	// Menyusun ukuran dari tabel
		tableLayout.addView(barisTabel, new
		TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		try {
			
	// Mengubah data dari BiodataActivity yang berupa String menjadi array
		arrayBuku = new JSONArray(bukuActivity.tampilBuku());
		for (int i = 0; i < arrayBuku.length(); i++) {
		JSONObject jsonChildNode = arrayBuku.getJSONObject(i);
		
		String id_kategori 		= jsonChildNode.optString	("id_kategori");
		String judul_buku 		= jsonChildNode.optString	("judul_buku");
		String pengarang 		= jsonChildNode.optString	("pengarang");
		String thn_terbit 		= jsonChildNode.optString	("thn_terbit");
		String penerbit 		= jsonChildNode.optString	("penerbit");
		String isbn 			= jsonChildNode.optString	("isbn");
		String jumlah_buku 		= jsonChildNode.optString	("jumlah_buku");
		String lokasi 			= jsonChildNode.optString	("lokasi");
		String gambar 			= jsonChildNode.optString	("gambar");
		String tgl_input 		= jsonChildNode.optString	("tgl_input");
		String status_buku 		= jsonChildNode.optString	("status_buku");
		String id_buku 			= jsonChildNode.optString	("id_buku");
		
		System.out.println("Kategori : "  + id_kategori);
		System.out.println("Judul : "	  + judul_buku);
		System.out.println("Pengarang : " + pengarang);
		System.out.println("Terbit : " 	  + thn_terbit);
		System.out.println("Penerbit : "  + penerbit);
		System.out.println("Isbn : " 	  + isbn);
		System.out.println("Jumlah : "    + jumlah_buku);
		System.out.println("Lokasi : " 	  + lokasi);
		System.out.println("Gambar : "    + gambar);
		System.out.println("Input : "     + tgl_input);
		System.out.println("Status : "    + status_buku);
		System.out.println("ID : "        + id_buku);
		barisTabel = new TableRow(this);
		
	// Memberi warna pada baris tabel
		if (i % 2 == 0) {
		barisTabel.setBackgroundColor(Color.LTGRAY);
		}
		
		TextView viewID = new TextView(this);
		viewID.setText(id_buku);
		viewID.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewID);
		
		TextView viewKategori = new TextView(this);
		viewKategori.setText(id_kategori);
		viewKategori.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewKategori);
		
		TextView viewJudul = new TextView(this);
		viewJudul.setText(judul_buku);
		viewJudul.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewJudul);
		
		TextView viewPengarang = new TextView(this);
		viewPengarang.setText(pengarang);
		viewPengarang.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewPengarang);
		
		TextView viewTerbit = new TextView(this);
		viewTerbit.setText(thn_terbit);
		viewTerbit.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewTerbit);
		
		TextView viewPenerbit = new TextView(this);
		viewPenerbit.setText(penerbit);
		viewPenerbit.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewPenerbit);
		
		TextView viewIsbn = new TextView(this);
		viewIsbn.setText(isbn);
		viewIsbn.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewIsbn);
		
		TextView viewJumlah = new TextView(this);
		viewJumlah.setText(jumlah_buku);
		viewJumlah.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewJumlah);
		
		TextView viewLokasi = new TextView(this);
		viewLokasi.setText(lokasi);
		viewLokasi.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewLokasi);
		
		TextView viewGambar = new TextView(this);
		viewGambar.setText(gambar);
		viewGambar.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewGambar);
		
		TextView viewInput = new TextView(this);
		viewInput.setText(tgl_input);
		viewInput.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewInput);
		
		TextView viewStatusBuku = new TextView(this);
		viewStatusBuku.setText(status_buku);
		viewStatusBuku.setPadding(5, 1, 5, 1);
		barisTabel.addView(viewStatusBuku);

	// Menambahkan button Edit
		buttonEdit.add(i, new Button(this));
		buttonEdit.get(i).setId(Integer.parseInt(id_buku));
		buttonEdit.get(i).setTag("Edit");
		buttonEdit.get(i).setText("Edit");
		buttonEdit.get(i).setOnClickListener(this);
		barisTabel.addView(buttonEdit.get(i));
		
	// Menambahkan tombol Delete
		buttonDelete.add(i, new Button(this));
		buttonDelete.get(i).setId(Integer.parseInt(id_buku));
		buttonDelete.get(i).setTag("Delete");
		buttonDelete.get(i).setText("Delete");
		buttonDelete.get(i).setOnClickListener(this);
		barisTabel.addView(buttonDelete.get(i));
		
		tableLayout.addView(barisTabel, new TableLayout.LayoutParams
				(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		}
	}
	catch (JSONException e) {
		e.printStackTrace();
	}
	}
public void onClick (View view) {
	if (view.getId() == R.id.buttonTambahBuku) {
		tambahBuku();
	}else{
	for (int i= 0; i < buttonEdit.size(); i++) {
	// Jika ingin mengedit data pada biodata
		if (view.getId() == buttonEdit.get(i).getId() &&
		view.getTag().toString().trim().equals("Edit")) {
		Toast.makeText(MainActivity.this, "Edit : " + buttonEdit.get(i).getId(),
		Toast.LENGTH_SHORT).show();
		int id_buku = buttonEdit.get(i).getId();
		getBukuByID(id_buku);
		}
	// Menghapus data di Tabel
		else if (view.getId() == buttonDelete.get(i).getId() &&
		view.getTag().toString().trim().equals("Delete")){
		Toast.makeText(MainActivity.this, "Delete : " +
		buttonDelete.get(i).getId(), Toast.LENGTH_SHORT).show();
		int id_buku = buttonDelete.get(i).getId();
		deleteBuku(id_buku);
		}
		}
	}
}

public void deleteBuku (int id_buku) {
	bukuActivity.deleteBuku(id_buku);
		finish();
		startActivity(getIntent());
	}
	// Mendapatkan Biodata melalui ID
public void getBukuByID (int id_buku) {
	String id_kategoriEdit 	= null,
		   judul_bukuEdit 	= null,
		   pengarangEdit 	= null, 
		   thn_terbitEdit 	= null, 
		   penerbitEdit 	= null, 
		   isbnEdit 		= null, 
		   jumlah_bukuEdit 	= null, 
		   lokasiEdit 		= null, 
		   gambarEdit 		= null, 
		   tgl_inputEdit 	= null,
		   status_bukuEdit 	= null;
	
		JSONArray arrayPersonal;
		try {
			arrayPersonal = new JSONArray(bukuActivity.getBukuById(id_buku));
			for (int i = 0; i < arrayPersonal.length(); i++) {
				JSONObject jsonChildNode = arrayPersonal.getJSONObject(i);
				
				id_kategoriEdit 		 = jsonChildNode.optString	("id_kategori");
				judul_bukuEdit 			 = jsonChildNode.optString	("judul_buku");
				pengarangEdit 			 = jsonChildNode.optString	("pengarang");
				thn_terbitEdit 			 = jsonChildNode.optString	("tahun_terbit");
				penerbitEdit 			 = jsonChildNode.optString	("penerbit");
				isbnEdit 				 = jsonChildNode.optString	("isbn");
				jumlah_bukuEdit 		 = jsonChildNode.optString	("jumlah_buku");
				lokasiEdit 				 = jsonChildNode.optString	("lokasi");
				gambarEdit 				 = jsonChildNode.optString	("gambar");
				tgl_inputEdit 			 = jsonChildNode.optString	("tgl_input");
				status_bukuEdit 		 = jsonChildNode.optString	("status_buku");
			}
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		LinearLayout layoutInput = new LinearLayout(this);
		layoutInput.setOrientation(LinearLayout.VERTICAL);
		
	// Membuat id tersembunyi pada AlertDialog
		final TextView viewId = new TextView(this);
		viewId.setText(String.valueOf(id_buku));
		viewId.setTextColor(Color.TRANSPARENT);
		layoutInput.addView(viewId);
		
		final EditText editKategori = new EditText(this);
		editKategori.setText(id_kategoriEdit);
		layoutInput.addView(editKategori);
		
		final EditText editJudul = new EditText(this);
		editJudul.setText(judul_bukuEdit);
		layoutInput.addView(editJudul);
		
		final EditText editPengarang = new EditText(this);
		editPengarang.setText(pengarangEdit);
		layoutInput.addView(editPengarang);
		
		final EditText editTerbit = new EditText(this);
		editTerbit.setText(thn_terbitEdit);
		layoutInput.addView(editTerbit);
		
		final EditText editPenerbit = new EditText(this);
		editPenerbit.setText(penerbitEdit);
		layoutInput.addView(editPenerbit);
		
		final EditText editIsbn = new EditText(this);
		editIsbn.setText(isbnEdit);
		layoutInput.addView(editIsbn);
		
		final EditText editJumlah = new EditText(this);
		editJumlah.setText(jumlah_bukuEdit);
		layoutInput.addView(editJumlah);
		
		final EditText editLokasi = new EditText(this);
		editLokasi.setText(lokasiEdit);
		layoutInput.addView(editLokasi);
		
		final EditText editGambar = new EditText(this);
		editGambar.setText(gambarEdit);
		layoutInput.addView(editGambar);
		
		final EditText editInput = new EditText(this);
		editInput.setText(tgl_inputEdit);
		layoutInput.addView(editInput);
		
		final EditText editStatus = new EditText(this);
		editStatus.setText(status_bukuEdit);
		layoutInput.addView(editStatus);
		
	// Membuat AlertDialog untuk mengubah data di Biodata
		AlertDialog.Builder builderEditBuku = new AlertDialog.Builder(this);
		
	//builderEditBiodata.setIcon(R.drawable.webse);
		builderEditBuku.setTitle("Update Buku");
		builderEditBuku.setView(layoutInput);
		builderEditBuku.setPositiveButton("Update", new DialogInterface.OnClickListener()
		{
			
@Override
public void onClick(DialogInterface dialog, int which) {
	String id_kategori 	= editKategori.getText().toString();
	String judul_buku 	= editJudul.getText().toString();
	String pengarang 	= editPengarang.getText().toString();
	String thn_terbit 	= editTerbit.getText().toString();
	String penerbit 	= editPenerbit.getText().toString();
	String isbn 		= editIsbn.getText().toString();
	String jumlah_buku 	= editJumlah.getText().toString();
	String lokasi 		= editLokasi.getText().toString();
	String gambar 		= editGambar.getText().toString();
	String tgl_input 	= editInput.getText().toString();
	String status_buku 	= editStatus.getText().toString();
	
	System.out.println(	"Kategori : " 	+ id_kategori + 
						"Judul : " 		+ judul_buku +
						"Pengarang :"   + pengarang +
						"Penerbit : " 	+ penerbit + 
						"Terbit :"    	+ thn_terbit +
						"Isbn : " 		+ isbn + 
						"Jumlah : " 	+ jumlah_buku + 
						"Lokasi : " 	+ lokasi + 
						"Gambar : " 	+ gambar + 
						"Input : " 		+ tgl_input + 
						"Status : " 	+ status_buku);
	
	String laporan = bukuActivity.updateBuku(viewId.getText().toString(),
			editKategori.getText().toString(), 
			editJudul.getText().toString(),
			editPengarang.getText().toString(),
			editTerbit.getText().toString(),
			editPenerbit.getText().toString(),
			editIsbn.getText().toString(),
			editJumlah.getText().toString(),
			editLokasi.getText().toString(),
			editGambar.getText().toString(),
			editInput.getText().toString(),
			editStatus.getText().toString());
	Toast.makeText(MainActivity.this, laporan, Toast.LENGTH_SHORT).show();
	finish();
	startActivity(getIntent());
	}
	});
		
	// Jika tidak ingin mengubah data pada Biodata
		builderEditBuku.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
		{
			
@Override
public void onClick(DialogInterface dialog, int which) {
	dialog.cancel();
	}
});
		builderEditBuku.show();
}
public void tambahBuku() {
	LinearLayout layoutInput = new LinearLayout(this);
	layoutInput.setOrientation(LinearLayout.VERTICAL);
	
	final EditText editKategori = new EditText(this);
	editKategori.setHint("Kategori");
	layoutInput.addView(editKategori);
	
	final EditText editJudul = new EditText(this);
	editJudul.setHint("Judul");
	layoutInput.addView(editJudul);
	
	final EditText editPengarang = new EditText(this);
	editPengarang.setHint("Pengarang");
	layoutInput.addView(editPengarang);
	
	final EditText editTerbit = new EditText(this);
	editTerbit.setHint("Terbit");
	layoutInput.addView(editTerbit);
	
	final EditText editPenerbit = new EditText(this);
	editPenerbit.setHint("Penerbit");
	layoutInput.addView(editPenerbit);
	
	final EditText editIsbn = new EditText(this);
	editIsbn.setHint("Isbn");
	layoutInput.addView(editIsbn);
	
	final EditText editJumlah = new EditText(this);
	editJumlah.setHint("Jumlah");
	layoutInput.addView(editJumlah);
	
	final EditText editLokasi = new EditText(this);
	editLokasi.setHint("Lokasi");
	layoutInput.addView(editLokasi);
	
	final EditText editGambar = new EditText(this);
	editGambar.setHint("Gambar");
	layoutInput.addView(editGambar);
	
	final EditText editInput = new EditText(this);
	editInput.setHint("Input");
	layoutInput.addView(editInput);
	
	final EditText editStatus = new EditText(this);
	editStatus.setHint("Status");
	layoutInput.addView(editStatus);
	
// Membuat AlertDialog untuk menambahkan data pada Biodata
AlertDialog.Builder builderInsertBuku= new AlertDialog.Builder(this);

//builderInsertBiodata.setIcon(R.drawable.webse);
	builderInsertBuku.setTitle("Insert Buku");
	builderInsertBuku.setView(layoutInput);
	builderInsertBuku.setPositiveButton("Insert", new
	DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
	String id_kategori 	= editKategori.getText().toString();
	String judul_buku 	= editJudul.getText().toString();
	String pengarang 	= editPengarang.getText().toString();
	String thn_terbit 	= editTerbit.getText().toString();
	String penerbit 	= editPenerbit.getText().toString();
	String isbn 		= editIsbn.getText().toString();
	String jumlah_buku 	= editJumlah.getText().toString();
	String lokasi 		= editLokasi.getText().toString();
	String gambar 		= editGambar.getText().toString();
	String tgl_input 	= editInput.getText().toString();
	String status_buku 	= editStatus.getText().toString();
	
	System.out.println(	"Kategori : " 		+ id_kategori + 
						"Judul : " 			+ judul_buku + 
						"Pengarang :"    	+ pengarang +
						"Terbit :"   		+ thn_terbit +
						"Penerbit : " 		+ penerbit +
						"Isbn : " 			+ isbn + 
						"Jumlah : " 		+ jumlah_buku + 
						"Lokasi : " 		+ lokasi + 
						"Gambar : " 		+ gambar + 
						"Input : " 			+ tgl_input + 
						"Status : " 		+ status_buku);
	
	String laporan = bukuActivity.insertBuku(id_kategori, 
											 judul_buku,
											 pengarang,
											 thn_terbit,
											 penerbit,
											 isbn,
											 jumlah_buku,
											 lokasi,
											 gambar,
											 tgl_input,
											 status_buku);
	Toast.makeText(MainActivity.this, laporan, Toast.LENGTH_SHORT).show();
	finish();
	startActivity(getIntent());
	}
});
	builderInsertBuku.setNegativeButton("Cancel", new
	DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
	dialog.cancel();
	}
});
	builderInsertBuku.show();
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
	}
}
