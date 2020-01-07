/*Este c�digo visa simular um sistema de compras de uma loja de souvenir
 * a fict�cia TokyoSouvenir, onde o usu�rio podera escolher produtos da loja
 * e "pagar" inserindo o nome do titular e n�mero do cart�o(ambos f�cticios)
 */


package Tokyo_Souvenir;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Interface_Compra {

	public static void main(String[] args) {
		ImageIcon Logo = new ImageIcon("Imagens/Logo.png"), Car = new ImageIcon("Imagens/Compra.png");//Atribuindo imagens (A logo de TokyoSouvenir e um �cone de compras) aos objetos em quest�o
		
		/*Array Unidimensional dos produtos oferecidos*/
		String Estoque[] = 
			   {"",
			    "Camiseta 'I Love Tokyo'",
				"Camiseta 'Monte Fuji'",
				"Camiseta 'Jap�o Minha Paix�o'", 
				"Bon� 'I Love Tokyo'", 
				"Bon� 'Tokyo Tower'",
				"Caneca 'Tokyo!!!'", 
				"Caneca 'Jap�o'",
				"Caneca 'Jap�o 2020'",
				"Chaveiro Mario Bros",
				"Chaveiro Jap�o",
				"Chaveiro Sushi",
				"Chaveiro Onigiri",
				"Miniatura Monte Fugi",
				"Miniatura Tokyo Tower",
				"Porta N�quel Sushi"},
			   
			   /*Array Bidimensional com Nomes e N�meros dos cart�es*/
			   Cards[][] =
		   		{{"Fernando Lopez","111000"}, 
		   		{"Julio Cesar","222000"}, 
		   		{"Alice Alcantara","333000"}, 
		   		{"Ana Paula","444000"}},
		   		
		Carrinho[] = new String[15], Resp ="", Tit[] = new String[2], 
		
		//Array Unidimensionais que ser�o utilizados para futuros bot�es n� c�digo
		Compra[] = {"Finalizar Compra", "Adicionar Produtos"},  Opc[] = {"Reenviar", "Cancelar"};
		
		
		//Array Unidimensional com pre�os dos produtos oferecidos
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
		
		
		JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema de Compras da TokyoSouvenir\nLeve um pedacinho de Tokyo com voc�!!!", "TokyoSuvenir", -1, Logo);
		 
		/*Enquanto a quantia de produtos selecionados forem menores que 15 e Cont indicar que o usu�rio quer adquirir novos itens*/
		while(x<15 && Cont ==1) {
			Carrinho[x] = (String) JOptionPane.showInputDialog(null, "Indique quais produtos deseja adicionar ao Carrinho(Lim: 14)\n", "TokyoSouvenir", -1, Car, Estoque, Estoque[0]);
			
			/*Se N�o for selecionado nenhum item o sistema � encerrado*/
			if(Carrinho[0]== "") {
				JOptionPane.showMessageDialog(null, "Obrigado pela visita e\nVolte sempre!!!", "TohyoSouvenir", -1, Logo);
				System.exit(0);
			}
			
			Quant[x] = Short.parseShort(JOptionPane.showInputDialog(null, "Quantas unidades ser�o compradas?", "TokyoSouvenir", 3));
			
			Cont = JOptionPane.showOptionDialog(null,"Oque fazer a seguir?", "TokyoSouvenir", -1, -1, Car, Compra, Compra[0]);
			
			
			x++;
		}
		
		/*Enquanto n�o foram verificados os 14 slotes para produtos*/
		while(y<15) {
			int p =0;
			
			/*Fazendo a compara��o entre o item selecionado na posi��o 'y' e todo o estoque*/
			for(int z =0; z<15; z++) {
				if(Carrinho[y] == Estoque[z+1])//'z+1' � necessario pelo fato de apenas em 'Estoque' a primeira posi��o do Array esta vazia para fins visuais
					p = z;
			}
			
			Valor[y] = Pres[p] * Quant[y];//Valor final da compra do(s) item(ns) 'y'
			Total += Valor[y];
			
			y++;
		}
		
			/*Adicionando dados de compra de cada item a uma String para facilitar o informe ao usu�rio*/
			for(int z=0; z<15; z++) {
				if(Carrinho[z]==""|| Carrinho[z]== null)//Se a posi��o do carrinho estiver vazia apenas 'pula-se' uma linha
					Resp +="\n";
				else//Se n�o adicionam-se os respectivos dados referentes ao item 
					Resp +=Carrinho[z] + ":\n" + Quant[z] + " Uni =>           R$:" + Valor[z] + "\n";
			}
			Resp +="------------------------------------\nTotal R$:" + Total;
			
			JOptionPane.showMessageDialog(null, Resp, "TokyoSouvenir", -1);//Valor final da compra e de cada item � informado ao Usu�rio
			
			/*Pe�a e processe o nome do t�tuar e n�mero do cart�o...*/
			do {
				int r =0;
				v =0;
				
				Tit[0] = JOptionPane.showInputDialog(null, "Insira o nome do t�tular do cart�o:", "TohyoSouvenir", 1);
				Tit[1] = JOptionPane.showInputDialog(null, "Agora insira o n�mero do cart�o de '" + Tit[0] + "'", "TohyoSouvenir", 1);
				
				//Verificando se algum dos dados informados constam no sistema
				for(int a=0; a<4; a++) {
					
					for(int s=0; s<2; s++) {
						
						/*Se a informa��o em quest�o consta no sistema*/
						if(Cards[a][s] == Tit[s].intern()) {
							v++;
							g[s] = a;
						}
						
					}
				}
				
				/*Se a s informa��es passadas n�o constarem no sistema, ou n�o peretencerem ao mesmo cadastro*/
				if(v !=2 || g[0] != g[1]) {
					r =JOptionPane.showOptionDialog(null, "Nome e/ou Cart�o inv�lido(s), \nDeseja reenviar os dados?", "TohyoSouvenir", -1, 0, null, Opc, Opc[0]);
					if(r==1) { //Se n�o quiser reenviar os dados
						JOptionPane.showMessageDialog(null, "Obrigado pela visita e\nVolte sempre!!!", "TohyoSouvenir", -1, Logo);
						System.exit(0);
					}
				}
			}while(v !=2 ||g[0] != g[1]);//...enquanto estes n�o constarem no sistema, ou n�o peretencerem ao mesmo cadastro
			
			
			JOptionPane.showMessageDialog(null, "Compra Realizada com Sucesso!!!\nObrigado e volte sempre!!!", "TokyoSouvenir", -1, Logo);
		
		

	}

}
