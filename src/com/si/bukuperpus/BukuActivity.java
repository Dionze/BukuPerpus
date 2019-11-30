package com.si.bukuperpus;

import com.si.bukuperpus.KoneksiActivity;

public class BukuActivity extends KoneksiActivity {
// sourcecode untuk URL ->URL menggunakan IP address default eclipse
	String URL = "http://192.168.8.101/Perpustakaan/server.php";
	String url = "";
	String response = "";
//menampilkan kategori dari database
public String tampilBuku() {
	try{
		url = URL + "?operasi_buku=view";
		System.out.println("URL Tampil Buku : " + url);
		response = call(url);
		}
	catch(Exception e) {
	}
	return response;
	}
//memasukan biodata baru ke dlama database
public String insertBuku(String id_kategori,
						 String judul_buku,
						 String pengarang,
						 String thn_terbit,
						 String penerbit,
						 String isbn,
						 String jumlah_buku,
						 String lokasi,
						 String gambar,
						 String tgl_input,
						 String status_buku) {
	try{
		url = URL + "?operasi_buku=insert&id_kategori=" + id_kategori + 
										"&judul_buku=" 	+ judul_buku + 
										"&pengarang=" 	+ pengarang + 
										"&thn_terbit=" 	+ thn_terbit + 
										"&penerbit=" 	+ penerbit + 
										"&isbn=" 		+ isbn + 
										"&jumlah_buku=" + jumlah_buku + 
										"&lokasi=" 		+ lokasi + 
										"&gambar=" 		+ gambar + 
										"&tgl_input=" 	+ tgl_input + 
										"&status_buku=" + status_buku;
		System.out.println("URL Insert Buku : " + url);
		response = call(url);
	}
	catch (Exception e){
	}
	return response;
	}
//melihat biodata berdasarkan ID
public String getBukuById (int id_buku) {
	try{
		url=URL + "?operasi_buku=get_buku_by_id&id_buku=" + id_buku;
		System.out.println("URL Insert Buku : " + url);
		response = call(url);
		}
	catch(Exception e) {
	}
	return response;
	}
//mengubah isi biodata
public String updateBuku(String id_buku,
						 String id_kategori, 
						 String judul_buku,
						 String pengarang,
						 String thn_terbit,
						 String penerbit,
						 String isbn,
						 String jumlah_buku,
						 String lokasi,
						 String gambar,
						 String tgl_input,
						 String status_buku) {
	try{
		url=URL + "?operasi_buku=update&id_buku=" 		+ id_buku + 
									  "&id_kategori=" 	+ id_kategori + 
									  "&judul_buku=" 	+ judul_buku + 
									  "&pengarang=" 	+ pengarang + 
									  "&thn_terbit=" 	+ thn_terbit + 
									  "&penerbit=" 		+ penerbit + 
									  "&isbn=" 			+ isbn + 
									  "&jumlah_buku=" 	+ jumlah_buku + 
									  "&lokasi=" 		+ lokasi + 
									  "&gambar=" 		+ gambar + 
									  "&tgl_input=" 	+ tgl_input + 
									  "&status_buku=" 	+ status_buku;
		System.out.println("URL Update Buku : " + url);
		response = call(url);
		}
	catch(Exception e){
	}
	return response;
	}
//coding hapus
public String deleteBuku (int id_buku) {
	try{
		url = URL + "?operasi_buku=delete&id_buku=" + id_buku;
		System.out.println("URL Hapus Buku : " + url);
		response = call(url);
		}
	catch(Exception e){
	}
	return response;
	}
}