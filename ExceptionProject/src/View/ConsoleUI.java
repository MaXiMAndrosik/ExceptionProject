package ExeptionProject.ExceptionProject.src.View;

import java.io.FileWriter;
import java.io.IOException;

import ExeptionProject.ExceptionProject.src.service.Service;

public class ConsoleUI {
    private Service service;
    private String fileName;
    private boolean flag = true;

    public ConsoleUI() {
        service = new Service(this);
    }

    public void start() {

        while (flag) {
            System.out.println("Заполните следующие поля данных через пробел:");
            System.out.println(
                    "Фамилия Имя Отчество Дата_рождения(dd.mm.yyyy) Номер_телефона(только цифры) Пол(m или f)");
            String[] input = service.inputData();
            try {
                service.addData(input);
                fileName = System.getProperty("user.dir") + "\\" + service.getName();
                flag = false;
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }            
        }

        try (FileWriter writer = new FileWriter(fileName + ".txt", true);) {
            writer.write(service.getInfo());
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println("Ошибка записи данных в файл");
            e.printStackTrace();
        }
    }

}
