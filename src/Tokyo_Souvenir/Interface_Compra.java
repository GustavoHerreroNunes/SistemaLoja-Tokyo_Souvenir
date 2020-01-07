/*Este código visa simular um sistema de compras de uma loja de souvenir
 * a fictícia TokyoSouvenir, onde o usuário podera escolher produtos da loja
 * e "pagar" inserindo o nome do titular e número do cartão(ambos fícticios)
 */


package Tokyo_Souvenir;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Interface_Compra {

	public static void main(String[] args) {
		ImageIcon Logo = new ImageIcon("Imagens/Logo.png"), Car = new ImageIcon("Imagens/Compra.png");//Atribuindo imagens (A logo de TokyoSouvenir e um ícone de compras) aos objetos em questão
		
		/*Array Unidimensional dos produtos oferecidos*/
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
			   
			   /*Array Bidimensional com Nomes e Números dos cartões*/
			   Cards[][] =
		   		{{"Fernando Lopez","111000"}, 
		   		{"Julio Cesar","222000"}, 
		   		{"Alice Alcantara","333000"}, 
		   		{"Ana Paula","444000"}},
		   		
		Carrinho[] = new String[15], Resp ="", Tit[] = new String[2], 
		
		//Array Unidimensionais que serão utilizados para futuros botões nó código
		Compra[] = {"Finalizar Compra", "Adicionar Produtos"},  Opc[] = {"Reenviar", "Cancelar"};
		
		
		//Array Unidimensional com preços dos produtos oferecidos
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
	
		int Cont =1, v =0, g[] = new int [2];
		
		
		JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema de Compras da TokyoSouvenir\nLeve um pedacinho de Tokyo com você!!!", "TokyoSuvenir", -1, Logo);
		 
		/*Enquanto a quantia de produtos selecionados forem menores que 15 e Cont indicar que o usuário quer adquirir novos itens*/
		while(x<15 && Cont ==1) {
			Carrinho[x] = (String) JOptionPane.showInputDialog(null, "Indique quais produtos deseja adicionar ao Carrinho(Lim: 14)\n", "TokyoSouvenir", -1, Car, Estoque, Estoque[0]);
			
			/*Se Não for selecionado nenhum item o sistema é encerrado*/
			if(Carrinho[0]== "") {
				JOptionPane.showMessageDialog(null, "Obrigado pela visita e\nVolte sempre!!!", "TohyoSouvenir", -1, Logo);
				System.exit(0);
			}
			
			Quant[x] = Short.parseShort(JOptionPane.showInputDialog(null, "Quantas unidades serão compradas?", "TokyoSouvenir", 3));
			
			Cont = JOptionPane.showOptionDialog(null,"Oque fazer a seguir?", "TokyoSouvenir", -1, -1, Car, Compra, Compra[0]);
			
			
			x++;
		}
		
		/*Enquanto não foram verificados os 14 slotes para produtos*/
		while(y<15) {
			int p =0;
			
			/*Fazendo a comparação entre o item selecionado na posição 'y' e todo o estoque*/
			for(int z =0; z<15; z++) {
				if(Carrinho[y] == Estoque[z+1])//'z+1' é necessario pelo fato de apenas em 'Estoque' a primeira posição do Array esta vazia para fins visuais
					p = z;
			}
			
			Valor[y] = Pres[p] * Quant[y];//Valor final da compra do(s) item(ns) 'y'
			Total += Valor[y];
			
			y++;
		}
		
			/*Adicionando dados de compra de cada item a uma String para facilitar o informe ao usuário*/
			for(int z=0; z<15; z++) {
				if(Carrinho[z]==""|| Carrinho[z]== null)//Se a posição do carrinho estiver vazia apenas 'pula-se' uma linha
					Resp +="\n";
				else//Se não adicionam-se os respectivos dados referentes ao item 
					Resp +=Carrinho[z] + ":\n" + Quant[z] + " Uni =>           R$:" + Valor[z] + "\n";
			}
			Resp +="------------------------------------\nTotal R$:" + Total;
			
			JOptionPane.showMessageDialog(null, Resp, "TokyoSouvenir", -1);//Valor final da compra e de cada item é informado ao Usuário
			
			/*Peça e processe o nome do títuar e número do cartão...*/
			do {
				int r =0;
				v =0;
				
				Tit[0] = JOptionPane.showInputDialog(null, "Insira o nome do títular do cartão:", "TohyoSouvenir", 1);
				Tit[1] = JOptionPane.showInputDialog(null, "Agora insira o número do cartão de '" + Tit[0] + "'", "TohyoSouvenir", 1);
				
				//Verificando se algum dos dados informados constam no sistema
				for(int a=0; a<4; a++) {
					
					for(int s=0; s<2; s++) {
						
						/*Se a informação em questão consta no sistema*/
						if(Cards[a][s] == Tit[s].intern()) {
							v++;
							g[s] = a;
						}
						
					}
				}
				
				/*Se a s informações passadas não constarem no sistema, ou não peretencerem ao mesmo cadastro*/
				if(v !=2 || g[0] != g[1]) {
					r =JOptionPane.showOptionDialog(null, "Nome e/ou Cartão inválido(s), \nDeseja reenviar os dados?", "TohyoSouvenir", -1, 0, null, Opc, Opc[0]);
					if(r==1) { //Se não quiser reenviar os dados
						JOptionPane.showMessageDialog(null, "Obrigado pela visita e\nVolte sempre!!!", "TohyoSouvenir", -1, Logo);
						System.exit(0);
					}
				}
			}while(v !=2 ||g[0] != g[1]);//...enquanto estes não constarem no sistema, ou não peretencerem ao mesmo cadastro
			
			
			JOptionPane.showMessageDialog(null, "Compra Realizada com Sucesso!!!\nObrigado e volte sempre!!!", "TokyoSouvenir", -1, Logo);
		
		

	}

}
