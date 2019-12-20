package main;

public class CreeTableau {

	public static void main(String[] args) {
		double[] defaultparam = new double[] {
				
				1233.4499641946452, 1283.0137702850104, 0.8025501425054788,
				949.4382226390139, 995.7783901614047, 0.7065891429924284,
		
		};
		
		double[] defaultparamSig;
		double[] paramMax ;
		double[] paramMin;
		
		if(defaultparam.length % 3 != 0){
			System.out.println("Taille inconforme : "+defaultparam.length);
			return;
		}
		defaultparamSig = new double[defaultparam.length];
		paramMax = new double[defaultparam.length];
		paramMin = new double[defaultparam.length];
		for(int i = 0; i < defaultparam.length;i++){
			if(i%3 == 2){
				defaultparamSig[i] = 0.2;
				paramMax[i] = (double)(Math.round((defaultparam[i] + 0.2)*100)) /100;
				paramMin[i] = (double)(Math.round((defaultparam[i] - 0.2)*100)) /100;
				if(paramMax[i] > 1) paramMax[i] =1;
				if(paramMin[i] < 0) paramMax[i] =0;
			}
			else{
				defaultparamSig[i] = 15;
				paramMax[i] = defaultparam[i] + 15;
				paramMin[i] = defaultparam[i] - 15;
			}
		}
			
		System.out.print("defaultparam = new double[] {");
		for(int h = 0 ; h < defaultparam.length;h++){
			if(h == defaultparam.length-1)
				System.out.print(defaultparam[h]+"};");
			else
				System.out.print(defaultparam[h]+",");
		}		
		System.out.println();
		System.out.print("defaultparamSig = new double[] {");
		for(int j = 0 ; j < defaultparam.length;j++){
			if(j == defaultparam.length-1)
				System.out.print(defaultparamSig[j]+"};");
			else
				System.out.print(defaultparamSig[j]+",");
		}
		System.out.println();
		System.out.print("paramMax = new double[] {");
		for(int k = 0 ; k < defaultparam.length;k++){
			if(k == defaultparam.length-1)
				System.out.print(paramMax[k]+"};");
			else
				System.out.print(paramMax[k]+",");
		}
		System.out.println();
		System.out.print("paramMin = new double[] {");
		for(int l = 0 ; l < defaultparam.length;l++){
			if(l == defaultparam.length-1)
				System.out.print(paramMin[l]+"};");
			else
				System.out.print(paramMin[l]+",");
		}
		
		
		System.out.println();
		System.out.println();
		
		defaultparamSig = new double[defaultparam.length];
		paramMax = new double[defaultparam.length];
		paramMin = new double[defaultparam.length];
		for(int a = 0; a < defaultparam.length;a++){
			if(a%3 == 2){
				defaultparamSig[a] = 0.1;
				paramMax[a] = (double)(Math.round((defaultparam[a] + 0.2)*100)) /100;
				paramMin[a] = (double)(Math.round((defaultparam[a] - 0.2)*100)) /100;
				if(paramMax[a] > 1) paramMax[a] =1;
				if(paramMin[a] < 0) paramMax[a] =0;
			}
			else{
				defaultparamSig[a] = 7;
				paramMax[a] = defaultparam[a] + 10;
				paramMin[a] = defaultparam[a] - 10;
			}
		}
			
		System.out.print("defaultparam = new double[] {");
		for(int b = 0 ; b < defaultparam.length;b++){
			if(b == defaultparam.length-1)
				System.out.print(defaultparam[b]+"};");
			else
				System.out.print(defaultparam[b]+",");
		}		
		System.out.println();
		System.out.print("defaultparamSig = new double[] {");
		for(int c = 0 ; c < defaultparam.length;c++){
			if(c == defaultparam.length-1)
				System.out.print(defaultparamSig[c]+"};");
			else
				System.out.print(defaultparamSig[c]+",");
		}
		System.out.println();
		System.out.print("paramMax = new double[] {");
		for(int d = 0 ; d < defaultparam.length;d++){
			if(d == defaultparam.length-1)
				System.out.print(paramMax[d]+"};");
			else
				System.out.print(paramMax[d]+",");
		}
		System.out.println();
		System.out.print("paramMin = new double[] {");
		for(int e = 0 ; e < defaultparam.length;e++){
			if(e == defaultparam.length-1)
				System.out.print(paramMin[e]+"};");
			else
				System.out.print(paramMin[e]+",");
		}
		System.out.println();
	}
}
