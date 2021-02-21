package br.com.solondiego.controller;

import br.com.solondiego.model.Produtos;
import br.com.solondiego.model.Urls;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HttpsURLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author Solon Diego
 */
public class Controle {

    public String consultaApi(int codigo) {

        Produtos p = new Produtos();
        Urls u = new Urls("D:\\urls.txt");

        try {
            HttpsURLConnection conn = (HttpsURLConnection) new URL(u.getUrlapi() + codigo).openConnection();
            conn.setRequestProperty(u.getAut(), u.getToken());
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + u.getUrlapi());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }

            conn.disconnect();

            JSONParser parser = new JSONParser();
            JSONObject data_obj = (JSONObject) parser.parse(output);
            JSONObject prod = (JSONObject) data_obj.get("produto");

            p.setId((Object) prod.get("codigoAgrupador"));
            p.setTitle((Object) prod.get("titulo"));
            p.setDescription((Object) prod.get("descricao"));
            p.setAvailability("in stock");
            p.setInventory(20);
            p.setCondition("new");
            p.setPrice(Double.parseDouble((String) prod.get("precoSite")));
            p.setBrand((Object) prod.get("marca"));
            p.setGoogle_product_category((Object) prod.get("categoria") + " > " + (Object) prod.get("subcategoria"));
            p.setSale_price("");
            p.setSale_price_effective_date("");
            p.setItem_group_id("");
            p.setGender("");
            p.setColor("");
            p.setSize("");
            p.setAge_group("");
            p.setMaterial("");
            p.setPattern("");
            p.setProduct_type("");
            p.setShipping("");
            p.setShipping_weight("");

            JSONArray atributos = (JSONArray) prod.get("atributos");

            Iterator i = atributos.iterator();

            while (i.hasNext()) {
                JSONObject slide = (JSONObject) i.next();
                p.setImage_link((String) slide.get("fotoprincipal"));
            }

            Document url = Jsoup.connect(u.getUrlsite() + p.getId()).get();
            Elements href = url.select("a.csb-wrapper");
            String link = href.attr("href");
            p.setLink(u.getPagina() + link);

        } catch (IOException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        } catch (org.json.simple.parser.ParseException ex) {
            Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p.toString();

    }
}
