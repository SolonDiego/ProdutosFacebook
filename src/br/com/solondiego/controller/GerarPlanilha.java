package br.com.solondiego.controller;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Solon Diego
 */
public class GerarPlanilha {

    Date hoje = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss");

    Controle c = new Controle();

    public GerarPlanilha(int[] codigo) {

        try {
            
            System.out.println("Criando arquivo...");
            BufferedWriter gravarArq = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\Ofertas_Facebook_" + sdf.format(hoje) + ".csv"), "UTF-8"));

            gravarArq.write("id,title,description,availability,inventory,condition,price,link,image_link,brand,google_product_category,sale_price,sale_price_effective_date,item_group_id,gender,color,size,age_group,material,pattern,product_type,shipping,shipping_weight\n");
            for (int i = 0; i < codigo.length; i++) {
                gravarArq.write(c.consultaApi(codigo[i]) + "\n");;
                System.out.print((i + 1) + "... ");
            }
            gravarArq.close();

            System.out.println("\nArquivo criado com sucesso!");

        } catch (IOException ex) {
            Logger.getLogger(GerarPlanilha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
