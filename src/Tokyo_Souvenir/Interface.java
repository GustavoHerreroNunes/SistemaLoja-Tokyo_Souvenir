package Tokyo_Souvenir;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Interface{

	public static void main(String[] args) {
		ImageIcon Logo = new ImageIcon("Imagens/Logo.png"), Car = new ImageIcon("Imagens/Compra.png");
		
		String Estoque[] = 
			   {"",
			    "Camiseta 'I Love Tokyo'",
				"Camiseta 'Monte Fuji'",
				"Camiseta 'Japão Minha Paixão'", 
				"Boné 'I Love Tokyo'", 
				"Boné 'Tokyo Tower'",
				"Caneca 'Tokyo!!!'", 
				"Caneca 'Japão'",
				"Caneca 'Japão 2020'",
				"Chaveiro Mario Bros",
				"Chaveiro Japão",
				"Chaveiro Sushi",
				"Chaveiro Onigiri",
				"Miniatura Monte Fugi",
				"Miniatura Tokyo Tower",
				"Porta Níquel Sushi"},
			   
			   Cards[] =
		   		{"Fernando Lopez",
		   		"Julio Cesar",
		   		"Alice Alcantara",
		   		"Maria Paula"},
		   		
		   	   Cards2[] =
	   			{"111000",
	   			"222000",
	   			"333000",
	   			"444000"},
		   		
		Carrinho[] = new String[15], Resp ="", Compra[] = {"Finalizar Compra", "Adicionar Produtos"}, Tit[] = new String[2], Opc[] = {"Reenviar", "Cancelar"}, q="a", m="a";
		float Pres[] =
			   {(float)29.90,
				(float)29.90,
				(float)29.90, 
				(float)15.00, 
				(float)17.90,
				(float)30.00,
				(float)30.00,
				(float)30.00,
				(float)8.00,
				(float)5.50, 
				(float)5.50,
				(float)5.50,
				(float)120.00,
				(float)100.00,
				(float)4.90}, 
	    Valor[] = new float[15], Total=0;
		short Quant[] = new short[15], x=0, y=0;
		int Cont =1, v =0;
		
		JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema de Compras da TokyoSouvenir\nLeve um pedacinho de Tokyo com você!!!", "TokyoSuvenir", -1, Logo);
		 
		while(x<15 && Cont !=0) {
			Carrinho[x] = (String) JOptionPane.showInputDialog(null, "Indique quais produtos deseja adicionar ao Carrinho(Lim: 14)\n", "TokyoSouvenir", -1, Car, Estoque, Estoque[0]);
			
			if(Carrinho[0]== "") {
				JOptionPane.showMessageDialog(null, "Obrigado pela visita e\nVolte sempre!!!", "TohyoSouvenir", -1, Logo);
				System.exit(0);
			}
			
			Quant[x] = Short.parseShort(JOptionPane.showInputDialog(null, "Quantas unidades serão compradas?", "TokyoSouvenir", 3));
			
			Cont = JOptionPane.showOptionDialog(null,"Oque fazer a seguir?", "TokyoSouvenir", -1, -1, Car, Compra, Compra[0]);
			
			
			x++;
		}
		
		while(y<15) {
			int p =0;
			
			for(int z =0; z<15; z++) {
				if(Carrinho[y] == Estoque[z+1])
					p = z;
			}
			
			Valor[y] = Pres[p] * Quant[y];
			Total += Valor[y];
			
			y++;
		}
		
		
			for(int z=0; z<15; z++) {
				if(Carrinho[z]==""|| Carrinho[z]== null)
					Resp +="\n";
				else
					Resp +=Carrinho[z] + ":\n" + Quant[z] + " Uni =>           R$:" + Valor[z] + "\n";
			}
			Resp +="------------------------------------\nTotal R$:" + Total;
			
			do {
				int r =0;
				
				Tit[0] = JOptionPane.showInputDialog(null, "Insira o nome do títular do cartão:", "TohyoSouvenir", 1);
				Tit[1] = JOptionPane.showInputDialog(null, "Agora insira o número do cartão de '" + Tit[0] + "'", "TohyoSouvenir", 1);
				
				for(int a=0; a<4; a++) {
					
					System.out.println(Cards[a]);
					System.out.println(Tit[0]);
					if(Cards[a] == Tit[0].intern())
						v++;
						
					System.out.println(v);
					
				}
				
				for(int a=0; a<4; a++) {
					
					System.out.println(Cards2[a]);
					System.out.println(Tit[1]);
					if(Cards2[a] == Tit[1].intern())
						v++;
						
					System.out.println(v);
					
				}
				
				if(v !=2) {
					r =JOptionPane.showOptionDialog(null, "Nome ou Cartão inválido(s), \nDeseja reenviar os dados?", "TohyoSouvenir", -1, 0, null, Opc, Opc[0]);
					v =0;
					if(r==1) { 
						JOptionPane.showMessageDialog(null, "Obrigado pela visita e\nVolte sempre!!!", "TohyoSouvenir", -1, Logo);
						System.exit(0);
					}
				}
			}while(v !=2);
			
			JOptionPane.showMessageDialog(null, Resp, "TokyoSouvenir", -1);
			JOptionPane.showMessageDialog(null, "Compra finalizada!!!\nObrigado e volte sempre!!!", "TokyoSouvenir", -1, Logo);
		
		

	}

}
