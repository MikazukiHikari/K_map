import java.util.*;
import java.util.ArrayList;
import java.io.*;

 public class Kmap{
	public static void main(String args[]){
Scanner input=new Scanner(System.in);
	   try{
	   Scanner inputstream=new Scanner(new FileInputStream("input.txt"));
       PrintWriter writer = new PrintWriter(new FileOutputStream("output.txt")); 
	   // PrintWriter writer = new PrintWriter(new File("output.txt"))	   
//================================================================================//
     String[] K=new String[16];
	 String[] x=new String[16];
	 int[] solve={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	 int[] rule={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	 String[] R=new String[16];
	 int gn=0;
	 int number=0;
    String karnaughmap = inputstream.nextLine();
    String[] k=karnaughmap.split("\\+");//將輸入的以"+"分割並存入array k
	int r1=0;
	int r2=0;
	int totalVariablesCount=0;
	boolean[] allK=new boolean[80];//將80種可能(3^4-1)給編號,參考附錄的對照表
	for(int i=0;i<=15;i++){
		K[i]="0";
	}
	for(int ii=0;ii<=15;ii++){
		x[ii]="0";
	}
    for(int j=0;j<=k.length-1;j++){//有d則4 variable
		r1=r1+k[j].indexOf("d");
	}
     if(r1+k.length>0){
       totalVariablesCount=4;
	 }else{
		 for(int j=0;j<=k.length-1;j++){//沒有d有c則3 variable
		r2=r2+k[j].indexOf("c");
	}
	if(r2+k.length>0){//沒有d沒有c則2 variable
       totalVariablesCount=3;
	}else{
		 totalVariablesCount=2;
	 }
	 }
     switch(totalVariablesCount){
      case 4:
     for(int e=0;e<=k.length-1;e++){
		if(k[e].indexOf("(")!=-1&&k[e].indexOf(")")!=-1){
        int[] X={-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		if(k[e].indexOf("a'")!=-1){
			X[8]=0;
			X[9]=0;
			X[11]=0;
			X[10]=0;
			X[12]=0;
			X[13]=0;
			X[15]=0;
			X[14]=0;
	}else if(k[e].indexOf("a")!=-1){
			X[0]=0;
			X[1]=0;
			X[3]=0;
			X[2]=0;
			X[4]=0;
			X[5]=0;
			X[7]=0;
			X[6]=0;
	}
		if(k[e].indexOf("b'")!=-1){
			X[4]=0;
			X[5]=0;
			X[7]=0;
			X[6]=0;
			X[12]=0;
			X[13]=0;
			X[15]=0;
			X[14]=0;
		}else if(k[e].indexOf("b")!=-1){
			X[0]=0;
			X[1]=0;
			X[3]=0;
			X[2]=0;
			X[8]=0;
			X[9]=0;
			X[11]=0;
			X[10]=0;
		}
		if(k[e].indexOf("c'")!=-1){
			X[3]=0;
			X[15]=0;
			X[7]=0;
			X[11]=0;
			X[2]=0;
			X[6]=0;
			X[10]=0;
			X[14]=0;
		}else if(k[e].indexOf("c")!=-1){
			X[0]=0;
			X[4]=0;
			X[12]=0;
			X[8]=0;
			X[1]=0;
			X[5]=0;
			X[13]=0;
			X[9]=0;
		}
		if(k[e].indexOf("d'")!=-1){
			X[1]=0;
			X[5]=0;
			X[13]=0;
			X[9]=0;
			X[3]=0;
			X[7]=0;
			X[15]=0;
			X[11]=0;
		}else if(k[e].indexOf("d")!=-1){
			X[0]=0;
			X[4]=0;
			X[12]=0;
			X[8]=0;
			X[2]=0;
			X[6]=0;
			X[14]=0;
			X[10]=0;
	}
		for(int fff=0;fff<=15;fff++){
		if(X[fff]==-1){
			x[fff]="X";//紀錄don't care的位置
		}
	}
		}else{			
		 int[] onoff={1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		if(k[e].indexOf("a'")!=-1){
			onoff[8]=0;
			onoff[9]=0;
			onoff[11]=0;
			onoff[10]=0;
			onoff[12]=0;
			onoff[13]=0;
			onoff[15]=0;
			onoff[14]=0;
	}else if(k[e].indexOf("a")!=-1){
			onoff[0]=0;
			onoff[1]=0;
			onoff[3]=0;
			onoff[2]=0;
			onoff[4]=0;
			onoff[5]=0;
			onoff[7]=0;
			onoff[6]=0;
	}
		if(k[e].indexOf("b'")!=-1){
			onoff[4]=0;
			onoff[5]=0;
			onoff[7]=0;
			onoff[6]=0;
			onoff[12]=0;
			onoff[13]=0;
			onoff[15]=0;
			onoff[14]=0;
		}else if(k[e].indexOf("b")!=-1){
			onoff[0]=0;
			onoff[1]=0;
			onoff[3]=0;
			onoff[2]=0;
			onoff[8]=0;
			onoff[9]=0;
			onoff[11]=0;
			onoff[10]=0;
		}
		if(k[e].indexOf("c'")!=-1){
			onoff[3]=0;
			onoff[15]=0;
			onoff[7]=0;
			onoff[11]=0;
			onoff[2]=0;
			onoff[6]=0;
			onoff[10]=0;
			onoff[14]=0;
		}else if(k[e].indexOf("c")!=-1){
			onoff[0]=0;
			onoff[4]=0;
			onoff[12]=0;
			onoff[8]=0;
			onoff[1]=0;
			onoff[5]=0;
			onoff[13]=0;
			onoff[9]=0;
		}
		if(k[e].indexOf("d'")!=-1){
			onoff[1]=0;
			onoff[5]=0;
			onoff[13]=0;
			onoff[9]=0;
			onoff[3]=0;
			onoff[7]=0;
			onoff[15]=0;
			onoff[11]=0;
		}else if(k[e].indexOf("d")!=-1){
			onoff[0]=0;
			onoff[4]=0;
			onoff[12]=0;
			onoff[8]=0;
			onoff[2]=0;
			onoff[6]=0;
			onoff[14]=0;
			onoff[10]=0;
	}
		for(int f=0;f<=15;f++){
		if(onoff[f]==1){
			K[f]="1";//紀錄1的位置
		}
	}
		}
		}//for
		for(int law=0;law<=15;law++){
		if(K[law].equals("1")){
			K[law]="1";//1在K-map上優先度最高
			R[law]="1";
			rule[law]=1;//另外紀錄1的位置
		}else if(x[law].equals("X")&&K[law].equals("0")){
			K[law]="X";//X在K-map上優先度第二
			rule[law]=0;//另外紀錄0的位置(X視為0)
		}else{
			K[law]="0";//其餘為0
			rule[law]=0;//另外紀錄0的位置
		}
		}
		writer.println("========K Map========");//4*4 K-map
		writer.println("  \\AB|");
		writer.println("CD \\ | 00  01  11  10");
		writer.println("-----+----------------");
		writer.println("  00 | "+K[0]+" | "+K[4]+" | "+K[12]+" | "+K[8]+" |");
		writer.println("-----+---+---+---+---|");
		writer.println("  01 | "+K[1]+" | "+K[5]+" | "+K[13]+" | "+K[9]+" |");
		writer.println("-----+---+---+---+---|");
		writer.println("  11 | "+K[3]+" | "+K[7]+" | "+K[15]+" | "+K[11]+" |");
		writer.println("-----+---+---+---+---|");
		writer.println("  10 | "+K[2]+" | "+K[6]+" | "+K[14]+" | "+K[10]+" |");
		writer.println("----------------------");
		for(int z=0;z<=79;z++){
		allK[z]=false;
}
       
      break;//4
	  case 3:
	 for(int g=0;g<=k.length-1;g++){
		 if(k[g].indexOf("(")!=-1&&k[g].indexOf(")")!=-1){
        int[] X={-1,-1,-1,-1,-1,-1,-1,-1};
		if(k[g].indexOf("a'")!=-1){
			X[6]=0;
			X[4]=0;
			X[7]=0;
			X[5]=0;
			
	}else if(k[g].indexOf("a")!=-1){
			X[0]=0;
			X[1]=0;
			X[3]=0;
			X[2]=0;
			
	}
		if(k[g].indexOf("b'")!=-1){
			X[2]=0;
			X[3]=0;
			X[7]=0;
			X[6]=0;
			
		}else if(k[g].indexOf("b")!=-1){
			X[0]=0;
			X[1]=0;
			X[4]=0;
			X[5]=0;
			
		}
		if(k[g].indexOf("c'")!=-1){
			X[3]=0;
			X[1]=0;
			X[7]=0;
			X[5]=0;
			
		}else if(k[g].indexOf("c")!=-1){
			X[0]=0;
			X[4]=0;
			X[2]=0;
			X[6]=0;
			
		}
		
		for(int ggg=0;ggg<=7;ggg++){
		if(X[ggg]==-1){
			x[ggg]="X";//紀錄don't care的位置
		}
	}
		}else{
		 int[] onoff={1,1,1,1,1,1,1,1};
		if(k[g].indexOf("a'")!=-1){
			onoff[6]=0;
			onoff[4]=0;
			onoff[7]=0;
			onoff[5]=0;
			
	}else if(k[g].indexOf("a")!=-1){
			onoff[0]=0;
			onoff[1]=0;
			onoff[3]=0;
			onoff[2]=0;
			
	}
		if(k[g].indexOf("b'")!=-1){
			onoff[2]=0;
			onoff[3]=0;
			onoff[7]=0;
			onoff[6]=0;
			
		}else if(k[g].indexOf("b")!=-1){
			onoff[0]=0;
			onoff[1]=0;
			onoff[4]=0;
			onoff[5]=0;
			
		}
		if(k[g].indexOf("c'")!=-1){
			onoff[3]=0;
			onoff[1]=0;
			onoff[7]=0;
			onoff[5]=0;
			
		}else if(k[g].indexOf("c")!=-1){
			onoff[0]=0;
			onoff[4]=0;
			onoff[2]=0;
			onoff[6]=0;
			
		}
		
		for(int h=0;h<=7;h++){
		if(onoff[h]==1){
			K[h]="1";//紀錄1的位置
		}
	}
		}
		}//for
		for(int la=0;la<=7;la++){
		if(K[la].equals("1")){
			K[la]="1";//1在K-map上優先度最高
			rule[la]=1;//另外紀錄1的位置
		}else if(x[la].equals("X")&&K[la].equals("0")){
			K[la]="X";//X在K-map上優先度第二
			rule[la]=0;//另外紀錄0的位置(X視為0)
		}else{
			K[la]="0";
			rule[la]=0;
		}
		}
		writer.println("========K Map========");//4*2 K-map
		writer.println("  \\AB|");
		writer.println(" C \\ | 00  01  11  10");
		writer.println("-----+----------------");
		writer.println("  0  | "+K[0]+" | "+K[2]+" | "+K[6]+" | "+K[4]+" |");
		writer.println("-----+---+---+---+---|");
		writer.println("  1  | "+K[1]+" | "+K[3]+" | "+K[7]+" | "+K[5]+" |");
		writer.println("----------------------");
		for(int y=0;y<=25;y++){
		allK[y]=false;
	}
		break;//3
		case 2:
	 for(int l=0;l<=k.length-1;l++){
		 if(k[l].indexOf("(")!=-1&&k[l].indexOf(")")!=-1){
        int[] X={-1,-1,-1,-1};
		if(k[l].indexOf("a'")!=-1){
			X[2]=0;
			X[3]=0;
			
			
	}else if(k[l].indexOf("a")!=-1){
			X[0]=0;
			X[1]=0;
			
	}
		if(k[l].indexOf("b'")!=-1){
			X[1]=0;
			X[3]=0;
	}else if(k[l].indexOf("b")!=-1){
			X[0]=0;
			X[2]=0;
		}
		for(int lll=0;lll<=3;lll++){
		if(X[lll]==-1){
			x[lll]="X";//紀錄don't care的位置
		}
	}
		}else{
		 int[] onoff={1,1,1,1};
		if(k[l].indexOf("a'")!=-1){
			onoff[2]=0;
			onoff[3]=0;
			
			
	}else if(k[l].indexOf("a")!=-1){
			onoff[0]=0;
			onoff[1]=0;
			
	}
		if(k[l].indexOf("b'")!=-1){
			onoff[1]=0;
			onoff[3]=0;
	}else if(k[l].indexOf("b")!=-1){
			onoff[0]=0;
			onoff[2]=0;
		}
		for(int m=0;m<=3;m++){
		if(onoff[m]==1){
			K[m]="1";//紀錄1的位置
		}
	}
		}
		}//for
		for(int laa=0;laa<=3;laa++){
		if(K[laa].equals("1")){
			K[laa]="1";//1在K-map上優先度最高
			rule[laa]=1;//另外紀錄1的位置
		}else if(x[laa].equals("X")&&K[laa].equals("0")){
			K[laa]="X";//X在K-map上優先度第二
			rule[laa]=0;//另外紀錄0的位置(X視為0)
		}else{
			K[laa]="0";
			rule[laa]=0;
		}
		}
		writer.println("=====K Map=====");//2*2 K-map
		writer.println("  \\ A|");
		writer.println(" B \\ | 0   1");
		writer.println("-----+--------");
		writer.println("   0 | "+K[0]+" | "+K[2]+" | ");
		writer.println("-----+---+---+");
		writer.println("   1 | "+K[1]+" | "+K[3]+" | ");
		writer.println("--------------");
		for(int w=0;w<=7;w++){
		allK[w]=false;
	}
		break;//2
		default:
		
	 }//switch
	 switch(totalVariablesCount){//暫時先令X為1
		 case 4:
		 for(int q=0;q<=15;q++){
			 if(K[q].equals("0")){
				K[q]="0"; 
			 }else{
				 K[q]="1"; 
			 }
		 }
		 break;
		 case 3:
		 for(int q=0;q<=7;q++){
			 if(K[q].equals("0")){
				K[q]="0"; 
			 }else{
				 K[q]="1"; 
			 }
		 }
		 break;
		 case 2:
		 for(int q=0;q<=3;q++){
			 if(K[q].equals("0")){
				K[q]="0"; 
			 }else{
				 K[q]="1"; 
			 }
		 }
		 break;
	 }//switch
      switch(totalVariablesCount){//考慮所有的狀況,並使符合條件的編號的array改成true
		 case 4:
		 if(K[0].equals("1")&&K[1].equals("1")&&K[3].equals("1")&&K[2].equals("1")
			 &&K[4].equals("1")&&K[5].equals("1")&&K[7].equals("1")&&K[6].equals("1")){
			 allK[1]=true;
		 }else{
			if(K[0].equals("1")&&K[1].equals("1")&&K[3].equals("1")&&K[2].equals("1")){
			 allK[7]=true;
			 }else{
			 if(K[0].equals("1")&&K[1].equals("1")){
			 allK[25]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[3].equals("1")){
			 allK[22]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
		 }
		 if(K[1].equals("1")&&K[3].equals("1")){
			 allK[44]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
			 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[0].equals("1")){
			 allK[24]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
		 }
			 }
           	if(K[4].equals("1")&&K[5].equals("1")&&K[7].equals("1")&&K[6].equals("1")){
			 allK[5]=true;
			 }else{
			 if(K[4].equals("1")&&K[5].equals("1")){
			 allK[23]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[7].equals("1")&&K[6].equals("1")){
			 allK[19]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[7].equals("1")){
			 allK[41]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
		 if(K[4].equals("1")&&K[6].equals("1")){
			 allK[45]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
			 }	
            if(K[4].equals("1")&&K[5].equals("1")&&K[1].equals("1")&&K[0].equals("1")){
			 allK[13]=true;
			 }else{
			 if(K[4].equals("1")&&K[5].equals("1")){
			 allK[23]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[1].equals("1")){
			 allK[25]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[1].equals("1")){
			 allK[52]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[4].equals("1")&&K[0].equals("1")){
			 allK[55]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
		 }
			 }	
            if(K[3].equals("1")&&K[5].equals("1")&&K[1].equals("1")&&K[7].equals("1")){
			 allK[29]=true;
			 }else{
			 if(K[7].equals("1")&&K[5].equals("1")){
			 allK[41]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[1].equals("1")){
			 allK[44]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[1].equals("1")){
			 allK[52]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[7].equals("1")){
			 allK[49]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
			 }	
            if(K[3].equals("1")&&K[2].equals("1")&&K[6].equals("1")&&K[7].equals("1")){
			 allK[11]=true;
			 }else{
			 if(K[7].equals("1")&&K[6].equals("1")){
			 allK[19]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[2].equals("1")){
			 allK[22]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[6].equals("1")){
			 allK[53]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[7].equals("1")){
			 allK[49]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
			 }
            if(K[0].equals("1")&&K[2].equals("1")&&K[6].equals("1")&&K[4].equals("1")){
			 allK[31]=true;
			 }else{
			 if(K[4].equals("1")&&K[6].equals("1")){
			 allK[45]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[2].equals("1")){
			 allK[47]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[6].equals("1")){
			 allK[53]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[4].equals("1")){
			 allK[55]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
		 }
			 }			 			 			 
		 }
		 if(K[12].equals("1")&&K[13].equals("1")&&K[15].equals("1")&&K[14].equals("1")
			 &&K[4].equals("1")&&K[5].equals("1")&&K[7].equals("1")&&K[6].equals("1")){
			 allK[2]=true;
		 }else{
			if(K[12].equals("1")&&K[13].equals("1")&&K[15].equals("1")&&K[14].equals("1")){
			 allK[4]=true;
			 }else{
			 if(K[12].equals("1")&&K[13].equals("1")){
			 allK[21]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[15].equals("1")){
			 allK[18]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[13].equals("1")){
			 allK[40]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[14].equals("1")){
			 allK[43]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
			 }
           	if(K[4].equals("1")&&K[5].equals("1")&&K[7].equals("1")&&K[6].equals("1")){
			 allK[5]=true;
			 }else{
			 if(K[4].equals("1")&&K[5].equals("1")){
			 allK[23]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[7].equals("1")&&K[6].equals("1")){
			 allK[19]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[7].equals("1")){
			 allK[41]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
		 if(K[4].equals("1")&&K[6].equals("1")){
			 allK[45]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
			 }	
            if(K[4].equals("1")&&K[5].equals("1")&&K[12].equals("1")&&K[13].equals("1")){
			 allK[16]=true;
			 }else{
			 if(K[4].equals("1")&&K[5].equals("1")){
			 allK[23]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[13].equals("1")){
			 allK[21]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[13].equals("1")){
			 allK[58]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[4].equals("1")&&K[12].equals("1")){
			 allK[62]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
		 }
			 }	
            if(K[13].equals("1")&&K[5].equals("1")&&K[15].equals("1")&&K[7].equals("1")){
			 allK[32]=true;
			 }else{
			 if(K[7].equals("1")&&K[5].equals("1")){
			 allK[41]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[13].equals("1")&&K[15].equals("1")){
			 allK[40]=true;
			 }else{
				 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
			 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[13].equals("1")){
			 allK[58]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[7].equals("1")){
			 allK[56]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
			 }	
            if(K[14].equals("1")&&K[15].equals("1")&&K[6].equals("1")&&K[7].equals("1")){
			 allK[14]=true;
			 }else{
			 if(K[7].equals("1")&&K[6].equals("1")){
			 allK[19]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[14].equals("1")){
			 allK[18]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[6].equals("1")){
			 allK[59]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[7].equals("1")){
			 allK[56]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
			 }
            if(K[14].equals("1")&&K[12].equals("1")&&K[6].equals("1")&&K[4].equals("1")){
			 allK[34]=true;
			 }else{
			 if(K[4].equals("1")&&K[6].equals("1")){
			 allK[45]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[14].equals("1")){
			 allK[43]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[6].equals("1")){
			 allK[59]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[4].equals("1")){
			 allK[62]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
		 }
			 }			 			 			 
		 }
		 if(K[12].equals("1")&&K[13].equals("1")&&K[15].equals("1")&&K[14].equals("1")
			 &&K[8].equals("1")&&K[9].equals("1")&&K[11].equals("1")&&K[10].equals("1")){
			 allK[0]=true;
		 }else{
			if(K[12].equals("1")&&K[13].equals("1")&&K[15].equals("1")&&K[14].equals("1")){
			 allK[4]=true;
			 }else{
			 if(K[12].equals("1")&&K[13].equals("1")){
			 allK[21]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[15].equals("1")){
			 allK[18]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[13].equals("1")){
			 allK[40]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[14].equals("1")){
			 allK[43]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
			 }
           	if(K[8].equals("1")&&K[9].equals("1")&&K[11].equals("1")&&K[10].equals("1")){
			 allK[6]=true;
			 }else{
			 if(K[8].equals("1")&&K[9].equals("1")){
			 allK[24]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[9].equals("1")&&K[11].equals("1")){
			 allK[42]=true;
			 }else{
				 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
		 if(K[11].equals("1")&&K[10].equals("1")){
			 allK[20]=true;
			 }else{
				 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[8].equals("1")&&K[10].equals("1")){
			 allK[46]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
			 }	
            if(K[8].equals("1")&&K[9].equals("1")&&K[12].equals("1")&&K[13].equals("1")){
			 allK[12]=true;
			 }else{
			 if(K[8].equals("1")&&K[9].equals("1")){
			 allK[24]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[13].equals("1")){
			 allK[21]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[9].equals("1")&&K[13].equals("1")){
			 allK[50]=true;
			 }else{
				 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[8].equals("1")&&K[12].equals("1")){
			 allK[54]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
		 }
			 }	
            if(K[13].equals("1")&&K[9].equals("1")&&K[15].equals("1")&&K[11].equals("1")){
			 allK[28]=true;
			 }else{
			 if(K[11].equals("1")&&K[9].equals("1")){
			 allK[42]=true;
			 }else{
				 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[13].equals("1")&&K[15].equals("1")){
			 allK[40]=true;
			 }else{
				 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
			 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
		 }
		 if(K[9].equals("1")&&K[13].equals("1")){
			 allK[50]=true;
			 }else{
				 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[11].equals("1")){
			 allK[48]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
			 }	
            if(K[14].equals("1")&&K[15].equals("1")&&K[11].equals("1")&&K[10].equals("1")){
			 allK[10]=true;
			 }else{
			 if(K[11].equals("1")&&K[10].equals("1")){
			 allK[20]=true;
			 }else{
				 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[14].equals("1")){
			 allK[18]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[10].equals("1")){
			 allK[51]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[11].equals("1")){
			 allK[48]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
			 }
            if(K[14].equals("1")&&K[12].equals("1")&&K[8].equals("1")&&K[10].equals("1")){
			 allK[30]=true;
			 }else{
			 if(K[8].equals("1")&&K[10].equals("1")){
			 allK[46]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[14].equals("1")){
			 allK[43]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[10].equals("1")){
			 allK[51]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[8].equals("1")){
			 allK[54]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
		 }
			 }			 			 			 
		 }
		 if(K[0].equals("1")&&K[1].equals("1")&&K[3].equals("1")&&K[2].equals("1")
			 &&K[8].equals("1")&&K[9].equals("1")&&K[11].equals("1")&&K[10].equals("1")){
			 allK[3]=true;
		 }else{
			if(K[0].equals("1")&&K[1].equals("1")&&K[3].equals("1")&&K[2].equals("1")){
			 allK[7]=true;
			 }else{
			 if(K[0].equals("1")&&K[1].equals("1")){
			 allK[25]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[3].equals("1")){
			 allK[22]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
		 }
		 if(K[1].equals("1")&&K[3].equals("1")){
			 allK[44]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
			 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[0].equals("1")){
			 allK[24]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
		 }
			 }
           	if(K[8].equals("1")&&K[9].equals("1")&&K[11].equals("1")&&K[10].equals("1")){
			 allK[6]=true;
			 }else{
			 if(K[8].equals("1")&&K[9].equals("1")){
			 allK[24]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[9].equals("1")&&K[11].equals("1")){
			 allK[42]=true;
			 }else{
				 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
		 if(K[11].equals("1")&&K[10].equals("1")){
			 allK[20]=true;
			 }else{
				 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[8].equals("1")&&K[10].equals("1")){
			 allK[46]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
			 }	
            if(K[8].equals("1")&&K[9].equals("1")&&K[0].equals("1")&&K[1].equals("1")){
			 allK[17]=true;
			 }else{
			 if(K[8].equals("1")&&K[9].equals("1")){
			 allK[24]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[1].equals("1")&&K[0].equals("1")){
			 allK[25]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
			 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
		 }
		 if(K[9].equals("1")&&K[1].equals("1")){
			 allK[60]=true;
			 }else{
				 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[8].equals("1")&&K[0].equals("1")){
			 allK[63]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
		 }
			 }	
            if(K[1].equals("1")&&K[9].equals("1")&&K[3].equals("1")&&K[11].equals("1")){
			 allK[33]=true;
			 }else{
			 if(K[11].equals("1")&&K[9].equals("1")){
			 allK[42]=true;
			 }else{
				 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[1].equals("1")&&K[3].equals("1")){
			 allK[7]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
			 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
		 }
		 if(K[9].equals("1")&&K[1].equals("1")){
			 allK[60]=true;
			 }else{
				 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[11].equals("1")){
			 allK[57]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
			 }	
            if(K[3].equals("1")&&K[2].equals("1")&&K[11].equals("1")&&K[10].equals("1")){
			 allK[15]=true;
			 }else{
			 if(K[11].equals("1")&&K[10].equals("1")){
			 allK[20]=true;
			 }else{
				 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[2].equals("1")){
			 allK[22]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[10].equals("1")){
			 allK[61]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[11].equals("1")){
			 allK[57]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
			 }
            if(K[0].equals("1")&&K[2].equals("1")&&K[8].equals("1")&&K[10].equals("1")){
			 allK[35]=true;
			 }else{
			 if(K[8].equals("1")&&K[10].equals("1")){
			 allK[46]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[0].equals("1")){
			 allK[47]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[10].equals("1")){
			 allK[61]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[8].equals("1")){
			 allK[63]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
		 }
			 }			 			 			 
		 }
		 if(K[0].equals("1")&&K[1].equals("1")&&K[4].equals("1")&&K[5].equals("1")
			 &&K[8].equals("1")&&K[9].equals("1")&&K[12].equals("1")&&K[13].equals("1")){
			 allK[9]=true;
		 }else{
			if(K[0].equals("1")&&K[4].equals("1")&&K[12].equals("1")&&K[8].equals("1")){
			 allK[39]=true;
			 }else{
			 if(K[0].equals("1")&&K[4].equals("1")){
			 allK[55]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
		 }
		 if(K[4].equals("1")&&K[12].equals("1")){
			 allK[62]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[8].equals("1")){
			 allK[54]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
		 }
		 if(K[8].equals("1")&&K[0].equals("1")){
			 allK[63]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
		 }
			 }
           	if(K[1].equals("1")&&K[5].equals("1")&&K[13].equals("1")&&K[9].equals("1")){
			 allK[37]=true;
			 }else{
			 if(K[1].equals("1")&&K[5].equals("1")){
			 allK[52]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[13].equals("1")){
			 allK[58]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[13].equals("1")&&K[9].equals("1")){
			 allK[50]=true;
			 }else{
				 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[1].equals("1")&&K[9].equals("1")){
			 allK[60]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
			 }	
            if(K[8].equals("1")&&K[9].equals("1")&&K[0].equals("1")&&K[1].equals("1")){
			 allK[17]=true;
			 }else{
			 if(K[8].equals("1")&&K[9].equals("1")){
			 allK[24]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[1].equals("1")&&K[0].equals("1")){
			 allK[25]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
			 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
		 }
		 if(K[9].equals("1")&&K[1].equals("1")){
			 allK[60]=true;
			 }else{
				 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[8].equals("1")&&K[0].equals("1")){
			 allK[63]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
		 }
			 }	
            if(K[4].equals("1")&&K[5].equals("1")&&K[1].equals("1")&&K[0].equals("1")){
			 allK[13]=true;
			 }else{
			 if(K[4].equals("1")&&K[5].equals("1")){
			 allK[23]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[1].equals("1")){
			 allK[25]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[1].equals("1")){
			 allK[52]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[4].equals("1")&&K[0].equals("1")){
			 allK[55]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
		 }
			 }
            if(K[4].equals("1")&&K[5].equals("1")&&K[12].equals("1")&&K[13].equals("1")){
			 allK[16]=true;
			 }else{
			 if(K[4].equals("1")&&K[5].equals("1")){
			 allK[23]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[13].equals("1")){
			 allK[21]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[13].equals("1")){
			 allK[58]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[4].equals("1")&&K[12].equals("1")){
			 allK[62]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
		 }
			 }	
            if(K[8].equals("1")&&K[9].equals("1")&&K[12].equals("1")&&K[13].equals("1")){
			 allK[12]=true;
			 }else{
			 if(K[8].equals("1")&&K[9].equals("1")){
			 allK[24]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[13].equals("1")){
			 allK[21]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[9].equals("1")&&K[13].equals("1")){
			 allK[50]=true;
			 }else{
				 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[8].equals("1")&&K[12].equals("1")){
			 allK[54]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
		 }
			 }				 			 			 
		 }
		 if(K[3].equals("1")&&K[1].equals("1")&&K[15].equals("1")&&K[5].equals("1")
			 &&K[7].equals("1")&&K[9].equals("1")&&K[11].equals("1")&&K[13].equals("1")){
			 allK[26]=true;
		 }else{
			if(K[3].equals("1")&&K[7].equals("1")&&K[15].equals("1")&&K[11].equals("1")){
			 allK[36]=true;
			 }else{
			 if(K[3].equals("1")&&K[7].equals("1")){
			 allK[49]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
		 if(K[7].equals("1")&&K[15].equals("1")){
			 allK[56]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[11].equals("1")){
			 allK[48]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[11].equals("1")){
			 allK[57]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
			 }
           	if(K[1].equals("1")&&K[5].equals("1")&&K[13].equals("1")&&K[9].equals("1")){
			 allK[37]=true;
			 }else{
			 if(K[1].equals("1")&&K[5].equals("1")){
			 allK[52]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[13].equals("1")){
			 allK[58]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[13].equals("1")&&K[9].equals("1")){
			 allK[50]=true;
			 }else{
				 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[1].equals("1")&&K[9].equals("1")){
			 allK[60]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
			 }	
            if(K[3].equals("1")&&K[5].equals("1")&&K[1].equals("1")&&K[7].equals("1")){
			 allK[29]=true;
			 }else{
			 if(K[7].equals("1")&&K[5].equals("1")){
			 allK[41]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[1].equals("1")){
			 allK[44]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[1].equals("1")){
			 allK[52]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[7].equals("1")){
			 allK[49]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
			 }	
            if(K[13].equals("1")&&K[5].equals("1")&&K[15].equals("1")&&K[7].equals("1")){
			 allK[32]=true;
			 }else{
			 if(K[7].equals("1")&&K[5].equals("1")){
			 allK[41]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
		 }
		 if(K[13].equals("1")&&K[15].equals("1")){
			 allK[40]=true;
			 }else{
				 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
			 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[13].equals("1")){
			 allK[58]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[70]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[7].equals("1")){
			 allK[56]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
			 }	
            if(K[13].equals("1")&&K[9].equals("1")&&K[15].equals("1")&&K[11].equals("1")){
			 allK[28]=true;
			 }else{
			 if(K[11].equals("1")&&K[9].equals("1")){
			 allK[42]=true;
			 }else{
				 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[13].equals("1")&&K[15].equals("1")){
			 allK[40]=true;
			 }else{
				 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
			 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
		 }
		 if(K[9].equals("1")&&K[13].equals("1")){
			 allK[50]=true;
			 }else{
				 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
			 if(K[13].equals("1")){
			 allK[67]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[11].equals("1")){
			 allK[48]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
			 }	
            if(K[1].equals("1")&&K[9].equals("1")&&K[3].equals("1")&&K[11].equals("1")){
			 allK[33]=true;
			 }else{
			 if(K[11].equals("1")&&K[9].equals("1")){
			 allK[42]=true;
			 }else{
				 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
			 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
		 }
		 if(K[1].equals("1")&&K[3].equals("1")){
			 allK[7]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
			 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
		 }
		 if(K[9].equals("1")&&K[1].equals("1")){
			 allK[60]=true;
			 }else{
				 if(K[9].equals("1")){
			 allK[72]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[75]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[11].equals("1")){
			 allK[57]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
			 }		 			 
		 }
		 if(K[3].equals("1")&&K[2].equals("1")&&K[15].equals("1")&&K[6].equals("1")
			 &&K[7].equals("1")&&K[10].equals("1")&&K[11].equals("1")&&K[14].equals("1")){
			 allK[8]=true;
		 }else{
			if(K[3].equals("1")&&K[7].equals("1")&&K[15].equals("1")&&K[11].equals("1")){
			 allK[36]=true;
			 }else{
			 if(K[3].equals("1")&&K[7].equals("1")){
			 allK[49]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
		 if(K[7].equals("1")&&K[15].equals("1")){
			 allK[56]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[11].equals("1")){
			 allK[48]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[11].equals("1")){
			 allK[57]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
			 }
           	if(K[2].equals("1")&&K[6].equals("1")&&K[14].equals("1")&&K[10].equals("1")){
			 allK[38]=true;
			 }else{
			 if(K[2].equals("1")&&K[6].equals("1")){
			 allK[53]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[6].equals("1")&&K[14].equals("1")){
			 allK[59]=true;
			 }else{
				 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[10].equals("1")){
			 allK[51]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[10].equals("1")){
			 allK[61]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
			 }	
            if(K[3].equals("1")&&K[2].equals("1")&&K[6].equals("1")&&K[7].equals("1")){
			 allK[11]=true;
			 }else{
			 if(K[7].equals("1")&&K[6].equals("1")){
			 allK[19]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[2].equals("1")){
			 allK[22]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[6].equals("1")){
			 allK[53]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[7].equals("1")){
			 allK[49]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
			 }
            if(K[14].equals("1")&&K[15].equals("1")&&K[6].equals("1")&&K[7].equals("1")){
			 allK[14]=true;
			 }else{
			 if(K[7].equals("1")&&K[6].equals("1")){
			 allK[19]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[14].equals("1")){
			 allK[18]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[6].equals("1")){
			 allK[59]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[7].equals("1")){
			 allK[56]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[65]=true;
			 }//end
		 }
			 }
            if(K[14].equals("1")&&K[15].equals("1")&&K[11].equals("1")&&K[10].equals("1")){
			 allK[10]=true;
			 }else{
			 if(K[11].equals("1")&&K[10].equals("1")){
			 allK[20]=true;
			 }else{
				 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[14].equals("1")){
			 allK[18]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[10].equals("1")){
			 allK[51]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[15].equals("1")&&K[11].equals("1")){
			 allK[48]=true;
			 }else{
				 if(K[15].equals("1")){
			 allK[64]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
			 }
            if(K[3].equals("1")&&K[2].equals("1")&&K[11].equals("1")&&K[10].equals("1")){
			 allK[15]=true;
			 }else{
			 if(K[11].equals("1")&&K[10].equals("1")){
			 allK[20]=true;
			 }else{
				 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[2].equals("1")){
			 allK[22]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[10].equals("1")){
			 allK[61]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[11].equals("1")){
			 allK[57]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[69]=true;
			 }//end
			 if(K[11].equals("1")){
			 allK[66]=true;
			 }//end
		 }
			 }		 
		 }
		 if(K[0].equals("1")&&K[2].equals("1")&&K[12].equals("1")&&K[6].equals("1")
			 &&K[4].equals("1")&&K[10].equals("1")&&K[8].equals("1")&&K[14].equals("1")){
			 allK[27]=true;
		 }else{
			if(K[0].equals("1")&&K[4].equals("1")&&K[12].equals("1")&&K[8].equals("1")){
			 allK[39]=true;
			 }else{
			 if(K[0].equals("1")&&K[4].equals("1")){
			 allK[55]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
		 }
		 if(K[4].equals("1")&&K[12].equals("1")){
			 allK[62]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[8].equals("1")){
			 allK[54]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[8].equals("1")){
			 allK[63]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
		 }
			 }
           	if(K[2].equals("1")&&K[6].equals("1")&&K[14].equals("1")&&K[10].equals("1")){
			 allK[38]=true;
			 }else{
			 if(K[2].equals("1")&&K[6].equals("1")){
			 allK[53]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[6].equals("1")&&K[14].equals("1")){
			 allK[59]=true;
			 }else{
				 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[10].equals("1")){
			 allK[51]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[10].equals("1")){
			 allK[61]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
			 }	
            if(K[0].equals("1")&&K[2].equals("1")&&K[6].equals("1")&&K[4].equals("1")){
			 allK[31]=true;
			 }else{
			 if(K[4].equals("1")&&K[6].equals("1")){
			 allK[45]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[2].equals("1")){
			 allK[47]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[6].equals("1")){
			 allK[53]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[4].equals("1")){
			 allK[55]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
		 }
			 }			 			 		
            if(K[14].equals("1")&&K[12].equals("1")&&K[6].equals("1")&&K[4].equals("1")){
			 allK[34]=true;
			 }else{
			 if(K[4].equals("1")&&K[6].equals("1")){
			 allK[45]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[14].equals("1")){
			 allK[43]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[6].equals("1")){
			 allK[59]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[6].equals("1")){
			 allK[71]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[4].equals("1")){
			 allK[62]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[4].equals("1")){
			 allK[77]=true;
			 }//end
		 }
			 }			 	
            if(K[14].equals("1")&&K[12].equals("1")&&K[8].equals("1")&&K[10].equals("1")){
			 allK[30]=true;
			 }else{
			 if(K[8].equals("1")&&K[10].equals("1")){
			 allK[46]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[14].equals("1")){
			 allK[43]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
		 }
		 if(K[14].equals("1")&&K[10].equals("1")){
			 allK[51]=true;
			 }else{
				 if(K[14].equals("1")){
			 allK[68]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[12].equals("1")&&K[8].equals("1")){
			 allK[54]=true;
			 }else{
				 if(K[12].equals("1")){
			 allK[74]=true;
			 }//end
			 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
		 }
			 }			 			 
            if(K[0].equals("1")&&K[2].equals("1")&&K[8].equals("1")&&K[10].equals("1")){
			 allK[35]=true;
			 }else{
			 if(K[8].equals("1")&&K[10].equals("1")){
			 allK[46]=true;
			 }else{
				 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[0].equals("1")){
			 allK[47]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[10].equals("1")){
			 allK[61]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[76]=true;
			 }//end
			 if(K[10].equals("1")){
			 allK[73]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[8].equals("1")){
			 allK[63]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[79]=true;
			 }//end
			 if(K[8].equals("1")){
			 allK[78]=true;
			 }//end
		 }
			 }			 			
		 }
		 break;//4
         case 3:
		 if(K[0].equals("1")&&K[2].equals("1")&&K[6].equals("1")&&K[4].equals("1")){
			 allK[9]=true;
			 }else{
			 if(K[0].equals("1")&&K[2].equals("1")){
			 allK[13]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[25]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[23]=true;
			 }//end
		 }
		 if(K[6].equals("1")&&K[2].equals("1")){
			 allK[16]=true;
			 }else{
				 if(K[6].equals("1")){
			 allK[21]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[23]=true;
			 }//end
		 }
		 if(K[6].equals("1")&&K[4].equals("1")){
			 allK[12]=true;
			 }else{
				 if(K[6].equals("1")){
			 allK[21]=true;
			 }//end
			 if(K[4].equals("1")){
			 allK[24]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[4].equals("1")){
			 allK[17]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[25]=true;
			 }//end
			 if(K[4].equals("1")){
			 allK[24]=true;
			 }//end
		 }
			 }
		 if(K[1].equals("1")&&K[3].equals("1")&&K[7].equals("1")&&K[5].equals("1")){
			 allK[8]=true;
			 }else{
			 if(K[1].equals("1")&&K[3].equals("1")){
			 allK[11]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[22]=true;
			 }//end
			 if(K[3].equals("1")){
			 allK[19]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[7].equals("1")){
			 allK[14]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[19]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[18]=true;
			 }//end
		 }
		 if(K[7].equals("1")&&K[5].equals("1")){
			 allK[10]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[18]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[20]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[1].equals("1")){
			 allK[15]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[20]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[22]=true;
			 }//end
		 }
			 }		 
		 if(K[1].equals("1")&&K[3].equals("1")&&K[0].equals("1")&&K[2].equals("1")){
			 allK[1]=true;
			 }else{
			 if(K[1].equals("1")&&K[3].equals("1")){
			 allK[11]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[22]=true;
			 }//end
			 if(K[3].equals("1")){
			 allK[19]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[2].equals("1")){
			 allK[5]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[19]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[23]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[2].equals("1")){
			 allK[13]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[25]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[23]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[1].equals("1")){
			 allK[7]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[25]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[22]=true;
			 }//end
		 }
			 }		 
		 if(K[6].equals("1")&&K[4].equals("1")&&K[7].equals("1")&&K[5].equals("1")){
			 allK[0]=true;
			 }else{
			 if(K[6].equals("1")&&K[4].equals("1")){
			 allK[12]=true;
			 }else{
				 if(K[6].equals("1")){
			 allK[21]=true;
			 }//end
			 if(K[4].equals("1")){
			 allK[24]=true;
			 }//end
		 }
		 if(K[5].equals("1")&&K[4].equals("1")){
			 allK[6]=true;
			 }else{
				 if(K[5].equals("1")){
			 allK[20]=true;
			 }//end
			 if(K[4].equals("1")){
			 allK[24]=true;
			 }//end
		 }
		 if(K[7].equals("1")&&K[5].equals("1")){
			 allK[10]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[18]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[20]=true;
			 }//end
		 }
		 if(K[6].equals("1")&&K[7].equals("1")){
			 allK[4]=true;
			 }else{
				 if(K[6].equals("1")){
			 allK[21]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[18]=true;
			 }//end
		 }
			 }		 
		 if(K[6].equals("1")&&K[3].equals("1")&&K[7].equals("1")&&K[2].equals("1")){
			 allK[2]=true;
			 }else{
			 if(K[6].equals("1")&&K[2].equals("1")){
			 allK[16]=true;
			 }else{
				 if(K[6].equals("1")){
			 allK[21]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[23]=true;
			 }//end
		 }
		 if(K[2].equals("1")&&K[3].equals("1")){
			 allK[5]=true;
			 }else{
				 if(K[2].equals("1")){
			 allK[23]=true;
			 }//end
			 if(K[3].equals("1")){
			 allK[19]=true;
			 }//end
		 }
		 if(K[7].equals("1")&&K[3].equals("1")){
			 allK[14]=true;
			 }else{
				 if(K[7].equals("1")){
			 allK[18]=true;
			 }//end
			 if(K[3].equals("1")){
			 allK[19]=true;
			 }//end
		 }
		 if(K[6].equals("1")&&K[7].equals("1")){
			 allK[4]=true;
			 }else{
				 if(K[6].equals("1")){
			 allK[21]=true;
			 }//end
			 if(K[7].equals("1")){
			 allK[18]=true;
			 }//end
		 }
			 }		 
		 if(K[1].equals("1")&&K[4].equals("1")&&K[0].equals("1")&&K[5].equals("1")){
			 allK[3]=true;
			 }else{
			 if(K[1].equals("1")&&K[5].equals("1")){
			 allK[15]=true;
			 }else{
				 if(K[1].equals("1")){
			 allK[22]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[20]=true;
			 }//end
		 }
		 if(K[4].equals("1")&&K[5].equals("1")){
			 allK[6]=true;
			 }else{
				 if(K[4].equals("1")){
			 allK[24]=true;
			 }//end
			 if(K[5].equals("1")){
			 allK[20]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[4].equals("1")){
			 allK[17]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[25]=true;
			 }//end
			 if(K[4].equals("1")){
			 allK[24]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[1].equals("1")){
			 allK[7]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[25]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[22]=true;
			 }//end
		 }
			 }		 
		 break;//3
		 case 2:
		 if(K[0].equals("1")&&K[1].equals("1")){
			 allK[1]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[7]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[5]=true;
			 }//end
		 }
		 if(K[0].equals("1")&&K[2].equals("1")){
			 allK[3]=true;
			 }else{
				 if(K[0].equals("1")){
			 allK[7]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[6]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[2].equals("1")){
			 allK[0]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[4]=true;
			 }//end
			 if(K[2].equals("1")){
			 allK[6]=true;
			 }//end
		 }
		 if(K[3].equals("1")&&K[1].equals("1")){
			 allK[2]=true;
			 }else{
				 if(K[3].equals("1")){
			 allK[4]=true;
			 }//end
			 if(K[1].equals("1")){
			 allK[5]=true;
			 }//end
		 }
		 break;//2
}//switch
      
	 String[] F={"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
	 //80種可能,並將計算一個格子有幾個圈能圈到
	  if(allK[0]==true){
		  allK[4]=false;allK[6]=false;allK[10]=false;allK[12]=false;allK[18]=false;
		  allK[20]=false;allK[21]=false;allK[24]=false;allK[28]=false;allK[30]=false;
		  allK[40]=false;allK[42]=false;allK[43]=false;allK[46]=false;allK[48]=false;
		  allK[50]=false;allK[51]=false;allK[54]=false;allK[64]=false;allK[66]=false;
		  allK[67]=false;allK[68]=false;allK[72]=false;allK[73]=false;allK[74]=false;allK[78]=false;
		  number++;
		  F[number]="a";
		  switch(totalVariablesCount){
		  case 4:
		 solve[8]++;solve[9]++;solve[10]++;solve[11]++;
		  solve[12]++;solve[13]++;solve[14]++;solve[15]++;
		 break;
		 case 3:
		solve[4]++;solve[5]++;solve[6]++;solve[7]++;
		 break;
		 case 2:
		 solve[2]++;solve[3]++;
		 break;
		  }
	  } 
	  if(allK[1]==true){
		  allK[5]=false;allK[7]=false;allK[11]=false;allK[13]=false;allK[19]=false;
		  allK[22]=false;allK[23]=false;allK[25]=false;allK[29]=false;allK[31]=false;
		  allK[41]=false;allK[44]=false;allK[45]=false;allK[47]=false;allK[49]=false;
		  allK[52]=false;allK[53]=false;allK[55]=false;allK[65]=false;allK[69]=false;
		  allK[70]=false;allK[71]=false;allK[75]=false;allK[76]=false;allK[77]=false;allK[79]=false;
		  number++;
		  F[number]="a'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[0]++;solve[1]++;solve[2]++;solve[3]++;
		  solve[4]++;solve[5]++;solve[6]++;solve[7]++;
		 break;
		 case 3:
		solve[0]++;solve[1]++;solve[2]++;solve[3]++;
		 break;
		 case 2:
		 solve[0]++;solve[1]++;
		 break;
		  }
	}
	  if(allK[2]==true){
		  allK[5]=false;allK[4]=false;allK[14]=false;allK[16]=false;allK[18]=false;
		  allK[19]=false;allK[21]=false;allK[23]=false;allK[32]=false;allK[34]=false;
		  allK[40]=false;allK[41]=false;allK[43]=false;allK[45]=false;allK[56]=false;
		  allK[58]=false;allK[59]=false;allK[62]=false;allK[64]=false;allK[65]=false;
		  allK[67]=false;allK[68]=false;allK[70]=false;allK[71]=false;allK[74]=false;allK[77]=false;
		  number++;
		  F[number]="b";
		  switch(totalVariablesCount){
		  case 4:
		 solve[12]++;solve[13]++;solve[14]++;solve[15]++;
		  solve[4]++;solve[5]++;solve[6]++;solve[7]++;
		 break;
		 case 3:
		 solve[2]++;solve[3]++;solve[6]++;solve[7]++;
		 break;
		 case 2:
		 solve[3]++;solve[1]++;
		 break;
		  }
	}
	  if(allK[3]==true){
		  allK[6]=false;allK[7]=false;allK[15]=false;allK[17]=false;allK[20]=false;
		  allK[22]=false;allK[24]=false;allK[25]=false;allK[33]=false;allK[35]=false;
		  allK[42]=false;allK[44]=false;allK[46]=false;allK[47]=false;allK[57]=false;
		  allK[60]=false;allK[61]=false;allK[63]=false;allK[66]=false;allK[69]=false;
		  allK[72]=false;allK[73]=false;allK[75]=false;allK[76]=false;allK[78]=false;allK[79]=false;
		  number++;
		  F[number]="b'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[0]++;solve[1]++;solve[2]++;solve[3]++;
		  solve[8]++;solve[9]++;solve[10]++;solve[11]++;
		 break;
		 case 3:
		 solve[0]++;solve[1]++;solve[4]++;solve[5]++;
		 break;
		 case 2:
		 solve[0]++;solve[2]++;
		 break;
		  }
		}
	  if(allK[8]==true){
		  allK[10]=false;allK[14]=false;allK[18]=false;allK[20]=false;allK[19]=false;
		  allK[22]=false;allK[36]=false;allK[38]=false;allK[48]=false;allK[49]=false;
		  allK[51]=false;allK[53]=false;allK[56]=false;allK[57]=false;allK[59]=false;
		  allK[61]=false;allK[64]=false;allK[65]=false;allK[66]=false;allK[68]=false;
		  allK[69]=false;allK[71]=false;allK[73]=false;allK[76]=false;allK[11]=false;allK[15]=false;
		  number++;
		  F[number]="c";
		  switch(totalVariablesCount){
		  case 4:
		 solve[7]++;solve[6]++;solve[2]++;solve[3]++;
		  solve[10]++;solve[11]++;solve[14]++;solve[15]++;
		 break;
		 case 3:
		 solve[3]++;solve[1]++;solve[7]++;solve[5]++;
		 break;
		  }
	  }
	  if(allK[9]==true){
		  allK[12]=false;allK[13]=false;allK[16]=false;allK[17]=false;allK[21]=false;
		  allK[24]=false;allK[23]=false;allK[25]=false;allK[37]=false;allK[39]=false;
		  allK[50]=false;allK[52]=false;allK[54]=false;allK[55]=false;allK[58]=false;
		  allK[60]=false;allK[62]=false;allK[63]=false;allK[67]=false;allK[72]=false;
		  allK[70]=false;allK[74]=false;allK[75]=false;allK[78]=false;allK[77]=false;allK[79]=false;
		  number++;
		  F[number]="c'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[0]++;solve[1]++;solve[4]++;solve[5]++;
		  solve[8]++;solve[9]++;solve[12]++;solve[13]++;
		 break;
		 case 3:
		 solve[0]++;solve[2]++;solve[4]++;solve[6]++;
		 break;
		  }
	  }
	  if(allK[26]==true){
		  allK[28]=false;allK[29]=false;allK[32]=false;allK[33]=false;allK[36]=false;
		  allK[37]=false;allK[40]=false;allK[41]=false;allK[42]=false;allK[44]=false;
		  allK[48]=false;allK[49]=false;allK[50]=false;allK[52]=false;allK[56]=false;
		  allK[57]=false;allK[58]=false;allK[60]=false;allK[64]=false;allK[65]=false;
		  allK[66]=false;allK[67]=false;allK[69]=false;allK[70]=false;allK[72]=false;allK[75]=false;
		  number++;
		  F[number]="d";
		  switch(totalVariablesCount){
		  case 4:
		 solve[1]++;solve[3]++;solve[5]++;solve[7]++;
		  solve[9]++;solve[11]++;solve[13]++;solve[15]++;
		 break;
		  }
	 }
	  if(allK[27]==true){
		  allK[30]=false;allK[31]=false;allK[34]=false;allK[35]=false;allK[39]=false;
		  allK[38]=false;allK[43]=false;allK[45]=false;allK[46]=false;allK[47]=false;
		  allK[51]=false;allK[53]=false;allK[54]=false;allK[55]=false;allK[59]=false;
		  allK[61]=false;allK[63]=false;allK[62]=false;allK[68]=false;allK[71]=false;
		  allK[73]=false;allK[74]=false;allK[76]=false;allK[78]=false;allK[77]=false;allK[79]=false;
		  number++;
		  F[number]="d'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[0]++;solve[2]++;solve[4]++;solve[6]++;
		  solve[8]++;solve[10]++;solve[12]++;solve[14]++;
		 break;
		  }
	  }
	  if(allK[4]==true){
		  allK[18]=false;allK[21]=false;allK[40]=false;allK[43]=false;allK[64]=false;
		  allK[67]=false;allK[74]=false;allK[68]=false;
		  number++;
		  F[number]="ab";
		  switch(totalVariablesCount){
		  case 4:
		 solve[12]++;solve[13]++;solve[14]++;solve[15]++;
		 break;
		 case 3:
		 solve[6]++;solve[7]++;
		 break;
		 case 2:
		 solve[3]++;
		 break;
		  }
	  }
	  if(allK[5]==true){
		  allK[19]=false;allK[23]=false;allK[41]=false;allK[45]=false;allK[65]=false;
		  allK[77]=false;allK[71]=false;allK[70]=false;
		  number++;
		  F[number]="a'b";
		  switch(totalVariablesCount){
		  case 4:
		  solve[4]++;solve[5]++;solve[6]++;solve[7]++;
		 break;
		 case 3:
		 solve[2]++;solve[3]++;
		 break;
		 case 2:
		 solve[1]++;
		 break;
		  }
	  }
	  if(allK[6]==true){
		  allK[20]=false;allK[24]=false;allK[42]=false;allK[46]=false;allK[66]=false;
		  allK[78]=false;allK[73]=false;allK[72]=false;
		  number++;
		  F[number]="ab'";
		  switch(totalVariablesCount){
		  case 4:
		  solve[8]++;solve[9]++;solve[10]++;solve[11]++;
		 break;
		 case 3:
		 solve[4]++;solve[5]++;
		 break;
		 case 2:
		solve[2]++;
		 break;
		  }
	  }
	  if(allK[7]==true){
		  allK[22]=false;allK[25]=false;allK[44]=false;allK[47]=false;allK[69]=false;
		  allK[75]=false;allK[76]=false;allK[79]=false;
		  number++;
		  F[number]="a'b'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[0]++;solve[1]++;solve[2]++;solve[3]++;
		 break;
		 case 3:
		 solve[0]++;solve[1]++;
		 break;
		 case 2:
		 solve[0]++;
		 break;
		  }
	  }
	  if(allK[10]==true){
		  allK[18]=false;allK[20]=false;allK[48]=false;allK[51]=false;allK[64]=false;
		  allK[66]=false;allK[73]=false;allK[68]=false;
		  number++;
		  F[number]="ac";
		  switch(totalVariablesCount){
		  case 4:
		 solve[10]++;solve[11]++;solve[14]++;solve[15]++;
		 break;
		 case 3:
		 solve[5]++;solve[7]++;
		 break;
		  }
	  }
	  if(allK[11]==true){
		  allK[19]=false;allK[22]=false;allK[53]=false;allK[49]=false;allK[65]=false;
		  allK[76]=false;allK[71]=false;allK[69]=false;
		  number++;
		  F[number]="a'c";
		  switch(totalVariablesCount){
		  case 4:
		 solve[2]++;solve[3]++;solve[6]++;solve[7]++;
		 break;
		 case 3:
		 solve[1]++;solve[3]++;
		 break;
		  }
	  }
	  if(allK[12]==true){
		  allK[21]=false;allK[24]=false;allK[50]=false;allK[54]=false;allK[72]=false;
		  allK[67]=false;allK[74]=false;allK[78]=false;
		  number++;
		  F[number]="ac'";
		  switch(totalVariablesCount){
		  case 4:
		  solve[8]++;solve[9]++;solve[12]++;solve[13]++;
		 break;
		 case 3:
		 solve[4]++;solve[6]++;
		 break;
		  }
	  }
	  if(allK[13]==true){
		  allK[25]=false;allK[23]=false;allK[52]=false;allK[55]=false;allK[70]=false;
		  allK[76]=false;allK[79]=false;allK[77]=false;
		  number++;
		  F[number]="a'c'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[0]++;solve[1]++;solve[4]++;solve[5]++;
		 break;
		 case 3:
		 solve[0]++;solve[2]++;
		 break;
		  }
	  }
	  if(allK[14]==true){
		  allK[18]=false;allK[19]=false;allK[59]=false;allK[56]=false;allK[64]=false;
		  allK[71]=false;allK[68]=false;allK[65]=false;
		  number++;
		  F[number]="bc";
		  switch(totalVariablesCount){
		  case 4:
		 solve[4]++;solve[7]++;solve[14]++;solve[15]++;
		 break;
		 case 3:
		 solve[3]++;solve[7]++;
		 break;
		  }
	  }
	  if(allK[15]==true){
		  allK[20]=false;allK[22]=false;allK[57]=false;allK[61]=false;allK[66]=false;
		  allK[76]=false;allK[73]=false;allK[69]=false;
		  number++;
		  F[number]="b'c";
		  switch(totalVariablesCount){
		  case 4:
		 solve[2]++;solve[3]++;solve[10]++;solve[11]++;
		 break;
		 case 3:
		 solve[1]++;solve[5]++;
		 break;
		  }
	  }
	  if(allK[16]==true){
		  allK[23]=false;allK[21]=false;allK[58]=false;allK[62]=false;allK[67]=false;
		  allK[74]=false;allK[77]=false;allK[70]=false;
		  number++;
		  F[number]="bc'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[4]++;solve[5]++;solve[12]++;solve[13]++;
		 break;
		 case 3:
		 solve[2]++;solve[6]++;
		 break;
		  } 
	  }
	  if(allK[17]==true){
		  allK[25]=false;allK[24]=false;allK[60]=false;allK[63]=false;allK[75]=false;
		  allK[79]=false;allK[78]=false;allK[72]=false;
		  number++;
		  F[number]="b'c'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[0]++;solve[1]++;solve[8]++;solve[9]++;
		 break;
		 case 3:
		 solve[0]++;solve[4]++;
		 break;
		  }
	  }
	  if(allK[28]==true){
		  allK[48]=false;allK[40]=false;allK[42]=false;allK[50]=false;allK[64]=false;
		  allK[72]=false;allK[67]=false;allK[66]=false;
		  number++;
		  F[number]="ad";
		  switch(totalVariablesCount){
		  case 4:
		 solve[9]++;solve[11]++;solve[13]++;solve[15]++;
		 break;
		  }
	  }
	  if(allK[29]==true){
		  allK[41]=false;allK[44]=false;allK[52]=false;allK[49]=false;allK[65]=false;
		  allK[75]=false;allK[70]=false;allK[69]=false;
		  number++;
		  F[number]="a'd";
		  switch(totalVariablesCount){
		  case 4:
		 solve[1]++;solve[7]++;solve[3]++;solve[5]++;
		 break;
		  } 
	  }
	  if(allK[30]==true){
		  allK[43]=false;allK[46]=false;allK[51]=false;allK[54]=false;allK[68]=false;
		  allK[73]=false;allK[74]=false;allK[78]=false;
		  number++;
		  F[number]="ad'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[8]++;solve[10]++;solve[12]++;solve[14]++;
		 break;
		  }
	  } 
      if(allK[31]==true){
		  allK[45]=false;allK[47]=false;allK[53]=false;allK[55]=false;allK[71]=false;
		  allK[76]=false;allK[77]=false;allK[79]=false;
		  number++;
		  F[number]="a'd'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[0]++;solve[2]++;solve[4]++;solve[6]++;
		 break;
		  }
	  }   
	  if(allK[32]==true){
		  allK[40]=false;allK[41]=false;allK[56]=false;allK[58]=false;allK[64]=false;
		  allK[65]=false;allK[67]=false;allK[70]=false;
		  number++;
		  F[number]="bd";
		  switch(totalVariablesCount){
		  case 4:
		 solve[5]++;solve[7]++;solve[13]++;solve[15]++;
		 break;
		  }
	  } 
	  if(allK[33]==true){
		  allK[42]=false;allK[44]=false;allK[60]=false;allK[57]=false;allK[66]=false;
		  allK[69]=false;allK[72]=false;allK[75]=false;
		  number++;
		  F[number]="b'd";
		  switch(totalVariablesCount){
		  case 4:
		 solve[1]++;solve[3]++;solve[9]++;solve[11]++;
		 break;
		  }
	  }
      if(allK[34]==true){
		  allK[43]=false;allK[45]=false;allK[62]=false;allK[59]=false;allK[68]=false;
		  allK[71]=false;allK[74]=false;allK[77]=false;
		  number++;
		  F[number]="bd'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[4]++;solve[6]++;solve[12]++;solve[14]++;
		 break;
		  }
	  } 
      if(allK[35]==true){
		  allK[47]=false;allK[46]=false;allK[61]=false;allK[63]=false;allK[76]=false;
		  allK[73]=false;allK[79]=false;allK[78]=false;
		  number++;
		  F[number]="b'd'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[0]++;solve[2]++;solve[8]++;solve[10]++;
		 break;
		  }
	  } 
      if(allK[36]==true){
		  allK[48]=false;allK[49]=false;allK[56]=false;allK[57]=false;allK[65]=false;
		  allK[66]=false;allK[69]=false;allK[64]=false;
		  number++;
		  F[number]="cd";
		  switch(totalVariablesCount){
		  case 4:
		 solve[3]++;solve[11]++;solve[7]++;solve[15]++;
		 break;
		  } 
	  } 
      if(allK[37]==true){
		  allK[50]=false;allK[52]=false;allK[58]=false;allK[60]=false;allK[67]=false;
		  allK[70]=false;allK[75]=false;allK[72]=false;
		  number++;
		  F[number]="c'd";
		  switch(totalVariablesCount){
		  case 4:
		 solve[1]++;solve[5]++;solve[9]++;solve[13]++;
		 break;
		  } 
	  } 
      if(allK[38]==true){
		  allK[51]=false;allK[53]=false;allK[61]=false;allK[59]=false;allK[68]=false;
		  allK[71]=false;allK[76]=false;allK[73]=false;
		  number++;
		  F[number]="cd'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[2]++;solve[6]++;solve[10]++;solve[14]++;
		 break;
		  } 
	  } 
      if(allK[39]==true){
		  allK[54]=false;allK[55]=false;allK[62]=false;allK[63]=false;allK[77]=false;
		  allK[79]=false;allK[74]=false;allK[78]=false;
		  number++;
		  F[number]="c'd'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[4]++;solve[8]++;solve[12]++;solve[0]++;
		 break;
		  }
	  } 
      if(allK[18]==true){
		  allK[64]=false;allK[68]=false;
		  number++;
		  F[number]="abc";
		  switch(totalVariablesCount){
		  case 4:
		 solve[14]++;solve[15]++;
		 break;
		 case 3:
		 solve[7]++;
		 break;
		  }
	  }
	  if(allK[19]==true){
		  allK[65]=false;allK[71]=false;
		  number++;
		  F[number]="a'bc";
		  switch(totalVariablesCount){
		  case 4:
		 solve[6]++;solve[7]++;
		 break;
		 case 3:
		 solve[3]++;
		 break;
		  }
	  }
	  if(allK[20]==true){
		  allK[66]=false;allK[73]=false;
		  number++;
		  F[number]="ab'c";
		  switch(totalVariablesCount){
		  case 4:
		 solve[9]++;solve[11]++;
		 break;
		 case 3:
		 solve[5]++;
		 break;
		  } 
	  }
	  if(allK[21]==true){
		  allK[67]=false;allK[74]=false;
		  number++;
		  F[number]="abc'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[12]++;solve[13]++;
		 break;
		 case 3:
		 solve[6]++;
		 break;
		  } 
	  }
	  if(allK[22]==true){
		  allK[69]=false;allK[76]=false;
		  number++;
		  F[number]="a'b'c";
		  switch(totalVariablesCount){
		  case 4:
		 solve[2]++;solve[3]++;
		 break;
		 case 3:
		 solve[1]++;
		 break;
		  } 
	  }
	  if(allK[23]==true){
		  allK[70]=false;allK[77]=false;
		  number++;
		  F[number]="a'bc'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[4]++;solve[5]++;
		 break;
		 case 3:
		 solve[2]++;
		 break;
		  }
	  }
	  if(allK[24]==true){
		  allK[72]=false;allK[78]=false;
		  number++;
		  F[number]="ab'c'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[8]++;solve[9]++;
		 break;
		 case 3:
		 solve[4]++;
		 break;
		  }
	  }
	  if(allK[25]==true){
		  allK[79]=false;allK[75]=false;
		  number++;
		  F[number]="a'b'c'";
		  switch(totalVariablesCount){
		  case 4:
		 solve[1]++;solve[0]++;
		 break;
		 case 3:
		 solve[0]++;
		 break;
		  }
	  }
	  if(allK[40]==true){
		  allK[64]=false;allK[67]=false;
		  number++;
		  F[number]="abd";
		 solve[13]++;solve[15]++;}
	  if(allK[41]==true){
		  allK[65]=false;allK[70]=false;
		  number++;
		  F[number]="a'bd";
		 solve[5]++;solve[7]++;}
	  if(allK[42]==true){
		  allK[66]=false;allK[72]=false;
		  number++;
		  F[number]="ab'd";
		 solve[9]++;solve[11]++;} 
	  if(allK[43]==true){
		  allK[68]=false;allK[74]=false;
		  number++;
		  F[number]="abd'";
		 solve[12]++;solve[14]++;}
	  if(allK[44]==true){
		  allK[69]=false;allK[75]=false;
		  number++;
		  F[number]="a'b'd";
		 solve[3]++;solve[1]++;}
	  if(allK[45]==true){
		  allK[71]=false;allK[77]=false;
		  number++;
		  F[number]="a'bd'";
		 solve[4]++;solve[6]++;}
	  if(allK[46]==true){
		  allK[73]=false;allK[78]=false;
		  number++;
		  F[number]="ab'd'";
		 solve[8]++;solve[10]++;}
	  if(allK[47]==true){
		  allK[76]=false;allK[79]=false;
		  number++;
		  F[number]="a'b'd'";
		 solve[0]++;solve[2]++;}
	  if(allK[48]==true){
		  allK[64]=false;allK[66]=false;
		  number++;
		  F[number]="acd";
		 solve[11]++;solve[15]++;}
	  if(allK[49]==true){
		  allK[65]=false;allK[69]=false;
		  number++;
		  F[number]="a'cd";
		 solve[3]++;solve[7]++;}
	  if(allK[50]==true){
		  allK[67]=false;allK[72]=false;
		  number++;
		  F[number]="ac'd";
		 solve[9]++;solve[13]++;}
	  if(allK[51]==true){
		  allK[68]=false;allK[73]=false;
		  number++;
		  F[number]="acd'";
		 solve[10]++;solve[14]++;}
	  if(allK[52]==true){
		  allK[70]=false;allK[75]=false;
		  number++;
		  F[number]="a'c'd";
		 solve[1]++;solve[5]++;}
	  if(allK[53]==true){
		  allK[71]=false;allK[76]=false;
		  number++;
		  F[number]="a'cd'";
		 solve[2]++;solve[6]++;}
	  if(allK[54]==true){
		  allK[74]=false;allK[78]=false;
		  number++;
		  F[number]="ac'd'";
		 solve[8]++;solve[12]++;}
	  if(allK[55]==true){
		  allK[77]=false;allK[79]=false;
		  number++;
		  F[number]="a'c'd'";
		 solve[0]++;solve[4]++;}
	  if(allK[56]==true){
		  allK[64]=false;allK[65]=false;
		  number++;
		  F[number]="bcd";
		 solve[7]++;solve[15]++;}
	  if(allK[57]==true){
		  allK[69]=false;allK[66]=false;
		  number++;
		  F[number]="b'cd";
		 solve[3]++;solve[11]++;}
	  if(allK[58]==true){
		  allK[67]=false;allK[70]=false;
		  number++;
		  F[number]="bc'd";
		 solve[5]++;solve[13]++;}
	  if(allK[59]==true){
		  allK[68]=false;allK[71]=false;
		  number++;
		  F[number]="bcd'";
		 solve[6]++;solve[14]++;}
	  if(allK[60]==true){
		  allK[72]=false;allK[75]=false;
		  number++;
		  F[number]="b'c'd";
		 solve[1]++;solve[9]++;}
	  if(allK[61]==true){
		  allK[73]=false;allK[76]=false;
		  number++;
		  F[number]="b'cd'";
		 solve[2]++;solve[10]++;}
	  if(allK[62]==true){
		  allK[74]=false;allK[77]=false;
		  number++;
		  F[number]="bc'd'";
		 solve[4]++;solve[12]++;}
	  if(allK[63]==true){
		  allK[79]=false;allK[78]=false;
		  number++;
		  F[number]="b'c'd'";
		 solve[0]++;solve[8]++;}
	  if(allK[64]==true){
		  number++;
		  F[number]="abcd";
		 solve[15]++;}
	  if(allK[65]==true){
		  number++;
		  F[number]="a'bcd";
		 solve[7]++;}
	  if(allK[66]==true){
		  number++;
		  F[number]="ab'cd";
		 solve[11]++;}
	  if(allK[67]==true){
		  number++;
		  F[number]="abc'd";
		 solve[13]++;}
	  if(allK[68]==true){
		  number++;
		  F[number]="abcd'";
		 solve[14]++;}
	  if(allK[69]==true){
		  number++;
		  F[number]="a'b'cd";
		 solve[3]++;}
	  if(allK[70]==true){
		  number++;
		  F[number]="a'bc'd";
		 solve[5]++;}
	  if(allK[71]==true){
		  number++;
		  F[number]="a'bcd'";
		 solve[6]++;}
	  if(allK[72]==true){
		  number++;
		  F[number]="ab'c'd";
		 solve[9]++;}
	  if(allK[73]==true){
		 number++;
		  F[number]="ab'cd'";
		 solve[10]++;}
	  if(allK[74]==true){
		  number++;
		  F[number]="abc'd'";
		 solve[12]++;}
	  if(allK[75]==true){
		  number++;
		  F[number]="a'b'c'd";
		 solve[1]++;}
	  if(allK[76]==true){
		  number++;
		  F[number]="a'b'cd'";
		 solve[2]++;}
	  if(allK[77]==true){
		  number++;
		  F[number]="a'bc'd'";
		 solve[4]++;}
	  if(allK[78]==true){
		  number++;
		  F[number]="ab'c'd'";
		 solve[8]++;}
	  if(allK[79]==true){
		  number++;
		  F[number]="a'b'c'd'";
		 solve[0]++;}
	  
	  for(int r=1;r<=F.length-1;r++){//假設刪除這個圈不會導致有遺漏的1，那這個圈就是多餘的
	  if(F[r].equals("a")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[8]--;solve[9]--;solve[10]--;solve[11]--;
		  solve[12]--;solve[13]--;solve[14]--;solve[15]--;
		  if(solve[8]<rule[8]||solve[9]<rule[9]||solve[10]<rule[10]||solve[11]<rule[11]
		  ||solve[12]<rule[12]||solve[13]<rule[13]||solve[14]<rule[14]||solve[15]<rule[15]){
		  solve[8]++;solve[9]++;solve[10]++;solve[11]++;
		  solve[12]++;solve[13]++;solve[14]++;solve[15]++; 
		  gn++;
		  writer.println("group "+gn+": 8,9,10,11,12,13,14,15");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[4]--;solve[5]--;solve[6]--;solve[7]--;
			   if(solve[4]<rule[4]||solve[5]<rule[5]||solve[6]<rule[6]||solve[7]<rule[7]){
				 solve[4]++;solve[5]++;solve[6]++;solve[7]++;
				 gn++;
				 writer.println("group "+gn+": 4,5,6,7");
			  }else{
				 F[r]="0"; }break;
			  case 2:
			  solve[2]--;solve[3]--;
			  if(solve[2]<rule[2]||solve[3]<rule[3]){
			 solve[2]++;solve[3]++;
			 gn++;
			 writer.println("group "+gn+": 2,3");
			 }else{
				 F[r]="0";  }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[0]--;solve[1]--;solve[2]--;solve[3]--;
		  solve[4]--;solve[5]--;solve[6]--;solve[7]--;
		  if(solve[0]<rule[0]||solve[1]<rule[1]||solve[2]<rule[2]||solve[3]<rule[3]
		  ||solve[4]<rule[4]||solve[5]<rule[5]||solve[6]<rule[6]||solve[7]<rule[7]){
		  solve[0]++;solve[1]++;solve[2]++;solve[3]++;
		  solve[4]++;solve[5]++;solve[6]++;solve[7]++; 
		  gn++;
		  writer.println("group "+gn+": 0,1,2,3,4,5,6,7");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[0]--;solve[1]--;solve[2]--;solve[3]--;
			   if(solve[0]<rule[0]||solve[1]<rule[1]||solve[2]<rule[2]||solve[3]<rule[3]){
				 solve[0]++;solve[1]++;solve[2]++;solve[3]++;
				 gn++;
				 writer.println("group "+gn+": 0,1,2,3");
			  }else{
				 F[r]="0"; }break;
			  case 2:
			  solve[0]--;solve[1]--;
			  if(solve[0]<rule[0]||solve[1]<rule[1]){
			 solve[0]++;solve[1]++;
			 gn++;
			 writer.println("group "+gn+": 0,1");
			 }else{
				 F[r]="0";  }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("b")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[12]--;solve[13]--;solve[14]--;solve[15]--;
		  solve[4]--;solve[5]--;solve[6]--;solve[7]--;
		  if(solve[12]<rule[12]||solve[13]<rule[13]||solve[14]<rule[14]||solve[15]<rule[15]
		  ||solve[4]<rule[4]||solve[5]<rule[5]||solve[6]<rule[6]||solve[7]<rule[7]){
		  solve[12]++;solve[13]++;solve[14]++;solve[15]++;
		  solve[4]++;solve[5]++;solve[6]++;solve[7]++; 
		  gn++;
		  writer.println("group "+gn+": 4,5,6,7,12,13,14,15");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[6]--;solve[7]--;solve[2]--;solve[3]--;
			   if(solve[6]<rule[6]||solve[7]<rule[7]||solve[2]<rule[2]||solve[3]<rule[3]){
				 solve[6]++;solve[7]++;solve[2]++;solve[3]++;
				 gn++;
				 writer.println("group "+gn+": 2,3,6,7");
			  }else{
				 F[r]="0"; }break;
			  case 2:
			  solve[1]--;solve[3]--;
			  if(solve[3]<rule[3]||solve[1]<rule[1]){
			 solve[3]++;solve[1]++;
			 gn++;
			 writer.println("group "+gn+": 1,3");
			 }else{
				 F[r]="0";  }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("b'")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[0]--;solve[1]--;solve[2]--;solve[3]--;
		  solve[8]--;solve[9]--;solve[10]--;solve[11]--;
		  if(solve[0]<rule[0]||solve[1]<rule[1]||solve[2]<rule[2]||solve[3]<rule[3]
		  ||solve[8]<rule[8]||solve[9]<rule[9]||solve[10]<rule[10]||solve[11]<rule[11]){
		  solve[0]++;solve[1]++;solve[2]++;solve[3]++;
		  solve[8]++;solve[9]++;solve[10]++;solve[11]++;
		  gn++;
          writer.println("group "+gn+": 0,1,2,3,8,9,10,11");		  
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[0]--;solve[1]--;solve[4]--;solve[5]--;
			   if(solve[0]<rule[0]||solve[1]<rule[1]||solve[4]<rule[4]||solve[5]<rule[5]){
				 solve[0]++;solve[1]++;solve[4]++;solve[5]++;
				 gn++;
				 writer.println("group "+gn+": 0,1,4,5");
			  }else{
				 F[r]="0"; }break;
			  case 2:
			  solve[0]--;solve[2]--;
			  if(solve[0]<rule[0]||solve[2]<rule[2]){
			 solve[0]++;solve[2]++;
			 gn++;
			 writer.println("group "+gn+": 0,2");
			 }else{
				 F[r]="0";  }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("c")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[10]--;solve[11]--;solve[2]--;solve[3]--;
		  solve[14]--;solve[15]--;solve[6]--;solve[7]--;
		  if(solve[10]<rule[10]||solve[11]<rule[11]||solve[2]<rule[2]||solve[3]<rule[3]
		  ||solve[14]<rule[14]||solve[15]<rule[15]||solve[6]<rule[6]||solve[7]<rule[7]){
		  solve[10]++;solve[11]++;solve[2]++;solve[3]++;
		  solve[14]++;solve[15]++;solve[6]++;solve[7]++; 
		  gn++;
		  writer.println("group "+gn+": 2,3,6,7,10,11,14,15");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[7]--;solve[1]--;solve[5]--;solve[3]--;
			   if(solve[7]<rule[7]||solve[1]<rule[1]||solve[5]<rule[5]||solve[3]<rule[3]){
				 solve[7]++;solve[1]++;solve[5]++;solve[3]++;
				 gn++;
				 writer.println("group "+gn+": 1,3,5,7");
			  }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("c'")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[0]--;solve[1]--;solve[8]--;solve[9]--;
		  solve[4]--;solve[5]--;solve[12]--;solve[13]--;
		  if(solve[0]<rule[0]||solve[1]<rule[1]||solve[8]<rule[8]||solve[9]<rule[9]
		  ||solve[4]<rule[4]||solve[5]<rule[5]||solve[12]<rule[12]||solve[13]<rule[13]){
		  solve[0]++;solve[1]++;solve[8]++;solve[9]++;
		  solve[4]++;solve[5]++;solve[12]++;solve[13]++; 
		  gn++;
		  writer.println("group "+gn+": 0,1,4,5,8,9,12,13");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[0]--;solve[2]--;solve[4]--;solve[6]--;
			   if(solve[0]<rule[0]||solve[2]<rule[2]||solve[4]<rule[4]||solve[6]<rule[6]){
				 solve[0]++;solve[2]++;solve[4]++;solve[6]++;
				 gn++;
				 writer.println("group "+gn+": 0,2,4,6");
			  }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("d")){
		  solve[1]--;solve[11]--;solve[9]--;solve[3]--;
		  solve[5]--;solve[15]--;solve[13]--;solve[7]--;
		  if(solve[1]<rule[1]||solve[11]<rule[11]||solve[9]<rule[9]||solve[3]<rule[3]
		  ||solve[5]<rule[5]||solve[15]<rule[15]||solve[13]<rule[13]||solve[7]<rule[7]){
		  solve[1]++;solve[11]++;solve[9]++;solve[3]++;
		  solve[5]++;solve[15]++;solve[13]++;solve[7]++; 
		  gn++;
		  writer.println("group "+gn+": 1,3,5,7,9,11,13,15");
			  }else{
				 F[r]="0"; }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
	  if(F[r].equals("d'")){
		  solve[10]--;solve[0]--;solve[2]--;solve[8]--;
		  solve[14]--;solve[4]--;solve[6]--;solve[12]--;
		  if(solve[10]<rule[10]||solve[0]<rule[0]||solve[2]<rule[2]||solve[8]<rule[8]
		  ||solve[14]<rule[14]||solve[4]<rule[4]||solve[6]<rule[6]||solve[12]<rule[12]){
		  solve[10]++;solve[0]++;solve[2]++;solve[8]++;
		  solve[14]++;solve[4]++;solve[6]++;solve[12]++; 
		  gn++;
		   writer.println("group "+gn+": 0,2,4,6,8,10,12,14");
			  }else{
				 F[r]="0"; }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ab")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[12]--;solve[13]--;solve[14]--;solve[15]--;
		  if(solve[12]<rule[12]||solve[13]<rule[13]||solve[14]<rule[14]||solve[15]<rule[15]){
		  solve[12]++;solve[13]++;solve[14]++;solve[15]++;
		  gn++;
		  writer.println("group "+gn+": 12,13,14,15");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[6]--;solve[7]--;
			   if(solve[6]<rule[6]||solve[7]<rule[7]){
				 solve[6]++;solve[7]++;
				 gn++;
				 writer.println("group "+gn+": 6,7");
			  }else{
				 F[r]="0"; }break;
			  case 2:
			  solve[3]--;
			  if(solve[3]<rule[3]){
			 solve[3]++;
			 gn++;
			 writer.println("group "+gn+": 3");
			 }else{
				 F[r]="0";  }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'b")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[4]--;solve[5]--;solve[6]--;solve[7]--;
		  if(solve[4]<rule[4]||solve[5]<rule[5]||solve[6]<rule[6]||solve[7]<rule[7]){
		  solve[4]++;solve[5]++;solve[6]++;solve[7]++;
		  gn++;
		  writer.println("group "+gn+": 4,5,6,7");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[2]--;solve[3]--;
			   if(solve[2]<rule[2]||solve[3]<rule[3]){
				 solve[2]++;solve[3]++;
				 gn++;
				 writer.println("group "+gn+": 2,3");
			  }else{
				 F[r]="0"; }break;
			  case 2:
			  solve[1]--;
			  if(solve[1]<rule[1]){
			 solve[1]++;
			 gn++;
			 writer.println("group "+gn+": 1");
			 }else{
				 F[r]="0";  }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ab'")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[8]--;solve[9]--;solve[10]--;solve[11]--;
		  if(solve[8]<rule[8]||solve[9]<rule[9]||solve[10]<rule[10]||solve[11]<rule[11]){
		  solve[8]++;solve[9]++;solve[10]++;solve[11]++;
		  gn++;
		  writer.println("group "+gn+": 8,9,10,11");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[4]--;solve[5]--;
			   if(solve[4]<rule[4]||solve[5]<rule[5]){
				 solve[4]++;solve[5]++;
				 gn++;
				 writer.println("group "+gn+": 4,5");
			  }else{
				 F[r]="0"; }break;
			  case 2:
			  solve[2]--;
			  if(solve[2]<rule[2]){
			 solve[2]++;
			 gn++;
			 writer.println("group "+gn+": 2");
			 }else{
				 F[r]="0";  }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'b'")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[0]--;solve[1]--;solve[2]--;solve[3]--;
		  if(solve[0]<rule[0]||solve[1]<rule[1]||solve[2]<rule[2]||solve[3]<rule[3]){
		  solve[0]++;solve[1]++;solve[2]++;solve[3]++;
		  gn++;
		  writer.println("group "+gn+": 0,1,2,3");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[0]--;solve[1]--;
			   if(solve[0]<rule[0]||solve[1]<rule[1]){
				 solve[0]++;solve[1]++;
				 gn++;
				 writer.println("group "+gn+": 0,1");
			  }else{
				 F[r]="0"; }break;
			  case 2:
			  solve[0]--;
			  if(solve[0]<rule[0]){
			 solve[0]++;
			 gn++;
			 writer.println("group "+gn+": 0");
			 }else{
				 F[r]="0";  }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ac")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[14]--;solve[15]--;solve[10]--;solve[11]--;
		  if(solve[14]<rule[14]||solve[15]<rule[15]||solve[10]<rule[10]||solve[11]<rule[11]){
		  solve[10]++;solve[11]++;solve[14]++;solve[15]++;
		  gn++;
		  writer.println("group "+gn+": 10,11,14,15");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[7]--;solve[5]--;
			   if(solve[7]<rule[7]||solve[5]<rule[5]){
				 solve[7]++;solve[5]++;
				 gn++;
				 writer.println("group "+gn+": 5,7");
			  }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
	  if(F[r].equals("a'c")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[2]--;solve[3]--;solve[6]--;solve[7]--;
		  if(solve[2]<rule[2]||solve[3]<rule[3]||solve[6]<rule[6]||solve[7]<rule[7]){
		  solve[2]++;solve[3]++;solve[6]++;solve[7]++;
		  gn++;
		  writer.println("group "+gn+": 2,3,6,7");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[1]--;solve[3]--;
			   if(solve[1]<rule[1]||solve[3]<rule[3]){
				 solve[1]++;solve[3]++;
				 gn++;
				 writer.println("group "+gn+": 1,3");
			  }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
	  if(F[r].equals("ac'")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[8]--;solve[9]--;solve[12]--;solve[13]--;
		  if(solve[8]<rule[8]||solve[9]<rule[9]||solve[12]<rule[12]||solve[13]<rule[13]){
		  solve[8]++;solve[9]++;solve[12]++;solve[13]++;
		  gn++;
		  writer.println("group "+gn+": 8,9,12,13");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[4]--;solve[6]--;
			   if(solve[4]<rule[4]||solve[6]<rule[6]){
				 solve[4]++;solve[6]++;
				 gn++;
				 writer.println("group "+gn+": 4,6");
			  }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
	  if(F[r].equals("a'c'")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[0]--;solve[1]--;solve[4]--;solve[5]--;
		  if(solve[0]<rule[0]||solve[1]<rule[1]||solve[4]<rule[4]||solve[5]<rule[5]){
		  solve[0]++;solve[1]++;solve[4]++;solve[5]++;
		  gn++;
		  writer.println("group "+gn+": 0,1,4,5");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[0]--;solve[2]--;
			   if(solve[0]<rule[0]||solve[2]<rule[2]){
				 solve[0]++;solve[2]++;
				 gn++;
				 writer.println("group "+gn+": 0,2");
			  }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
	  if(F[r].equals("bc")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[6]--;solve[7]--;solve[14]--;solve[15]--;
		  if(solve[6]<rule[6]||solve[7]<rule[7]||solve[14]<rule[14]||solve[15]<rule[15]){
		  solve[6]++;solve[7]++;solve[14]++;solve[15]++;
		  gn++;
		  writer.println("group "+gn+": 6,7,14,15");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[3]--;solve[7]--;
			   if(solve[3]<rule[3]||solve[7]<rule[7]){
				 solve[3]++;solve[7]++;
				 gn++;
				 writer.println("group "+gn+": 3,7");
			  }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
	  if(F[r].equals("b'c")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[2]--;solve[3]--;solve[10]--;solve[11]--;
		  if(solve[2]<rule[2]||solve[3]<rule[3]||solve[10]<rule[10]||solve[11]<rule[11]){
		  solve[10]++;solve[11]++;solve[2]++;solve[3]++;
		  gn++;
		  writer.println("group "+gn+": 2,3,10,11");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[1]--;solve[5]--;
			   if(solve[1]<rule[1]||solve[5]<rule[5]){
				 solve[1]++;solve[5]++;
				 gn++;
				 writer.println("group "+gn+": 1,5");
			  }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
	  if(F[r].equals("bc'")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[4]--;solve[5]--;solve[12]--;solve[13]--;
		  if(solve[4]<rule[4]||solve[5]<rule[5]||solve[12]<rule[12]||solve[13]<rule[13]){
		  solve[4]++;solve[5]++;solve[12]++;solve[13]++;
		  gn++;
		  writer.println("group "+gn+": 4,5,12,13");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[2]--;solve[6]--;
			   if(solve[2]<rule[2]||solve[6]<rule[6]){
				 solve[2]++;solve[6]++;
				 gn++;
				 writer.println("group "+gn+": 2,6");
			  }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }  
	  if(F[r].equals("b'c'")){
		  switch(totalVariablesCount){
		  case 4:
		  solve[0]--;solve[1]--;solve[8]--;solve[9]--;
		  if(solve[0]<rule[0]||solve[1]<rule[1]||solve[8]<rule[8]||solve[9]<rule[9]){
		  solve[0]++;solve[1]++;solve[8]++;solve[9]++;
		  gn++;
		  writer.println("group "+gn+": 0,1,8,9");
			  }else{
				 F[r]="0"; }break;
			  case 3:
			  solve[0]--;solve[4]--;
			   if(solve[0]<rule[0]||solve[4]<rule[4]){
				 solve[0]++;solve[4]++;
				 gn++;
				 writer.println("group "+gn+": 0,4");
			  }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }  
		if(F[r].equals("ad")){
		  solve[9]--;solve[11]--;solve[13]--;solve[15]--;
		  if(solve[9]<rule[9]||solve[11]<rule[11]||solve[13]<rule[13]||solve[15]<rule[15]){
				 solve[9]++;solve[11]++;solve[13]++;solve[15]++;
				 gn++;
				 writer.println("group "+gn+": 9,11,13,15");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
		if(F[r].equals("a'd")){
		  solve[1]--;solve[3]--;solve[5]--;solve[7]--;
		  if(solve[1]<rule[1]||solve[3]<rule[3]||solve[5]<rule[5]||solve[7]<rule[7]){
				 solve[1]++;solve[3]++;solve[5]++;solve[7]++;
				 gn++;
				 writer.println("group "+gn+": 1,3,5,7");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }  
		if(F[r].equals("ad'")){
		  solve[8]--;solve[10]--;solve[12]--;solve[14]--;
		  if(solve[8]<rule[8]||solve[10]<rule[10]||solve[12]<rule[12]||solve[14]<rule[14]){
				 solve[8]++;solve[10]++;solve[12]++;solve[14]++;
				 gn++;
				 writer.println("group "+gn+": 9,11,13,15");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }  
		if(F[r].equals("a'd'")){
		  solve[0]--;solve[2]--;solve[4]--;solve[6]--;
		  if(solve[0]<rule[0]||solve[2]<rule[2]||solve[4]<rule[4]||solve[6]<rule[6]){
				 solve[0]++;solve[2]++;solve[4]++;solve[6]++;
				 gn++;
				 writer.println("group "+gn+": 0,2,4,6");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }  
		if(F[r].equals("bd")){
		  solve[5]--;solve[7]--;solve[13]--;solve[15]--;
		  if(solve[5]<rule[5]||solve[7]<rule[7]||solve[13]<rule[13]||solve[15]<rule[15]){
				 solve[5]++;solve[7]++;solve[13]++;solve[15]++;
				 gn++;
				 writer.println("group "+gn+": 5,7,13,15");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }  
		  if(F[r].equals("b'd")){
		  solve[1]--;solve[3]--;solve[9]--;solve[11]--;
		  if(solve[9]<rule[9]||solve[11]<rule[11]||solve[3]<rule[3]||solve[1]<rule[1]){
				 solve[9]++;solve[11]++;solve[3]++;solve[1]++;
				 gn++;
				 writer.println("group "+gn+": 1,3,9,11");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
	  if(F[r].equals("bd'")){
		  solve[4]--;solve[6]--;solve[12]--;solve[14]--;
		  if(solve[4]<rule[4]||solve[6]<rule[6]||solve[12]<rule[12]||solve[14]<rule[14]){
				 solve[4]++;solve[6]++;solve[12]++;solve[14]++;
				 gn++;
				 writer.println("group "+gn+": 4,6,12,14");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
	  if(F[r].equals("b'd'")){
		  solve[0]--;solve[2]--;solve[8]--;solve[10]--;
		  if(solve[0]<rule[0]||solve[2]<rule[2]||solve[8]<rule[8]||solve[10]<rule[10]){
				 solve[0]++;solve[2]++;solve[8]++;solve[10]++;
				 gn++;
				 writer.println("group "+gn+": 0,2,8,10");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
	  if(F[r].equals("cd")){
		  solve[3]--;solve[7]--;solve[11]--;solve[15]--;
		  if(solve[3]<rule[3]||solve[7]<rule[7]||solve[11]<rule[11]||solve[15]<rule[15]){
				 solve[3]++;solve[7]++;solve[11]++;solve[15]++;
				 gn++;
				 writer.println("group "+gn+": 3,7,11,15");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
	  if(F[r].equals("c'd")){
		  solve[1]--;solve[5]--;solve[9]--;solve[13]--;
		  if(solve[1]<rule[1]||solve[5]<rule[5]||solve[9]<rule[9]||solve[13]<rule[13]){
				 solve[1]++;solve[5]++;solve[9]++;solve[13]++;
				 gn++;
				 writer.println("group "+gn+": 1,5,9,13");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
		  if(F[r].equals("cd'")){
		  solve[2]--;solve[6]--;solve[10]--;solve[14]--;
		  if(solve[2]<rule[2]||solve[6]<rule[6]||solve[10]<rule[10]||solve[14]<rule[14]){
				 solve[2]++;solve[6]++;solve[10]++;solve[14]++;
				 gn++;
				 writer.println("group "+gn+": 2,6,10,14");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
		if(F[r].equals("c'd'")){
		  solve[0]--;solve[4]--;solve[8]--;solve[12]--;
		  if(solve[0]<rule[0]||solve[4]<rule[4]||solve[8]<rule[8]||solve[12]<rule[12]){
				 solve[0]++;solve[4]++;solve[8]++;solve[12]++;
				 gn++;
				 writer.println("group "+gn+": 0,4,8,12");
			  }else{
				 F[r]="0"; 
			  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
		  }
      if(F[r].equals("abc")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[14]--;solve[15]--;
		 if(solve[14]<rule[14]||solve[15]<rule[15]){
			 solve[14]++;solve[15]++;
			 gn++;
			 writer.println("group "+gn+": 14,15");
			 }else{
				 F[r]="0"; }break;
		 case 3:
		 solve[7]--;
		 if(solve[7]<rule[7]){
		 solve[7]++;
		 gn++;
		 writer.println("group "+gn+": 7");
		 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
      if(F[r].equals("a'bc")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[6]--;solve[7]--;
		 if(solve[6]<rule[6]||solve[7]<rule[7]){
			 solve[6]++;solve[7]++;
			 gn++;
			  writer.println("group "+gn+": 6,7");
			 }else{
				 F[r]="0"; }break;
		 case 3:
		 solve[3]--;
		 if(solve[3]<rule[3]){
		 solve[3]++;
		 gn++;
		 writer.println("group "+gn+": 3");
		 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ab'c")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[9]--;solve[11]--;
		 if(solve[9]<rule[9]||solve[11]<rule[11]){
			 solve[9]++;solve[11]++;
			 gn++;
			  writer.println("group "+gn+": 9,11");
			 }else{
				 F[r]="0"; }break;
		 case 3:
		 solve[5]--;
		 if(solve[5]<rule[5]){
		 solve[5]++;
		 gn++;
		 writer.println("group "+gn+": 5");
		 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("abc'")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[12]--;solve[13]--;
		 if(solve[12]<rule[12]||solve[13]<rule[13]){
			 solve[12]++;solve[13]++;
			 gn++;
			  writer.println("group "+gn+": 12,13");
			 }else{
				 F[r]="0"; }break;
		 case 3:
		 solve[6]--;
		 if(solve[6]<rule[6]){
		 solve[6]++;
		 gn++;
		 writer.println("group "+gn+": 6");
		 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'b'c")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[2]--;solve[3]--;
		 if(solve[2]<rule[2]||solve[3]<rule[3]){
			 solve[2]++;solve[3]++;
			 gn++;
			  writer.println("group "+gn+": 2,3");
			 }else{
				 F[r]="0"; }break;
		 case 3:
		 solve[1]--;
		 if(solve[1]<rule[1]){
		 solve[1]++;
		 gn++;
		 writer.println("group "+gn+": 1");
		 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'bc'")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[4]--;solve[5]--;
		 if(solve[4]<rule[4]||solve[5]<rule[5]){
			 solve[4]++;solve[5]++;
			 gn++;
			  writer.println("group "+gn+": 4,5");
			 }else{
				 F[r]="0"; }break;
		 case 3:
		 solve[2]--;
		 if(solve[2]<rule[2]){
		 solve[2]++;
		 gn++;
		 writer.println("group "+gn+": 2");
		 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ab'c'")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[8]--;solve[9]--;
		 if(solve[8]<rule[8]||solve[9]<rule[9]){
			 solve[8]++;solve[9]++;
			 gn++;
			  writer.println("group "+gn+": 8,9");
			 }else{
				 F[r]="0"; }break;
		 case 3:
		 solve[4]--;
		 if(solve[4]<rule[4]){
		 solve[4]++;
		 gn++;
		 writer.println("group "+gn+": 4");
		 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'b'c'")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[0]--;solve[1]--;
		 if(solve[0]<rule[0]||solve[1]<rule[1]){
			 solve[0]++;solve[1]++;
			 gn++;
			  writer.println("group "+gn+": 0,1");
			 }else{
				 F[r]="0"; }break;
		 case 3:
		 solve[0]--;
		 if(solve[0]<rule[0]){
		 solve[0]++;
		 gn++;
		 writer.println("group "+gn+": 0");
		 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	   if(F[r].equals("abd")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[13]--;solve[15]--;
		 if(solve[13]<rule[13]||solve[15]<rule[15]){
			 solve[13]++;solve[15]++;
			 gn++;
			  writer.println("group "+gn+": 13,15");
			 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'bd")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[5]--;solve[7]--;
		 if(solve[5]<rule[5]||solve[7]<rule[7]){
			 solve[5]++;solve[7]++;
			 gn++;
			  writer.println("group "+gn+": 5,7");
			 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ab'd")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[9]--;solve[11]--;
		 if(solve[9]<rule[9]||solve[11]<rule[11]){
			 solve[9]++;solve[11]++;
			 gn++;
			  writer.println("group "+gn+": 9,11");
			 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("abd'")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[12]--;solve[14]--;
		 if(solve[12]<rule[12]||solve[14]<rule[14]){
			 solve[12]++;solve[14]++;
			 gn++;
			  writer.println("group "+gn+": 12,14");
			 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'b'd")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[3]--;solve[1]--;
		 if(solve[3]<rule[3]||solve[1]<rule[1]){
			 solve[3]++;solve[1]++;
			 gn++;
			  writer.println("group "+gn+": 1,3");
			 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'bd'")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[4]--;solve[6]--;
		 if(solve[4]<rule[4]||solve[6]<rule[6]){
			 solve[4]++;solve[6]++;
			 gn++;
			  writer.println("group "+gn+": 4,6");
			 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ab'd'")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[8]--;solve[10]--;
		 if(solve[8]<rule[8]||solve[10]<rule[10]){
			 solve[8]++;solve[10]++;
			 gn++;
			  writer.println("group "+gn+": 8,10");
			 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'b'd'")){
		  switch(totalVariablesCount){
		  case 4:
		 solve[0]--;solve[2]--;
		 if(solve[0]<rule[0]||solve[2]<rule[2]){
			 solve[0]++;solve[2]++;
			 gn++;
			  writer.println("group "+gn+": 0,2");
			 }else{
				 F[r]="0"; }break;
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("acd")){
		  solve[11]--;solve[15]--;
		 if(solve[11]<rule[11]||solve[15]<rule[15]){
			 solve[11]++;solve[15]++;
			 gn++;
			  writer.println("group "+gn+": 11,15");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'cd")){
		  solve[3]--;solve[7]--;
		 if(solve[3]<rule[3]||solve[7]<rule[7]){
			 solve[3]++;solve[7]++;
			 gn++;
			  writer.println("group "+gn+": 3,7");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ac'd")){
		  solve[9]--;solve[13]--;
		 if(solve[9]<rule[9]||solve[13]<rule[13]){
			 solve[9]++;solve[13]++;
			 gn++;
			  writer.println("group "+gn+": 9,13");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("acd'")){
		  solve[10]--;solve[14]--;
		 if(solve[10]<rule[10]||solve[14]<rule[14]){
			 solve[10]++;solve[14]++;
			 gn++;
			  writer.println("group "+gn+": 10,14");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'c'd")){
		  solve[1]--;solve[5]--;
		 if(solve[1]<rule[1]||solve[5]<rule[5]){
			 solve[1]++;solve[5]++;
			 gn++;
			  writer.println("group "+gn+": 1,5");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'cd'")){
		  solve[2]--;solve[6]--;
		 if(solve[2]<rule[2]||solve[6]<rule[6]){
			 solve[2]++;solve[6]++;
			 gn++;
			  writer.println("group "+gn+": 2,6");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ac'd'")){
		  solve[8]--;solve[12]--;
		 if(solve[8]<rule[8]||solve[12]<rule[12]){
			 solve[8]++;solve[12]++;
			 gn++;
			  writer.println("group "+gn+": 8,12");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'c'd'")){
		  solve[0]--;solve[4]--;
		 if(solve[0]<rule[0]||solve[4]<rule[4]){
			 solve[0]++;solve[4]++;
			 gn++;
			  writer.println("group "+gn+": 0,4");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("bcd")){
		  solve[7]--;solve[15]--;
		 if(solve[7]<rule[7]||solve[15]<rule[15]){
			 solve[7]++;solve[15]++;
			 gn++;
			  writer.println("group "+gn+": 7,15");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("b'cd")){
		  solve[11]--;solve[3]--;
		 if(solve[11]<rule[11]||solve[3]<rule[3]){
			 solve[11]++;solve[3]++;
			 gn++;
			  writer.println("group "+gn+": 3,11");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("bc'd")){
		  solve[5]--;solve[13]--;
		 if(solve[5]<rule[5]||solve[13]<rule[13]){
			 solve[5]++;solve[13]++;
			 gn++;
			  writer.println("group "+gn+": 5,13");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("bcd'")){
		  solve[6]--;solve[14]--;
		 if(solve[6]<rule[6]||solve[14]<rule[14]){
			 solve[6]++;solve[14]++;
			 gn++;
			  writer.println("group "+gn+": 6,14");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("b'c'd")){
		  solve[1]--;solve[9]--;
		 if(solve[1]<rule[1]||solve[9]<rule[9]){
			 solve[1]++;solve[9]++;
			 gn++;
			  writer.println("group "+gn+": 1,9");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("b'cd'")){
		  solve[2]--;solve[10]--;
		 if(solve[2]<rule[2]||solve[10]<rule[10]){
			 solve[2]++;solve[10]++;
			 gn++;
			  writer.println("group "+gn+": 2,10");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("bc'd'")){
		  solve[12]--;solve[4]--;
		 if(solve[12]<rule[12]||solve[4]<rule[4]){
			 solve[12]++;solve[4]++;
			 gn++;
			  writer.println("group "+gn+": 4,12");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("b'c'd'")){
		  solve[0]--;solve[8]--;
		 if(solve[0]<rule[0]||solve[8]<rule[8]){
			 solve[0]++;solve[8]++;
			 gn++;
			  writer.println("group "+gn+": 0,8");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("abcd")){
		  solve[15]--;
		 if(solve[15]<rule[15]){
			 solve[15]++;
			 gn++;
			  writer.println("group "+gn+": 15");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'bcd")){
		  solve[7]--;
		 if(solve[7]<rule[7]){
			 solve[7]++;
			 gn++;
			  writer.println("group "+gn+": 7");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ab'cd")){
		  solve[11]--;
		 if(solve[11]<rule[11]){
			 solve[11]++;
			 gn++;
			  writer.println("group "+gn+": 11");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("abc'd")){
		  solve[13]--;
		 if(solve[13]<rule[13]){
			 solve[13]++;
			 gn++;
			  writer.println("group "+gn+": 13");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("abcd'")){
		  solve[14]--;
		 if(solve[14]<rule[14]){
			 solve[14]++;
			 gn++;
			  writer.println("group "+gn+": 14");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'b'cd")){
		  solve[3]--;
		 if(solve[3]<rule[3]){
			 solve[3]++;
			 gn++;
			  writer.println("group "+gn+": 3");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'bc'd")){
		  solve[5]--;
		 if(solve[5]<rule[5]){
			 solve[5]++;
			 gn++;
			  writer.println("group "+gn+": 5");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'bcd'")){
		  solve[6]--;
		 if(solve[6]<rule[6]){
			 solve[6]++;
			 gn++;
			  writer.println("group "+gn+": 6");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ab'c'd")){
		  solve[9]--;
		 if(solve[9]<rule[9]){
			 solve[9]++;
			 gn++;
			  writer.println("group "+gn+": 9");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ab'cd'")){
		  solve[10]--;
		 if(solve[10]<rule[10]){
			 solve[10]++;
			 gn++;
			  writer.println("group "+gn+": 10");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("abc'd'")){
		  solve[12]--;
		 if(solve[12]<rule[12]){
			 solve[12]++;
			 gn++;
			  writer.println("group "+gn+": 12");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'b'c'd")){
		  solve[1]--;
		 if(solve[1]<rule[1]){
			 solve[1]++;
			 gn++;
			  writer.println("group "+gn+": 1");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'b'cd'")){
		  solve[2]--;
		 if(solve[2]<rule[2]){
			 solve[2]++;
			 gn++;
			  writer.println("group "+gn+": 2");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'bc'd'")){
		  solve[4]--;
		 if(solve[4]<rule[4]){
			 solve[4]++;
			 gn++;
			  writer.println("group "+gn+": 4");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("ab'c'd'")){
		  solve[8]--;
		 if(solve[8]<rule[8]){
			 solve[8]++;
			 gn++;
			  writer.println("group "+gn+": 8");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  if(F[r].equals("a'b'c'd'")){
		  solve[0]--;
		 if(solve[0]<rule[0]){
			 solve[0]++;
			 gn++;
			  writer.println("group "+gn+": 0");
			 }else{
				 F[r]="0"; 
		  }if(!F[r].equals("0")){
			  writer.println("simplification of group "+gn+" -> "+F[r]);}
	  }
	  
	}//Fr
	   //輸出
	  writer.println("");
	  switch(totalVariablesCount){
		  case 4:
	  writer.print("F(A,B,C,D) = ");
	      break;
		  case 3:
	  writer.print("F(A,B,C) = ");
	      break;
		  case 2:
	  writer.print("F(A,B) = ");
	      break;
	  }
	  for(int ff=1;ff<=15;ff++){
		  if(!F[ff].equals("0")){
			  if(ff==1){
	       writer.print(F[ff]);
		  }else{	
		  writer.print("+"+F[ff]);}
	  }
			  }
		  
	    writer.flush(); 
		writer.close(); 
}catch(FileNotFoundException e){ 
	   System.out.println("IO Exception Happened"); 
	   }	
	  

 }
 }
 
