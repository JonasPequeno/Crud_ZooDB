package com.ifpb.model;

import java.util.List;
import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import org.zoodb.jdo.ZooJdoHelper;

/**
 *
 * @author jonas
 */
public class App {
    
    	private static final String DB_FILE = "banco.zdb";
	private PersistenceManager pm;
        
        public static void main(String[] args) {
            App app = new App();    
            app.insert();
            app.getPedidos();     
            app.clientesComprou(1);
        }
        
       public void insert () {
            pm = ZooJdoHelper.openOrCreateDB(DB_FILE);
            pm.currentTransaction().begin();
            
            PessoaJuridica cliente1 = new PessoaJuridica("12312313", 1000,4,"Pequeno");
            
            Produto p1 = new Produto(1, "Cerveja Itaipava", 7);
            Produto p2 = new Produto(2, "Vinho Quinta Do Morgado", 13);
            Produto p3 = new Produto(3, "Cachaça 51 Ouro", 17);
            Produto p4 = new Produto(4, "Vodka absolut",110);
            
            ItemPedido item1 = new ItemPedido(1,12,p1);
            ItemPedido item2 = new ItemPedido(2,2,p2);
            ItemPedido item3 = new ItemPedido(3,2,p3);
            ItemPedido item4 = new ItemPedido(4,1,p4);
                       
            Pedido pedido = new Pedido(4, cliente1);
            
            pedido.addItens(item1);
            pedido.addItens(item2);
            pedido.addItens(item3);
            pedido.addItens(item4);
                       
            pm.makePersistent(pedido);
            
            pm.currentTransaction().commit();            
       }
       
       public void getPedidos () {
            pm = ZooJdoHelper.openDB(DB_FILE);
            pm.currentTransaction().begin();
            Extent<Pedido> pedidos = pm.getExtent(Pedido.class);
            System.out.println(pedidos);
            System.out.println("O conjunto de todos os pedidos :");
            for (Pedido pedido : pedidos) {
                System.out.println("Pedido : " + pedido.toString());
            }
           
       }
       
       public void getPedidoByCodidoCliente (int codigo) {
                      
            pm = ZooJdoHelper.openDB(DB_FILE);
            pm.currentTransaction().begin();
            
            Extent<Pedido> pedidos = pm.getExtent(Pedido.class);
            
            System.out.println("Todos os pedidos dado o código de um cliente :");
            
            for (Pedido pedido : pedidos) {                
                if(pedido.getCliente().getCodigo() == codigo ) {
                    System.out.println("Pedidos :" + pedido.getItens().toString());
                }
            }
                                        
       }
       
       public void clientesComprou (int codigoProduto) {
           
           pm = ZooJdoHelper.openDB(DB_FILE);
           pm.currentTransaction().begin();           
                     
           Extent<Pedido> pedidos = pm.getExtent(Pedido.class);
           
           System.out.println("Todos os pedidos dado o código de um cliente :");
            
            for (Pedido pedido : pedidos) {                 
                for(ItemPedido p : pedido.getItens()) {
                    if(p.getCodigo() == codigoProduto) {
                        System.out.println("Cliente :" + pedido.getCliente().getNome());
                    }
                }
            }
           
       }
       
}
