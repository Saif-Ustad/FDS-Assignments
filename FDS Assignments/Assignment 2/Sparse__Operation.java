import java.util.* ;

class sparse 
{
    private int k=1;
    private int[][] sp = new int[10][3];
    private int [][] sim_tran = new int[10][3];
    private int [][] fast_tran = new int[10][3];
    private int [] total = new int[10];
    private int [] index = new int[10];

    public void create_sparse(int row, int col, int [][] mat)
    {
        

        Scanner sc = new Scanner(System.in);
        
        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                if(mat[i][j] != 0)
                {
                    sp[k][0] = i ;
                    sp[k][1] = j ;
                    sp[k][2] = mat[i][j];
                    k++ ;
                }
            }
        }

        sp[0][0] = row;
        sp[0][1] = col;
        sp[0][2] = (k-1) ;
    }
    public void display()
    {
        System.out.println("Your sparse matrix is :");

        for(int i=0; i<k; i++)
        {
            System.out.println(sp[i][0] + "\t" + sp[i][1] + "\t" + sp[i][2]);
        }
    }
    public void display_simple_tran()
    {
        System.out.println("Your simple transpose sparse matrix is :");

        for(int i=0; i<k; i++)
        {
            System.out.println(sim_tran[i][0] + "\t" + sim_tran[i][1] + "\t" + sim_tran[i][2]);
        }
    }
 
    public void display_fast_tran()
    {
        System.out.println("Your fast transpose sparse matrix is :");

        for(int i=0; i<k; i++)
        {
            System.out.println(fast_tran[i][0] + "\t" + fast_tran[i][1] + "\t" + fast_tran[i][2]);
        }
    }


    public void Simple_Transpose()
    {
        

        sim_tran[0][0] = sp[0][1] ;
        sim_tran[0][1] = sp[0][0] ;
        sim_tran[0][2] = sp[0][2] ;

        int m=1;
        for(int i=0; i<sp[0][1]; i++)
        {
            for(int j=1; j<=sp[0][2]; j++)
            {
                if(sp[j][1]== i)
                {
                    sim_tran[m][0] = sp[j][1];
                    sim_tran[m][1] = sp[j][0];
                    sim_tran[m][2] = sp[j][2];
                    m++ ;
                }
            }
        }
        display_simple_tran();

    }

    public void Fast_Transpose()
    {   
        int ctr;
        int i;
        for(i=0; i<sp[0][1]; i++)
        {
            total[i] = 0 ;
        }
       
        
        fast_tran[0][0] = sp[0][1];
        fast_tran[0][1] = sp[0][0];
        fast_tran[0][2] = sp[0][2];

        for(i=1; i<=sp[0][2]; i++)
        {
            total[sp[i][1]]++ ; 
        }

        index[0] = 1;
        for(i=1; i<=sp[0][1]; i++)
        {
            index[i] = index[i-1] + total[i-1] ; 
        }

        for(i=1; i<=sp[0][2]; i++)
        {
            ctr = index[sp[i][1]];
            fast_tran[ctr][0] = sp[i][1];
            fast_tran[ctr][1] = sp[i][0];
            fast_tran[ctr][2] = sp[i][2];
            index[sp[i][1]]++ ;

        }
        display_fast_tran();


    }
};

public class Sparse__Operation{
    public static void main(String[] args)
    {
        int row, col;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row and column : ");
        row = sc.nextInt();
        col = sc.nextInt();
        
        int[][] mat = new int[10][10];
        System.out.println("Enter matrix elements : ");

        for(int i=0; i<row; i++)
        {
            for(int j=0; j<col; j++)
            {
                mat[i][j] = sc.nextInt();
            }
        }

        sparse s = new sparse();
        s.create_sparse(row, col, mat);
        s.display();

        System.out.println("Enter what method you want to perform transpose of matrix : ");
        System.out.println("1.Simple \n2.fast");

        int choice;
        choice = sc.nextInt();

        switch(choice)
        {
            case 1 :
            s.Simple_Transpose();
            break;

            case 2:
            s.Fast_Transpose();
            break;            

        }

       
        sc .close();

    }

}
