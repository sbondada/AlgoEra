package lecture;

//the whole code only works for square matrix which can further be reduced 4 smaller square matrix size
// to accept all square matrices we need to make the matix dividble by adding extra zeros in front of the
//matrix
public class StracensMatrixMultiplication 
{
	//add method which adds two matrices
	public int[][] add(int[][] a,int[][] b)
	{
		int[][] sum= new int[a.length][a[0].length];
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				sum[i][j]=a[i][j]+b[i][j];
			}
		}
		return sum;
	}
	//considering a, b as a square matrix and multiplication is possible only if both has same dimention
	public int[][] multiply(int[][] a, int[][] b)
	{
		//checking if the matrix has just a single element if it has return the multiplication of them
		if(a.length==1 && a[0].length==1)
		{
			int[][] product={{a[0][0]*b[0][0]}}; 
			return product;
		}
		else
		{
		//else divide the matrix into 4 equal parts
			int n=a.length/2;
			int[][] lefttopa=new int[n][n];
			int[][] lefttopb=new int[n][n];
			for (int i=0;i<n;i++)
			{
				for(int j=0;j<n;j++)
				{
					lefttopa[i][j]=a[i][j];
					lefttopb[i][j]=b[i][j];
				}
			}
			int[][] righttopa=new int[n][a.length-n];
			int[][] righttopb=new int[n][b.length-n];
			for(int i=0;i<n;i++)
			{
				for(int j=0;j<b.length-n;j++)
				{
					righttopa[i][j]=a[i][n+j];
					righttopb[i][j]=b[i][n+j];
				}
			}
			int[][] leftbottoma= new int[a.length-n][n];
			int[][] leftbottomb= new int[a.length-n][n];
			for(int i=0;i<a.length-n;i++)
			{
				for(int j=0;j<n;j++)
				{
					leftbottoma[i][j]=a[n+i][j];
					leftbottomb[i][j]=b[n+i][j];
				}
			}
			int[][]rightbottoma=new int[a.length-n][a.length-n];
			int[][]rightbottomb=new int[a.length-n][a.length-n];
			for(int i=0;i<a.length-n;i++)
			{
				for(int j=0;j<a.length-n;j++)
				{
					rightbottoma[i][j]=a[n+i][n+j];
					rightbottomb[i][j]=b[n+i][n+j];
				}
			}
			//now perform the multiplication with 4 square matrices
			//here is the general solution which performs 8 further multiplications. its not that better as stracens
			int[][] rlefttop=add(multiply(lefttopa,lefttopb),multiply(righttopa, leftbottomb));
			int[][] rrighttop=add(multiply(lefttopa,righttopb),multiply(righttopa, rightbottomb));
			int[][] rleftbottom=add(multiply(leftbottoma,lefttopb),multiply(rightbottoma, leftbottomb));
			int[][] rrightbottom=add(multiply(leftbottoma,righttopb),multiply(rightbottoma, rightbottomb)); 
			int[][] total=new int[rlefttop.length+rleftbottom.length][rrightbottom[0].length+rrighttop[0].length];
			//instead of these you can include the strasens calculations of 7 multiplications and some extra additions 
			//and substractions
			
			//add the strasens products here.
			
			//merging these individually calculated matrices into a large matrix
			for(int i=0;i<rlefttop.length;i++)
			{
				for(int j=0;j<rlefttop[0].length;j++)
				{
					total[i][j]=rlefttop[i][j];
				}
			}
			for(int i=0;i<rrighttop.length;i++)
			{
				for(int j=0;j<rrighttop[0].length;j++)
				{
					total[i][rlefttop[0].length+j]=rrighttop[i][j];
				}
			}
			for(int i=0;i<rleftbottom.length;i++)
			{
				for(int j=0;j<rleftbottom[0].length;j++)
				{
					total[rlefttop.length+i][j]=rleftbottom[i][j];
				}
			}
			for(int i=0;i<rrightbottom.length;i++)
			{
				for(int j=0;j<rrightbottom[0].length;j++)
				{
					total[rlefttop.length+i][rlefttop[0].length+j]=rrightbottom[i][j];
				}
			}
			return total;
		}
		
	}
	public static void main(String args[])
	{
		int[][] a={{1,2,3,5},{4,5,6,3},{2,6,4,3},{1,5,7,9}};
		int[][] b={{1,2,7,6},{2,4,3,5},{9,8,4,3},{2,3,5,4}};
		StracensMatrixMultiplication smm=new StracensMatrixMultiplication();
		int[][] ab=smm.multiply(a,b);
		for(int i=0;i<ab.length;i++)
		{
			for(int j=0;j<ab[0].length;j++)
			{
				System.out.print(ab[i][j]+" ");
			}
			System.out.println();
		}
	}
}
