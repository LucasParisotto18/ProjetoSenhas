/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import controller.AtendimentoController;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AtendimentoModel;
import org.junit.Test;

/**
 *
 * @author Lucas
 */
public class TesteController { //teste project na aba run
    
   @Test 
   public void testeController(){ //vai olhar td o projeto ate achar um @Test, vai executar esse metodo, e ver se o projeto tem algum erro.
       AtendimentoModel atendimentoModel = new AtendimentoModel();
       
       atendimentoModel.setNome("Test " +  new Date());
       atendimentoModel.setData(new Date());
       
       AtendimentoController atendimentoController = new AtendimentoController();
       atendimentoController.save(atendimentoModel);
       
       Integer cod = atendimentoModel.getId();
       
       if (cod != null){
           System.out.println("Registro inserido" + atendimentoModel.toString()); //registro inserido + o registro
       } else {
           System.err.println("Falha ao inserir registro");
       }
   } 
   
   @Test
   public void testGetAll(){
      AtendimentoController atendimentoController = new AtendimentoController();
      
      List<AtendimentoModel> atendimentoModels = atendimentoController.getAll();
      
       for (AtendimentoModel atendimentoModel : atendimentoModels) {
           System.out.println("Ok" + atendimentoModel.toString());
           
       }
   }
   @Test
   public void testGetFirst(){
       AtendimentoController atendimentoController = new AtendimentoController();
       try {
           AtendimentoModel atendimentoModel = atendimentoController.getFirst();
           if (atendimentoModel == null){
               System.err.println("Erro no getFirst");  
           } else {
              System.out.println("Ok"); 
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TesteController.class.getName()).log(Level.SEVERE, null, ex);
       }
       

     
   }
   @Test
   public void testGetNextList(){
     AtendimentoController atendimentoController = new AtendimentoController();
       try {
           
           List<AtendimentoModel> atendimentoModel = atendimentoController.getNextList();
           if (atendimentoModel.size() != 3){
               System.err.println("Erro no getNextList");  
           } else {
              System.out.println("Ok"); 
           }
           
       } catch (SQLException ex) {
           Logger.getLogger(TesteController.class.getName()).log(Level.SEVERE, null, ex);
       }   
   }
   @Test
   public void testGetChamadosList(){
      AtendimentoController atendimentoController = new AtendimentoController();
       try {
           
           List<AtendimentoModel> atendimentoModel = atendimentoController.getNextList();
           if (atendimentoModel.size() != 3){
               System.err.println("Erro no getGetChamadosList");  
           } else {
              System.out.println("Ok"); 
           }   
       } catch (SQLException ex) {
           Logger.getLogger(TesteController.class.getName()).log(Level.SEVERE, null, ex);
       }        
   }
   @Test
   public void testUpdateJaAtendido(){
       AtendimentoController atendimentoController = new AtendimentoController();
       try {
           AtendimentoModel atendimentoModel = atendimentoController.getChamado();
           atendimentoController.updateJaAtendido();
           
       if (atendimentoModel.getStatus() == 2){
           System.out.println("Ok");
           } else {
             System.err.println("Erro no testUpdateJaAtendido");  
           }
        atendimentoModel.setStatus(1);
        atendimentoController.update(atendimentoModel);
       
       } catch (SQLException ex) {
           Logger.getLogger(TesteController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   @Test
   public void testUpdated(){
       
       
       AtendimentoController atendimentoController = new AtendimentoController();
       try {
           AtendimentoModel atendimentoModel = atendimentoController.getChamado();
           String nomeAntigo = atendimentoModel.getNome();
           
           atendimentoModel.setNome("TesteUpdate");
           atendimentoController.update(atendimentoModel);
           
           String novoNome = atendimentoModel.getNome();
           
       if (nomeAntigo == novoNome){
         System.err.println("Erro no testUpdateJaAtendido");  
        } else {
         System.out.println("Ok"); 
           }     
       } catch (SQLException ex) {
           Logger.getLogger(TesteController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}
