import model.Product;
import model.services.ProductsService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProductsService productsService= new ProductsService();

        try {
            productsService.listaDeprodcutosfromCSV("resources/inventory.csv");
            productsService.getListaDeProddcutos().forEach(product -> {

                if(product.getName().equals("Leche Colanta Deslactosada")) {
                    System.out.println("Nombre " + product.getName());
                    System.out.println("Descripcion " + product.getDescription());
                    System.out.println("Categoria " + product.getCategory());
                    System.out.println("Tags " + product.getTags());
                    System.out.println("Price " + product.getPrice());
                    System.out.println("url " + product.getImageUrl());
                    System.out.println();
                }



            });
        }  catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir un número: " + e.getMessage());
        }



    }
}