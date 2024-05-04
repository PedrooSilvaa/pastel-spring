package com.edu.senaisp.Pastel.repository;

import com.edu.senaisp.Pastel.model.Pastel;

import java.util.List;

public interface ICrud {

    public List<Pastel> list();

    public Pastel findById(int id);

    public List<Pastel> insert(Pastel pastel);

    public Pastel update(Pastel pastel, int id);

    public void delete(int id);

}
