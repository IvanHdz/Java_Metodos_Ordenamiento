/**
 *
 * @author Jesus Ivan
 */
public class MetodosOrdenamiento {
    public int arrFijo[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
    public int arr[] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

    public void restablecer() {
        int tam = this.arr.length;
        int newvector[] = new int[tam];
        System.arraycopy(this.arrFijo, 0, newvector, 0, newvector.length);
        this.arr = newvector;
    }

    public void insertarNumero(int num) {
        int tam = this.arr.length;
        int[] newvector = new int[tam+1];
        System.arraycopy(this.arr, 0, newvector, 0, newvector.length-1);
        
        this.arr = newvector;
        this.arr[tam] = num;
        this.arrFijo = newvector;
        this.arrFijo[tam] = num;
    }

    public void eliminarNumero(int x) {
        int nPosicion=0;
        for(int j=0; j < arr.length;j++) {
            if( arr[j]== x ) {
                nPosicion = j;
                break;
            }
            else {
                if (j == arr.length)
                    System.out.println("Elemento no Encontrado");
                }
            }

        for (int k = nPosicion; k < this.arr.length-1;k++)
            this.arr[k] = this.arr[k+1];

        int tam = this.arr.length;
        int[] newvector = new int[tam-1];
        for (int i = 0;i < newvector.length;i++)
            newvector[i] = this.arr[i];
    
        this.arr = newvector;
        this.arrFijo = newvector;
    }

    public void Burbuja() {
       int n = arr.length;
       int aux;
       int control = 0;

       for (int j = n-1; j > 0;j--)
           for (int i =0;i < j;i++)
               if (arr[i] > arr[i+1]) {
                  aux = arr[i];
                  arr[i] = arr[i+1];
                  arr[i+1] = aux;
                  control = 0;
                  }
               else {
                    control++;
                          if (control == j)
                              j=0;
                    }
       }

    public void busquedaSecuencial(int x) {
           for(int i=1; i <= arr.length;i++) {
               if( arr[i-1]== x ) {
                   System.out.println("Elemento Encontrado");
                   System.out.println("Posicion: " + (i-1));
                   break;
               }
               else {
                    if (i == arr.length)
                       System.out.println("Elemento no Encontrado");
                  }
             }
      }


   public void shellSort() {
        int salto;
        int cambios;
        int aux;
        int i;
        for (salto=(arr.length/2);salto!=0;salto/=2) {
            for(cambios=1;cambios!=0;){
                cambios=0;
		for(i=salto;i<arr.length;i++) {
                    if(arr[i-salto]>arr[i]) {
                        aux=arr[i];
			arr[i]=arr[i-salto];
			arr[i-salto]=aux;
			cambios++;
                    }
		}
            }
        }
    }

    public void radixSort() {
        int tam = arr.length;
        int[] control = new int[tam];
		int[] siguiente = new int[tam];
		int[] delante = new int[10];
		int[] atras = new int[10];
		int num=0, primero=0, i=0, j=0, k=0, p=0, q=0, y=0;

		for(i=0;i<10;i++ ){
                    control[i]=arr[i];
                    siguiente[i]=i+1;
		}

		control[tam-1]=arr[tam-1];
		siguiente[tam-1]=-1;
		primero=0;

		for(k=1;k<4;k++) {
                    for(i=0;i<(tam-1);i++) {
                        atras[i]=-1;
			delante[i]=-1;
                    }
                    while(primero!=-1) {
                        p=primero;
			primero=siguiente[primero];
			y=control[p];
			num=1;
                        
                        for(i=1;i<=k-1;i++)
                            num=num*10;
                    
                            j=(y/num) % 10;
                            q=atras[j];
                            if(q==-1) {
                                delante[j]=p;
                            }
                            else{
                                siguiente[q]=p;
                            }
                    
                            atras[j]=p;
                    }
                    for(j=0;(j<10)&&(delante[j]==-1);j++);
                        primero=delante[j];
                        while(j<=9)
                        {
                            for(i=j+1;(i<10)&&(delante[i]==-1);i++);
                                if(i<=9) {
                                    p=i;
                                    siguiente[atras[j]]=delante[i];
				}
				j=i;
                            }

			if(atras[p]!=-1)
                            siguiente[atras[p]]=-1;
                }

		for(i=0;i<tam;i++) {
                    arr[i]=control[primero];
                    primero=siguiente[primero];
		}
     }

    public void mostrar() {
       for (int i =0; i < this.arr.length;i++)
           System.out.print(this.arr[i] + ", ");
       restablecer();
    }
}