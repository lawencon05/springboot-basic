package com.lawencon.springboot.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author lawencon05
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mahasiswa {

	private String nim;
	private String nama;
	private List<Matkul> matkul;
	private LocalDate waktuMasuk;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime waktuMasukTime;

	public LocalDateTime getWaktuMasukTime() {
		return waktuMasukTime;
	}

	public void setWaktuMasukTime(LocalDateTime waktuMasukTime) {
		this.waktuMasukTime = waktuMasukTime;
	}

	public LocalDate getWaktuMasuk() {
		return waktuMasuk;
	}

	public void setWaktuMasuk(LocalDate waktuMasuk) {
		this.waktuMasuk = waktuMasuk;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public List<Matkul> getMatkul() {
		return matkul;
	}

	public void setMatkul(List<Matkul> matkul) {
		this.matkul = matkul;
	}

}
