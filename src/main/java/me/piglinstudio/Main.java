package me.piglinstudio;

import com.github.javafaker.Faker;
import me.piglinstudio.Players.CreatePlayersList;
import me.piglinstudio.Players.Models.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static me.piglinstudio.Players.CreatePlayersList.playersList;

public class Main {
    public static Faker faker = new Faker();

    public static void main(String[] args) {
        CreatePlayersList.execute();
        createExelFile(playersList);
        System.out.println("Файл был создан!");
    }

    public static void createExelFile(List<Player> players) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Players");

        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Player Name");
        headerRow.createCell(1).setCellValue("Points");

        int rowNum = 1;
        for (Player player : players) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(player.getPlayerName());
            row.createCell(1).setCellValue(player.getPoints());
        }

        try (FileOutputStream fileOut = new FileOutputStream("players.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException ignored) {

        } finally {
            try {
                workbook.close();
            } catch (IOException ignored) {

            }
        }
    }
}