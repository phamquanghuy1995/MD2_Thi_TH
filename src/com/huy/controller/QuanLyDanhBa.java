package com.huy.controller;


import com.huy.model.DanhBa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class QuanLyDanhBa {
    List<DanhBa> danhBas = new ArrayList<>();

    public QuanLyDanhBa() {
        File file = new File("contact.txt");
        if (file.exists()) {
            try {
                readFile("contact.txt");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayALL(){
        for (DanhBa danhBa: danhBas
        ) {
            System.out.println(danhBa);
        }
    }

    public void Themmoi(DanhBa danhBa){
        danhBas.add(danhBa);
    }

    public int getIndexByName(String name){
        int index = -1;
        for (int i = 0; i < danhBas.size(); i++) {
            if(danhBas.get(i).getName().equals(name)){
                index = i;
            }
        }
        return index;
    }

    public DanhBa getInfoByName(String name){
        DanhBa danhBaGetByName = new DanhBa();
        for (int i = 0; i < danhBas.size(); i++) {
            if(danhBas.get(i).getName().equals(name)){
                danhBaGetByName = danhBas.get(i);
                break;
            }
        }
        return danhBaGetByName;
    }

    public void update(int index,DanhBa changePhone){
        danhBas.set(index, changePhone);
    }

    public void delete(int index){
        danhBas.remove(index);
    }

    public int getSize(){
        return danhBas.size();
    }

    public boolean checkExistByName(String checkName){
        boolean isExsit = false;
        for (int i = 0; i < danhBas.size(); i++) {
            if(danhBas.get(i).getName().equals(checkName)){
                isExsit = true;
                break;
            }
        }
        return isExsit;
    }

    public void writeFile(String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(this.danhBas);
    }

    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream is = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(is);
        this.danhBas = (List<DanhBa>) ois.readObject();
    }
}
