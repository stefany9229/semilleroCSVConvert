package model.services;

import model.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductsService {

    private List<Product> listaDeProddcutos;

    public ProductsService() {
        this.listaDeProddcutos= new ArrayList<>();
    }

    public List<Product> getListaDeProddcutos() {
        return new ArrayList<>(listaDeProddcutos);
    }


    public void setListaDeProddcutos(List<Product> listaDeProddcutos) {
        this.listaDeProddcutos = listaDeProddcutos;
    }

    public void listaDeprodcutosfromCSV(String path) throws FileNotFoundException, NumberFormatException {
        File file = new File(path);
        Scanner fileScanner = new Scanner(file);
        // Saltar el encabezado del CSV
        fileScanner.nextLine();
        while (fileScanner.hasNextLine()) {
            Product producto = new Product();
            String line = fileScanner.nextLine();
            String[] productInfo = line.split(",");

            producto.setName(productInfo[0]);
            producto.setDescription(productInfo[1]);
            producto.setCategory( productInfo[2]);
            producto.setTags(productInfo[3]);

            // Para el precio, verifica primero si el índice existe y si no está vacío
            if (productInfo.length > 4 && !productInfo[4].trim().isEmpty()) {
                try {
                    producto.setPrice(Float.parseFloat(productInfo[4].trim()));
                } catch (NumberFormatException e) {
                    producto.setPrice(null);
                }
            } else {
                producto.setPrice(null); // Si el campo está vacío o fuera de índice, asigna null
            }

            // Para la URL de la imagen, verifica si el índice existe
            producto.setImageUrl(productInfo.length > 5 ? productInfo[5] : null);

            // Agrega el producto a la lista
            listaDeProddcutos.add(producto);

            

        }
        fileScanner.close(); // No olvides cerrar el Scanner
    }
}
