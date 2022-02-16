package com.huy;


import com.huy.controller.QuanLyDanhBa;
import com.huy.model.DanhBa;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private static Scanner scanner = new Scanner(System.in);


    public  void run() {
        QuanLyDanhBa quanLyDanhBa = new QuanLyDanhBa();
        int choice  = -1;
        do{
            menu();
            choice = scanner.nextInt();
            switch (choice){
                case 1:{
                    showDisplayAll(quanLyDanhBa);
                    break;
                }
                case 2:{
                    showAddNew(quanLyDanhBa);
                    break;
                }
                case 3:{
                    showUpdateByName(quanLyDanhBa);
                    break;
                }
                case 4:{
                    showDelete(quanLyDanhBa);
                    break;
                }
                case 5:{
                    showSearchByName(quanLyDanhBa);
                    break;
                }

                case 6:{
                    showReadFile(quanLyDanhBa);
                    break;
                }

                case 7:{
                    showWriteFile(quanLyDanhBa);
                    break;
                }

            }
        }while (choice !=8);
    }

    private void showSearchByName(QuanLyDanhBa quanLyDanhBa) {
        System.out.println("---Tìm kiếm liên lạc theo tên---");
        System.out.println("Nhập tên bạn muốn tìm kiếm");
        String searchName = scanner.nextLine();
        boolean isExist = quanLyDanhBa.checkExistByName(searchName);
        if(isExist){
            DanhBa foundPhoneContact = quanLyDanhBa.getInfoByName(searchName);
            System.out.println(foundPhoneContact);
        }else {
            System.out.println("Không tìm thấy tên liên lạc");
        }
    }

    private void showWriteFile(QuanLyDanhBa quanLyDanhBa) {
        System.out.println("---Ghi vào file---");
        System.out.println("---Nhập tên file muốn ghi---");
        String filePath = scanner.nextLine();
        try {
            quanLyDanhBa.writeFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showReadFile(QuanLyDanhBa quanLyDanhBa) {
        System.out.println("--Đọc một danh sách có sẵn---");
        System.out.println("Nhập tên file bạn muốn đọc");
        String filePath = scanner.nextLine();
        try {
            quanLyDanhBa.readFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(QuanLyDanhBa quanLyDanhBa) {
        System.out.println("--Xóa một liên lạc---");
        System.out.println("Nhập tên liên lạc cần xóa");
        String deleteName = scanner.nextLine();
        boolean isExist = quanLyDanhBa.checkExistByName(deleteName);
        if(isExist){
            int index = quanLyDanhBa.getIndexByName(deleteName);
            quanLyDanhBa.delete(index);
            try {
                quanLyDanhBa.writeFile("contact.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Xóa liên lạc thành công");
        }else   {
            System.out.println("Tên liên lạc không tồn tại");
        }
    }

    private void showUpdateByName(QuanLyDanhBa quanLyDanhBa) {
        System.out.println("---Cập nhật danh bạ---");
        System.out.println("Nhập tên liên lạc cần cập nhật");
        String changeContactName = scanner.nextLine();
        boolean isExist = quanLyDanhBa.checkExistByName(changeContactName);
        if(isExist){
            int index = quanLyDanhBa.getIndexByName(changeContactName);
            System.out.println("---Thay đổi thông tin---");
            DanhBa changePhone = inputInfo();
            quanLyDanhBa.update(index,changePhone);
            try {
                quanLyDanhBa.writeFile("contact.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Thay đổi thông tin thành công");
        }else{
            System.out.println("Tên liên lạc không đúng");
        }
    }

    private void showDisplayAll(QuanLyDanhBa quanLyDanhBa) {
        int size = quanLyDanhBa.getSize();
        if(size == 0){
            System.out.println("Danh sách liên lạc rỗng");
        }else {
            System.out.println("--Danh sách các liên lạc có trong danh bạ---");
            quanLyDanhBa.displayALL();
        }
    }

    private static DanhBa inputInfo() {

        System.out.println("Nhập tên:");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("Nhập số điện thoại");

        String phoneNumber = scanner.nextLine();
        System.out.println("Nhập nhóm liên lạc");
        String group = scanner.nextLine();
        System.out.println("Nhập giới tính");
        String gender = scanner.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("Nhập ngày sinh");
        String birthday = scanner.nextLine();
        System.out.println("Nhập email:");
        String email = scanner.nextLine();

        DanhBa danhBa = new DanhBa(phoneNumber,group,name,gender,address,birthday,email);
        return danhBa;
    }

    private void showAddNew(QuanLyDanhBa quanLyDanhBa){
        System.out.println("---Thêm một liên lạc mới---");
        DanhBa danhBa = inputInfo();
        quanLyDanhBa.Themmoi(danhBa);
        try {
            quanLyDanhBa.writeFile("contact.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Thêm liên lạc mới thành công");
    }

    public static void menu(){
        System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ---");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhập");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng:");
    }
}